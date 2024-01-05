package top.yora.virtuarealcraft.tool;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import top.yora.virtuarealcraft.Utils;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Utils.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> DECOMPOSABLE = tag("decomposable");
        public static final TagKey<Item> BREWING_POWDER = tag("brewing_powder");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Utils.MOD_ID, name));
        }
    }
}
