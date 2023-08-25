package top.yora.virtuarealcraft.block;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import top.yora.virtuarealcraft.init.SoundRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import java.util.List;

@SuppressWarnings("deprecation")
public class KouichiZipper extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty OPEN = BooleanProperty.create("open");
    public static final BooleanProperty WALL = BooleanProperty.create("wall");
    public static final BooleanProperty TOP = BooleanProperty.create("top");

    public KouichiZipper() {
        super(Properties.of().noCollission());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false)
                .setValue(WALL, false).setValue(TOP, false));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> tooltip, TooltipFlag pFlag) {
        tooltip.add(Component.translatable("des.virtuarealcraft.kouichi_zipper").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY).withItalic(true)));

        TooltipTool.addLiverInfo(tooltip, Livers.KOUICHI);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, OPEN, WALL, TOP);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState blockstate = this.defaultBlockState();
        Direction facing = pContext.getClickedFace();
        blockstate = blockstate.setValue(FACING, pContext.getHorizontalDirection().getOpposite());
        if (facing == Direction.DOWN) {
            blockstate = blockstate.setValue(WALL, false).setValue(TOP, true);
        } else if (facing == Direction.UP) {
            blockstate = blockstate.setValue(WALL, false);
        } else {
            blockstate = blockstate.setValue(WALL, true);
        }
        return blockstate;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction facing = pState.getValue(FACING);
        if (pState.getValue(WALL)) {
            switch (facing) {
                case NORTH -> {
                    if (pState.getValue(OPEN)) {
                        return Block.box(0, 0, 15, 16, 16, 16);
                    } else {
                        return Block.box(7, 0, 15, 9, 16, 16);
                    }
                }
                case WEST -> {
                    if (pState.getValue(OPEN)) {
                        return Block.box(15, 0, 0, 16, 16, 16);
                    } else {
                        return Block.box(15, 0, 7, 16, 16, 9);
                    }
                }
                case SOUTH -> {
                    if (pState.getValue(OPEN)) {
                        return Block.box(0, 0, 0, 16, 16, 1);
                    } else {
                        return Block.box(7, 0, 0, 9, 16, 1);
                    }
                }
                case EAST -> {
                    if (pState.getValue(OPEN)) {
                        return Block.box(0, 0, 0, 1, 16, 16);
                    } else {
                        return Block.box(0, 0, 7, 1, 16, 9);
                    }
                }
            }
        } else if (pState.getValue(TOP)) {
            if (pState.getValue(OPEN)) {
                return Block.box(0, 15, 0, 16, 16, 16);
            }else {
                if (facing == Direction.SOUTH || facing == Direction.NORTH) {
                    return Block.box(7, 15, 0, 9, 16, 16);
                } else {
                    return Block.box(0, 15, 7, 16, 16, 9);
                }
            }
        } else {
            if (pState.getValue(OPEN)) {
                return Block.box(0, 0, 0, 16, 1, 16);
            } else {
                if (facing == Direction.SOUTH || facing == Direction.NORTH) {
                    return Block.box(7, 0, 0, 9, 1, 16);
                } else {
                    return Block.box(0, 0, 7, 16, 1, 9);
                }
            }
        }
        return Block.box(7, 0, 0, 9, 1, 16);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pState = pState.cycle(OPEN);
        pLevel.setBlock(pPos, pState, 2);
        pLevel.playSound(pPlayer, pPos, SoundRegistry.ZIPPER.get(), SoundSource.BLOCKS, 1.0F, pLevel.getRandom().nextFloat() * 0.1F + 0.9F);
        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }
}
