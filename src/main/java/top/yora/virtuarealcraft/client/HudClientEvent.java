package top.yora.virtuarealcraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yora.virtuarealcraft.gui.RainyButterflyHUD;
import top.yora.virtuarealcraft.init.ItemRegistry;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class HudClientEvent {
    @SubscribeEvent
    public static void onRainyButterflyHudRender(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        if (Minecraft.getInstance().player == null) {
            return;
        }

        PlayerEntity player = Minecraft.getInstance().player;

        if (player.isSpectator() || player.isCreative()) {
            return;
        }

        ItemStack stack = null;
        ItemStack mainhandStack = player.getHeldItemMainhand();
        ItemStack offhandStack = player.getHeldItemOffhand();

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
            RainyButterflyHUD butterflyHUD = new RainyButterflyHUD(event.getMatrixStack(), stack, player.world.isRaining());
            butterflyHUD.render();
        }
    }
}
