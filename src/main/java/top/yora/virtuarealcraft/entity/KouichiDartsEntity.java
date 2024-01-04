package top.yora.virtuarealcraft.entity;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import top.yora.virtuarealcraft.init.EntityRegistry;
import top.yora.virtuarealcraft.init.ItemRegistry;

public class KouichiDartsEntity extends ThrowableItemProjectile {
    public KouichiDartsEntity(EntityType<? extends KouichiDartsEntity> type, Level world) {
        super(type, world);
    }

    public KouichiDartsEntity(Level world, LivingEntity entity) {
        super(EntityRegistry.KOUICHI_DARTS_ENTITY.get(), world);
        this.setOwner(entity);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.BLOOD_WINGS.get().asItem();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);

        if (!this.level().isClientSide && !this.isRemoved()) {
            Entity entity = this.getOwner();
            if (entity instanceof ServerPlayer serverplayer) {
                if (serverplayer.connection.isAcceptingMessages() && serverplayer.level() == this.level() && !serverplayer.isSleeping() && serverplayer.isSteppingCarefully()) {
                    if (entity.isPassenger()) {
                        serverplayer.dismountTo(this.getX(), this.getY(), this.getZ());
                    } else {
                        entity.teleportTo(this.getX(), this.getY(), this.getZ());
                    }

                    entity.teleportTo(this.getX(), this.getY(), this.getZ());
                    entity.resetFallDistance();
                }
            } else if (entity != null) {
                entity.teleportTo(this.getX(), this.getY(), this.getZ());
                entity.resetFallDistance();
            }

            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() instanceof LivingEntity livingEntity) {
            livingEntity.hurt(livingEntity.level().damageSources().thrown(this, this.getOwner()), 3.0F);
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 300, 2));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 1));
        }
        this.discard();
    }
}
