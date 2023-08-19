package top.yora.virtuarealcraft.item.virtuareal17th.sui;

import net.minecraft.item.Food;
import net.minecraft.network.chat.Component;
import net.minecraft.util.text.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
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
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((new TranslationTextComponent("des.virtuarealcraft.suimashed_cookie")).mergeStyle(TextFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.SUI);
    }
}
