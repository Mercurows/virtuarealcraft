package top.yora.virtuarealcraft.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.entity.KuyaEntity;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Utils.MOD_ID);

    public static final RegistryObject<EntityType<KuyaEntity>> KUYA_ENTITY =
            ENTITY_TYPES.register("kuya",
                    () -> EntityType.Builder.<KuyaEntity>of(KuyaEntity::new, MobCategory.MISC).sized(0.3f, 0.3f).build("kuya"));

}
