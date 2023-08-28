package top.yora.virtuarealcraft.item.virtuareal7th.yukie;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
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

public class YukieDumplings extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().alwaysEat().nutrition(12).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 300, 1), 1.0f).build();

    public YukieDumplings() {
        super(new Properties().food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.yukie_dumplings").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY).withItalic(true)));

        TooltipTool.addLiverInfo(tooltip, Livers.YUKIE);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300, 0));
        pTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 1));
        pTarget.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 300, 1));

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
