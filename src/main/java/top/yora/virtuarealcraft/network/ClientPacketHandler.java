package top.yora.virtuarealcraft.network;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;
import top.yora.virtuarealcraft.network.packet.CurseFlamePacket;

import java.util.function.Supplier;

public class ClientPacketHandler {
    public static void handleCurseFlamePacket(CurseFlamePacket msg, Supplier<NetworkEvent.Context> ctx) {
        if (ctx.get().getDirection().getReceptionSide() == LogicalSide.CLIENT) {
            Level level = Minecraft.getInstance().level;
            if (level != null) {
                Entity entity = level.getEntity(msg.getEntityId());
                if (entity instanceof LivingEntity living) {
                    living.getPersistentData().putInt("CurseFlame", msg.getFlameTime());
                }
            }
        }
    }
}
