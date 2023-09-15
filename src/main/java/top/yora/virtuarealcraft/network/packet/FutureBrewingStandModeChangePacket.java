package top.yora.virtuarealcraft.network.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.network.NetworkEvent;
import top.yora.virtuarealcraft.gui.FutureBrewingStandMenu;

import java.util.function.Supplier;

@SuppressWarnings("ClassCanBeRecord")
public class FutureBrewingStandModeChangePacket {
    private final byte mode;

    public FutureBrewingStandModeChangePacket(byte mode) {
        this.mode = mode;
    }

    public static void encode(FutureBrewingStandModeChangePacket packet, ByteBuf buf) {
        buf.writeByte(packet.mode);
    }

    public static FutureBrewingStandModeChangePacket decode(ByteBuf buf) {
        return new FutureBrewingStandModeChangePacket(buf.readByte());
    }

    public static void handle(FutureBrewingStandModeChangePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            int mode = packet.mode % 3;

            ServerPlayer player = ctx.get().getSender();
            if (player != null) {
                AbstractContainerMenu abstractcontainermenu = player.containerMenu;
                if (abstractcontainermenu instanceof FutureBrewingStandMenu futureBrewingStandMenu) {
                    if (!player.containerMenu.stillValid(player)) {
                        return;
                    }

                    futureBrewingStandMenu.setBrewingMode(mode);
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
