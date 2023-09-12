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
import top.yora.virtuarealcraft.init.ItemRegistry;

//TODO 完成菜单类型注册和渲染
public class FutureBrewingStandMenu extends AbstractContainerMenu {
    private final Container brewingStand;
    private final ContainerData brewingStandData;
    private final Slot ingredientSlot;

    public FutureBrewingStandMenu(int pContainerId, Inventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, new SimpleContainer(9), new SimpleContainerData(2));
    }

    public FutureBrewingStandMenu(int pContainerId, Inventory pPlayerInventory, Container pBrewingStandContainer, ContainerData pBrewingStandData) {
        super(MenuType.BREWING_STAND, pContainerId);

        //TODO 修改为正确的槽位排列
        checkContainerSize(pBrewingStandContainer, 9);
        checkContainerDataCount(pBrewingStandData, 2);
        this.brewingStand = pBrewingStandContainer;
        this.brewingStandData = pBrewingStandData;
        this.addSlot(new FutureBrewingStandMenu.PotionSlot(pBrewingStandContainer, 0, 36, 51));
        this.addSlot(new FutureBrewingStandMenu.PotionSlot(pBrewingStandContainer, 1, 60, 58));
        this.addSlot(new FutureBrewingStandMenu.PotionSlot(pBrewingStandContainer, 2, 84, 65));
        this.addSlot(new FutureBrewingStandMenu.PotionSlot(pBrewingStandContainer, 3, 108, 65));
        this.addSlot(new FutureBrewingStandMenu.PotionSlot(pBrewingStandContainer, 4, 132, 58));
        this.addSlot(new FutureBrewingStandMenu.PotionSlot(pBrewingStandContainer, 5, 156, 51));
        this.ingredientSlot = this.addSlot(new FutureBrewingStandMenu.IngredientsSlot(pBrewingStandContainer, 6, 96, 17));
        this.addSlot(new FutureBrewingStandMenu.FuelSlot(pBrewingStandContainer, 7, 17, 17));
        this.addSlot(new FutureBrewingStandMenu.PowderSlot(pBrewingStandContainer, 8, 120, 17));
        this.addDataSlots(pBrewingStandData);

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(pPlayerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(pPlayerInventory, k, 8 + k * 18, 142));
        }

    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        //TODO 完成快速填充方法
        return null;
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
                CriteriaTriggers.BREWED_POTION.trigger((ServerPlayer)pPlayer, potion);
            }

            super.onTake(pPlayer, pStack);
        }

        public static boolean mayPlaceItem(ItemStack pStack) {
            return net.minecraftforge.common.brewing.BrewingRecipeRegistry.isValidInput(pStack);
        }
    }
}
