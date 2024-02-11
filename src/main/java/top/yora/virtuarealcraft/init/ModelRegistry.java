package top.yora.virtuarealcraft.init;


import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.models.armor.*;
import top.yora.virtuarealcraft.models.curios.EternalTouchModel;
import top.yora.virtuarealcraft.models.curios.JokerMaskModel;
import top.yora.virtuarealcraft.models.curios.OrangeAhogeModel;
import top.yora.virtuarealcraft.models.projectile.*;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModelRegistry {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SharkTailModel.LAYER_LOCATION, SharkTailModel::createBodyLayer);
        event.registerLayerDefinition(ShadowHoodModel.LAYER_LOCATION, ShadowHoodModel::createBodyLayer);
        event.registerLayerDefinition(HamsterWheelModel.LAYER_LOCATION, HamsterWheelModel::createBodyLayer);
        event.registerLayerDefinition(KuyaModel.LAYER_LOCATION, KuyaModel::createBodyLayer);
        event.registerLayerDefinition(BarrierHatModel.LAYER_LOCATION, BarrierHatModel::createBodyLayer);
        event.registerLayerDefinition(RainCrystalModel.LAYER_LOCATION, RainCrystalModel::createBodyLayer);
        event.registerLayerDefinition(BloodWingsModel.LAYER_LOCATION, BloodWingsModel::createBodyLayer);
        event.registerLayerDefinition(AngelHaloModel.LAYER_LOCATION, AngelHaloModel::createBodyLayer);
        event.registerLayerDefinition(RoyalHaloModel.LAYER_LOCATION, RoyalHaloModel::createBodyLayer);
        event.registerLayerDefinition(MihiruTailModel.LAYER_LOCATION, MihiruTailModel::createBodyLayer);
        event.registerLayerDefinition(KouichiDartsModel.LAYER_LOCATION, KouichiDartsModel::createBodyLayer);
        event.registerLayerDefinition(OrangeGrenadeModel.LAYER_LOCATION, OrangeGrenadeModel::createBodyLayer);
        event.registerLayerDefinition(TacticalHeadsetMK1Model.LAYER_LOCATION, TacticalHeadsetMK1Model::createBodyLayer);
        event.registerLayerDefinition(OrangeAhogeModel.LAYER_LOCATION, OrangeAhogeModel::createBodyLayer);
        event.registerLayerDefinition(RainShowerButterflyModel.LAYER_LOCATION, RainShowerButterflyModel::createBodyLayer);
        event.registerLayerDefinition(JokerMaskModel.LAYER_LOCATION, JokerMaskModel::createBodyLayer);
        event.registerLayerDefinition(SparkleButterflyModel.LAYER_LOCATION, SparkleButterflyModel::createBodyLayer);
        event.registerLayerDefinition(EternalTouchModel.LAYER_LOCATION, EternalTouchModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onModelBake(ModelEvent.RegisterAdditional event) {
        event.register(new ModelResourceLocation(Utils.MOD_ID, "special/endless_rain_shower_butterfly", "inventory"));
        event.register(new ModelResourceLocation(Utils.MOD_ID, "special/endless_rain_shower_sparkle", "inventory"));
        event.register(new ModelResourceLocation(Utils.MOD_ID, "special/sui_jokes_3d", "inventory"));
    }
}
