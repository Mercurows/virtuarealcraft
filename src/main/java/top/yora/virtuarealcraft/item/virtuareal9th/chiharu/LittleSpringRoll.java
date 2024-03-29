package top.yora.virtuarealcraft.item.virtuareal9th.chiharu;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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

public class LittleSpringRoll extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().alwaysEat().nutrition(6).saturationMod(0.35f)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.5f).build();

    public LittleSpringRoll() {
        super(new Properties().food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((Component.translatable("des.virtuarealcraft.little_spring_roll")).withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.CHIHARU);
    }
}
