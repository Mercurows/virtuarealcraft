package top.yora.virtuarealcraft.tool;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Rarity;

public class RarityTool {
    public static final Rarity PRODUCER = Rarity.create("virtuarealcraft_producer", s -> {
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
    });

    public static final Rarity LEGENDARY = Rarity.create("virtuarealcraft_legendary", ChatFormatting.GOLD);
}
