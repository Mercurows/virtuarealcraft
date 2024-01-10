package top.yora.virtuarealcraft.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import top.yora.virtuarealcraft.init.DamageSourceRegistry;
import top.yora.virtuarealcraft.init.EntityRegistry;

public class SparkleButterflyEntity extends Projectile {
    private static final EntityDataAccessor<Integer> LIFE = SynchedEntityData.defineId(SparkleButterflyEntity.class, EntityDataSerializers.INT);
    private int life = 600;

    public SparkleButterflyEntity(EntityType<? extends SparkleButterflyEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SparkleButterflyEntity(Level pLevel, LivingEntity pShooter) {
        this(EntityRegistry.SPARKLE_BUTTERFLY_ENTITY.get(), pLevel);
        this.setOwner(pShooter);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {

    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() instanceof LivingEntity livingEntity) {
            boolean glow = livingEntity.hasEffect(MobEffects.GLOWING);
            livingEntity.hurt(DamageSourceRegistry.causeSparkleButterflyDamage(level().registryAccess(), getOwner()), glow ? 8.0F : 4.0F);
            livingEntity.hurt(livingEntity.level().damageSources().inFire(), 2.0f);
            livingEntity.setSecondsOnFire(2);
            livingEntity.invulnerableTime = 0;

            livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 0));

            if (this.getOwner() != null && this.getOwner() instanceof LivingEntity entity) {
                entity.heal(3f);
                if (glow) {
                    entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1));
                }
            }

        }
        if (!this.level().isClientSide) {
            this.discard();
        }
    }

    @Override
    public void tick() {
        super.tick();
        --this.life;
        if (this.life <= 0) {
            this.discard();
            return;
        }

        Vec3 vec = this.getDeltaMovement();

        if (!this.level().isClientSide) {
            HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
            if (hitresult.getType() != HitResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitresult)) {
                this.onHit(hitresult);
            }

            this.setPos(this.getX() + vec.x, this.getY() + vec.y, this.getZ() + vec.z);
        } else {
            this.setPosRaw(this.getX() + vec.x, this.getY() + vec.y, this.getZ() + vec.z);
        }
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(LIFE, 600);
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putShort("Life", (short) this.getLife());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        this.setLife(pCompound.getShort("Life"));
    }
}
