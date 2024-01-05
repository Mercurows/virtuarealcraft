package top.yora.virtuarealcraft.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.yora.virtuarealcraft.Utils;

public class PotionRegistry {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, Utils.MOD_ID);

    public static final RegistryObject<Potion> SUPER_REGENERATION = POTIONS.register("super_regeneration",
            () -> new Potion(new MobEffectInstance(MobEffects.REGENERATION, 320, 3)));
    public static final RegistryObject<Potion> FURY = POTIONS.register("fury",
            () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1600, 3), new MobEffectInstance(MobEffects.WITHER, 200, 1)));
}
