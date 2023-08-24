package top.yora.virtuarealcraft.network.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.network.NetworkEvent;
import top.yora.virtuarealcraft.init.ItemRegistry;

import java.util.function.Supplier;

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
                        // TODO 修改为吓我一跳释放匕首
                        Fireball ball = new LargeFireball(level, player, 0, 0, 0, 5);
                        ball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, 5, 0);
                        ball.setPos(player.getPosition(0).add(0, player.getEyeHeight(), 0));
                        level.addFreshEntity(ball);

                        player.getItemBySlot(EquipmentSlot.CHEST).hurtAndBreak(1, player, p -> p.broadcastBreakEvent(EquipmentSlot.CHEST));
                        player.getCooldowns().addCooldown(ItemRegistry.BLOOD_WINGS.get(), 80);
                    } else {
                        // TODO 修复音效无法播放的问题
                        level.playSound(player, player.getOnPos(), SoundEvents.SCULK_BLOCK_CHARGE, SoundSource.PLAYERS);

                        AABB box = new AABB(player.getOnPos()).inflate(10);
                        for (var entity : level.getEntitiesOfClass(LivingEntity.class, box)) {
                            if (!entity.equals(player)) {
                                // TODO 修改为造成正确的伤害类型
                                entity.hurt(level.damageSources().magic(), 3);
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
