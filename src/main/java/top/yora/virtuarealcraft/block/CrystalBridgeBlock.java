package top.yora.virtuarealcraft.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("ALL")
public class CrystalBridgeBlock extends Block {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 40);

    public CrystalBridgeBlock() {
        super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).noOcclusion().lightLevel(l -> 15).strength(1.0F, 1200.0F));
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        int age = pState.getValue(AGE);
        if (age < 40) {
            pLevel.setBlock(pPos, pState.setValue(AGE, age + 1), 2);
        } else {
            pLevel.destroyBlock(pPos, false);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return ItemStack.EMPTY;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Block.box(0, 14, 0, 16, 16, 16);
    }
}
