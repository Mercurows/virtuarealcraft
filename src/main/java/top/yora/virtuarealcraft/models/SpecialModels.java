package top.yora.virtuarealcraft.models;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yora.virtuarealcraft.Utils;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpecialModels {
    @SubscribeEvent
    public static void onModelBake(ModelEvent.RegisterAdditional event) {
        event.register(new ModelResourceLocation(Utils.MOD_ID, "endless_rain_shower_butterfly", "inventory"));
    }
}
