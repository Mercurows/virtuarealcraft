package top.yora.virtuarealcraft;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.yora.virtuarealcraft.init.*;
import top.yora.virtuarealcraft.network.VrcNetwork;

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
        GroupRegistry.TABS.register(eventBus);
        SoundRegistry.SOUNDS.register(eventBus);
        EntityRegistry.ENTITY_TYPES.register(eventBus);
//        VillagerInit.POINTS_OF_INTEREST.register(eventBus);
//        VillagerInit.PROFESSIONS.register(eventBus);
        BlockRegistry.BLOCKS.register(eventBus);
//        AttributeRegistry.ATTRIBUTES.register(eventBus);
//        ParticleRegistry.PARTICLE_TYPES.register(eventBus);
        BlockEntityRegistry.BLOCK_ENTITY_TYPES.register(eventBus);
        MenuTypeRegistry.MENU_TYPES.register(eventBus);
//        LootTableHandler.init(eventBus);
//        CompatHandler.registerCompatItems(eventBus);
        LootModifierRegistry.register(eventBus);
        VrcNetwork.init();

        eventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.GORGEOUS_BLOOM.getId(), BlockRegistry.POTTED_GORGEOUS_BLOOM));
        event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WEAKNESS)), Ingredient.of(Items.GOLDEN_APPLE), new ItemStack(ItemRegistry.KINDNESS_BOTTLE.get())));
    }

}
