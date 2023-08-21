package top.yora.virtuarealcraft.entity;

import io.netty.buffer.Unpooled;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.fml.network.NetworkHooks;
import top.yora.virtuarealcraft.init.EntityRegistry;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.init.SoundRegistry;

public class KuyaEntity extends ThrowableItemProjectile {
    private static final EntityDataAccessor<Integer> FUSE = SynchedEntityData.defineId(KuyaEntity.class, EntityDataSerializers.INT);
    private int fuse = 100;

    public KuyaEntity(EntityType<? extends KuyaEntity> type, Level world) {
        super(type, world);
    }

    public KuyaEntity(Level world, LivingEntity entity) {
        super(EntityRegistry.KUYA_ENTITY.get(), entity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.KUYA.get();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FUSE, 80);
    }

    @Override
    public boolean canBeCollidedWith() {
        return this.isAlive();
    }

    public void tick() {
        super.tick();
        --this.fuse;
        if (this.fuse <= 0) {
            this.discard();
            if (!this.level().isClientSide) {
                explode(this);
            }
        } else {
            if (this.level().isClientSide) {
                this.level().addParticle(ParticleTypes.FIREWORK, this.getX(), this.getY() + 0.5D, this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    @Override
    protected void onHit(HitResult result) {
        if (!level().isClientSide) {
            if (result.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockResult = (BlockHitResult) result;

                //From TaC
                Direction direction = blockResult.getDirection();
                switch (direction.getAxis()) {
                    case X -> this.setMotion(this.getMotion().mul(-0.5, 0.75, 0.75));
                    case Y -> {
                        this.setMotion(this.getMotion().mul(0.75, -0.25, 0.75));
                        if (this.getMotion().getY() < this.getGravityVelocity()) {
                            this.setMotion(this.getMotion().mul(1, 0, 1));
                        }
                    }
                    case Z -> this.setMotion(this.getMotion().mul(0.75, 0.75, -0.5));
                }
            } else {
                this.discard();
                explode(this);
            }
        }
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        this.setFuse(compound.getShort("Fuse"));
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        compound.putShort("Fuse", (short) this.getFuse());
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        PacketBuffer pack = new PacketBuffer(Unpooled.buffer());
        pack.writeDouble(getPosX());
        pack.writeDouble(getPosY());
        pack.writeDouble(getPosZ());
        pack.writeInt(getEntityId());
        pack.writeUniqueId(getUniqueID());

        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public int getFuse() {
        return fuse;
    }

    public void setFuse(int fuse) {
        this.fuse = fuse;
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

        ((ServerLevel) world).addParticle(ParticleTypes.EXPLOSION, entity.getX(), entity.getY(), entity.getZ(), 10, 1.0D, 0.0D, 0.0D, 0.1);
        ((ServerLevel) world).addParticle(ParticleTypes.HEART, entity.getX(), entity.getY(), entity.getZ(), 30, 3.0D, 3.0D, 3.0D, 0.2);

        entity.playSound(SoundRegistry.HEAL.get(), 4.0F, 1.0f);

        AreaEffectCloud areaEffectCloud = new AreaEffectCloud(world, entity.getX(), entity.getY(), entity.getZ());
        areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 0));
        areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 2));
        areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.HEAL, 100, 1));

        areaEffectCloud.setRadius(10.0f);
        areaEffectCloud.setDuration(180);
        areaEffectCloud.setRadiusPerTick(-0.05f);

        world.addFreshEntity(areaEffectCloud);
    }
}
