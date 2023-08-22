package top.yora.virtuarealcraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yora.virtuarealcraft.gui.RainyButterflyHUD;
import top.yora.virtuarealcraft.init.ItemRegistry;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class HudClientEvent {
    @SubscribeEvent
    public static void onRainyButterflyHudRender(RenderGuiOverlayEvent.Post event) {
        if (Minecraft.getInstance().player == null) {
            return;
        }

        Player player = Minecraft.getInstance().player;

        if (player.isSpectator() || player.isCreative()) {
            return;
        }

        ItemStack stack = null;
        ItemStack mainhandStack = player.getMainHandItem();
        ItemStack offhandStack = player.getMainHandItem();

        if (mainhandStack.getItem() == ItemRegistry.RAINY_BUTTERFLY.get()) {
            stack = mainhandStack;
        } else if (offhandStack.getItem() == ItemRegistry.RAINY_BUTTERFLY.get()) {
            stack = offhandStack;
        }
        if (mainhandStack.getItem() == ItemRegistry.RAINY_BUTTERFLY.get() &&
                offhandStack.getItem() == ItemRegistry.RAINY_BUTTERFLY.get()) {
            stack = mainhandStack;
        }

        if (stack != null) {
            RainyButterflyHUD butterflyHUD = new RainyButterflyHUD(event.getGuiGraphics(), stack, player.level().isRaining());
            butterflyHUD.render();
        }
    }
}
