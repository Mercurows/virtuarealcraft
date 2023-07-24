package top.yora.virtuarealcraft.tool;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.*;

import java.util.List;

public class TooltipTool {
    public static void addHideText(List<ITextComponent> tooltip, ITextComponent text) {
        if (Screen.hasShiftDown()) {
            tooltip.add(text);
        }
    }

    public static void addDevelopingText(List<ITextComponent> tooltip) {
        tooltip.add(new StringTextComponent("本物品还在开发中").mergeStyle(TextFormatting.BOLD).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#ADDBFF"))));
    }

    public static void addLiverInfo(List<ITextComponent> tooltip, Livers liver) {
        addHideText(tooltip, new StringTextComponent(""));
        addHideText(tooltip, new TranslationTextComponent("liver.virtuarealcraft.liver").mergeStyle(TextFormatting.WHITE));
        addHideText(tooltip, new TranslationTextComponent("liver.virtuarealcraft." + liver.getName()).mergeStyle(Style.EMPTY.setColor(Color.fromHex(liver.getColor()))));
        String gen = liver.getGen();
        String bgColor = "#FFFFFF";
        switch (gen) {
            case "2nd":
                bgColor = "#FF63A7";
                break;
        }
        if (!liver.isActive()) {
            addHideText(tooltip, new TranslationTextComponent("des.virtuarealcraft.group." + gen).mergeStyle(Style.EMPTY.setColor(Color.fromHex(bgColor))).
                    mergeStyle(TextFormatting.BOLD).mergeStyle(TextFormatting.STRIKETHROUGH));
        } else {
            addHideText(tooltip, new TranslationTextComponent("des.virtuarealcraft.group." + gen).mergeStyle(Style.EMPTY.setColor(Color.fromHex(bgColor))).mergeStyle(TextFormatting.BOLD));
        }
    }

}
