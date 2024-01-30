package top.yora.virtuarealcraft.network.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@SuppressWarnings("ClassCanBeRecord")
public class CurseFlamePacket {
    private final int entityId;
    private final int flameTime;

    public CurseFlamePacket(int entityId, int flameTime) {
        this.entityId = entityId;
        this.flameTime = flameTime;
    }

    public static void encode(CurseFlamePacket packet, ByteBuf buf) {
        buf.writeInt(packet.entityId);
        buf.writeInt(packet.flameTime);
    }

    public static CurseFlamePacket decode(ByteBuf buf) {
        return new CurseFlamePacket(buf.readInt(), buf.readInt());
    }

    public static void handle(CurseFlamePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (FMLLoader.getDist().isClient()) {
                Level level = Minecraft.getInstance().level;
                if (level != null) {
                    Entity entity = level.getEntity(packet.entityId);
                    if (entity instanceof LivingEntity living) {
                        living.getPersistentData().putInt("CurseFlame", packet.flameTime);
                    }
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
