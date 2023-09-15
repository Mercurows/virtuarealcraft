package top.yora.virtuarealcraft.gui;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import top.yora.virtuarealcraft.block.blockentity.FutureBrewingStandBlockEntity;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.init.MenuTypeRegistry;

public class FutureBrewingStandMenu extends AbstractContainerMenu {
    private final Container brewingStand;
    private final ContainerData brewingStandData;
    private final Slot ingredientSlot;
    private final Slot powderSlot;

    public static final int X_OFFSET = 30;
    public static final int Y_OFFSET = 39;

    public FutureBrewingStandMenu(int pContainerId, Inventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, new SimpleContainer(9), new SimpleContainerData(FutureBrewingStandBlockEntity.MAX_DATA_COUNT));
    }

    public FutureBrewingStandMenu(int pContainerId, Inventory pPlayerInventory, Container pBrewingStandContainer, ContainerData pBrewingStandData) {
        super(MenuTypeRegistry.FUTURE_BREWING_STAND_MENU.get(), pContainerId);

        //TODO 修改为正确的槽位排列
        checkContainerSize(pBrewingStandContainer, 9);
        checkContainerDataCount(pBrewingStandData, FutureBrewingStandBlockEntity.MAX_DATA_COUNT);
        this.brewingStand = pBrewingStandContainer;
        this.brewingStandData = pBrewingStandData;
        this.addSlot(new FutureBrewingStandMenu.PotionSlot(pBrewingStandContainer, 0, 36, 51));
        this.addSlot(new FutureBrewingStandMenu.PotionSlot(pBrewingStandContainer, 1, 60, 58));
        this.addSlot(new FutureBrewingStandMenu.PotionSlot(pBrewingStandContainer, 2, 84, 65));
        this.addSlot(new FutureBrewingStandMenu.PotionSlot(pBrewingStandContainer, 3, 108, 65));
        this.addSlot(new FutureBrewingStandMenu.PotionSlot(pBrewingStandContainer, 4, 132, 58));
        this.addSlot(new FutureBrewingStandMenu.PotionSlot(pBrewingStandContainer, 5, 156, 51));
        this.ingredientSlot = this.addSlot(new FutureBrewingStandMenu.IngredientsSlot(pBrewingStandContainer, 6, 129, 11));
        this.addSlot(new FutureBrewingStandMenu.FuelSlot(pBrewingStandContainer, 7, 14, 58));
        this.powderSlot = this.addSlot(new FutureBrewingStandMenu.PowderSlot(pBrewingStandContainer, 8, 159, 24));
        this.addDataSlots(pBrewingStandData);

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(pPlayerInventory, j + i * 9 + 9, 8 + j * 18 + X_OFFSET, 84 + i * 18 + Y_OFFSET));
            }
        }

        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(pPlayerInventory, k, 8 + k * 18 + X_OFFSET, 142 + Y_OFFSET));
        }

    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if ((pIndex < 0 || pIndex > 5) && pIndex != 6 && pIndex != 7 && pIndex != 8) {
                if (FutureBrewingStandMenu.FuelSlot.mayPlaceItem(itemstack)) {
                    if (this.moveItemStackTo(itemstack1, 7, 8, false) ||
                            this.ingredientSlot.mayPlace(itemstack1) && !this.moveItemStackTo(itemstack1, 6, 7, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.powderSlot.mayPlace(itemstack1)) {
                    if (this.moveItemStackTo(itemstack1, 8, 9, false) ||
                            this.ingredientSlot.mayPlace(itemstack1) && !this.moveItemStackTo(itemstack1, 6, 7, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.ingredientSlot.mayPlace(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 6, 7, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (FutureBrewingStandMenu.PotionSlot.mayPlaceItem(itemstack)) {
                    if (!this.moveItemStackTo(itemstack1, 0, 6, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= 9 && pIndex < 36) {
                    if (!this.moveItemStackTo(itemstack1, 36, 45, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= 36 && pIndex < 45) {
                    if (!this.moveItemStackTo(itemstack1, 9, 36, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.moveItemStackTo(itemstack1, 9, 45, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!this.moveItemStackTo(itemstack1, 9, 45, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, itemstack1);
        }

        return itemstack;
    }

    public int getFuelTick() {
        return this.brewingStandData.get(3);
    }

    /**
     * 获取当前炼药模式
     *
     * @return 0 - 普通; 1 - 自动注水; 2 - 自动注水 + 自动粗制
     */
    public int getBrewingMode() {
        return this.brewingStandData.get(2);
    }

    public int getFuel() {
        return this.brewingStandData.get(1);
    }

    public int getBrewingTicks() {
        return this.brewingStandData.get(0);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return this.brewingStand.stillValid(pPlayer);
    }

    static class FuelSlot extends Slot {
        public FuelSlot(Container pContainer, int pSlot, int pX, int pY) {
            super(pContainer, pSlot, pX, pY);
        }

        public boolean mayPlace(ItemStack pStack) {
            return mayPlaceItem(pStack);
        }

        public static boolean mayPlaceItem(ItemStack pItemStack) {
            return pItemStack.is(Items.BLAZE_POWDER);
        }

        public int getMaxStackSize() {
            return 64;
        }
    }

    static class IngredientsSlot extends Slot {
        public IngredientsSlot(Container pContainer, int pSlot, int pX, int pY) {
            super(pContainer, pSlot, pX, pY);
        }

        public boolean mayPlace(ItemStack pStack) {
            return net.minecraftforge.common.brewing.BrewingRecipeRegistry.isValidIngredient(pStack);
        }

        public int getMaxStackSize() {
            return 64;
        }
    }

    static class PowderSlot extends Slot {
        public PowderSlot(Container pContainer, int pSlot, int pX, int pY) {
            super(pContainer, pSlot, pX, pY);
        }

        public boolean mayPlace(ItemStack pStack) {
            return pStack.is(Items.REDSTONE) || pStack.is(Items.GLOWSTONE_DUST) || pStack.is(ItemRegistry.TOKIMORI_SEISAND.get());
        }

        public int getMaxStackSize() {
            return 64;
        }
    }

    static class PotionSlot extends Slot {
        public PotionSlot(Container pContainer, int pSlot, int pX, int pY) {
            super(pContainer, pSlot, pX, pY);
        }

        public boolean mayPlace(ItemStack pStack) {
            return mayPlaceItem(pStack);
        }

        public int getMaxStackSize() {
            return 1;
        }

        public void onTake(Player pPlayer, ItemStack pStack) {
            Potion potion = PotionUtils.getPotion(pStack);
            if (pPlayer instanceof ServerPlayer) {
                net.minecraftforge.event.ForgeEventFactory.onPlayerBrewedPotion(pPlayer, pStack);
                CriteriaTriggers.BREWED_POTION.trigger((ServerPlayer) pPlayer, potion);
            }

            super.onTake(pPlayer, pStack);
        }

        public static boolean mayPlaceItem(ItemStack pStack) {
            return net.minecraftforge.common.brewing.BrewingRecipeRegistry.isValidInput(pStack);
        }
    }
}
