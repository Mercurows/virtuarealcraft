package top.yora.virtuarealcraft.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.block.blockentity.CornucopiaBlockEntity;
import top.yora.virtuarealcraft.block.blockentity.CrystalBridgeBlockEntity;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Utils.MOD_ID);

    public static final RegistryObject<BlockEntityType<CrystalBridgeBlockEntity>> CRYSTAL_BRIDGE_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register("crystal_bridge_block_entity",
                    () -> BlockEntityType.Builder.of(CrystalBridgeBlockEntity::new, BlockRegistry.CRYSTAL_BRIDGE.get()).build(null));
    public static final RegistryObject<BlockEntityType<CornucopiaBlockEntity>> CORNUCOPIA_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register("cornucopia_block_entity",
                    () -> BlockEntityType.Builder.of(CornucopiaBlockEntity::new, BlockRegistry.CORNUCOPIA.get()).build(null));
}
