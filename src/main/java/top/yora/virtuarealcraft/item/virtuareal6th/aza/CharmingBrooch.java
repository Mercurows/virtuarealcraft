package top.yora.virtuarealcraft.item.virtuareal6th.aza;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class CharmingBrooch extends Item {
    public CharmingBrooch() {
        super(new Properties().durability(818).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.charming_brooch").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.AZA);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (pLivingEntity instanceof Player player) {
            if (pStack.getDamageValue() < pStack.getMaxDamage()) {
                AABB box = new AABB(player.getOnPos()).inflate(5);
                for (var entity : pLevel.getEntitiesOfClass(LivingEntity.class, box)) {
                    if (!entity.equals(player)) {
                        entity.addDeltaMovement(
                                new Vec3(player.getX() - entity.getX(), player.getY() - entity.getY(), player.getZ() - entity.getZ())
                                        .normalize().scale(0.1));
                    }
                }

                if (!player.isCreative()) {
                    pStack.setDamageValue(Math.min(pStack.getDamageValue() + 1, pStack.getMaxDamage()));
                }
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            if (player.isSprinting() && player.tickCount % 2 == 0 && !player.isCreative()) {
                pStack.setDamageValue(Math.max(0, pStack.getDamageValue() - 1));
            }
        }
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BRUSH;
    }
}
