package top.yora.virtuarealcraft.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.effect.CurseFlame;

public class EffectRegistry {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Utils.MOD_ID);

    public static final RegistryObject<MobEffect> CURSE_FLAME = EFFECTS.register("curse_flame", CurseFlame::new);
}
