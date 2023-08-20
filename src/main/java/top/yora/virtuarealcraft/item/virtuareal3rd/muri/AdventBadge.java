package top.yora.virtuarealcraft.item.virtuareal3rd.muri;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ActionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.init.GroupRegistry;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class AdventBadge extends Item {
    public AdventBadge() {
        super(new Properties().durability(62).group(GroupRegistry.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.advent_badge").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)).setStyle(Style.EMPTY.withColor(ChatFormatting.ITALIC)));

        TooltipTool.addLiverInfo(tooltip, Livers.MURI);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);

        if (!worldIn.isClientSide) {
            ((ServerLevel) worldIn).setDayTime(13000);

            playerIn.getCooldowns().addCooldown(stack.getItem(), 12000);
            stack.damageItem(1, playerIn, p -> p.sendBreakAnimation(handIn));

            for (Player player : worldIn.getPlayers()) {
                if (player != playerIn) {
                    player.sendSystemMessage(Component.translatable("des.virtuarealcraft.advent_badge.warn")
                            .setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_PURPLE).withBold(true)), true);
                    player.addItem(new ItemStack(ItemRegistry.MURI_DICE.get()));
                }
            }
        }

        return ActionResult.func_233538_a_(stack, worldIn.isClientSide);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.PRISMARINE_SHARD;
    }

}
