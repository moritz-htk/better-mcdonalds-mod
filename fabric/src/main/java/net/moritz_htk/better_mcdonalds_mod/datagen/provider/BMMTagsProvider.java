package net.moritz_htk.better_mcdonalds_mod.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.moritz_htk.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.moritz_htk.better_mcdonalds_mod.common.registry.BMMItems;
import net.moritz_htk.better_mcdonalds_mod.common.registry.BMMTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BMMTagsProvider {
    public static class Items extends FabricTagProvider.ItemTagProvider {
        public Items(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            // Dust Tags
            getOrCreateTagBuilder(ConventionalItemTags.DUSTS).addTag(BMMTags.Items.DUSTS_SALT);
            getOrCreateTagBuilder(BMMTags.Items.DUSTS_SALT).add(BMMItems.SALT.getId());

            // Crop Tags
            getOrCreateTagBuilder(ConventionalItemTags.CROPS).addTag(BMMTags.Items.CROPS_TOMATO).addTag(BMMTags.Items.CROPS_LETTUCE);
            getOrCreateTagBuilder(BMMTags.Items.CROPS_TOMATO).add(BMMItems.TOMATO.getId());
            getOrCreateTagBuilder(BMMTags.Items.CROPS_LETTUCE).add(BMMItems.LETTUCE.getId());

            // Seed Tags
            getOrCreateTagBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS).addAll(List.of(BMMItems.TOMATO_SEEDS.getKey(), BMMItems.LETTUCE_SEEDS.getKey()));
            getOrCreateTagBuilder(ConventionalItemTags.SEEDS).addTag(BMMTags.Items.SEEDS_TOMATO).addTag(BMMTags.Items.SEEDS_LETTUCE);
            getOrCreateTagBuilder(BMMTags.Items.SEEDS_TOMATO).add(BMMItems.TOMATO_SEEDS.getId());
            getOrCreateTagBuilder(BMMTags.Items.SEEDS_LETTUCE).add(BMMItems.LETTUCE_SEEDS.getId());

            // Food Tags
            getOrCreateTagBuilder(ConventionalItemTags.FOODS).addTag(BMMTags.Items.FOODS_CHEESE).addTag(BMMTags.Items.FOODS_SAUCE).addTag(BMMTags.Items.FOODS_BURGER).addTag(BMMTags.Items.FOODS_DRINK).addAll(List.of(BMMItems.TORTILLA.getKey(), BMMItems.MCWRAP.getKey(), BMMItems.MCFLURRY.getKey(), BMMItems.MCFLURRY_CHOCOLATE.getKey()));
            getOrCreateTagBuilder(BMMTags.Items.FOODS_CHEESE).add(BMMItems.CHEESE.getId());
            getOrCreateTagBuilder(BMMTags.Items.FOODS_SAUCE).addTag(BMMTags.Items.FOODS_SAUCES_MAYONNAISE).addTag(BMMTags.Items.FOODS_SAUCES_SWEET_SOUR_SAUCE).addTag(BMMTags.Items.FOODS_SAUCES_KETCHUP).addTag(BMMTags.Items.FOODS_SAUCES_MUSTARD);
            getOrCreateTagBuilder(BMMTags.Items.FOODS_BURGER).addTag(BMMTags.Items.FOODS_BURGERS_HAMBURGER).addTag(BMMTags.Items.FOODS_BURGERS_CHEESEBURGER).addTag(BMMTags.Items.FOODS_BURGERS_CHICKENBURGER).addTag(BMMTags.Items.FOODS_BURGERS_FISHBURGER);
            getOrCreateTagBuilder(BMMTags.Items.FOODS_SIDE_DISH).addAll(List.of(BMMItems.SNACK_SALAD.getKey(), BMMItems.CHICKEN_MCNUGGETS.getKey(), BMMItems.FRIES.getKey()));
            getOrCreateTagBuilder(BMMTags.Items.FOODS_DRINK).addTag(BMMTags.Items.FOODS_DRINKS_COKE).addTag(BMMTags.Items.FOODS_DRINKS_ORANGE_JUICE).addTag(BMMTags.Items.FOODS_DRINKS_LEMON_JUICE).addTag(BMMTags.Items.FOODS_DRINKS_ICE_TEA);

            // Vegetable Food Tags
            getOrCreateTagBuilder(ConventionalItemTags.VEGETABLE_FOODS).addTag(BMMTags.Items.FOODS_VEGETABLES_TOMATO).addTag(BMMTags.Items.FOODS_VEGETABLES_LETTUCE);
            getOrCreateTagBuilder(BMMTags.Items.FOODS_VEGETABLES_TOMATO).add(BMMItems.TOMATO.getId());
            getOrCreateTagBuilder(BMMTags.Items.FOODS_VEGETABLES_LETTUCE).add(BMMItems.LETTUCE.getId());

            // Meat Tags
            getOrCreateTagBuilder(ItemTags.MEAT).addAll(List.of(BMMItems.BEEF_PATTY.getKey(), BMMItems.COOKED_BEEF_PATTY.getKey(), BMMItems.RAW_BACON.getKey(), BMMItems.COOKED_BACON.getKey()));

            // Raw Meat Food Tags
            getOrCreateTagBuilder(ConventionalItemTags.RAW_MEAT_FOODS).addTag(BMMTags.Items.FOODS_RAW_BEEF).addTag(BMMTags.Items.FOODS_RAW_BACON);
            getOrCreateTagBuilder(BMMTags.Items.FOODS_RAW_BEEF).add(BMMItems.BEEF_PATTY.getId());
            getOrCreateTagBuilder(BMMTags.Items.FOODS_RAW_BACON).add(BMMItems.RAW_BACON.getId());

            // Cooked Meat Food Tags
            getOrCreateTagBuilder(ConventionalItemTags.COOKED_MEAT_FOODS).addTag(BMMTags.Items.FOODS_COOKED_BEEF).addTag(BMMTags.Items.FOODS_COOKED_BACON);
            getOrCreateTagBuilder(BMMTags.Items.FOODS_COOKED_BEEF).add(BMMItems.COOKED_BEEF_PATTY.getId());
            getOrCreateTagBuilder(BMMTags.Items.FOODS_COOKED_BACON).add(BMMItems.COOKED_BACON.getId());

            // Sauce Food Tags
            getOrCreateTagBuilder(BMMTags.Items.FOODS_SAUCES_MAYONNAISE).add(BMMItems.MAYONNAISE.getId());
            getOrCreateTagBuilder(BMMTags.Items.FOODS_SAUCES_SWEET_SOUR_SAUCE).add(BMMItems.SWEET_SOUR_SAUCE.getId());
            getOrCreateTagBuilder(BMMTags.Items.FOODS_SAUCES_KETCHUP).add(BMMItems.KETCHUP.getId());
            getOrCreateTagBuilder(BMMTags.Items.FOODS_SAUCES_MUSTARD).add(BMMItems.MUSTARD.getId());

            // Burger Food Tags
            getOrCreateTagBuilder(BMMTags.Items.FOODS_BURGERS_HAMBURGER).addAll(List.of(BMMItems.HAMBURGER.getKey(), BMMItems.MCBACON.getKey(), BMMItems.BIG_MAC.getKey()));
            getOrCreateTagBuilder(BMMTags.Items.FOODS_BURGERS_CHEESEBURGER).add(BMMItems.CHEESEBURGER.getId());
            getOrCreateTagBuilder(BMMTags.Items.FOODS_BURGERS_CHICKENBURGER).addAll(List.of(BMMItems.CHICKENBURGER.getKey(), BMMItems.MCCHICKEN.getKey()));
            getOrCreateTagBuilder(BMMTags.Items.FOODS_BURGERS_FISHBURGER).add(BMMItems.FILET_O_FISH.getId());

            // Drink Food Tag
            getOrCreateTagBuilder(BMMTags.Items.FOODS_DRINKS_COKE).add(BMMItems.COCA_COLA.getId());
            getOrCreateTagBuilder(BMMTags.Items.FOODS_DRINKS_ORANGE_JUICE).add(BMMItems.FANTA.getId());
            getOrCreateTagBuilder(BMMTags.Items.FOODS_DRINKS_LEMON_JUICE).add(BMMItems.SPRITE.getId());
            getOrCreateTagBuilder(BMMTags.Items.FOODS_DRINKS_ICE_TEA).add(BMMItems.LIPTON_ICE_TEA_PEACH.getId());

            // Villager Tags
            getOrCreateTagBuilder(ItemTags.VILLAGER_PICKS_UP).addAll(List.of(BMMItems.TOMATO.getKey(), BMMItems.LETTUCE.getKey()));

            // Serene Season Crop Tags
            getOrCreateTagBuilder(BMMTags.Items.SERENE_SEASON_SUMMER_CROPS).add(BMMItems.TOMATO_SEEDS.getId());
            getOrCreateTagBuilder(BMMTags.Items.SERENE_SEASON_AUTUMN_CROPS).add(BMMItems.LETTUCE_SEEDS.getId());
        }
    }

    public static class Blocks extends FabricTagProvider.BlockTagProvider {
        public Blocks(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_SHOVEL).add(BMMBlocks.SALT_BLOCK.getId());
            getOrCreateTagBuilder(BlockTags.CROPS).add(BMMBlocks.TOMATO_CROP.getId()).add(BMMBlocks.LETTUCE_CROP.getId());
            getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND).add(BMMBlocks.TOMATO_CROP.getId()).add(BMMBlocks.LETTUCE_CROP.getId());

            // Serene Season Crop Tags
            getOrCreateTagBuilder(BMMTags.Blocks.SERENE_SEASON_SUMMER_CROPS).add(BMMBlocks.TOMATO_CROP.getId());
            getOrCreateTagBuilder(BMMTags.Blocks.SERENE_SEASON_AUTUMN_CROPS).add(BMMBlocks.LETTUCE_CROP.getId());
        }
    }
}