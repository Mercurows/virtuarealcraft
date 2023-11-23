package top.yora.virtuarealcraft.item.virtuareal17th.sui;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class SuimashedCookie extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().fast().alwaysEat().nutrition(2).saturationMod(0.25f).build();

    public SuimashedCookie() {
        super(new Properties().food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((Component.translatable("des.virtuarealcraft.suimashed_cookie")).withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.SUI);
    }
}
