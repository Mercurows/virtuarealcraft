package top.yora.virtuarealcraft.item.virtuareal19th.hatsuse;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
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
import java.util.ArrayList;
import java.util.List;

public class Nemumaru extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(0.25f).build();

    public Nemumaru() {
        super(new Properties().food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((Component.translatable("des.virtuarealcraft.nemumaru")).withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.HATSUSE);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide) {
            List<MobEffectInstance> effectInstances = new ArrayList<>();

            pLivingEntity.getActiveEffects().forEach(e -> {
                if (e.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
                    effectInstances.add(e);
                }
            });

            effectInstances.forEach(e -> pLivingEntity.removeEffect(e.getEffect()));
        }

        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
