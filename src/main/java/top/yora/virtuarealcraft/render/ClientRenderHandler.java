package top.yora.virtuarealcraft.render;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import top.yora.virtuarealcraft.init.EntityRegistry;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.render.curios.OrangeAhogeRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRenderHandler {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityRegistry.KUYA_ENTITY.get(), KuyaEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.RAIN_CRYSTAL_ENTITY.get(), RainCrystalEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.KOUICHI_DARTS_ENTITY.get(), KouichiDartsEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.ORANGE_GRENADE_ENTITY.get(), OrangeGrenadeEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.RAIN_SHOWER_BUTTERFLY_ENTITY.get(), RainShowerButterflyEntityRenderer::new);

        CuriosRendererRegistry.register(ItemRegistry.ORANGE_AHOGE.get(), OrangeAhogeRenderer::new);
    }
}
