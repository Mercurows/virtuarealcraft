package top.yora.virtuarealcraft.render;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.yora.virtuarealcraft.init.EntityRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRenderHandler {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityRegistry.KUYA_ENTITY.get(), KuyaEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.RAIN_CRYSTAL_ENTITY.get(), RainCrystalEntityRenderer::new);
    }
}
