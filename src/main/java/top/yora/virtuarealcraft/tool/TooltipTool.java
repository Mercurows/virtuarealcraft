package top.yora.virtuarealcraft.tool;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;

import java.util.List;

public class TooltipTool {
    public static void addHideText(List<Component> tooltip, Component text) {
        if (Screen.hasShiftDown()) {
            tooltip.add(text);
        }
    }

    public static void addDevelopingText(List<Component> tooltip) {
        tooltip.add(Component.literal("本物品还在开发中").withStyle(Style.EMPTY.withBold(true).withColor(TextColor.parseColor("#ADDBFF"))));
    }

    public static void addLiverInfo(List<Component> tooltip, Livers liver) {
        addHideText(tooltip, Component.literal(""));
        addHideText(tooltip, Component.translatable("liver.virtuarealcraft.liver").withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
        addHideText(tooltip, Component.translatable("liver.virtuarealcraft." + liver.getName()).withStyle(Style.EMPTY.withColor(TextColor.parseColor(liver.getColor()))));
        String gen = liver.getGen();
        String bgColor = switch (gen) {
            case "1st" -> "#913837";
            case "2nd" -> "#E8DED3";
            case "3rd" -> "#E6F4FD";
            case "4th" -> "#6ECECF";
            case "5th" -> "#EE756B";
            case "6th" -> "#6CDA90";
            case "7th" -> "#EF9EF7";
            case "8th" -> "#D8D382";
            case "9th" -> "#AC8582";
            case "10th" -> "#C9EDD8";
            case "11th" -> "#C67B7D";
            case "12th" -> "#F9F3DE";
            case "13th" -> "#F7CDDB";
            case "14th" -> "#AA9EE1";
            case "15th" -> "#B77361";
            case "16th" -> "#8DB4E8";
            case "17th" -> "#C92F51";
            case "18th" -> "#FCF9F0";
            case "19th" -> "#F8BCA3";
            default -> "#FFFFFF";
        };
        if (!liver.isActive()) {
            addHideText(tooltip, Component.translatable("des.virtuarealcraft.group." + gen)
                    .withStyle(Style.EMPTY.withColor(TextColor.parseColor(bgColor))
                            .withBold(true)
                            .withStrikethrough(true)));
        } else {
            addHideText(tooltip, Component.translatable("des.virtuarealcraft.group." + gen).withStyle(Style.EMPTY.withColor(TextColor.parseColor(bgColor)).withBold(true)));
        }
    }

}
