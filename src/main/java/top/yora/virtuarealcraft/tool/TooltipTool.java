package top.yora.virtuarealcraft.tool;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.text.*;

import java.util.List;

public class TooltipTool {
    public static void addHideText(List<Component> tooltip, Component text) {
        if (Screen.hasShiftDown()) {
            tooltip.add(text);
        }
    }

    public static void addDevelopingText(List<Component> tooltip) {
        tooltip.add(new StringTextComponent("本物品还在开发中").mergeStyle(TextFormatting.BOLD).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#ADDBFF"))));
    }

    public static void addLiverInfo(List<Component> tooltip, Livers liver) {
        addHideText(tooltip, new StringTextComponent(""));
        addHideText(tooltip, new TranslationTextComponent("liver.virtuarealcraft.liver").mergeStyle(TextFormatting.WHITE));
        addHideText(tooltip, new TranslationTextComponent("liver.virtuarealcraft." + liver.getName()).mergeStyle(Style.EMPTY.setColor(Color.fromHex(liver.getColor()))));
        String gen = liver.getGen();
        String bgColor = "#FFFFFF";
        switch (gen) {
            case "1st":
                bgColor = "#913837";
                break;
            case "2nd":
                bgColor = "#E8DED3";
                break;
            case "3rd":
                bgColor = "#E6F4FD";
                break;
            case "4th":
                bgColor = "#6ECECF";
                break;
            case "5th":
                bgColor = "#EE756B";
                break;
            case "6th":
                bgColor = "#6CDA90";
                break;
            case "7th":
                bgColor = "#EF9EF7";
                break;
            case "8th":
                bgColor = "#D8D382";
                break;
            case "9th":
                bgColor = "#AC8582";
                break;
            case "10th":
                bgColor = "#C9EDD8";
                break;
            case "11th":
                bgColor = "#C67B7D";
                break;
            case "12th":
                bgColor = "#F9F3DE";
                break;
            case "13th":
                bgColor = "#F7CDDB";
                break;
            case "14th":
                bgColor = "#AA9EE1";
                break;
            case "15th":
                bgColor = "#B77361";
                break;
            case "16th":
                bgColor = "#8DB4E8";
                break;
            case "17th":
                bgColor = "#C92F51";
                break;
            case "18th":
                bgColor = "#FCF9F0";
                break;
            case "19th":
                bgColor = "#F8BCA3";
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
