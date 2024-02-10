package top.yora.virtuarealcraft.item.virtuareal19th.hatsuse;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class PureChickenLeg extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().alwaysEat().nutrition(5).saturationMod(0.75f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400), 1.0f).build();

    public PureChickenLeg() {
        super(new Item.Properties().food(food));
    }
}
