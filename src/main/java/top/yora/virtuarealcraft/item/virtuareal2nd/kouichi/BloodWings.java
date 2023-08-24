package top.yora.virtuarealcraft.item.virtuareal2nd.kouichi;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.network.VrcNetwork;
import top.yora.virtuarealcraft.network.packet.BloodWingPacket;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BloodWings extends ArmorItem {
    public BloodWings() {
        super(ArmorMaterials.IRON, Type.CHESTPLATE, new Properties());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add(Component.translatable("des.virtuarealcraft.blood_wings").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.KOUICHI);
    }

    @SubscribeEvent
    public static void leftClick(PlayerInteractEvent.LeftClickEmpty event) {
        if (!event.getItemStack().isEmpty()) {
            return;
        }

        Player player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }

        if (!player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(ItemRegistry.BLOOD_WINGS.get()) || player.getCooldowns().isOnCooldown(ItemRegistry.BLOOD_WINGS.get())) {
            return;
        }

        VrcNetwork.CHANNEL.sendToServer(new BloodWingPacket(true));
    }

    @SubscribeEvent
    public static void rightClick(PlayerInteractEvent.RightClickEmpty event) {
        if (!event.getItemStack().isEmpty()) {
            return;
        }

        Player player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }

        if (!player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(ItemRegistry.BLOOD_WINGS.get()) || player.getCooldowns().isOnCooldown(ItemRegistry.BLOOD_WINGS.get())) {
            return;
        }

        VrcNetwork.CHANNEL.sendToServer(new BloodWingPacket(false));

        Level level = player.level();

        if (level.isClientSide) {
            player.playSound(SoundEvents.SCULK_SHRIEKER_SHRIEK, 0.8f, 1f);
        }
    }
}
