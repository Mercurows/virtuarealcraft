package top.yora.virtuarealcraft.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import top.yora.virtuarealcraft.init.EntityRegistry;

public class RainCrystalEntity extends Projectile {
    public RainCrystalEntity(EntityType<? extends RainCrystalEntity> type, Level world) {
        super(type, world);
    }

    public RainCrystalEntity(Level world, LivingEntity entity) {
        super(EntityRegistry.RAIN_CRYSTAL_ENTITY.get(), world);
        this.setOwner(entity);
    }

    @Override
    protected void defineSynchedData() {

    }
}
