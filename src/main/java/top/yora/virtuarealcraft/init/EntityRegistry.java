package top.yora.virtuarealcraft.init;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.entity.KuyaEntity;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Utils.MOD_ID);

    public static final RegistryObject<EntityType<KuyaEntity>> KUYA_ENTITY =
            ENTITY_TYPES.register("kuya",
                    () -> EntityType.Builder.<KuyaEntity>create(KuyaEntity::new, EntityClassification.MISC).size(0.3f,0.3f).build("kuya"));

}
