package top.yora.virtuarealcraft.recipe;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yora.virtuarealcraft.Utils;

import java.util.List;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID)
public class FutureBrewingRecipeRegistry {
    public static List<FutureBrewingRecipe> recipes = null;

    public static void loadRecipes(List<FutureBrewingRecipe> list) {
        recipes = list;
    }

    @SubscribeEvent
    public static void onInit(ServerStartingEvent event) {
        Level level = event.getServer().overworld();
        RecipeManager recipeManager = level.getRecipeManager();
        List<FutureBrewingRecipe> list = recipeManager.getAllRecipesFor(FutureBrewingRecipe.Type.INSTANCE);
        if (FutureBrewingRecipeRegistry.recipes == null) {
            FutureBrewingRecipeRegistry.loadRecipes(list);
        }
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();

        if (FutureBrewingRecipeRegistry.recipes == null) {
            RecipeManager recipeManager = player.level().getRecipeManager();
            List<FutureBrewingRecipe> list = recipeManager.getAllRecipesFor(FutureBrewingRecipe.Type.INSTANCE);
            FutureBrewingRecipeRegistry.loadRecipes(list);
        }
    }

    public static boolean isValidIngredient(ItemStack stack) {
        if (recipes == null) {
            return false;
        }

        if (stack.isEmpty()) {
            return false;
        }

        for (FutureBrewingRecipe recipe : recipes) {
            if (recipe.ingredient.test(stack)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidInput(ItemStack stack) {
        if (recipes == null) {
            return false;
        }

        if (stack.isEmpty()) {
            return false;
        }

        for (FutureBrewingRecipe recipe : recipes) {
            if (recipe.input.test(stack)) {
                return true;
            }
        }
        return false;
    }
}
