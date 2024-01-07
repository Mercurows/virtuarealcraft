package top.yora.virtuarealcraft.tool;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootDataType;

import java.util.List;

public class LootTableTool {
    public static ResourceLocation getRandomLootTable(Level level, String prefix) {
        if (!level.isClientSide && level.getServer() != null) {
            List<ResourceLocation> resourceLocations = level.getServer().getLootData().getKeys(LootDataType.TABLE).
                    stream().filter(name -> name.getPath().startsWith(prefix)).toList();

            if (!resourceLocations.isEmpty()) {
                return resourceLocations.get(level.getRandom().nextInt(resourceLocations.size()));
            }
        }
        return null;
    }
}
