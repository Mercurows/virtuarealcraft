package top.yora.virtuarealcraft.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderArmEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;
import top.yora.virtuarealcraft.client.render.curios.EternalTouchRenderer;
import top.yora.virtuarealcraft.init.ItemRegistry;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class ArmRenderHandler {

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onRenderArm(RenderArmEvent event) {
        if (event.isCanceled()) {
            return;
        }

        CuriosApi.getCuriosInventory(event.getPlayer()).ifPresent(
                handler -> handler.findFirstCurio(ItemRegistry.ETERNAL_TOUCH.get()).ifPresent(
                        slotResult -> {
                            EternalTouchRenderer renderer = new EternalTouchRenderer();
                            if (slotResult.slotContext().visible()) {
                                renderer.renderFirstPersonArm(event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight(), event.getPlayer(), event.getArm(), false);
                            }
                        }
                )
        );
    }
}
