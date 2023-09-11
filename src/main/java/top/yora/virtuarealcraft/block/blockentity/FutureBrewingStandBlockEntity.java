package top.yora.virtuarealcraft.block.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import top.yora.virtuarealcraft.init.BlockEntityRegistry;

public class FutureBrewingStandBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    private static final int INGREDIENT_SLOT = 6;
    private static final int FUEL_SLOT = 7;
    private static final int[] SLOTS_FOR_UP = new int[]{6};
    //水瓶和材料
    private static final int[] SLOTS_FOR_DOWN = new int[]{0, 1, 2, 3, 4, 5, 6};
    //水瓶和燃料
    private static final int[] SLOTS_FOR_SIDES = new int[]{0, 1, 2, 3, 4, 5, 7};
    public static final int FUEL_USES = 20;
    public static final int DATA_BREW_TIME = 0;
    public static final int DATA_FUEL_USES = 1;
    public static final int NUM_DATA_VALUES = 2;

    private NonNullList<ItemStack> items = NonNullList.withSize(5, ItemStack.EMPTY);

    public FutureBrewingStandBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.FUTURE_BREWING_STAND_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public int[] getSlotsForFace(Direction pSide) {
        if (pSide == Direction.UP) {
            return SLOTS_FOR_UP;
        } else {
            return pSide == Direction.DOWN ? SLOTS_FOR_DOWN : SLOTS_FOR_SIDES;
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int pIndex, ItemStack pItemStack, @Nullable Direction pDirection) {
        return this.canPlaceItem(pIndex, pItemStack);
    }

    @Override
    public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
        return false;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.virtuarealcraft.brewing");
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return null;
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getItem(int pIndex) {
        return pIndex >= 0 && pIndex < this.items.size() ? this.items.get(pIndex) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
        return ContainerHelper.removeItem(this.items, pSlot, pAmount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int pSlot) {
        return ContainerHelper.takeItem(this.items, pSlot);
    }

    @Override
    public void setItem(int pSlot, ItemStack pStack) {

    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return Container.stillValidBlockEntity(this, pPlayer);
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }
}
