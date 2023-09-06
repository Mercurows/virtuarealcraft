package top.yora.virtuarealcraft.entity;

import net.minecraft.network.protocol.game.ClientboundExplodePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import top.yora.virtuarealcraft.init.EntityRegistry;
import top.yora.virtuarealcraft.init.ItemRegistry;

public class OrangeGrenadeEntity extends ThrowableItemProjectile {
    public OrangeGrenadeEntity(EntityType<? extends OrangeGrenadeEntity> type, Level world) {
        super(type, world);
    }

    public OrangeGrenadeEntity(Level world, LivingEntity entity) {
        super(EntityRegistry.ORANGE_GRENADE_ENTITY.get(), entity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.ORANGE_GRENADE.get();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    @Override
    public boolean canBeCollidedWith() {
        return this.isAlive();
    }

    @Override
    protected void onHit(HitResult result) {
        if (!level().isClientSide) {
            this.discard();
            explode(this);
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        explode(this);
    }

    public static void explode(Entity entity) {
        Level world = entity.level();
        if (world.isClientSide()) {
            return;
        }

        Explosion explosion = new Explosion(world, entity, null, null,
                entity.getX(), entity.getY(), entity.getZ(), 2.0f, false, Explosion.BlockInteraction.KEEP);

        if(net.minecraftforge.event.ForgeEventFactory.onExplosionStart(world, explosion)) {
            return;
        }

        explosion.explode();
        explosion.finalizeExplosion(true);

        explosion.clearToBlow();

        for (ServerPlayer player : ((ServerLevel) world).players()) {
            if (player.distanceToSqr(player.getX(), player.getY(), player.getZ()) < 100) {
                player.connection.send(new ClientboundExplodePacket(entity.getX(), entity.getY(), entity.getZ(), 2, explosion.getToBlow(), explosion.getHitPlayers().get(player)));
            }
        }
    }
}
