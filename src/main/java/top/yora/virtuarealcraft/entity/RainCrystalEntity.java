package top.yora.virtuarealcraft.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import top.yora.virtuarealcraft.init.EntityRegistry;
import top.yora.virtuarealcraft.init.ItemRegistry;

public class RainCrystalEntity extends ThrowableItemProjectile {
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
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        this.discard();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if(pResult.getEntity() instanceof LivingEntity livingEntity){
            //TODO 添加自定义伤害类型
            livingEntity.hurt(level().damageSources().drown(), 4.0F);
        }
        super.onHitEntity(pResult);
    }
}
