package top.yora.virtuarealcraft.group;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.init.ItemRegistry;

public class AddItemsToGroup {
    public static final ResourceKey<CreativeModeTab> VRC_TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB,
            new ResourceLocation(Utils.MOD_ID, "vrc_tab"));

    @SubscribeEvent
    public static void addItemsToGroup(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(VRC_TAB_KEY)) {
            event.getBuilder().addItem(new ItemStack(ItemRegistry.RAINY_BUTTERFLY.get()));
        }
    }

}
