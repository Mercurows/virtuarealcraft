package top.yora.virtuarealcraft.data;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import top.yora.virtuarealcraft.data.recipes.FutureBrewingRecipe;
import top.yora.virtuarealcraft.data.recipes.IFutureBrewingRecipe;

import java.util.ArrayList;
import java.util.List;

public class BrewingRecipes {
    private static List<IFutureBrewingRecipe> recipes = new ArrayList<>();

    static {

    }

    public static boolean addRecipe(Ingredient input, Ingredient ingredient, Ingredient powder, boolean flag, ItemStack output) {
        return addRecipe(new FutureBrewingRecipe(input, ingredient, powder, flag, output));
    }

    public static boolean addRecipe(IFutureBrewingRecipe recipe) {
        return recipes.add(recipe);
    }

}
