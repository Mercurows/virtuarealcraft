package top.yora.virtuarealcraft.item.others;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class TokimoriSeisand extends Item {
    public TokimoriSeisand() {
        super(new Properties().rarity(Rarity.create("virtuarealcraft_producer", s -> Style.EMPTY.withColor(3092282))));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(tooltip);
        tooltip.add(Component.translatable("des.virtuarealcraft.tokimori_seisand").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
    }
}
