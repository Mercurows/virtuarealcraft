package top.yora.virtuarealcraft.block;

import net.minecraft.world.level.block.Block;

public class CornucopiaBlock extends Block {
    public CornucopiaBlock() {
        super(Properties.of().lightLevel(l -> 15).strength(2.0f));
    }
}
