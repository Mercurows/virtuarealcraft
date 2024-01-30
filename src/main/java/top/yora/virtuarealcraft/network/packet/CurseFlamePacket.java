package top.yora.virtuarealcraft.network.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;
import top.yora.virtuarealcraft.network.ClientPacketHandler;

import java.util.function.Supplier;

@SuppressWarnings("ClassCanBeRecord")
public class CurseFlamePacket {
    private final int entityId;
    private final int flameTime;

    public int getEntityId() {
        return entityId;
    }

    public int getFlameTime() {
        return flameTime;
    }

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
        ctx.get().enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientPacketHandler.handleCurseFlamePacket(packet, ctx)));
        ctx.get().setPacketHandled(true);
    }
}
