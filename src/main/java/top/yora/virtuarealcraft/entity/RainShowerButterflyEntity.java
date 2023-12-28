package top.yora.virtuarealcraft.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import top.yora.virtuarealcraft.init.EntityRegistry;

import javax.annotation.Nullable;
import java.util.UUID;

public class RainShowerButterflyEntity extends Projectile {
    private static final EntityDataAccessor<Integer> LIFE = SynchedEntityData.defineId(RainShowerButterflyEntity.class, EntityDataSerializers.INT);
    private int life = 600;
    @Nullable
    private Entity finalTarget;
    @Nullable
    private UUID targetId;

    public RainShowerButterflyEntity(EntityType<? extends RainShowerButterflyEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.noPhysics = true;
    }

    public RainShowerButterflyEntity(Level pLevel, LivingEntity pShooter, Entity pFinalTarget) {
        this(EntityRegistry.RAIN_SHOWER_BUTTERFLY_ENTITY.get(), pLevel);
        this.setOwner(pShooter);
        BlockPos blockpos = pShooter.blockPosition();
        double d0 = (double)blockpos.getX() + 0.5D;
        double d1 = (double)blockpos.getY() + 0.5D;
        double d2 = (double)blockpos.getZ() + 0.5D;
        this.moveTo(d0, d1, d2, this.getYRot(), this.getXRot());
        this.finalTarget = pFinalTarget;
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if (this.finalTarget != null) {
            pCompound.putUUID("Target", this.finalTarget.getUUID());
        }
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.hasUUID("Target")) {
            this.targetId = pCompound.getUUID("Target");
        }
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(LIFE, 200);
    }
}
