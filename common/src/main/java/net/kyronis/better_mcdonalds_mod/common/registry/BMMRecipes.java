package net.kyronis.better_mcdonalds_mod.common.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.DeferredSupplier;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.recipe.BMMFryingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class BMMRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BetterMcDonaldsMod.MOD_ID, Registries.RECIPE_SERIALIZER);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BetterMcDonaldsMod.MOD_ID, Registries.RECIPE_TYPE);
    public static final DeferredRegister<RecipeBookCategory> RECIPE_BOOK_CATEGORIES = DeferredRegister.create(BetterMcDonaldsMod.MOD_ID, Registries.RECIPE_BOOK_CATEGORY);

    public static final DeferredSupplier<RecipeSerializer<BMMFryingRecipe>> FRYING_SERIALIZER = RECIPE_SERIALIZERS.register("frying", () -> new AbstractCookingRecipe.Serializer<>(BMMFryingRecipe::new, 200));
    public static final DeferredSupplier<RecipeType<BMMFryingRecipe>> FRYING_TYPE = RECIPE_TYPES.register("frying", () -> new RecipeType<BMMFryingRecipe>() {
        @Override
        public String toString() {
            return "frying";
        }
    });
    public static final DeferredSupplier<RecipeBookCategory> FRYER_FOOD = RECIPE_BOOK_CATEGORIES.register("fryer_food", RecipeBookCategory::new);

    public static void register() {
        RECIPE_SERIALIZERS.register();
        RECIPE_TYPES.register();
        RECIPE_BOOK_CATEGORIES.register();
    }
}