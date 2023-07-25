package top.yora.virtuarealcraft;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.init.SoundRegistry;

@Mod("virtuarealcraft")
public class Utils {
    public static final String MOD_ID = "virtuarealcraft";

    public static final String ATTRIBUTE_MODIFIER = "vrc_modifier";

    public Utils() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.ITEMS.register(eventBus);
//        EffectRegistry.EFFECTS.register(eventBus);
//        PotionRegistry.POTION_TYPES.register(eventBus);
//        EnchantRegistry.ENCHANTMENTS.register(eventBus);
        SoundRegistry.SOUNDS.register(eventBus);
//        EntityRegistry.ENTITY_TYPES.register(eventBus);
//        VillagerInit.POINTS_OF_INTEREST.register(eventBus);
//        VillagerInit.PROFESSIONS.register(eventBus);
//        BlockRegistry.BLOCKS.register(eventBus);
//        AttributeRegistry.ATTRIBUTES.register(eventBus);
//        ParticleRegistry.PARTICLE_TYPES.register(eventBus);
//        TileEntityRegistry.TILE_ENTITY_TYPES.register(eventBus);
//        LootTableHandler.init(eventBus);
//        CompatHandler.registerCompatItems(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
