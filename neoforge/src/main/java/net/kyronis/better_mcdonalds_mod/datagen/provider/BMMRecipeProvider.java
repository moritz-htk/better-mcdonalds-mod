package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BMMRecipeProvider extends RecipeProvider {
    private final HolderGetter<Item> items;

    protected BMMRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
        items = registries.lookupOrThrow(Registries.ITEM);
    }

    @Override
    protected void buildRecipes() {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, BMMBlocks.SALT_BLOCK.get(), 1)
                .define('#', BMMTags.Items.DUSTS_SALT)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .save(output, registerRecipe(BMMBlocks.SALT_BLOCK.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.TOMATO_SEEDS.get(), 2)
                .requires(BMMTags.Items.CROPS_TOMATO)
                .unlockedBy(getHasName(BMMItems.TOMATO.get()), has(BMMTags.Items.CROPS_TOMATO))
                .save(output, registerRecipe(BMMItems.TOMATO_SEEDS.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.LETTUCE_SEEDS.get(), 2)
                .requires(BMMTags.Items.CROPS_LETTUCE)
                .unlockedBy(getHasName(BMMItems.LETTUCE.get()), has(BMMTags.Items.CROPS_LETTUCE))
                .save(output, registerRecipe(BMMItems.LETTUCE_SEEDS.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.CHEESE.get(), 2)
                .requires(Items.MILK_BUCKET)
                .requires(BMMTags.Items.DUSTS_SALT)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .save(output, registerRecipe(BMMItems.CHEESE.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.TORTILLA.get(), 2)
                .requires(Items.WATER_BUCKET)
                .requires(Items.WHEAT, 2)
                .requires(Items.EGG)
                .requires(BMMTags.Items.DUSTS_SALT)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .save(output, registerRecipe(BMMItems.TORTILLA.get()));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.BEEF), RecipeCategory.FOOD, BMMItems.BEEF_PATTY.get(), 2)
                .unlockedBy(getHasName(Items.BEEF), has(Items.BEEF))
                .save(output, registerRecipe(BMMItems.BEEF_PATTY.get()));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BMMItems.BEEF_PATTY.get()), RecipeCategory.FOOD, BMMItems.COOKED_BEEF_PATTY.get(), 1.0f, 200)
                .unlockedBy(getHasName(BMMItems.BEEF_PATTY.get()), has(BMMItems.BEEF_PATTY.get()))
                .save(output, ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BEEF_PATTY.get()) + "_smelting")));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(BMMItems.BEEF_PATTY.get()), RecipeCategory.FOOD, BMMItems.COOKED_BEEF_PATTY.get(), 1.0f, 100)
                .unlockedBy(getHasName(BMMItems.BEEF_PATTY.get()), has(BMMItems.BEEF_PATTY.get()))
                .save(output, ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BEEF_PATTY.get()) + "_smoking")));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(BMMItems.BEEF_PATTY.get()), RecipeCategory.FOOD, BMMItems.COOKED_BEEF_PATTY.get(), 1.0f, 600)
                .unlockedBy(getHasName(BMMItems.BEEF_PATTY.get()), has(BMMItems.BEEF_PATTY.get()))
                .save(output, ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BEEF_PATTY.get()) + "_campfire_cooking")));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.PORKCHOP), RecipeCategory.FOOD, BMMItems.RAW_BACON.get(), 2)
                .unlockedBy(getHasName(Items.PORKCHOP), has(Items.PORKCHOP))
                .save(output, registerRecipe(BMMItems.RAW_BACON.get()));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BMMItems.RAW_BACON.get()), RecipeCategory.FOOD, BMMItems.COOKED_BACON.get(), 1.0f, 200)
                .unlockedBy(getHasName(BMMItems.RAW_BACON.get()), has(BMMItems.RAW_BACON.get()))
                .save(output, ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BACON.get()) + "_smelting")));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(BMMItems.RAW_BACON.get()), RecipeCategory.FOOD, BMMItems.COOKED_BACON.get(), 1.0f, 100)
                .unlockedBy(getHasName(BMMItems.RAW_BACON.get()), has(BMMItems.RAW_BACON.get()))
                .save(output, ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BACON.get()) + "_smoking")));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(BMMItems.RAW_BACON.get()), RecipeCategory.FOOD, BMMItems.COOKED_BACON.get(), 1.0f, 600)
                .unlockedBy(getHasName(BMMItems.RAW_BACON.get()), has(BMMItems.RAW_BACON.get()))
                .save(output, ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BACON.get()) + "_campfire_cooking")));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.MAYONNAISE.get(), 2)
                .requires(Items.MILK_BUCKET)
                .requires(Items.EGG)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .save(output, registerRecipe(BMMItems.MAYONNAISE.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.SWEET_SOUR_SAUCE.get(), 2)
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(Items.HONEY_BOTTLE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(Items.HONEY_BOTTLE), has(Items.HONEY_BOTTLE))
                .save(output, registerRecipe(BMMItems.SWEET_SOUR_SAUCE.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.KETCHUP.get(), 2)
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(BMMTags.Items.CROPS_TOMATO)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(BMMItems.TOMATO.get()), has(BMMTags.Items.CROPS_TOMATO))
                .save(output, registerRecipe(BMMItems.KETCHUP.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.MUSTARD.get(), 2)
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(Items.PUMPKIN_SEEDS)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(Items.PUMPKIN_SEEDS), has(Items.PUMPKIN_SEEDS))
                .save(output, registerRecipe(BMMItems.MUSTARD.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.HAMBURGER.get())
                .requires(Items.BREAD)
                .requires(BMMItems.COOKED_BEEF_PATTY.get())
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.get()), has(BMMItems.COOKED_BEEF_PATTY.get()))
                .save(output, registerRecipe(BMMItems.HAMBURGER.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.CHEESEBURGER.get())
                .requires(Items.BREAD)
                .requires(BMMItems.COOKED_BEEF_PATTY.get())
                .requires(BMMTags.Items.FOODS_CHEESE)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.get()), has(BMMItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(BMMItems.CHEESE.get()), has(BMMTags.Items.FOODS_CHEESE))
                .save(output, registerRecipe(BMMItems.CHEESEBURGER.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.MCBACON.get())
                .requires(Items.BREAD)
                .requires(BMMItems.COOKED_BEEF_PATTY.get())
                .requires(BMMTags.Items.FOODS_CHEESE)
                .requires(BMMTags.Items.FOODS_COOKED_BACON)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.get()), has(BMMItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(BMMItems.CHEESE.get()), has(BMMTags.Items.FOODS_CHEESE))
                .unlockedBy(getHasName(BMMItems.COOKED_BACON.get()), has(BMMTags.Items.FOODS_COOKED_BACON))
                .save(output, registerRecipe(BMMItems.MCBACON.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.BIG_MAC.get())
                .requires(Items.BREAD)
                .requires(BMMItems.COOKED_BEEF_PATTY.get(), 2)
                .requires(BMMTags.Items.FOODS_CHEESE)
                .requires(BMMTags.Items.CROPS_LETTUCE)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.get()), has(BMMItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(BMMItems.CHEESE.get()), has(BMMTags.Items.FOODS_CHEESE))
                .unlockedBy(getHasName(BMMItems.LETTUCE.get()), has(BMMTags.Items.CROPS_LETTUCE))
                .save(output, registerRecipe(BMMItems.BIG_MAC.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.CHICKENBURGER.get())
                .requires(Items.BREAD)
                .requires(Items.COOKED_CHICKEN)
                .requires(BMMTags.Items.FOODS_SAUCES_KETCHUP)
                .requires(BMMTags.Items.CROPS_LETTUCE)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                .unlockedBy(getHasName(BMMItems.KETCHUP.get()), has(BMMTags.Items.FOODS_SAUCES_KETCHUP))
                .unlockedBy(getHasName(BMMItems.LETTUCE.get()), has(BMMTags.Items.CROPS_LETTUCE))
                .save(output, registerRecipe(BMMItems.CHICKENBURGER.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.MCCHICKEN.get())
                .requires(Items.BREAD)
                .requires(Items.COOKED_CHICKEN)
                .requires(BMMTags.Items.FOODS_SAUCES_MAYONNAISE)
                .requires(BMMTags.Items.CROPS_LETTUCE)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                .unlockedBy(getHasName(BMMItems.MAYONNAISE.get()), has(BMMTags.Items.FOODS_SAUCES_MAYONNAISE))
                .unlockedBy(getHasName(BMMItems.LETTUCE.get()), has(BMMTags.Items.CROPS_LETTUCE))
                .save(output, registerRecipe(BMMItems.MCCHICKEN.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.FILET_O_FISH.get())
                .requires(Items.BREAD)
                .requires(BMMTags.Items.FOODS_CHEESE)
                .requires(Items.COOKED_SALMON)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(BMMItems.CHEESE.get()), has(BMMTags.Items.FOODS_CHEESE))
                .unlockedBy(getHasName(Items.COOKED_SALMON), has(Items.COOKED_SALMON))
                .save(output, registerRecipe(BMMItems.FILET_O_FISH.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.MCWRAP.get())
                .requires(BMMItems.TORTILLA.get())
                .requires(Items.COOKED_CHICKEN)
                .requires(BMMTags.Items.FOODS_SAUCES_MAYONNAISE)
                .requires(BMMTags.Items.CROPS_LETTUCE)
                .unlockedBy(getHasName(BMMItems.TORTILLA.get()), has(BMMItems.TORTILLA.get()))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                .unlockedBy(getHasName(BMMItems.MAYONNAISE.get()), has(BMMTags.Items.FOODS_SAUCES_MAYONNAISE))
                .unlockedBy(getHasName(BMMItems.LETTUCE.get()), has(BMMTags.Items.CROPS_LETTUCE))
                .save(output, registerRecipe(BMMItems.MCWRAP.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.SNACK_SALAD.get())
                .requires(BMMTags.Items.CROPS_TOMATO)
                .requires(BMMTags.Items.CROPS_LETTUCE)
                .requires(Items.CARROT)
                .unlockedBy(getHasName(BMMItems.TOMATO.get()), has(BMMTags.Items.CROPS_TOMATO))
                .unlockedBy(getHasName(BMMItems.LETTUCE.get()), has(BMMTags.Items.CROPS_LETTUCE))
                .unlockedBy(getHasName(Items.CARROT), has(Items.CARROT))
                .save(output, registerRecipe(BMMItems.SNACK_SALAD.get()));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.COOKED_CHICKEN), RecipeCategory.FOOD, BMMItems.CHICKEN_MCNUGGETS.get(), 2)
                .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                .save(output, registerRecipe(BMMItems.CHICKEN_MCNUGGETS.get()));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.BAKED_POTATO), RecipeCategory.FOOD, BMMItems.FRIES.get(), 2)
                .unlockedBy(getHasName(Items.BAKED_POTATO), has(Items.BAKED_POTATO))
                .save(output, registerRecipe(BMMItems.FRIES.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.HAPPY_MEAL.get())
                .requires(BMMTags.Items.BURGER)
                .requires(BMMTags.Items.SIDE_DISHES)
                .requires(BMMTags.Items.DRINKS)
                .requires(Items.APPLE)
                .unlockedBy("has_burger", has(BMMTags.Items.BURGER))
                .unlockedBy("has_side_dish", has(BMMTags.Items.SIDE_DISHES))
                .unlockedBy("has_drink", has(BMMTags.Items.DRINKS))
                .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                .save(output, registerRecipe(BMMItems.HAPPY_MEAL.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.COCA_COLA.get())
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(Items.BROWN_DYE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(Items.BROWN_DYE), has(Items.BROWN_DYE))
                .save(output, registerRecipe(BMMItems.COCA_COLA.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.FANTA.get())
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(Items.YELLOW_DYE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(Items.YELLOW_DYE), has(Items.YELLOW_DYE))
                .save(output, registerRecipe(BMMItems.FANTA.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.SPRITE.get())
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(Items.GREEN_DYE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(Items.GREEN_DYE), has(Items.GREEN_DYE))
                .save(output, registerRecipe(BMMItems.SPRITE.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.LIPTON_ICE_TEA_PEACH.get())
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(Items.PINK_DYE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(Items.PINK_DYE), has(Items.PINK_DYE))
                .save(output, registerRecipe(BMMItems.LIPTON_ICE_TEA_PEACH.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.MCFLURRY.get())
                .requires(Items.MILK_BUCKET)
                .requires(Items.SNOWBALL)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .save(output, registerRecipe(BMMItems.MCFLURRY.get()));

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, BMMItems.MCFLURRY_CHOCOLATE.get())
                .requires(Items.MILK_BUCKET)
                .requires(Items.SNOWBALL)
                .requires(Items.SUGAR)
                .requires(Items.COCOA_BEANS)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                .save(output, registerRecipe(BMMItems.MCFLURRY_CHOCOLATE.get()));
    }

    public static ResourceKey<Recipe<?>> registerRecipe(ItemLike item) {
        return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(item)));
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider registries, @NotNull RecipeOutput output) {
            return new BMMRecipeProvider(registries, output);
        }

        @Override
        public @NotNull String getName() {
            return BetterMcDonaldsMod.MOD_ID + " recipes";
        }
    }
}