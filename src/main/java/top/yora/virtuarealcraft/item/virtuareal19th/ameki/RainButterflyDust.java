package top.yora.virtuarealcraft.item.virtuareal19th.ameki;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class RainButterflyDust extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 200), 1.0f).fast().build();

    public RainButterflyDust() {
        super(new Properties().food(food));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.rain_butterfly_dust").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.AMEKI);
    }
}
