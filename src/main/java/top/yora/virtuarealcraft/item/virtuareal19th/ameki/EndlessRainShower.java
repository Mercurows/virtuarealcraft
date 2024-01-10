package top.yora.virtuarealcraft.item.virtuareal19th.ameki;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yora.virtuarealcraft.entity.RainShowerButterflyEntity;
import top.yora.virtuarealcraft.entity.SparkleButterflyEntity;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.models.item.EndlessRainShowerModel;
import top.yora.virtuarealcraft.render.EndlessRainShowerRenderer;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.RarityTool;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EndlessRainShower extends SwordItem {
    public EndlessRainShower() {
        super(Tiers.NETHERITE, 2, -2.1f, new Properties().rarity(RarityTool.LEGENDARY).durability(197).fireResistant().setNoRepair());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.endless_rain_shower_1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("des.virtuarealcraft.endless_rain_shower_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.AMEKI);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new EndlessRainShowerRenderer();
            }
        });
    }

    @SubscribeEvent
    public static void onModelBaked(ModelEvent.ModifyBakingResult event) {
        Map<ResourceLocation, BakedModel> modelRegistry = event.getModels();
        ModelResourceLocation location = new ModelResourceLocation(ItemRegistry.ENDLESS_RAIN_SHOWER.getId(), "inventory");
        BakedModel existingModel = modelRegistry.get(location);
        if (existingModel == null) {
            throw new RuntimeException();
        } else if (existingModel instanceof EndlessRainShowerModel) {
            throw new RuntimeException();
        } else {
            EndlessRainShowerModel model = new EndlessRainShowerModel(existingModel);
            event.getModels().put(location, model);
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.success(stack);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 30;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            float useProgress = (getUseDuration(pStack) - pRemainingUseDuration) / (float) getUseDuration(pStack);

            if (pRemainingUseDuration == 1) {
                int butterfliesToSpawn = 8;
                for (int i = 0; i < butterfliesToSpawn; i++) {
                    spawnButterfly(pLevel, player, 1, player.isSteppingCarefully());
                }

                player.getCooldowns().addCooldown(this, 150);
            } else if (pRemainingUseDuration % 2 == 0) {
                spawnButterfly(pLevel, player, Mth.clamp(useProgress, 0.2f, 1.0f), player.isSteppingCarefully());
                if (useProgress > .4f) {
                    spawnButterfly(pLevel, player, Mth.clamp(useProgress, 0.2f, 1.0f), player.isSteppingCarefully());
                }
                if (useProgress > .8f) {
                    spawnButterfly(pLevel, player, Mth.clamp(useProgress, 0.2f, 1.0f), player.isSteppingCarefully());
                }
            }
        }
    }

    @Override
    public void onStopUsing(ItemStack stack, LivingEntity entity, int count) {
        if (!entity.level().isClientSide && entity instanceof Player player) {
            player.getCooldowns().addCooldown(stack.getItem(), (getUseDuration(stack) - count) * 5);
        }
    }

    private void spawnButterfly(Level pLevel, Player player, float inaccuracy, boolean isSparkle) {
        if (isSparkle) {
            SparkleButterflyEntity entity = new SparkleButterflyEntity(pLevel, player);
            entity.shootFromRotation(player, player.getXRot() + new Random().nextFloat(-1, 1) * inaccuracy * 2,
                    player.getYRot() + new Random().nextFloat(-1, 1) * inaccuracy * 10, 0.0F, 3.0F, inaccuracy / 2);
            entity.setPos(player.getPosition(0).add(0, 1.3, 0));
            entity.setNoGravity(true);
            pLevel.addFreshEntity(entity);
        } else {
            RainShowerButterflyEntity entity = new RainShowerButterflyEntity(pLevel, player, null);
            entity.shootFromRotation(player, player.getXRot() + new Random().nextFloat(-1, 1) * inaccuracy * 2,
                    player.getYRot() + new Random().nextFloat(-1, 1) * inaccuracy * 10, 0.0F, 1.6F, inaccuracy);
            entity.setPos(player.getPosition(0).add(0, 1.3, 0));
            entity.setNoGravity(true);
            pLevel.addFreshEntity(entity);
        }
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}
