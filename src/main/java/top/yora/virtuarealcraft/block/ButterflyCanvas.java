package top.yora.virtuarealcraft.block;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import java.util.List;

public class ButterflyCanvas extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public ButterflyCanvas() {
        super(Properties.of().sound(SoundType.WOOL).strength(1.0f).noCollission());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> tooltip, TooltipFlag pFlag) {
        tooltip.add(Component.translatable("des.virtuarealcraft.butterfly_canvas").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.AMEKI);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState blockstate = this.defaultBlockState();
        blockstate = blockstate.setValue(FACING, pContext.getHorizontalDirection().getOpposite());
        return blockstate;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction direction = pState.getValue(FACING);
        return switch (direction) {
            case EAST -> Block.box(0, -16, -16, 2, 32, 32);
            case SOUTH -> Block.box(-16, -16, 0, 32, 32, 2);
            case WEST -> Block.box(14, -16, -16, 16, 32, 32);
            default -> Block.box(-16, -16, 14, 32, 32, 16);
        };
    }

}
