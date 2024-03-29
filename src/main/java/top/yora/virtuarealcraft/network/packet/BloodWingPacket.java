package top.yora.virtuarealcraft.network.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.network.NetworkEvent;
import top.yora.virtuarealcraft.entity.KouichiDartsEntity;
import top.yora.virtuarealcraft.init.ItemRegistry;

import java.util.function.Supplier;

@SuppressWarnings("ClassCanBeRecord")
public class BloodWingPacket {
    private final boolean isLeftClick;

    public BloodWingPacket(boolean isLeftClick) {
        this.isLeftClick = isLeftClick;
    }

    public static void encode(BloodWingPacket packet, ByteBuf buf) {
        buf.writeBoolean(packet.isLeftClick);
    }

    public static BloodWingPacket decode(ByteBuf buf) {
        return new BloodWingPacket(buf.readBoolean());
    }

    public static void handle(BloodWingPacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null) {
                Level level = player.level();
                boolean isLeftClick = packet.isLeftClick;
                if (player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(ItemRegistry.BLOOD_WINGS.get()) &&
                        !player.getCooldowns().isOnCooldown(ItemRegistry.BLOOD_WINGS.get())) {

                    if (isLeftClick) {
                        KouichiDartsEntity kouichiDarts = new KouichiDartsEntity(level, player);
                        kouichiDarts.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, 4, 0);
                        kouichiDarts.setPos(player.getPosition(0).add(0, player.getEyeHeight(), 0));
                        level.addFreshEntity(kouichiDarts);

                        player.getItemBySlot(EquipmentSlot.CHEST).hurtAndBreak(1, player, p -> p.broadcastBreakEvent(EquipmentSlot.CHEST));
                        player.getCooldowns().addCooldown(ItemRegistry.BLOOD_WINGS.get(), 80);
                    } else {
                        AABB box = new AABB(player.getOnPos()).inflate(10);
                        for (var entity : level.getEntitiesOfClass(LivingEntity.class, box)) {
                            if (!entity.equals(player)) {
                                entity.hurt(level.damageSources().sonicBoom(player), 3);

                                if (!level.isClientSide) {
                                    ((ServerLevel) level).sendParticles(ParticleTypes.SCULK_SOUL,
                                            entity.getX(), entity.getY() + 0.5, entity.getZ(), 1, 0, 0, 0, 0.01);
                                }
                            }
                        }
                        player.getItemBySlot(EquipmentSlot.CHEST).hurtAndBreak(10, player, p -> p.broadcastBreakEvent(EquipmentSlot.CHEST));

                        player.getCooldowns().addCooldown(ItemRegistry.BLOOD_WINGS.get(), 140);
                    }
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
