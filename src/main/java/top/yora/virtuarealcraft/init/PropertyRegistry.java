package top.yora.virtuarealcraft.init;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.yora.virtuarealcraft.tool.ItemNBTTool;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PropertyRegistry {
    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
        event.enqueueWork(() -> ItemProperties.register(ItemRegistry.RAINY_BUTTERFLY.get(), new ResourceLocation("open"),
                (stack, level, entity, seed) -> ItemNBTTool.getBoolean(stack, "rainy_butterfly_open", false) ? 1.0F : 0.0F));
    }
}
