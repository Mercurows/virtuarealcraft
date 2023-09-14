package top.yora.virtuarealcraft.data.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("ClassCanBeRecord")
public class FutureBrewingRecipe implements IFutureBrewingRecipe{
    @NotNull private final Ingredient input;
    @NotNull private final Ingredient ingredient;
    @Nullable private final Ingredient powder;
    @NotNull private final ItemStack output;
    private final boolean flag;

    public FutureBrewingRecipe(@NotNull Ingredient input, @NotNull Ingredient ingredient, @Nullable Ingredient powder, boolean flag, @NotNull ItemStack output) {
        this.input = input;
        this.ingredient = ingredient;
        this.powder = powder;
        this.flag = flag;
        this.output = output;
    }

    @Override
    public boolean isInput(ItemStack input) {
        return this.input.test(input);
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return this.ingredient.test(ingredient);
    }

    @Override
    public boolean isPowder(ItemStack powder) {
        return true;
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient, ItemStack powder) {
        return isInput(input) && isIngredient(ingredient) && isPowder(powder) ? getOutput().copy() : ItemStack.EMPTY;
    }

    public ItemStack getOutput() {
        return output;
    }

    public Ingredient getInput() {
        return input;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Ingredient getPowder() {
        return powder;
    }

    public boolean isFlag() {
        return flag;
    }
}
