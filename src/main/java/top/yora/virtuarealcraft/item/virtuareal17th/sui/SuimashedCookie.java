package top.yora.virtuarealcraft.item.virtuareal17th.sui;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class SuimashedCookie extends Item {
    private static final Food food = new Food.Builder().fastToEat().setAlwaysEdible().hunger(2).saturation(0.25f).build();

    public SuimashedCookie() {
        super(new Properties().group(ModGroup.itemgroup).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.virtuarealcraft.suimashed_cookie")).mergeStyle(TextFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.SUI);
    }
}
