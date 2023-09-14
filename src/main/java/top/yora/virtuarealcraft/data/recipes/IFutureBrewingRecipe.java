package top.yora.virtuarealcraft.data.recipes;

import net.minecraft.world.item.ItemStack;

public interface IFutureBrewingRecipe {
    boolean isInput(ItemStack input);

    boolean isIngredient(ItemStack ingredient);

    boolean isPowder(ItemStack powder);

    ItemStack getOutput(ItemStack input, ItemStack ingredient, ItemStack powder);
}
