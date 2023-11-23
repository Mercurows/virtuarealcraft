package top.yora.virtuarealcraft.item.virtuareal19th.ameki;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.entity.RainCrystalEntity;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.ItemNBTTool;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class ButterflyStaff extends SwordItem {
    public ButterflyStaff() {
        super(Tiers.IRON, 1, -2.0f, new Properties().durability(261).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.butterfly_staff").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.AMEKI);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(stack);
    }

    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        int tick = this.getUseDuration(pStack) - pRemainingUseDuration;

        if (pLivingEntity instanceof Player player) {
            ItemStack stack = player.getOffhandItem();
            if(stack.getItem() == ItemRegistry.RAINY_BUTTERFLY.get() &&
                ItemNBTTool.getBoolean(stack, "rainy_butterfly_open", false)) {

                if(tick % 10 == 0) {
                    for (int i = 0; i < 8; i++) {
                        if (!pLevel.isClientSide) {
                            RainCrystalEntity rainCrystal = new RainCrystalEntity(pLevel, player);
                            rainCrystal.shootFromRotation(player, 0, player.getYRot() + i * 45 + (tick % 90 / 10) * 5f, 0, 2.2f, 0);
                            rainCrystal.setPos(player.getPosition(0).add(0, 1, 0));
                            rainCrystal.setNoGravity(true);
                            pLevel.addFreshEntity(rainCrystal);
                        }
                    }

                    pStack.hurtAndBreak(5, player, p -> p.broadcastBreakEvent(p.getUsedItemHand()));
                }
            }else {
                if(tick % 5 == 0) {
                    if (!pLevel.isClientSide) {
                        RainCrystalEntity rainCrystal = new RainCrystalEntity(pLevel, player);
                        rainCrystal.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, 3.0f, 0);
                        rainCrystal.setPos(player.getPosition(0).add(0, 1.3, 0));
                        rainCrystal.setNoGravity(true);
                        pLevel.addFreshEntity(rainCrystal);
                    }

                    pStack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(p.getUsedItemHand()));
                }
            }
        }
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.SPEAR;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(pEntity instanceof Player player) {
            if(player.tickCount % 20 == 0) {
                pStack.hurtAndBreak(-1, player, p -> p.broadcastBreakEvent(p.getUsedItemHand()));
            }
        }
    }
}
