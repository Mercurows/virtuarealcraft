package top.yora.virtuarealcraft.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import top.yora.virtuarealcraft.Utils;

import javax.annotation.Nullable;

public class DamageSourceRegistry {
    public static final ResourceKey<DamageType>
            RAIN_CRYSTAL = key("rain_crystal");

    private static ResourceKey<DamageType> key(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, name));
    }

    private static String msgId(ResourceKey<DamageType> key) {
        return key.location().getNamespace() + "." + key.location().getPath();
    }

    public static void bootstrap(BootstapContext<DamageType> ctx) {
        ctx.register(key("rain_crystal"),
                new DamageType(msgId(key("rain_crystal")), DamageScaling.NEVER, 0.0f, DamageEffects.HURT, DeathMessageType.DEFAULT));
    }

    private static DamageSource source(ResourceKey<DamageType> key, LevelReader level) {
        Registry<DamageType> registry = level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE);
        return new DamageSource(registry.getHolderOrThrow(key));
    }

    private static DamageSource source(ResourceKey<DamageType> key, LevelReader level, @Nullable Entity entity) {
        Registry<DamageType> registry = level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE);
        return new DamageSource(registry.getHolderOrThrow(key), entity);
    }

    private static DamageSource source(ResourceKey<DamageType> key, LevelReader level, @Nullable Entity causingEntity, @Nullable Entity directEntity) {
        Registry<DamageType> registry = level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE);
        return new DamageSource(registry.getHolderOrThrow(key), causingEntity, directEntity);
    }

    public static DamageSource rainCrystal(Level level, Entity shooter){
        return source(RAIN_CRYSTAL, level, shooter);
    }

}
