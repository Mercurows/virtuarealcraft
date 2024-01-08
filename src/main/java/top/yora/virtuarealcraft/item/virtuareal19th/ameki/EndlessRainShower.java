package top.yora.virtuarealcraft.item.virtuareal19th.ameki;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.entity.RainShowerButterflyEntity;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.RarityTool;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

//TODO 添加模型
public class EndlessRainShower extends SwordItem {
    public EndlessRainShower() {
        super(Tiers.NETHERITE, 2, -2.1f, new Properties().rarity(RarityTool.LEGENDARY).durability(197).fireResistant().setNoRepair());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add(Component.translatable("des.virtuarealcraft.endless_rain_shower_1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("des.virtuarealcraft.endless_rain_shower_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.AMEKI);
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
        return UseAnim.SPEAR;
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            float useProgress = (getUseDuration(pStack) - pRemainingUseDuration) / (float) getUseDuration(pStack);

            if (pRemainingUseDuration == 1) {
                int butterfliesToSpawn = 8;
                for (int i = 0; i < butterfliesToSpawn; i++) {
                    spawnButterfly(pLevel, player, 1);
                }

                player.getCooldowns().addCooldown(this, 150);
            } else if (pRemainingUseDuration % 2 == 0) {
                spawnButterfly(pLevel, player, Mth.clamp(useProgress, 0.2f, 1.0f));
                if (useProgress > .4f) {
                    spawnButterfly(pLevel, player, Mth.clamp(useProgress, 0.2f, 1.0f));
                }
                if (useProgress > .8f) {
                    spawnButterfly(pLevel, player, Mth.clamp(useProgress, 0.2f, 1.0f));
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

    private void spawnButterfly(Level pLevel, Player player, float inaccuracy) {
        RainShowerButterflyEntity entity = new RainShowerButterflyEntity(pLevel, player, null);
        entity.shootFromRotation(player, player.getXRot() + new Random().nextFloat(-1, 1) * inaccuracy * 2,
                player.getYRot() + new Random().nextFloat(-1, 1) * inaccuracy * 10, 0.0F, 1.6F, inaccuracy);
        entity.setPos(player.getPosition(0).add(0, 1.3, 0));
        entity.setNoGravity(true);
        pLevel.addFreshEntity(entity);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}
