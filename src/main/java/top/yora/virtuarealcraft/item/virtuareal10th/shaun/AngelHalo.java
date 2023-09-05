package top.yora.virtuarealcraft.item.virtuareal10th.shaun;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.models.AngelHaloModel;
import top.yora.virtuarealcraft.tool.ItemNBTTool;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class AngelHalo extends ArmorItem {
    public static final String TAG_ENERGY = "energy";
    public static final String TAG_TIME = "time";

    public AngelHalo() {
        super(ArmorMaterials.IRON, Type.HELMET, new Properties().durability(303).rarity(Rarity.EPIC));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.angel_halo").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltip.add(Component.literal(""));
        tooltip.add(Component.translatable("des.virtuarealcraft.angel_halo.energy").withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
        showFlyEnergy(pStack, tooltip);
        TooltipTool.addLiverInfo(tooltip, Livers.SHAUN);
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
                        "head", new AngelHaloModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(AngelHaloModel.LAYER_LOCATION)).main,
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
        return Utils.MOD_ID + ":textures/models/armor/angel_halo.png";
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!player.onGround()) {
            if (getFlyEnergy(stack) > 0) {
                Vec3 look = player.getLookAngle();

                player.setDeltaMovement(new Vec3(look.x * 0.25, look.y * 0.25 + 0.05, look.z * 0.25));
                player.fallDistance = 0;

                if (player.tickCount % 10 == 0) {
                    setFlyEnergy(stack, Math.max(0, getFlyEnergy(stack) - 1));
                }
                if (player.tickCount % 20 == 0) {
                    setFlyTime(stack, getFlyTime(stack) + 1);
                }
            }
        } else {
            if (player.tickCount % 20 == 0) {
                setFlyEnergy(stack, getFlyEnergy(stack) + 1);
            }
        }

        if (!level.isClientSide) {
            if (getFlyTime(stack) >= 30) {
                player.addItem(new ItemStack(ItemRegistry.LITTLE_SWEET_POTATO.get()));

                setFlyTime(stack, 0);
            }
        }
    }

    private static int getFlyEnergy(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_ENERGY, 1000);
    }

    private static void setFlyEnergy(ItemStack stack, int num) {
        ItemNBTTool.setInt(stack, TAG_ENERGY, Math.min(num, 1000));
    }

    private static int getFlyTime(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_TIME, 0);
    }

    private static void setFlyTime(ItemStack stack, int num) {
        ItemNBTTool.setInt(stack, TAG_TIME, Math.min(num, 30));
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    private void showFlyEnergy(ItemStack stack, List<Component> tooltip) {
        ChatFormatting formatting;
        if (getFlyEnergy(stack) >= 800) {
            formatting = ChatFormatting.GREEN;
        } else if (getFlyEnergy(stack) >= 500) {
            formatting = ChatFormatting.YELLOW;
        } else if (getFlyEnergy(stack) >= 200) {
            formatting = ChatFormatting.GOLD;
        } else {
            formatting = ChatFormatting.RED;
        }
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(1);
        numberFormat.setMinimumFractionDigits(1);
        double per = (double) getFlyEnergy(stack) / 1000;
        String percent = numberFormat.format(per);

        tooltip.add(Component.literal(percent).withStyle(Style.EMPTY.withColor(formatting)));
    }
}
