package net.moritz_htk.better_mcdonalds_mod.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.moritz_htk.better_mcdonalds_mod.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMBlocks;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMItems;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMTags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BMMRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public BMMRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BMMBlocks.SALT_BLOCK.get(), 1)
                .define('#', BMMTags.Items.DUSTS_SALT)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMBlocks.SALT_BLOCK.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.TOMATO_SEEDS.get(), 2)
                .requires(BMMTags.Items.CROPS_TOMATO)
                .unlockedBy(getHasName(BMMItems.TOMATO.get()), has(BMMTags.Items.CROPS_TOMATO))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.TOMATO_SEEDS.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.LETTUCE_SEEDS.get(), 2)
                .requires(BMMTags.Items.CROPS_LETTUCE)
                .unlockedBy(getHasName(BMMItems.LETTUCE.get()), has(BMMTags.Items.CROPS_LETTUCE))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.LETTUCE_SEEDS.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.CHEESE.get(), 2)
                .requires(Items.MILK_BUCKET)
                .requires(BMMTags.Items.DUSTS_SALT)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.CHEESE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.TORTILLA.get(), 2)
                .requires(Items.WATER_BUCKET)
                .requires(Items.WHEAT, 2)
                .requires(Items.EGG)
                .requires(BMMTags.Items.DUSTS_SALT)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.TORTILLA.get())));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.BEEF), RecipeCategory.FOOD, BMMItems.BEEF_PATTY.get(), 2)
                .unlockedBy(getHasName(Items.BEEF), has(Items.BEEF))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.BEEF_PATTY.get())));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(BMMItems.BEEF_PATTY.get()), RecipeCategory.FOOD, BMMItems.COOKED_BEEF_PATTY.get(), 1.0f, 200, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new)
                .unlockedBy(getHasName(BMMItems.BEEF_PATTY.get()), has(BMMItems.BEEF_PATTY.get()))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BEEF_PATTY.get()) + "_smelting"));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(BMMItems.BEEF_PATTY.get()), RecipeCategory.FOOD, BMMItems.COOKED_BEEF_PATTY.get(), 1.0f, 100, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new)
                .unlockedBy(getHasName(BMMItems.BEEF_PATTY.get()), has(BMMItems.BEEF_PATTY.get()))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BEEF_PATTY.get()) + "_smoking"));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(BMMItems.BEEF_PATTY.get()), RecipeCategory.FOOD, BMMItems.COOKED_BEEF_PATTY.get(), 1.0f, 600, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new)
                .unlockedBy(getHasName(BMMItems.BEEF_PATTY.get()), has(BMMItems.BEEF_PATTY.get()))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BEEF_PATTY.get()) + "_campfire_cooking"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.PORKCHOP), RecipeCategory.FOOD, BMMItems.RAW_BACON.get(), 2)
                .unlockedBy(getHasName(Items.PORKCHOP), has(Items.PORKCHOP))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.RAW_BACON.get())));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(BMMItems.RAW_BACON.get()), RecipeCategory.FOOD, BMMItems.COOKED_BACON.get(), 1.0f, 200, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new)
                .unlockedBy(getHasName(BMMItems.RAW_BACON.get()), has(BMMItems.RAW_BACON.get()))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BACON.get()) + "_smelting"));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(BMMItems.RAW_BACON.get()), RecipeCategory.FOOD, BMMItems.COOKED_BACON.get(), 1.0f, 100, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new)
                .unlockedBy(getHasName(BMMItems.RAW_BACON.get()), has(BMMItems.RAW_BACON.get()))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BACON.get()) + "_smoking"));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(BMMItems.RAW_BACON.get()), RecipeCategory.FOOD, BMMItems.COOKED_BACON.get(), 1.0f, 600, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new)
                .unlockedBy(getHasName(BMMItems.RAW_BACON.get()), has(BMMItems.RAW_BACON.get()))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BACON.get()) + "_campfire_cooking"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.MAYONNAISE.get(), 2)
                .requires(Items.MILK_BUCKET)
                .requires(Items.EGG)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.MAYONNAISE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.SWEET_SOUR_SAUCE.get(), 2)
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(Items.HONEY_BOTTLE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(Items.HONEY_BOTTLE), has(Items.HONEY_BOTTLE))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.SWEET_SOUR_SAUCE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.KETCHUP.get(), 2)
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(BMMTags.Items.CROPS_TOMATO)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(BMMItems.TOMATO.get()), has(BMMTags.Items.CROPS_TOMATO))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.KETCHUP.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.MUSTARD.get(), 2)
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(Items.PUMPKIN_SEEDS)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(Items.PUMPKIN_SEEDS), has(Items.PUMPKIN_SEEDS))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.MUSTARD.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.HAMBURGER.get())
                .requires(Items.BREAD)
                .requires(BMMItems.COOKED_BEEF_PATTY.get())
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.get()), has(BMMItems.COOKED_BEEF_PATTY.get()))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.HAMBURGER.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.CHEESEBURGER.get())
                .requires(Items.BREAD)
                .requires(BMMItems.COOKED_BEEF_PATTY.get())
                .requires(BMMItems.CHEESE.get())
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.get()), has(BMMItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(BMMItems.CHEESE.get()), has(BMMItems.CHEESE.get()))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.CHEESEBURGER.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.MCBACON.get())
                .requires(Items.BREAD)
                .requires(BMMItems.COOKED_BEEF_PATTY.get())
                .requires(BMMItems.CHEESE.get())
                .requires(BMMItems.COOKED_BACON.get())
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.get()), has(BMMItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(BMMItems.CHEESE.get()), has(BMMItems.CHEESE.get()))
                .unlockedBy(getHasName(BMMItems.COOKED_BACON.get()), has(BMMItems.COOKED_BACON.get()))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.MCBACON.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.BIG_MAC.get())
                .requires(Items.BREAD)
                .requires(BMMItems.COOKED_BEEF_PATTY.get(), 2)
                .requires(BMMItems.CHEESE.get())
                .requires(BMMTags.Items.CROPS_LETTUCE)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.get()), has(BMMItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(BMMItems.CHEESE.get()), has(BMMItems.CHEESE.get()))
                .unlockedBy(getHasName(BMMItems.LETTUCE.get()), has(BMMTags.Items.CROPS_LETTUCE))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.BIG_MAC.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.CHICKENBURGER.get())
                .requires(Items.BREAD)
                .requires(Items.COOKED_CHICKEN)
                .requires(BMMTags.Items.FOODS_SAUCES_KETCHUP)
                .requires(BMMTags.Items.CROPS_LETTUCE)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                .unlockedBy(getHasName(BMMItems.KETCHUP.get()), has(BMMTags.Items.FOODS_SAUCES_KETCHUP))
                .unlockedBy(getHasName(BMMItems.LETTUCE.get()), has(BMMTags.Items.CROPS_LETTUCE))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.CHICKENBURGER.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.MCCHICKEN.get())
                .requires(Items.BREAD)
                .requires(Items.COOKED_CHICKEN)
                .requires(BMMTags.Items.FOODS_SAUCES_MAYONNAISE)
                .requires(BMMTags.Items.CROPS_LETTUCE)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                .unlockedBy(getHasName(BMMItems.MAYONNAISE.get()), has(BMMTags.Items.FOODS_SAUCES_MAYONNAISE))
                .unlockedBy(getHasName(BMMItems.LETTUCE.get()), has(BMMTags.Items.CROPS_LETTUCE))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.MCCHICKEN.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.FILET_O_FISH.get())
                .requires(Items.BREAD)
                .requires(BMMItems.CHEESE.get())
                .requires(Items.COOKED_SALMON)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .unlockedBy(getHasName(BMMItems.CHEESE.get()), has(BMMItems.CHEESE.get()))
                .unlockedBy(getHasName(Items.COOKED_SALMON), has(Items.COOKED_SALMON))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.FILET_O_FISH.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.MCWRAP.get())
                .requires(BMMItems.TORTILLA.get())
                .requires(Items.COOKED_CHICKEN)
                .requires(BMMTags.Items.FOODS_SAUCES_MAYONNAISE)
                .requires(BMMTags.Items.CROPS_LETTUCE)
                .unlockedBy(getHasName(BMMItems.TORTILLA.get()), has(BMMItems.TORTILLA.get()))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                .unlockedBy(getHasName(BMMItems.MAYONNAISE.get()), has(BMMTags.Items.FOODS_SAUCES_MAYONNAISE))
                .unlockedBy(getHasName(BMMItems.LETTUCE.get()), has(BMMTags.Items.CROPS_LETTUCE))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.MCWRAP.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.SNACK_SALAD.get())
                .requires(BMMTags.Items.CROPS_TOMATO)
                .requires(BMMTags.Items.CROPS_LETTUCE)
                .requires(Items.CARROT)
                .unlockedBy(getHasName(BMMItems.TOMATO.get()), has(BMMTags.Items.CROPS_TOMATO))
                .unlockedBy(getHasName(BMMItems.LETTUCE.get()), has(BMMTags.Items.CROPS_LETTUCE))
                .unlockedBy(getHasName(Items.CARROT), has(Items.CARROT))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.SNACK_SALAD.get())));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.COOKED_CHICKEN), RecipeCategory.FOOD, BMMItems.CHICKEN_MCNUGGETS.get(), 2)
                .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.CHICKEN_MCNUGGETS.get())));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.BAKED_POTATO), RecipeCategory.FOOD, BMMItems.FRIES.get(), 2)
                .unlockedBy(getHasName(Items.BAKED_POTATO), has(Items.BAKED_POTATO))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.FRIES.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.HAPPY_MEAL.get())
                .requires(BMMTags.Items.FOODS_BURGERS)
                .requires(BMMTags.Items.FOODS_DRINKS)
                .requires(BMMTags.Items.FOODS_SIDE_DISHES)
                .requires(Items.APPLE)
                .unlockedBy("has_burger", has(BMMTags.Items.FOODS_BURGERS))
                .unlockedBy("has_drink", has(BMMTags.Items.FOODS_DRINKS))
                .unlockedBy("has_side_dish", has(BMMTags.Items.FOODS_SIDE_DISHES))
                .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.HAPPY_MEAL.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.COCA_COLA.get())
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(Items.BROWN_DYE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(Items.BROWN_DYE), has(Items.BROWN_DYE))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COCA_COLA.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.FANTA.get())
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(Items.YELLOW_DYE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(Items.YELLOW_DYE), has(Items.YELLOW_DYE))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.FANTA.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.SPRITE.get())
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(Items.GREEN_DYE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(Items.GREEN_DYE), has(Items.GREEN_DYE))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.SPRITE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.LIPTON_ICE_TEA_PEACH.get())
                .requires(Items.WATER_BUCKET)
                .requires(Items.SUGAR)
                .requires(BMMTags.Items.DUSTS_SALT)
                .requires(Items.PINK_DYE)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTags.Items.DUSTS_SALT))
                .unlockedBy(getHasName(Items.PINK_DYE), has(Items.PINK_DYE))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.LIPTON_ICE_TEA_PEACH.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.MCFLURRY.get())
                .requires(Items.MILK_BUCKET)
                .requires(Items.SNOWBALL)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.MCFLURRY.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.MCFLURRY_CHOCOLATE.get())
                .requires(Items.MILK_BUCKET)
                .requires(Items.SNOWBALL)
                .requires(Items.SUGAR)
                .requires(Items.COCOA_BEANS)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                .save(output, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.MCFLURRY_CHOCOLATE.get())));
    }
}