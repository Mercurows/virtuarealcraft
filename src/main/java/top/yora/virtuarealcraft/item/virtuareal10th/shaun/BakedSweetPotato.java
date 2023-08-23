package top.yora.virtuarealcraft.item.virtuareal10th.shaun;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
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

public class BakedSweetPotato extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().nutrition(6).saturationMod(0.3f).build();

    public BakedSweetPotato() {
        super(new Properties().food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add(Component.translatable("des.virtuarealcraft.baked_sweet_potato").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.SHAUN);
    }
}
