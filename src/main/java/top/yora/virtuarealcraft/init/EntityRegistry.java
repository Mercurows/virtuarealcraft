package top.yora.virtuarealcraft.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.entity.*;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Utils.MOD_ID);

    public static final RegistryObject<EntityType<KuyaEntity>> KUYA_ENTITY =
            ENTITY_TYPES.register("kuya",
                    () -> EntityType.Builder.<KuyaEntity>of(KuyaEntity::new, MobCategory.MISC).sized(0.3f, 0.3f).build("kuya"));
    public static final RegistryObject<EntityType<RainCrystalEntity>> RAIN_CRYSTAL_ENTITY =
            ENTITY_TYPES.register("rain_crystal",
                    () -> EntityType.Builder.<RainCrystalEntity>of(RainCrystalEntity::new, MobCategory.MISC).sized(0.1f, 0.1f).build("rain_crystal"));
    public static final RegistryObject<EntityType<KouichiDartsEntity>> KOUICHI_DARTS_ENTITY =
            ENTITY_TYPES.register("kouichi_darts",
                    () -> EntityType.Builder.<KouichiDartsEntity>of(KouichiDartsEntity::new, MobCategory.MISC).sized(0.2f, 0.2f).build("kouichi_darts"));
    public static final RegistryObject<EntityType<OrangeGrenadeEntity>> ORANGE_GRENADE_ENTITY =
            ENTITY_TYPES.register("orange_grenade",
                    () -> EntityType.Builder.<OrangeGrenadeEntity>of(OrangeGrenadeEntity::new, MobCategory.MISC).sized(0.3f, 0.3f).build("orange_grenade"));
    public static final RegistryObject<EntityType<RainShowerButterflyEntity>> RAIN_SHOWER_BUTTERFLY_ENTITY =
            ENTITY_TYPES.register("rain_shower_butterfly",
                    () -> EntityType.Builder.<RainShowerButterflyEntity>of(RainShowerButterflyEntity::new, MobCategory.MISC).sized(0.2f, 0.2f).build("rain_shower_butterfly"));
}
