package top.yora.virtuarealcraft.item.virtuareal6th.roi;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.block.CrystalBridgeBlock;
import top.yora.virtuarealcraft.init.BlockRegistry;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.models.armor.RoyalHaloModel;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RoyalHalo extends ArmorItem {
    public RoyalHalo() {
        super(ArmorMaterials.GOLD, Type.HELMET, new Properties().rarity(Rarity.UNCOMMON).durability(725));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.royal_halo").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.ROI);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide) {
            BlockPos pos = player.getOnPos();

            BlockState state = level.getBlockState(pos);

            if (!player.isSteppingCarefully() && player.onGround()) {
                if (state.getBlock() instanceof AirBlock) {
                    setBlocks(level, pos, BlockRegistry.CRYSTAL_BRIDGE.get().defaultBlockState());
                    stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(EquipmentSlot.HEAD));
                } else if (state.getBlock() instanceof CrystalBridgeBlock) {
                    setBlocks(level, pos, BlockRegistry.CRYSTAL_BRIDGE.get().defaultBlockState());
                }
            } else {
                if (state.getBlock() instanceof CrystalBridgeBlock) {
                    level.removeBlock(pos, false);
                }
            }

            if (player.fallDistance >= 0.5f && !player.isSteppingCarefully()) {
                BlockState state1 = level.getBlockState(pos.offset(0, -1, 0));
                if (state1.getBlock() instanceof AirBlock) {
                    setBlocks(level, pos.offset(0, -1, 0), BlockRegistry.CRYSTAL_BRIDGE.get().defaultBlockState());
                    stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(EquipmentSlot.HEAD));
                }
            }
        } else {
            level.addParticle(ParticleTypes.HEART, player.getX(), player.getY(), player.getZ(), 0, 0, 0);
            level.addParticle(ParticleTypes.NOTE, player.getX(), player.getY() + 0.2, player.getZ(), 0, 0, 0);
        }
    }

    private static void setBlocks(Level level, BlockPos pos, BlockState state) {
        if (level.getBlockState(pos).getBlock() instanceof AirBlock) {
            level.setBlock(pos, state, 2);
        }
        if (level.getBlockState(pos.offset(1, 0, 0)).getBlock() instanceof AirBlock) {
            level.setBlock(pos.offset(1, 0, 0), state, 2);
        }
        if (level.getBlockState(pos.offset(-1, 0, 0)).getBlock() instanceof AirBlock) {
            level.setBlock(pos.offset(-1, 0, 0), state, 2);
        }
        if (level.getBlockState(pos.offset(0, 0, 1)).getBlock() instanceof AirBlock) {
            level.setBlock(pos.offset(0, 0, 1), state, 2);
        }
        if (level.getBlockState(pos.offset(0, 0, -1)).getBlock() instanceof AirBlock) {
            level.setBlock(pos.offset(0, 0, -1), state, 2);
        }
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                HumanoidModel<?> armorModel = new HumanoidModel<>(new ModelPart(Collections.emptyList(), Map.of(
                        "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "head", new RoyalHaloModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(RoyalHaloModel.LAYER_LOCATION)).main,
                        "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
                armorModel.crouching = livingEntity.isShiftKeyDown();
                armorModel.riding = original.riding;
                armorModel.young = livingEntity.isBaby();
                return armorModel;
            }
        });
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/royal_halo.png";
    }

    @SubscribeEvent
    public static void onPlayerJump(LivingEvent.LivingJumpEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack stack = player.getItemBySlot(EquipmentSlot.HEAD);

            if (stack.getItem() == ItemRegistry.ROYAL_HALO.get() && !player.level().isClientSide) {
                new Object() {
                    private int ticks = 0;
                    private float waitTicks;

                    public void start(int waitTicks) {
                        this.waitTicks = waitTicks;
                        MinecraftForge.EVENT_BUS.register(this);
                    }

                    @SubscribeEvent
                    public void tick(TickEvent.ServerTickEvent event) {
                        if (event.phase == TickEvent.Phase.END) {
                            this.ticks++;
                            if (this.ticks >= this.waitTicks) {
                                run();
                            }
                        }
                    }

                    private void run() {
                        setBlocks(player.level(), player.getOnPos().offset(0, -1, 0), BlockRegistry.CRYSTAL_BRIDGE.get().defaultBlockState());
                        stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(EquipmentSlot.HEAD));
                        MinecraftForge.EVENT_BUS.unregister(this);
                    }
                }.start(3);
            }
        }
    }
}
