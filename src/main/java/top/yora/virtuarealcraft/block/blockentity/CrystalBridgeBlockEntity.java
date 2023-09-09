package top.yora.virtuarealcraft.block.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import top.yora.virtuarealcraft.init.BlockEntityRegistry;

import javax.annotation.Nullable;

public class CrystalBridgeBlockEntity extends BlockEntity {
    private static final String TAG_AGE = "age";

    public int age = 0;

    public CrystalBridgeBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.CRYSTAL_BRIDGE_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    @SuppressWarnings("unused")
    public static void tick(Level level, BlockPos pos, BlockState state, CrystalBridgeBlockEntity self) {
        if (self.age < 40) {
            self.age++;
        } else {
            level.removeBlock(pos, false);
        }
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt(TAG_AGE, age);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        age = pTag.getInt(TAG_AGE);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
