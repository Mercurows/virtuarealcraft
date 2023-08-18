package top.yora.virtuarealcraft.item.virtuareal13th.joi;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class OrangeGrenade extends Item {
    private static final Food food = new Food.Builder().setAlwaysEdible().hunger(4).saturation(0.2f).build();

    public OrangeGrenade() {
        super(new Properties().group(ModGroup.itemgroup).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.orange_grenade_1").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.orange_grenade_2").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.JOI);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if(playerIn.isSneaking()){
            playerIn.sendStatusMessage(new StringTextComponent("丢橘子"), true);

            itemstack.shrink(1);
            return ActionResult.resultSuccess(itemstack);
        }else {
            playerIn.setActiveHand(handIn);
            return ActionResult.resultConsume(itemstack);
        }
    }


}
