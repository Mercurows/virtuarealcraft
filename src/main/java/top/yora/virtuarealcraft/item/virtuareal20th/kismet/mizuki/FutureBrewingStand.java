package top.yora.virtuarealcraft.item.virtuareal20th.kismet.mizuki;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.init.BlockRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class FutureBrewingStand extends BlockItem {
    public FutureBrewingStand() {
        super(BlockRegistry.FUTURE_BREWING_STAND.get(), new Properties().rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add(Component.translatable("des.virtuarealcraft.future_brewing_stand_1").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltip.add(Component.translatable("des.virtuarealcraft.future_brewing_stand_2").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY).withItalic(true)));

        TooltipTool.addLiverInfo(tooltip, Livers.MIZUKI);
    }
}