package top.yora.virtuarealcraft.item.virtuareal3rd.muri;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class AdventBadge extends Item {
    public AdventBadge() {
        super(new Properties().durability(62));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.advent_badge").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)).setStyle(Style.EMPTY.withColor(ChatFormatting.ITALIC)));

        TooltipTool.addLiverInfo(tooltip, Livers.MURI);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);

        if (!worldIn.isClientSide) {
            ((ServerLevel) worldIn).setDayTime(13000);

            playerIn.getCooldowns().addCooldown(stack.getItem(), 12000);
            stack.hurtAndBreak(1, playerIn, p -> p.broadcastBreakEvent(handIn));

            for (Player player : worldIn.players()) {
                if (player != playerIn) {
                    player.displayClientMessage(Component.translatable("des.virtuarealcraft.advent_badge.warn")
                            .setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_PURPLE).withBold(true)), true);
                    player.addItem(new ItemStack(ItemRegistry.MURI_DICE.get()));
                }
            }
        }

        return new InteractionResultHolder<>(InteractionResult.sidedSuccess(worldIn.isClientSide), stack);
    }

    @Override
    public boolean isValidRepairItem(ItemStack pStack, ItemStack pRepairCandidate) {
        return pRepairCandidate.getItem() == Items.PRISMARINE_SHARD;
    }
}
