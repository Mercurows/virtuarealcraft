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

public class RainCrystalEntity extends ThrowableItemProjectile {
    private static final EntityDataAccessor<Integer> LIFE = SynchedEntityData.defineId(RainCrystalEntity.class, EntityDataSerializers.INT);
    private int life = 200;

    public RainCrystalEntity(EntityType<? extends RainCrystalEntity> type, Level world) {
        super(type, world);
    }

    public RainCrystalEntity(Level world, LivingEntity entity) {
        super(EntityRegistry.RAIN_CRYSTAL_ENTITY.get(), world);
        this.setOwner(entity);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.BUTTERFLY_STAFF.get().asItem();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(LIFE, 200);
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
    protected void onHitBlock(BlockHitResult pResult) {
        this.discard();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() instanceof LivingEntity livingEntity) {
            livingEntity.hurt(DamageSourceRegistry.rainCrystal(level(), getOwner()), 4.0F);
        }
        super.onHitEntity(pResult);
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
