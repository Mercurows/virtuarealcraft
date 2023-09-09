package top.yora.virtuarealcraft.init;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.block.CornucopiaBlock;
import top.yora.virtuarealcraft.block.CrystalBridgeBlock;
import top.yora.virtuarealcraft.block.KouichiZipper;
import top.yora.virtuarealcraft.block.LittleSweetPotatoBlock;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Utils.MOD_ID);

    public static final RegistryObject<Block> KOUICHI_ZIPPER = BLOCKS.register("kouichi_zipper", KouichiZipper::new);
    public static final RegistryObject<Block> LITTLE_SWEET_POTATO_BLOCK = BLOCKS.register("little_sweet_potato", LittleSweetPotatoBlock::new);
    public static final RegistryObject<Block> CRYSTAL_BRIDGE = BLOCKS.register("crystal_bridge", CrystalBridgeBlock::new);
    public static final RegistryObject<Block> CORNUCOPIA = BLOCKS.register("cornucopia", CornucopiaBlock::new);
}
