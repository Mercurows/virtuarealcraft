package top.yora.virtuarealcraft.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import top.yora.virtuarealcraft.init.DamageSourceRegistry;
import top.yora.virtuarealcraft.init.EntityRegistry;
import top.yora.virtuarealcraft.init.ItemRegistry;

public class SparkleButterflyEntity extends ThrowableItemProjectile {
    private static final EntityDataAccessor<Integer> LIFE = SynchedEntityData.defineId(SparkleButterflyEntity.class, EntityDataSerializers.INT);
    private int life = 600;

    public SparkleButterflyEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
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
            livingEntity.hurt(DamageSourceRegistry.causeSparkleButterflyDamage(level().registryAccess(), getOwner()), 6.0F);

            if (this.getOwner() != null && this.getOwner() instanceof LivingEntity entity) {
                entity.heal(3f);
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
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(LIFE, 600);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.ENDLESS_RAIN_SHOWER.get();
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
