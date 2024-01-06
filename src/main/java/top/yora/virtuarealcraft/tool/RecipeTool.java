package top.yora.virtuarealcraft.tool;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipe;

import javax.annotation.Nullable;

public class RecipeTool {
    public static Ingredient potionFromJson(JsonObject json, String name) {
        if (json.has(name)) {
            JsonObject jsonObject = GsonHelper.getAsJsonObject(json, name);

            if (jsonObject.has("potion")) {
                JsonObject potion = GsonHelper.getAsJsonObject(jsonObject, "potion");

                if (!potion.has("potion")) {
                    throw new JsonSyntaxException("Missing potion, expected to find a String");
                }

                ItemStack base;

                if (!potion.has("type")) {
                    base = new ItemStack(Items.POTION);
                } else {
                    String typeStr = GsonHelper.getAsString(potion, "type");
                    base = switch (typeStr) {
                        case "lingering" -> new ItemStack(Items.LINGERING_POTION);
                        case "splash" -> new ItemStack(Items.SPLASH_POTION);
                        default -> new ItemStack(Items.POTION);
                    };
                }

                String potionStr = GsonHelper.getAsString(potion, "potion");

                ItemStack potionStack = PotionUtils.setPotion(base, Potion.byName(potionStr));
                if (potionStack.isEmpty()) {
                    throw new JsonSyntaxException("Empty ingredient not allowed here");
                }

                return Ingredient.of(potionStack);
            }

            return Ingredient.fromJson(GsonHelper.getAsJsonObject(jsonObject, name));
        } else {
            throw new JsonSyntaxException("Missing " + name + ", expected to find a JsonObject");
        }
    }

    public static ItemStack potionItemFromJson(JsonObject json, String name) {
        if (json.has(name)) {
            JsonObject jsonObject = GsonHelper.getAsJsonObject(json, name);

            if (jsonObject.has("potion")) {
                JsonObject potion = GsonHelper.getAsJsonObject(jsonObject, "potion");

                if (!potion.has("potion")) {
                    throw new JsonSyntaxException("Missing potion, expected to find a String");
                }

                ItemStack base;

                if (!potion.has("type")) {
                    base = new ItemStack(Items.POTION);
                } else {
                    String typeStr = GsonHelper.getAsString(potion, "type");
                    base = switch (typeStr) {
                        case "lingering" -> new ItemStack(Items.LINGERING_POTION);
                        case "splash" -> new ItemStack(Items.SPLASH_POTION);
                        default -> new ItemStack(Items.POTION);
                    };
                }

                String potionStr = GsonHelper.getAsString(potion, "potion");

                ItemStack potionStack = PotionUtils.setPotion(base, Potion.byName(potionStr));
                if (potionStack.isEmpty()) {
                    throw new JsonSyntaxException("Cannot find this item");
                }

                return potionStack;
            }

            return ShapedRecipe.itemStackFromJson(jsonObject);
        } else {
            throw new JsonSyntaxException("Missing " + name + ", expected to find a JsonObject");
        }
    }

    public static boolean strictTest(Ingredient ingredient, @Nullable ItemStack pStack) {
        if (pStack == null) {
            return false;
        } else if (ingredient.isEmpty()) {
            return pStack.isEmpty();
        } else {
            for (ItemStack itemstack : ingredient.getItems()) {
                if (itemstack.equals(pStack, true)) {
                    return true;
                }
            }

            return false;
        }
    }
}
