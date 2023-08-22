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

import javax.annotation.Nullable;
import java.util.List;

public class TokimoriSeisand extends Item {
    public TokimoriSeisand() {
        super(new Properties().rarity(Rarity.create("virtuarealcraft_producer", s -> {
            long time = System.currentTimeMillis();
            int step = (int) (time % 2000);

            int startR = 47;
            int startG = 47;
            int startB = 58;

            int endR = 236;
            int endG = 85;
            int endB = 106;

            int finalR;
            int finalG;
            int finalB;

            step = step > 1000 ? 2000 - step : step;
            finalR = (int) (startR + (endR - startR) * step / 1000f);
            finalG = (int) (startG + (endG - startG) * step / 1000f);
            finalB = (int) (startB + (endB - startB) * step / 1000f);
            int rgb = finalR * 65536 + finalG * 256 + finalB;

            return Style.EMPTY.withColor(rgb);
        })));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.tokimori_seisand").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
    }
}
