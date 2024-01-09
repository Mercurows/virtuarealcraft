package top.yora.virtuarealcraft.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import top.yora.virtuarealcraft.init.DamageSourceRegistry;
import top.yora.virtuarealcraft.init.EntityRegistry;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class RainShowerButterflyEntity extends Projectile {
    private static final double MIN_VELOCITY = 0.2;
    private static final double MAX_VELOCITY = 0.75;
    public static final int MAX_LIFE = 600;
    private static final int MAX_SPEED_TICK = 100; // 达到最大速度的tick

    private static final EntityDataAccessor<Integer> LIFE = SynchedEntityData.defineId(RainShowerButterflyEntity.class, EntityDataSerializers.INT);
    private int life = 0;
    @Nullable
    private Entity target;
    @Nullable
    private UUID targetId;

    public RainShowerButterflyEntity(EntityType<? extends RainShowerButterflyEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public RainShowerButterflyEntity(Level pLevel, LivingEntity pShooter, @Nullable Entity pFinalTarget) {
        this(EntityRegistry.RAIN_SHOWER_BUTTERFLY_ENTITY.get(), pLevel);
        this.setOwner(pShooter);
        this.target = pFinalTarget;
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if (this.target != null) {
            pCompound.putUUID("Target", this.target.getUUID());
        }
        pCompound.putShort("Life", (short) this.life);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.hasUUID("Target")) {
            this.targetId = pCompound.getUUID("Target");
        }
        this.life = pCompound.getShort("Life");
    }

    @Override
    public void tick() {
        super.tick();
        Vec3 vec = this.getDeltaMovement();

        if (++this.life > MAX_LIFE) {
            destroy();
            return;
        }

        if (!this.level().isClientSide) {
            if (this.life > 10) {
                if (this.target == null && this.targetId != null) {
                    this.target = ((ServerLevel) this.level()).getEntity(this.targetId);
                    if (this.target == null) {
                        this.targetId = null;
                    }
                }

                if (this.targetId == null || this.target.distanceTo(this) > 25 || (this.target instanceof LivingEntity living && !canBeTarget(living))) {
                    findTarget();
                }

                if (this.target != null) {
                    if (this.target.isAlive()) {
                        this.trackTarget(target);
                    } else {
                        this.target = null;
                        this.targetId = null;
                        findTarget();
                    }

                    if (this.life >= MAX_LIFE) {
                        destroy();
                    }
                }
            }

            HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
            if (hitresult.getType() != HitResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitresult)) {
                this.onHit(hitresult);
            }

            this.setPos(this.getX() + vec.x, this.getY() + vec.y, this.getZ() + vec.z);
        } else {
            this.setPosRaw(this.getX() + vec.x, this.getY() + vec.y, this.getZ() + vec.z);
        }
    }

    private void findTarget() {
        List<LivingEntity> entities = this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(10));

        LivingEntity closestEntity = entities.stream().filter(e -> e != this.getOwner() && this.canBeTarget(e))
                .min(Comparator.comparingDouble(this::getWeightedDistance))
                .orElse(null);

        this.targetId = closestEntity != null ? closestEntity.getUUID() : null;
    }

    private void trackTarget(Entity target) {
        Vec3 targetPos = target.position();
        Vec3 projectilePos = this.position();
        Vec3 direction = targetPos.subtract(projectilePos).normalize();

        // 当前速度
        Vec3 currentVelocity = this.getDeltaMovement();
        double currentSpeed = currentVelocity.length();

        // 计算朝向目标的新速度向量
        Vec3 newVelocity = direction.scale(currentSpeed);

        // 当距离目标小于此值时，开始减速
        double distanceToTarget = projectilePos.distanceTo(targetPos);
        final double slowDownThreshold = 2.0;

        // 使用线性插值来平滑过渡当前速度到新速度
        double lerpFactor = 0.2; // 调整这个值使得转向更平滑，值越小转向越平滑

        if (distanceToTarget < Math.sqrt(slowDownThreshold)) {
            lerpFactor = lerpFactor * Mth.clamp(distanceToTarget / Math.sqrt(slowDownThreshold), 0.05, 0.2);
        }

        newVelocity = new Vec3(
                currentVelocity.x + (newVelocity.x - currentVelocity.x) * lerpFactor,
                currentVelocity.y + (newVelocity.y - currentVelocity.y) * lerpFactor,
                currentVelocity.z + (newVelocity.z - currentVelocity.z) * lerpFactor
        );

        // 确保速度不超过最大速度
        double newSpeed = newVelocity.length();
        if (newSpeed > MAX_VELOCITY) {
            newVelocity = newVelocity.normalize().scale(MAX_VELOCITY);
        }

        // 减少速度，避免在目标附近过射
        if (distanceToTarget < Math.sqrt(slowDownThreshold)) {
            double slowDownFactor = distanceToTarget / slowDownThreshold * (MAX_VELOCITY - MIN_VELOCITY) + MIN_VELOCITY;
            newVelocity = newVelocity.normalize().scale(slowDownFactor);
        }

        // 限制速度不低于最小速度
        if (newVelocity.length() < MIN_VELOCITY) {
            newVelocity = newVelocity.add(0, -0.04, 0).normalize().scale(MIN_VELOCITY);
        }

        // 应用新的速度
        this.setDeltaMovement(newVelocity);

        // 调整投射物的姿态，使其指向目标
        double dx = target.getX() - this.getX();
        double dy = target.getY() - this.getY();
        double dz = target.getZ() - this.getZ();
        float yaw = (float) (Math.atan2(dz, dx) * (180 / Math.PI)) + 90;
        float pitch = (float) (-(Math.atan2(dy, Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI)));
        this.setYRot(yaw);
        this.setXRot(pitch);

        // 根据生存时间调整速度
        if (this.life <= MAX_SPEED_TICK) {
            double velocityIncrement = MAX_VELOCITY * life / MAX_SPEED_TICK;
            Vec3 cur = this.getDeltaMovement();
            Vec3 nVec = cur.normalize().scale(velocityIncrement);

            if (nVec.length() > MAX_VELOCITY) {
                nVec = nVec.normalize().scale(MAX_VELOCITY);
            }

            this.setDeltaMovement(nVec);
        } else {
            // 一旦达到最大速度，保持这个速度
            Vec3 cur = this.getDeltaMovement();
            if (cur.length() != MAX_VELOCITY) {
                Vec3 nVec = cur.normalize().scale(MAX_VELOCITY);
                this.setDeltaMovement(nVec);
            }
        }
    }

    private void destroy() {
        if (this.target != null) {
            for (int i = 0; i < 8; i++) {
                LivingEntity owner = this.getOwner() instanceof LivingEntity ? (LivingEntity) this.getOwner() : null;
                RainCrystalEntity rainCrystal = new RainCrystalEntity(this.level(), owner);
                rainCrystal.shootFromRotation(this, 0, this.getYRot() + i * 45, 0, 2.0f, 0);
                rainCrystal.setPos(this.position());
                rainCrystal.setNoGravity(true);
                this.level().addFreshEntity(rainCrystal);
            }
        }
        this.discard();
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (!this.level().isClientSide) {
            ((ServerLevel)this.level()).sendParticles(ParticleTypes.CRIT, this.getX(), this.getY(), this.getZ(), 3, 0.2D, 0.2D, 0.2D, 0.0D);
            this.destroy();
        }

        return true;
    }

    @Override
    protected boolean canHitEntity(Entity p_37341_) {
        if (this.target != null) {
            return p_37341_ == this.target && super.canHitEntity(p_37341_) && !p_37341_.noPhysics;
        }
        return super.canHitEntity(p_37341_) && !p_37341_.noPhysics;
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() instanceof LivingEntity livingEntity) {
            List<RainShowerButterflyEntity> butterflyEntities = this.level().getEntitiesOfClass(RainShowerButterflyEntity.class, this.getBoundingBox().inflate(3));
            AtomicInteger count = new AtomicInteger();
            butterflyEntities.forEach(e -> {
                if (e != this && (e.getOwner() != null || e.getOwner() == this.getOwner())) {
                    count.getAndIncrement();
                }
            });

            float damage = Math.min(2 + count.get() * 0.3f, 19.7f);

            livingEntity.hurt(DamageSourceRegistry.causeRainShowerButterflyDamage(level().registryAccess(), getOwner()), damage);
            livingEntity.invulnerableTime = 0;
        }

        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
    }

    private boolean canBeTarget(LivingEntity entity) {
        if (!entity.isAlive() || (entity instanceof Player player && player.isCreative()) || entity instanceof AbstractVillager) {
            return false;
        }
        if (this.getOwner() != null) {
            return !(entity instanceof ArmorStand) && !entity.isAlliedTo(this.getOwner()) && entity.isAlive();
        } else {
            return !(entity instanceof ArmorStand) && entity.isAlive();
        }
    }

    private double getWeightedDistance(LivingEntity entity) {
        double distance = this.distanceToSqr(entity);
        double weight;
        double fix = 0;

        if (entity instanceof Monster) {
            if (entity instanceof NeutralMob) {
                weight = 1.5;
            } else {
                weight = 0.1; // 怪物优先级最高
            }
        } else if (entity instanceof Player) {
            weight = 1.0; // 玩家优先级次之
        } else if (entity instanceof NeutralMob) {
            weight = 2.5; // 中立生物优先级再次之
        } else if (entity instanceof Animal) {
            weight = 4.0; // 动物优先级更低
            fix = 1000000;
        } else {
            weight = 5.0; // 其他生物
            fix = 30;
        }

        return Math.sqrt(distance) * weight + fix;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(LIFE, 0);
    }
}
