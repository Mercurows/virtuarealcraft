package top.yora.virtuarealcraft.block.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import top.yora.virtuarealcraft.block.FutureBrewingStandBlock;
import top.yora.virtuarealcraft.gui.FutureBrewingStandMenu;
import top.yora.virtuarealcraft.init.BlockEntityRegistry;
import top.yora.virtuarealcraft.init.ItemRegistry;

import java.util.Arrays;

public class FutureBrewingStandBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    /**
     * 原料槽 - 6
     * 燃料槽 - 7
     * 粉末槽 - 8 （用于放置红石粉/荧石粉/时守星沙等）
     */
    private static final int INGREDIENT_SLOT = 6;
    private static final int FUEL_SLOT = 7;
    private static final int POWDER_SLOT = 8;

    /**
     * 顶部输入 - 原材料
     * 底部输出 - 原材料和药水
     * 正面和两侧输入 - 燃料和药水
     * 后面输入 - 粉末
     */
    private static final int[] SLOTS_FOR_UP = new int[]{6};
    private static final int[] SLOTS_FOR_DOWN = new int[]{0, 1, 2, 3, 4, 5, 6};
    private static final int[] SLOTS_FOR_SIDES = new int[]{0, 1, 2, 3, 4, 5, 7};
    private static final int[] SLOTS_FOR_BEHIND = new int[]{8};

    public static final int MAX_FUEL = 160;
    public static final int MAX_DATA_COUNT = 4;

    private NonNullList<ItemStack> items = NonNullList.withSize(9, ItemStack.EMPTY);

    int brewTime;
    private boolean[] lastPotionCount;
    private Item ingredient;
    int fuel;
    /**
     * 模式：
     * 0 - 普通;
     * 1 - 自动注水;
     * 2 - 自动注水 + 自动粗制;
     */
    int mode;
    int fuelTick;

    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int type) {
            return switch (type) {
                case 0 -> FutureBrewingStandBlockEntity.this.brewTime;
                case 1 -> FutureBrewingStandBlockEntity.this.fuel;
                case 2 -> FutureBrewingStandBlockEntity.this.mode;
                case 3 -> FutureBrewingStandBlockEntity.this.fuelTick;
                default -> 0;
            };
        }

        public void set(int type, int value) {
            switch (type) {
                case 0 -> FutureBrewingStandBlockEntity.this.brewTime = value;
                case 1 -> FutureBrewingStandBlockEntity.this.fuel = value;
                case 2 -> FutureBrewingStandBlockEntity.this.mode = value;
                case 3 -> FutureBrewingStandBlockEntity.this.fuelTick = value;
            }
        }

        public int getCount() {
            return MAX_DATA_COUNT;
        }
    };

    public FutureBrewingStandBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.FUTURE_BREWING_STAND_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public int[] getSlotsForFace(Direction pSide) {
        if (pSide == Direction.UP) {
            return SLOTS_FOR_UP;
        } else if (pSide == Direction.DOWN) {
            return SLOTS_FOR_DOWN;
        } else if (pSide == Direction.SOUTH) {
            return SLOTS_FOR_BEHIND;
        } else {
            return SLOTS_FOR_SIDES;
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int pIndex, ItemStack pItemStack, @Nullable Direction pDirection) {
        return this.canPlaceItem(pIndex, pItemStack);
    }

    @Override
    public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
        return pIndex != 6 || pStack.is(Items.GLASS_BOTTLE);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.virtuarealcraft.brewing");
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        //TODO 完成炼药台的GUI
        return new FutureBrewingStandMenu(pContainerId, pInventory, this, this.dataAccess);
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private boolean[] getPotionBits() {
        boolean[] bool = new boolean[6];

        for (int i = 0; i < 6; ++i) {
            if (!this.items.get(i).isEmpty()) {
                bool[i] = true;
            }
        }

        return bool;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);
        this.brewTime = pTag.getShort("BrewTime");
        this.fuel = pTag.getShort("Fuel");
        this.mode = pTag.getShort("Mode");
        this.fuelTick = pTag.getShort("FuelTick");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putShort("BrewTime", (short) this.brewTime);
        ContainerHelper.saveAllItems(pTag, this.items);
        pTag.putShort("Fuel", (short) this.fuel);
        pTag.putShort("Mode", (short) this.mode);
        pTag.putShort("FuelTick", (short) this.fuelTick);
    }

    @Override
    public boolean canPlaceItem(int pIndex, ItemStack pStack) {
        //TODO 修改为自定义的配方检测
        if (pIndex == 6) {
            return net.minecraftforge.common.brewing.BrewingRecipeRegistry.isValidIngredient(pStack);
        } else if (pIndex == 7) {
            return pStack.is(Items.BLAZE_POWDER);
        } else if (pIndex == 8) {
            return pStack.is(Items.REDSTONE) || pStack.is(Items.GLOWSTONE_DUST) || pStack.is(ItemRegistry.TOKIMORI_SEISAND.get());
        } else {
            return net.minecraftforge.common.brewing.BrewingRecipeRegistry.isValidInput(pStack) && this.getItem(pIndex).isEmpty();
        }
    }

    private static boolean isBrewable(NonNullList<ItemStack> pItems) {
        ItemStack ingredient = pItems.get(INGREDIENT_SLOT);

        // TODO 添加自定义原料判断
        if (!ingredient.isEmpty())
            return net.minecraftforge.common.brewing.BrewingRecipeRegistry.canBrew(pItems, ingredient, SLOTS_FOR_SIDES); // divert to VanillaBrewingRegistry
        if (ingredient.isEmpty()) {
            return false;
        } else if (!PotionBrewing.isIngredient(ingredient)) {
            return false;
        } else {
            // 6个药水槽
            for (int i = 0; i < 6; ++i) {
                ItemStack potion = pItems.get(i);
                // TODO 添加自定义配方判断
                if (!potion.isEmpty() && PotionBrewing.hasMix(potion, ingredient)) {
                    return true;
                }
            }

            return false;
        }
    }

    private static void doBrew(Level pLevel, BlockPos pPos, NonNullList<ItemStack> pItems) {
        if (net.minecraftforge.event.ForgeEventFactory.onPotionAttemptBrew(pItems)) return;
        ItemStack ingredient = pItems.get(INGREDIENT_SLOT);

        // event listener
        net.minecraftforge.common.brewing.BrewingRecipeRegistry.brewPotions(pItems, ingredient, SLOTS_FOR_SIDES);
        net.minecraftforge.event.ForgeEventFactory.onPotionBrewed(pItems);

        if (ingredient.hasCraftingRemainingItem()) {
            ItemStack ingredientStack = ingredient.getCraftingRemainingItem();
            ingredient.shrink(1);
            if (ingredient.isEmpty()) {
                ingredient = ingredientStack;
            } else {
                Containers.dropItemStack(pLevel, pPos.getX(), pPos.getY(), pPos.getZ(), ingredientStack);
            }
        } else ingredient.shrink(1);

        pItems.set(INGREDIENT_SLOT, ingredient);

        // play sound?
        pLevel.levelEvent(1035, pPos, 0);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, FutureBrewingStandBlockEntity pBlockEntity) {
        //TODO 完成tick方法
        ItemStack fuel = pBlockEntity.items.get(FUEL_SLOT);
        if (pBlockEntity.fuel <= MAX_FUEL - 20 && fuel.is(Items.BLAZE_POWDER) && pBlockEntity.fuelTick != 200) {
            pBlockEntity.fuel += 20;
            fuel.shrink(1);
            setChanged(pLevel, pPos, pState);
        }

        if (pBlockEntity.fuel < MAX_FUEL) {
            if (pBlockEntity.fuelTick < 200) {
                pBlockEntity.fuelTick += 1;
            } else {
                pBlockEntity.fuel += 1;
                pBlockEntity.fuelTick = 0;
            }
        } else {
            pBlockEntity.fuelTick = 0;
        }

        boolean canBrew = isBrewable(pBlockEntity.items);
        boolean brewing = pBlockEntity.brewTime > 0;
        ItemStack ingredient = pBlockEntity.items.get(INGREDIENT_SLOT);

        if (brewing) {
            --pBlockEntity.brewTime;
            boolean brewFinished = pBlockEntity.brewTime == 0;
            if (brewFinished && canBrew) {
                // finish brewing
                if (pBlockEntity.mode == 2) {
                    pBlockEntity.fuel -= 2;
                } else {
                    pBlockEntity.fuel -= 1;
                }

                doBrew(pLevel, pPos, pBlockEntity.items);
                setChanged(pLevel, pPos, pState);
            } else if (!canBrew || !ingredient.is(pBlockEntity.ingredient) || (pBlockEntity.mode == 2 && pBlockEntity.fuel < 2)) {
                // wrong ingredient, stop brewing
                pBlockEntity.brewTime = 0;
                setChanged(pLevel, pPos, pState);
            }
        } else if (canBrew && canBrewInDifferentMode(pBlockEntity.mode, pBlockEntity.fuel)) {
            // start brewing
            pBlockEntity.brewTime = 200;    // 10s
            pBlockEntity.ingredient = ingredient.getItem();
            setChanged(pLevel, pPos, pState);
        }

        boolean[] potionBits = pBlockEntity.getPotionBits();
        if (!Arrays.equals(potionBits, pBlockEntity.lastPotionCount)) {
            pBlockEntity.lastPotionCount = potionBits;
            BlockState blockstate = pState;
            if (!(pState.getBlock() instanceof FutureBrewingStandBlock)) {
                return;
            }

            int count = 0;
            for (boolean potionBit : potionBits) {
                if (potionBit) {
                    count++;
                }
            }

            blockstate = blockstate.setValue(FutureBrewingStandBlock.BOTTLES, count);
            pLevel.setBlock(pPos, blockstate, 2);
        }
    }

    private static boolean canBrewInDifferentMode(int mode, int fuel) {
        return mode == 2 ? fuel > 1 : fuel > 0;
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
        if (pSlot >= 0 && pSlot < this.items.size()) {
            this.items.set(pSlot, pStack);
        }
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
