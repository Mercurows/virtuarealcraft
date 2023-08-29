package top.yora.virtuarealcraft.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.entity.KuyaEntity;
import top.yora.virtuarealcraft.entity.RainCrystalEntity;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Utils.MOD_ID);

    public static final RegistryObject<EntityType<KuyaEntity>> KUYA_ENTITY =
            ENTITY_TYPES.register("kuya",
                    () -> EntityType.Builder.<KuyaEntity>of(KuyaEntity::new, MobCategory.MISC).sized(0.3f, 0.3f).build("kuya"));
    public static final RegistryObject<EntityType<RainCrystalEntity>> RAIN_CRYSTAL_ENTITY =
            ENTITY_TYPES.register("rain_crystal",
                    () -> EntityType.Builder.<RainCrystalEntity>of(RainCrystalEntity::new, MobCategory.MISC).sized(0.1f, 0.1f).build("rain_crystal"));
}
