package top.yora.virtuarealcraft.item.virtuareal14th.koxia;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import top.yora.virtuarealcraft.entity.KuyaEntity;
import top.yora.virtuarealcraft.init.GroupRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class Kuya extends Item {
    public Kuya() {
        super(new Properties().rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((Component.translatable("des.virtuarealcraft.kuya_1")).setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltip.add((Component.translatable("des.virtuarealcraft.kuya_2")).setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.KOXIA);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);
        playerIn.startUsingItem(handIn);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.SPEAR;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
        if (!worldIn.isClientSide) {
            if (entityLiving instanceof Player player) {

                KuyaEntity kuyaEntity = new KuyaEntity(worldIn, player);
                int usingTime = this.getUseDuration(stack) - timeLeft;

                float power = Math.min(usingTime / 30.0f, 3.5f);

                kuyaEntity.shoot(player, player.rotationPitch, player.rotationYaw, 0.0f, power, 0.0f);
                worldIn.addFreshEntity(kuyaEntity);

                if (!player.isCreative()) {
                    stack.shrink(1);
                }

                player.getCooldowns().addCooldown(stack.getItem(), 100);
            }
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 1000;
    }
}
