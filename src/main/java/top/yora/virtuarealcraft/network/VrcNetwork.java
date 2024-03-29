package top.yora.virtuarealcraft.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.network.packet.BloodWingPacket;
import top.yora.virtuarealcraft.network.packet.CurseFlamePacket;
import top.yora.virtuarealcraft.network.packet.FutureBrewingStandModeChangePacket;

import java.util.Optional;

public class VrcNetwork {
    public static final String NETWORK_VERSION = "1.0";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(Utils.MOD_ID, "network"),
            () -> NETWORK_VERSION, NETWORK_VERSION::equals, NETWORK_VERSION::equals);

    public static void init() {
        CHANNEL.registerMessage(0, BloodWingPacket.class, BloodWingPacket::encode, BloodWingPacket::decode, BloodWingPacket::handle);
        CHANNEL.registerMessage(1, FutureBrewingStandModeChangePacket.class, FutureBrewingStandModeChangePacket::encode, FutureBrewingStandModeChangePacket::decode, FutureBrewingStandModeChangePacket::handle);
        CHANNEL.registerMessage(2, CurseFlamePacket.class, CurseFlamePacket::encode, CurseFlamePacket::decode, CurseFlamePacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    }
}
