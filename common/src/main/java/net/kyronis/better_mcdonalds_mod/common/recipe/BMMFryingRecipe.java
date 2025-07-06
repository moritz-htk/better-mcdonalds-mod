package net.kyronis.better_mcdonalds_mod.common.recipe;

import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMRecipes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.NotNull;

public class BMMFryingRecipe extends AbstractCookingRecipe {
    public BMMFryingRecipe(String group, CookingBookCategory category, Ingredient input, ItemStack result, float experience, int cookingTime) {
        super(group, category, input, result, experience, cookingTime);
    }

    @Override
    public @NotNull RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return BMMRecipes.FRYING_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<? extends AbstractCookingRecipe> getType() {
        return BMMRecipes.FRYING_TYPE.get();
    }

    @Override
    public @NotNull RecipeBookCategory recipeBookCategory() {
        return BMMRecipes.FRYER_FOOD.get();
    }

    @Override
    protected @NotNull Item furnaceIcon() {
        return BMMItems.HAPPY_MEAL.get();
    }
}