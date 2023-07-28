package top.yora.virtuarealcraft.item.virtuareal3rd.muri;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class AdventBadge extends Item {
    public AdventBadge() {
        super(new Properties().maxStackSize(1).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.advent_badge").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.MURI);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if(!worldIn.isRemote){
            ((ServerWorld) worldIn).setDayTime(13000);

            playerIn.getCooldownTracker().setCooldown(stack.getItem(), 12000);

            for(PlayerEntity player : worldIn.getPlayers()){
                if(player != playerIn){
                    player.sendStatusMessage(new TranslationTextComponent("des.virtuarealcraft.advent_badge.warn")
                            .mergeStyle(TextFormatting.DARK_PURPLE).mergeStyle(TextFormatting.BOLD), true);
                    player.addItemStackToInventory(new ItemStack(ItemRegistry.MURI_DICE.get()));
                }
            }
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
