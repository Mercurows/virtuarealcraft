//package top.yora.virtuarealcraft.recipe;
//
//import com.google.gson.JsonObject;
//import net.minecraft.core.NonNullList;
//import net.minecraft.core.RegistryAccess;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.util.GsonHelper;
//import net.minecraft.world.SimpleContainer;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.*;
//import net.minecraft.world.level.Level;
//import top.yora.virtuarealcraft.Utils;
//
//import javax.annotation.Nullable;
//
//@SuppressWarnings("ClassCanBeRecord")
//public class FutureBrewingRecipe implements Recipe<SimpleContainer> {
//    private final Ingredient input;
//    private final Ingredient ingredient;
//    @Nullable private final ItemStack powder;
//    private final ItemStack output;
//    private final ResourceLocation id;
//
//    public FutureBrewingRecipe(Ingredient input, Ingredient ingredient, @Nullable ItemStack powder, ItemStack output, ResourceLocation id) {
//        this.input = input;
//        this.ingredient = ingredient;
//        this.powder = powder;
//        this.output = output;
//        this.id = id;
//    }
//
//    @Override
//    public boolean matches(SimpleContainer pContainer, Level pLevel) {
//        if(pLevel.isClientSide()) {
//            return false;
//        }
//
//        return input.test(pContainer.getItem(0)) && ingredient.test(pContainer.getItem(6));
//    }
//
//    @Override
//    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
//        return output.copy();
//    }
//
//    @Override
//    public boolean canCraftInDimensions(int pWidth, int pHeight) {
//        return true;
//    }
//
//    @Override
//    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
//        return output.copy();
//    }
//
//    @Override
//    public ResourceLocation getId() {
//        return id;
//    }
//
//    @Override
//    public RecipeSerializer<?> getSerializer() {
//        return Serializer.INSTANCE;
//    }
//
//    @Override
//    public RecipeType<?> getType() {
//        return Type.INSTANCE;
//    }
//
//    public static class Type implements RecipeType<FutureBrewingRecipe> {
//        public static final Type INSTANCE = new Type();
//        public static final String ID = "future_brewing";
//    }
//
//    public static class Serializer implements RecipeSerializer<FutureBrewingRecipe> {
//        public static final Serializer INSTANCE = new Serializer();
//        public static final ResourceLocation ID = new ResourceLocation(Utils.MOD_ID, "future_brewing");
//
//        @Override
//        public FutureBrewingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
//            Ingredient input = Ingredient.fromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "input"));
//            Ingredient ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "ingredient"));
//            ItemStack powder = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "powder"));
//            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
//
//            return new FutureBrewingRecipe(input, ingredient, powder, output, pRecipeId);
//        }
//
//        @Override
//        public @Nullable FutureBrewingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
//            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
//
//            for(int i = 0; i < inputs.size(); i++) {
//                inputs.set(i, Ingredient.fromNetwork(pBuffer));
//            }
//
//            ItemStack output = pBuffer.readItem();
//            return new FutureBrewingRecipe(inputs, output, pRecipeId);
//        }
//
//        @Override
//        public void toNetwork(FriendlyByteBuf pBuffer, FutureBrewingRecipe pRecipe) {
//            pBuffer.writeInt(pRecipe.inputItems.size());
//
//            for (Ingredient ingredient : pRecipe.getIngredients()) {
//                ingredient.toNetwork(pBuffer);
//            }
//
//            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
//        }
//    }
//}
