package top.yora.virtuarealcraft.init;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.yora.virtuarealcraft.gui.FutureBrewingStandScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ScreenRegistry {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(MenuTypeRegistry.FUTURE_BREWING_STAND_MENU.get(), FutureBrewingStandScreen::new);
        });
    }
}
