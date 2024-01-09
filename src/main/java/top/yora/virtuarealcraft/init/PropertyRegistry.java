package top.yora.virtuarealcraft.init;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PropertyRegistry {
    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
        event.enqueueWork(() -> ItemProperties.register(ItemRegistry.ENDLESS_RAIN_SHOWER.get(), new ResourceLocation("sparkle"),
                (itemStack, clientWorld, livingEntity, seed) -> livingEntity != null && livingEntity.isSteppingCarefully() ? 1.0F : 0.0F));
    }
}
