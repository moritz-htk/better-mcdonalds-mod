package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.common.tags.BMMTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BMMTagsProvider {
    public static class Items extends FabricTagProvider.ItemTagProvider {
        public Items(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture, new Blocks(output, completableFuture));
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            // Dust Tags
            tag(ConventionalItemTags.DUSTS).addTag(BMMTags.Items.DUSTS_SALT);
            tag(BMMTags.Items.DUSTS_SALT).add(BMMItems.SALT.unwrap().orThrow());

            // Crop Tags
            tag(ConventionalItemTags.CROPS).addTag(BMMTags.Items.CROPS_TOMATO).addTag(BMMTags.Items.CROPS_LETTUCE);
            tag(BMMTags.Items.CROPS_TOMATO).add(BMMItems.TOMATO.unwrap().orThrow());
            tag(BMMTags.Items.CROPS_LETTUCE).add(BMMItems.LETTUCE.unwrap().orThrow());

            // Seed Tags
            tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).addAll(List.of(BMMItems.TOMATO_SEEDS.unwrap().orThrow(), BMMItems.LETTUCE_SEEDS.unwrap().orThrow()));
            tag(ConventionalItemTags.SEEDS).addTag(BMMTags.Items.SEEDS_TOMATO).addTag(BMMTags.Items.SEEDS_LETTUCE);
            tag(BMMTags.Items.SEEDS_TOMATO).add(BMMItems.TOMATO_SEEDS.unwrap().orThrow());
            tag(BMMTags.Items.SEEDS_LETTUCE).add(BMMItems.LETTUCE_SEEDS.unwrap().orThrow());

            // Food Tags
            tag(ConventionalItemTags.FOODS).addTag(BMMTags.Items.FOODS_CHEESE).addTag(BMMTags.Items.FOODS_SAUCE).addTag(BMMTags.Items.FOODS_BURGER).addTag(BMMTags.Items.FOODS_ICE_CREAM);
            tag(BMMTags.Items.FOODS_CHEESE).add(BMMItems.CHEESE.unwrap().orThrow());
            tag(ConventionalItemTags.BREAD_FOODS).add(BMMItems.TORTILLA.unwrap().orThrow());
            tag(BMMTags.Items.FOODS_SAUCE).addTag(BMMTags.Items.FOODS_SAUCES_MAYONNAISE).addTag(BMMTags.Items.FOODS_SAUCES_SWEET_SOUR_SAUCE).addTag(BMMTags.Items.FOODS_SAUCES_KETCHUP).addTag(BMMTags.Items.FOODS_SAUCES_MUSTARD);
            tag(BMMTags.Items.FOODS_BURGER).addTag(BMMTags.Items.FOODS_BURGERS_HAMBURGER).addTag(BMMTags.Items.FOODS_BURGERS_CHEESEBURGER).addTag(BMMTags.Items.FOODS_BURGERS_CHICKENBURGER).addTag(BMMTags.Items.FOODS_BURGERS_FISHBURGER).add(BMMItems.MCWRAP.unwrap().orThrow());
            tag(BMMTags.Items.FOODS_ICE_CREAM).addAll(List.of(BMMItems.MCFLURRY.unwrap().orThrow(), BMMItems.MCFLURRY_CHOCOLATE.unwrap().orThrow()));

            tag(BMMTags.Items.BURGER).addAll(List.of(BMMItems.HAMBURGER.unwrap().orThrow(), BMMItems.MCBACON.unwrap().orThrow(), BMMItems.BIG_MAC.unwrap().orThrow(), BMMItems.CHEESEBURGER.unwrap().orThrow(), BMMItems.CHICKENBURGER.unwrap().orThrow(), BMMItems.MCCHICKEN.unwrap().orThrow(), BMMItems.FILET_O_FISH.unwrap().orThrow()));
            tag(BMMTags.Items.SIDE_DISHES).addAll(List.of(BMMItems.SNACK_SALAD.unwrap().orThrow(), BMMItems.CHICKEN_MCNUGGETS.unwrap().orThrow(), BMMItems.FRIES.unwrap().orThrow()));

            // Vegetable Food Tags
            tag(ConventionalItemTags.VEGETABLE_FOODS).addTag(BMMTags.Items.FOODS_VEGETABLES_TOMATO).addTag(BMMTags.Items.FOODS_VEGETABLES_LETTUCE);
            tag(BMMTags.Items.FOODS_VEGETABLES_TOMATO).add(BMMItems.TOMATO.unwrap().orThrow());
            tag(BMMTags.Items.FOODS_VEGETABLES_LETTUCE).add(BMMItems.LETTUCE.unwrap().orThrow());

            // Meat Tags
            tag(ItemTags.MEAT).addAll(List.of(BMMItems.BEEF_PATTY.unwrap().orThrow(), BMMItems.COOKED_BEEF_PATTY.unwrap().orThrow(), BMMItems.RAW_BACON.unwrap().orThrow(), BMMItems.COOKED_BACON.unwrap().orThrow()));

            // Raw Meat Food Tags
            tag(ConventionalItemTags.RAW_MEAT_FOODS).addTag(BMMTags.Items.FOODS_RAW_BEEF).addTag(BMMTags.Items.FOODS_RAW_BACON);
            tag(BMMTags.Items.FOODS_RAW_BEEF).add(BMMItems.BEEF_PATTY.unwrap().orThrow());
            tag(BMMTags.Items.FOODS_RAW_BACON).add(BMMItems.RAW_BACON.unwrap().orThrow());

            // Cooked Meat Food Tags
            tag(ConventionalItemTags.COOKED_MEAT_FOODS).addTag(BMMTags.Items.FOODS_COOKED_BEEF).addTag(BMMTags.Items.FOODS_COOKED_BACON);
            tag(BMMTags.Items.FOODS_COOKED_BEEF).add(BMMItems.COOKED_BEEF_PATTY.unwrap().orThrow());
            tag(BMMTags.Items.FOODS_COOKED_BACON).add(BMMItems.COOKED_BACON.unwrap().orThrow());

            // Sauce Food Tags
            tag(BMMTags.Items.FOODS_SAUCES_MAYONNAISE).add(BMMItems.MAYONNAISE.unwrap().orThrow());
            tag(BMMTags.Items.FOODS_SAUCES_SWEET_SOUR_SAUCE).add(BMMItems.SWEET_SOUR_SAUCE.unwrap().orThrow());
            tag(BMMTags.Items.FOODS_SAUCES_KETCHUP).add(BMMItems.KETCHUP.unwrap().orThrow());
            tag(BMMTags.Items.FOODS_SAUCES_MUSTARD).add(BMMItems.MUSTARD.unwrap().orThrow());

            // Burger Food Tags
            tag(BMMTags.Items.FOODS_BURGERS_HAMBURGER).addAll(List.of(BMMItems.HAMBURGER.unwrap().orThrow(), BMMItems.MCBACON.unwrap().orThrow(), BMMItems.BIG_MAC.unwrap().orThrow()));
            tag(BMMTags.Items.FOODS_BURGERS_CHEESEBURGER).add(BMMItems.CHEESEBURGER.unwrap().orThrow());
            tag(BMMTags.Items.FOODS_BURGERS_CHICKENBURGER).addAll(List.of(BMMItems.CHICKENBURGER.unwrap().orThrow(), BMMItems.MCCHICKEN.unwrap().orThrow()));
            tag(BMMTags.Items.FOODS_BURGERS_FISHBURGER).add(BMMItems.FILET_O_FISH.unwrap().orThrow());

            // Drink Tags
            tag(ConventionalItemTags.DRINKS).addTag(BMMTags.Items.DRINKS_SODA).addTag(BMMTags.Items.DRINKS_TEA);
            tag(BMMTags.Items.DRINKS).addAll(List.of(BMMItems.COCA_COLA.unwrap().orThrow(), BMMItems.FANTA.unwrap().orThrow(), BMMItems.SPRITE.unwrap().orThrow(), BMMItems.LIPTON_ICE_TEA_PEACH.unwrap().orThrow()));
            tag(BMMTags.Items.DRINKS_SODA).addAll(List.of(BMMItems.COCA_COLA.unwrap().orThrow(), BMMItems.FANTA.unwrap().orThrow(), BMMItems.SPRITE.unwrap().orThrow()));
            tag(BMMTags.Items.DRINKS_TEA).add(BMMItems.LIPTON_ICE_TEA_PEACH.unwrap().orThrow());

            // Serene Season Crop Tags
            tag(BMMTags.Items.SERENE_SEASON_SUMMER_CROPS).add(BMMItems.TOMATO_SEEDS.unwrap().orThrow());
            tag(BMMTags.Items.SERENE_SEASON_AUTUMN_CROPS).add(BMMItems.LETTUCE_SEEDS.unwrap().orThrow());
        }
    }

    public static class Blocks extends FabricTagProvider.BlockTagProvider {
        public Blocks(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(BMMBlocks.SALT_BLOCK.unwrap().orThrow());
            tag(BlockTags.CROPS).addAll(List.of(BMMBlocks.TOMATO_CROP.unwrap().orThrow(), BMMBlocks.LETTUCE_CROP.unwrap().orThrow()));
            tag(BlockTags.MAINTAINS_FARMLAND).addAll(List.of(BMMBlocks.TOMATO_CROP.unwrap().orThrow(), BMMBlocks.LETTUCE_CROP.unwrap().orThrow()));

            // Serene Season Crop Tags
            tag(BMMTags.Blocks.SERENE_SEASON_SUMMER_CROPS).add(BMMBlocks.TOMATO_CROP.unwrap().orThrow());
            tag(BMMTags.Blocks.SERENE_SEASON_AUTUMN_CROPS).add(BMMBlocks.LETTUCE_CROP.unwrap().orThrow());
        }
    }
}