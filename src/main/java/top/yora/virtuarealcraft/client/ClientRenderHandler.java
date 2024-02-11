package top.yora.virtuarealcraft.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import top.yora.virtuarealcraft.client.render.*;
import top.yora.virtuarealcraft.client.render.curios.EternalTouchRenderer;
import top.yora.virtuarealcraft.client.render.curios.OrangeAhogeRenderer;
import top.yora.virtuarealcraft.init.EntityRegistry;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.client.render.curios.JokerMaskRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRenderHandler {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityRegistry.KUYA_ENTITY.get(), KuyaEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.RAIN_CRYSTAL_ENTITY.get(), RainCrystalEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.KOUICHI_DARTS_ENTITY.get(), KouichiDartsEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.ORANGE_GRENADE_ENTITY.get(), OrangeGrenadeEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.RAIN_SHOWER_BUTTERFLY_ENTITY.get(), RainShowerButterflyEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.SPARKLE_BUTTERFLY_ENTITY.get(), SparkleButterflyEntityRenderer::new);

        CuriosRendererRegistry.register(ItemRegistry.ORANGE_AHOGE.get(), OrangeAhogeRenderer::new);
        CuriosRendererRegistry.register(ItemRegistry.JOKER_MASK.get(), JokerMaskRenderer::new);
        CuriosRendererRegistry.register(ItemRegistry.ETERNAL_TOUCH.get(), EternalTouchRenderer::new);
    }
}
