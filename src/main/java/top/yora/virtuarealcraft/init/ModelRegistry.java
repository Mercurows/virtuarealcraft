package top.yora.virtuarealcraft.init;


import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yora.virtuarealcraft.models.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModelRegistry {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SharkTailModel.LAYER_LOCATION, SharkTailModel::createBodyLayer);
        event.registerLayerDefinition(ShadowHoodModel.LAYER_LOCATION, ShadowHoodModel::createBodyLayer);
        event.registerLayerDefinition(HamsterWheelModel.LAYER_LOCATION, HamsterWheelModel::createBodyLayer);
        event.registerLayerDefinition(KuyaModel.LAYER_LOCATION, KuyaModel::createBodyLayer);
        event.registerLayerDefinition(BarrierHatModel.LAYER_LOCATION, BarrierHatModel::createBodyLayer);
    }
}
