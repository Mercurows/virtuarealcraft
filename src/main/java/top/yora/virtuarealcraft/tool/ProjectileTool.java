package top.yora.virtuarealcraft.tool;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.Nullable;

public class ProjectileTool {
    public static boolean canHurtLivingEntity(LivingEntity living, @Nullable Entity shooter) {
        if (shooter == null) {
            return true;
        }

        return !living.isAlliedTo(shooter) || (living.getTeam() != null && living.isAlliedTo(shooter) && living.getTeam().isAllowFriendlyFire());
    }
}
