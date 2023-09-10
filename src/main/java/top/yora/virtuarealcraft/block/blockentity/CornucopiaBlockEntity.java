package top.yora.virtuarealcraft.block.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import top.yora.virtuarealcraft.init.BlockEntityRegistry;

import javax.annotation.Nullable;

public class CornucopiaBlockEntity extends BlockEntity {
    private static final String TAG_TIME = "time";

    public int time = 0;

    public CornucopiaBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.CORNUCOPIA_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    @SuppressWarnings("unused")
    public static void tick(Level level, BlockPos pos, BlockState state, CornucopiaBlockEntity self) {
        if (self.time < 2740) {
            self.time++;
        } else {
            double rand = Math.random();
            ItemStack stack = new ItemStack(Items.GOLD_NUGGET);
            if (rand <= .3) {
                stack = new ItemStack(Items.RAW_GOLD);
            }

            ItemEntity entity = new ItemEntity(level, pos.getX(), pos.getY() + 0.6, pos.getZ(), stack, 0.0D, 0.2D, 0.0D);
            level.addFreshEntity(entity);

            self.time = 0;
        }
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt(TAG_TIME, time);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        time = pTag.getInt(TAG_TIME);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
