package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class BMMRecipeProvider extends RecipeProvider.Runner {
    public BMMRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.BUILDING_BLOCKS, BMMBlocks.SALT_BLOCK.asItem(), 1)
                        .define('#', BMMTags.Items.DUSTS_SALT)
                        .pattern("##")
                        .pattern("##")
                        .unlockedBy(getHasName(BMMItems.SALT.asItem()), has(BMMTags.Items.DUSTS_SALT))
                        .save(output, registerRecipe(BMMBlocks.SALT_BLOCK.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.TOMATO_SEEDS.asItem(), 2)
                        .requires(BMMTags.Items.CROPS_TOMATO)
                        .unlockedBy(getHasName(BMMItems.TOMATO.asItem()), has(BMMTags.Items.CROPS_TOMATO))
                        .save(output, registerRecipe(BMMItems.TOMATO_SEEDS.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.LETTUCE_SEEDS.asItem(), 2)
                        .requires(BMMTags.Items.CROPS_LETTUCE)
                        .unlockedBy(getHasName(BMMItems.LETTUCE.asItem()), has(BMMTags.Items.CROPS_LETTUCE))
                        .save(output, registerRecipe(BMMItems.LETTUCE_SEEDS.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.CHEESE.asItem(), 2)
                        .requires(Items.MILK_BUCKET)
                        .requires(BMMTags.Items.DUSTS_SALT)
                        .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                        .unlockedBy(getHasName(BMMItems.SALT.asItem()), has(BMMTags.Items.DUSTS_SALT))
                        .save(output, registerRecipe(BMMItems.CHEESE.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.TORTILLA.asItem(), 2)
                        .requires(Items.WATER_BUCKET)
                        .requires(Items.WHEAT, 2)
                        .requires(Items.EGG)
                        .requires(BMMTags.Items.DUSTS_SALT)
                        .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                        .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                        .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                        .unlockedBy(getHasName(BMMItems.SALT.asItem()), has(BMMTags.Items.DUSTS_SALT))
                        .save(output, registerRecipe(BMMItems.TORTILLA.asItem()));

                SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.BEEF), RecipeCategory.FOOD, BMMItems.BEEF_PATTY.asItem(), 2)
                        .unlockedBy(getHasName(Items.BEEF), has(Items.BEEF))
                        .save(output, registerRecipe(BMMItems.BEEF_PATTY.asItem()));

                SimpleCookingRecipeBuilder.smelting(Ingredient.of(BMMItems.BEEF_PATTY.asItem()), RecipeCategory.FOOD, CookingBookCategory.FOOD, BMMItems.COOKED_BEEF_PATTY.asItem(), 1.0f, 200)
                        .unlockedBy(getHasName(BMMItems.BEEF_PATTY.asItem()), has(BMMItems.BEEF_PATTY.asItem()))
                        .save(output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BEEF_PATTY.asItem()) + "_smelting")));

                SimpleCookingRecipeBuilder.smoking(Ingredient.of(BMMItems.BEEF_PATTY.asItem()), RecipeCategory.FOOD, BMMItems.COOKED_BEEF_PATTY.asItem(), 1.0f, 100)
                        .unlockedBy(getHasName(BMMItems.BEEF_PATTY.asItem()), has(BMMItems.BEEF_PATTY.asItem()))
                        .save(output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BEEF_PATTY.asItem()) + "_smoking")));

                SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(BMMItems.BEEF_PATTY.asItem()), RecipeCategory.FOOD, BMMItems.COOKED_BEEF_PATTY.asItem(), 1.0f, 600)
                        .unlockedBy(getHasName(BMMItems.BEEF_PATTY.asItem()), has(BMMItems.BEEF_PATTY.asItem()))
                        .save(output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BEEF_PATTY.asItem()) + "_campfire_cooking")));

                SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.PORKCHOP), RecipeCategory.FOOD, BMMItems.RAW_BACON.asItem(), 2)
                        .unlockedBy(getHasName(Items.PORKCHOP), has(Items.PORKCHOP))
                        .save(output, registerRecipe(BMMItems.RAW_BACON.asItem()));

                SimpleCookingRecipeBuilder.smelting(Ingredient.of(BMMItems.RAW_BACON.asItem()), RecipeCategory.FOOD, CookingBookCategory.FOOD, BMMItems.COOKED_BACON.asItem(), 1.0f, 200)
                        .unlockedBy(getHasName(BMMItems.RAW_BACON.asItem()), has(BMMItems.RAW_BACON.asItem()))
                        .save(output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BACON.asItem()) + "_smelting")));

                SimpleCookingRecipeBuilder.smoking(Ingredient.of(BMMItems.RAW_BACON.asItem()), RecipeCategory.FOOD, BMMItems.COOKED_BACON.asItem(), 1.0f, 100)
                        .unlockedBy(getHasName(BMMItems.RAW_BACON.asItem()), has(BMMItems.RAW_BACON.asItem()))
                        .save(output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BACON.asItem()) + "_smoking")));

                SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(BMMItems.RAW_BACON.asItem()), RecipeCategory.FOOD, BMMItems.COOKED_BACON.asItem(), 1.0f, 600)
                        .unlockedBy(getHasName(BMMItems.RAW_BACON.asItem()), has(BMMItems.RAW_BACON.asItem()))
                        .save(output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BACON.asItem()) + "_campfire_cooking")));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.MAYONNAISE.asItem(), 2)
                        .requires(Items.MILK_BUCKET)
                        .requires(Items.EGG)
                        .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                        .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                        .save(output, registerRecipe(BMMItems.MAYONNAISE.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.SWEET_SOUR_SAUCE.asItem(), 2)
                        .requires(Items.WATER_BUCKET)
                        .requires(Items.SUGAR)
                        .requires(BMMTags.Items.DUSTS_SALT)
                        .requires(Items.HONEY_BOTTLE)
                        .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                        .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                        .unlockedBy(getHasName(BMMItems.SALT.asItem()), has(BMMTags.Items.DUSTS_SALT))
                        .unlockedBy(getHasName(Items.HONEY_BOTTLE), has(Items.HONEY_BOTTLE))
                        .save(output, registerRecipe(BMMItems.SWEET_SOUR_SAUCE.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.KETCHUP.asItem(), 2)
                        .requires(Items.WATER_BUCKET)
                        .requires(Items.SUGAR)
                        .requires(BMMTags.Items.DUSTS_SALT)
                        .requires(BMMTags.Items.CROPS_TOMATO)
                        .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                        .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                        .unlockedBy(getHasName(BMMItems.SALT.asItem()), has(BMMTags.Items.DUSTS_SALT))
                        .unlockedBy(getHasName(BMMItems.TOMATO.asItem()), has(BMMTags.Items.CROPS_TOMATO))
                        .save(output, registerRecipe(BMMItems.KETCHUP.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.MUSTARD.asItem(), 2)
                        .requires(Items.WATER_BUCKET)
                        .requires(Items.SUGAR)
                        .requires(BMMTags.Items.DUSTS_SALT)
                        .requires(Items.PUMPKIN_SEEDS)
                        .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                        .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                        .unlockedBy(getHasName(BMMItems.SALT.asItem()), has(BMMTags.Items.DUSTS_SALT))
                        .unlockedBy(getHasName(Items.PUMPKIN_SEEDS), has(Items.PUMPKIN_SEEDS))
                        .save(output, registerRecipe(BMMItems.MUSTARD.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.HAMBURGER.asItem())
                        .requires(Items.BREAD)
                        .requires(BMMItems.COOKED_BEEF_PATTY.asItem())
                        .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                        .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.asItem()), has(BMMItems.COOKED_BEEF_PATTY.asItem()))
                        .save(output, registerRecipe(BMMItems.HAMBURGER.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.CHEESEBURGER.asItem())
                        .requires(Items.BREAD)
                        .requires(BMMItems.COOKED_BEEF_PATTY.asItem())
                        .requires(BMMTags.Items.FOODS_CHEESE)
                        .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                        .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.asItem()), has(BMMItems.COOKED_BEEF_PATTY.asItem()))
                        .unlockedBy(getHasName(BMMItems.CHEESE.asItem()), has(BMMTags.Items.FOODS_CHEESE))
                        .save(output, registerRecipe(BMMItems.CHEESEBURGER.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.MCBACON.asItem())
                        .requires(Items.BREAD)
                        .requires(BMMItems.COOKED_BEEF_PATTY.asItem())
                        .requires(BMMTags.Items.FOODS_CHEESE)
                        .requires(BMMTags.Items.FOODS_COOKED_BACON)
                        .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                        .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.asItem()), has(BMMItems.COOKED_BEEF_PATTY.asItem()))
                        .unlockedBy(getHasName(BMMItems.CHEESE.asItem()), has(BMMTags.Items.FOODS_CHEESE))
                        .unlockedBy(getHasName(BMMItems.COOKED_BACON.asItem()), has(BMMTags.Items.FOODS_COOKED_BACON))
                        .save(output, registerRecipe(BMMItems.MCBACON.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.BIG_MAC.asItem())
                        .requires(Items.BREAD)
                        .requires(BMMItems.COOKED_BEEF_PATTY.asItem(), 2)
                        .requires(BMMTags.Items.FOODS_CHEESE)
                        .requires(BMMTags.Items.CROPS_LETTUCE)
                        .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                        .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.asItem()), has(BMMItems.COOKED_BEEF_PATTY.asItem()))
                        .unlockedBy(getHasName(BMMItems.CHEESE.asItem()), has(BMMTags.Items.FOODS_CHEESE))
                        .unlockedBy(getHasName(BMMItems.LETTUCE.asItem()), has(BMMTags.Items.CROPS_LETTUCE))
                        .save(output, registerRecipe(BMMItems.BIG_MAC.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.CHICKENBURGER.asItem())
                        .requires(Items.BREAD)
                        .requires(Items.COOKED_CHICKEN)
                        .requires(BMMTags.Items.FOODS_SAUCES_KETCHUP)
                        .requires(BMMTags.Items.CROPS_LETTUCE)
                        .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                        .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                        .unlockedBy(getHasName(BMMItems.KETCHUP.asItem()), has(BMMTags.Items.FOODS_SAUCES_KETCHUP))
                        .unlockedBy(getHasName(BMMItems.LETTUCE.asItem()), has(BMMTags.Items.CROPS_LETTUCE))
                        .save(output, registerRecipe(BMMItems.CHICKENBURGER.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.MCCHICKEN.asItem())
                        .requires(Items.BREAD)
                        .requires(Items.COOKED_CHICKEN)
                        .requires(BMMTags.Items.FOODS_SAUCES_MAYONNAISE)
                        .requires(BMMTags.Items.CROPS_LETTUCE)
                        .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                        .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                        .unlockedBy(getHasName(BMMItems.MAYONNAISE.asItem()), has(BMMTags.Items.FOODS_SAUCES_MAYONNAISE))
                        .unlockedBy(getHasName(BMMItems.LETTUCE.asItem()), has(BMMTags.Items.CROPS_LETTUCE))
                        .save(output, registerRecipe(BMMItems.MCCHICKEN.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.FILET_O_FISH.asItem())
                        .requires(Items.BREAD)
                        .requires(BMMTags.Items.FOODS_CHEESE)
                        .requires(Items.COOKED_SALMON)
                        .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                        .unlockedBy(getHasName(BMMItems.CHEESE.asItem()), has(BMMTags.Items.FOODS_CHEESE))
                        .unlockedBy(getHasName(Items.COOKED_SALMON), has(Items.COOKED_SALMON))
                        .save(output, registerRecipe(BMMItems.FILET_O_FISH.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.MCWRAP.asItem())
                        .requires(BMMItems.TORTILLA.asItem())
                        .requires(Items.COOKED_CHICKEN)
                        .requires(BMMTags.Items.FOODS_SAUCES_MAYONNAISE)
                        .requires(BMMTags.Items.CROPS_LETTUCE)
                        .unlockedBy(getHasName(BMMItems.TORTILLA.asItem()), has(BMMItems.TORTILLA.asItem()))
                        .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                        .unlockedBy(getHasName(BMMItems.MAYONNAISE.asItem()), has(BMMTags.Items.FOODS_SAUCES_MAYONNAISE))
                        .unlockedBy(getHasName(BMMItems.LETTUCE.asItem()), has(BMMTags.Items.CROPS_LETTUCE))
                        .save(output, registerRecipe(BMMItems.MCWRAP.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.SNACK_SALAD.asItem())
                        .requires(BMMTags.Items.CROPS_TOMATO)
                        .requires(BMMTags.Items.CROPS_LETTUCE)
                        .requires(Items.CARROT)
                        .unlockedBy(getHasName(BMMItems.TOMATO.asItem()), has(BMMTags.Items.CROPS_TOMATO))
                        .unlockedBy(getHasName(BMMItems.LETTUCE.asItem()), has(BMMTags.Items.CROPS_LETTUCE))
                        .unlockedBy(getHasName(Items.CARROT), has(Items.CARROT))
                        .save(output, registerRecipe(BMMItems.SNACK_SALAD.asItem()));

                SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.COOKED_CHICKEN), RecipeCategory.FOOD, BMMItems.CHICKEN_MCNUGGETS.asItem(), 2)
                        .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                        .save(output, registerRecipe(BMMItems.CHICKEN_MCNUGGETS.asItem()));

                SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.BAKED_POTATO), RecipeCategory.FOOD, BMMItems.FRIES.asItem(), 2)
                        .unlockedBy(getHasName(Items.BAKED_POTATO), has(Items.BAKED_POTATO))
                        .save(output, registerRecipe(BMMItems.FRIES.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.HAPPY_MEAL.asItem())
                        .requires(BMMTags.Items.BURGER)
                        .requires(BMMTags.Items.SIDE_DISHES)
                        .requires(BMMTags.Items.DRINKS)
                        .requires(Items.APPLE)
                        .unlockedBy("has_burger", has(BMMTags.Items.BURGER))
                        .unlockedBy("has_side_dish", has(BMMTags.Items.SIDE_DISHES))
                        .unlockedBy("has_drink", has(BMMTags.Items.DRINKS))
                        .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                        .save(output, registerRecipe(BMMItems.HAPPY_MEAL.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.COCA_COLA.asItem())
                        .requires(Items.WATER_BUCKET)
                        .requires(Items.SUGAR)
                        .requires(BMMTags.Items.DUSTS_SALT)
                        .requires(Items.BROWN_DYE)
                        .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                        .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                        .unlockedBy(getHasName(BMMItems.SALT.asItem()), has(BMMTags.Items.DUSTS_SALT))
                        .unlockedBy(getHasName(Items.BROWN_DYE), has(Items.BROWN_DYE))
                        .save(output, registerRecipe(BMMItems.COCA_COLA.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.FANTA.asItem())
                        .requires(Items.WATER_BUCKET)
                        .requires(Items.SUGAR)
                        .requires(BMMTags.Items.DUSTS_SALT)
                        .requires(Items.YELLOW_DYE)
                        .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                        .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                        .unlockedBy(getHasName(BMMItems.SALT.asItem()), has(BMMTags.Items.DUSTS_SALT))
                        .unlockedBy(getHasName(Items.YELLOW_DYE), has(Items.YELLOW_DYE))
                        .save(output, registerRecipe(BMMItems.FANTA.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.SPRITE.asItem())
                        .requires(Items.WATER_BUCKET)
                        .requires(Items.SUGAR)
                        .requires(BMMTags.Items.DUSTS_SALT)
                        .requires(Items.GREEN_DYE)
                        .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                        .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                        .unlockedBy(getHasName(BMMItems.SALT.asItem()), has(BMMTags.Items.DUSTS_SALT))
                        .unlockedBy(getHasName(Items.GREEN_DYE), has(Items.GREEN_DYE))
                        .save(output, registerRecipe(BMMItems.SPRITE.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.LIPTON_ICE_TEA_PEACH.asItem())
                        .requires(Items.WATER_BUCKET)
                        .requires(Items.SUGAR)
                        .requires(BMMTags.Items.DUSTS_SALT)
                        .requires(Items.PINK_DYE)
                        .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                        .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                        .unlockedBy(getHasName(BMMItems.SALT.asItem()), has(BMMTags.Items.DUSTS_SALT))
                        .unlockedBy(getHasName(Items.PINK_DYE), has(Items.PINK_DYE))
                        .save(output, registerRecipe(BMMItems.LIPTON_ICE_TEA_PEACH.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.MCFLURRY.asItem())
                        .requires(Items.MILK_BUCKET)
                        .requires(Items.SNOWBALL)
                        .requires(Items.SUGAR)
                        .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                        .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL))
                        .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                        .save(output, registerRecipe(BMMItems.MCFLURRY.asItem()));

                ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, BMMItems.MCFLURRY_CHOCOLATE.asItem())
                        .requires(Items.MILK_BUCKET)
                        .requires(Items.SNOWBALL)
                        .requires(Items.SUGAR)
                        .requires(Items.COCOA_BEANS)
                        .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                        .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL))
                        .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                        .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                        .save(output, registerRecipe(BMMItems.MCFLURRY_CHOCOLATE.asItem()));
            }

            public static ResourceKey<Recipe<?>> registerRecipe(ItemLike item) {
                return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, getItemName(item)));
            }
        };

    }

    @Override
    public String getName() {
        return BetterMcDonaldsMod.MOD_ID + " recipes";
    }
}