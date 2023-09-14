package top.yora.virtuarealcraft.data.recipes;

import com.google.common.collect.Lists;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.function.Predicate;

public class ModPotionBrewing {
    public static final int BREWING_TIME_SECONDS = 10;
    private static final List<PotionBrewing.Mix<Potion>> POTION_MIXES = Lists.newArrayList();
    private static final List<PotionBrewing.Mix<Item>> CONTAINER_MIXES = Lists.newArrayList();
    private static final List<Ingredient> ALLOWED_CONTAINERS = Lists.newArrayList();
    private static final Predicate<ItemStack> ALLOWED_CONTAINER = (item) -> {
        for (Ingredient ingredient : ALLOWED_CONTAINERS) {
            if (ingredient.test(item)) {
                return true;
            }
        }

        return false;
    };

    public static boolean isIngredient(ItemStack pInput) {
        return isContainerIngredient(pInput) || isPotionIngredient(pInput);
    }

    protected static boolean isContainerIngredient(ItemStack pInput) {
        int i = 0;

        for (int j = CONTAINER_MIXES.size(); i < j; ++i) {
            if ((CONTAINER_MIXES.get(i)).ingredient.test(pInput)) {
                return true;
            }
        }

        return false;
    }

    protected static boolean isPotionIngredient(ItemStack pInput) {
        int i = 0;

        for (int j = POTION_MIXES.size(); i < j; ++i) {
            if ((POTION_MIXES.get(i)).ingredient.test(pInput)) {
                return true;
            }
        }

        return false;
    }


    public static void bootStrap() {
        addContainer(Items.POTION);
        addContainer(Items.SPLASH_POTION);
        addContainer(Items.LINGERING_POTION);
        addContainerRecipe(Items.POTION, Items.GUNPOWDER, Items.SPLASH_POTION);
        addContainerRecipe(Items.SPLASH_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION);
    }

    private static void addContainerRecipe(Item pFrom, Item pIngredient, Item pTo) {
        if (!(pFrom instanceof PotionItem)) {
            throw new IllegalArgumentException("Expected a potion, got: " + BuiltInRegistries.ITEM.getKey(pFrom));
        } else if (!(pTo instanceof PotionItem)) {
            throw new IllegalArgumentException("Expected a potion, got: " + BuiltInRegistries.ITEM.getKey(pTo));
        } else {
            CONTAINER_MIXES.add(new PotionBrewing.Mix<>(net.minecraftforge.registries.ForgeRegistries.ITEMS, pFrom, Ingredient.of(pIngredient), pTo));
        }
    }

    private static void addContainer(Item pContainer) {
        if (!(pContainer instanceof PotionItem)) {
            throw new IllegalArgumentException("Expected a potion, got: " + BuiltInRegistries.ITEM.getKey(pContainer));
        } else {
            ALLOWED_CONTAINERS.add(Ingredient.of(pContainer));
        }
    }

    private static void addMix(Potion pPotionEntry, Item pPotionIngredient, Potion pPotionResult) {
        POTION_MIXES.add(new PotionBrewing.Mix<>(net.minecraftforge.registries.ForgeRegistries.POTIONS, pPotionEntry, Ingredient.of(pPotionIngredient), pPotionResult));
    }
}
