package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.common.tags.BMMTags;
import net.kyronis.better_mcdonalds_mod.common.trading.BMMVillagerTrades;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BMMTagsProvider {
    public static class Items extends ItemTagsProvider {
        public Items(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries, BetterMcDonaldsMod.MOD_ID);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            // Dust Tags
            tag(Tags.Items.DUSTS).addTag(BMMTags.Items.DUSTS_SALT);
            tag(BMMTags.Items.DUSTS_SALT).add(BMMItems.SALT.asResourceKey());

            // Crop Tags
            tag(Tags.Items.CROPS).addTag(BMMTags.Items.CROPS_TOMATO).addTag(BMMTags.Items.CROPS_LETTUCE);
            tag(BMMTags.Items.CROPS_TOMATO).add(BMMItems.TOMATO.asResourceKey());
            tag(BMMTags.Items.CROPS_LETTUCE).add(BMMItems.LETTUCE.asResourceKey());

            // Seed Tags
            tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).addAll(List.of(BMMItems.TOMATO_SEEDS.asResourceKey(), BMMItems.LETTUCE_SEEDS.asResourceKey()));
            tag(Tags.Items.SEEDS).addTag(BMMTags.Items.SEEDS_TOMATO).addTag(BMMTags.Items.SEEDS_LETTUCE);
            tag(BMMTags.Items.SEEDS_TOMATO).add(BMMItems.TOMATO_SEEDS.asResourceKey());
            tag(BMMTags.Items.SEEDS_LETTUCE).add(BMMItems.LETTUCE_SEEDS.asResourceKey());

            // Food Tags
            tag(Tags.Items.FOODS).addTag(BMMTags.Items.FOODS_CHEESE).addTag(BMMTags.Items.FOODS_SAUCE).addTag(BMMTags.Items.FOODS_BURGER).addTag(BMMTags.Items.FOODS_ICE_CREAM);
            tag(BMMTags.Items.FOODS_CHEESE).add(BMMItems.CHEESE.asResourceKey());
            tag(Tags.Items.FOODS_BREAD).add(BMMItems.TORTILLA.asResourceKey());
            tag(BMMTags.Items.FOODS_SAUCE).addTag(BMMTags.Items.FOODS_SAUCES_MAYONNAISE).addTag(BMMTags.Items.FOODS_SAUCES_SWEET_SOUR_SAUCE).addTag(BMMTags.Items.FOODS_SAUCES_KETCHUP).addTag(BMMTags.Items.FOODS_SAUCES_MUSTARD);
            tag(BMMTags.Items.FOODS_BURGER).addTag(BMMTags.Items.FOODS_BURGERS_HAMBURGER).addTag(BMMTags.Items.FOODS_BURGERS_CHEESEBURGER).addTag(BMMTags.Items.FOODS_BURGERS_CHICKENBURGER).addTag(BMMTags.Items.FOODS_BURGERS_FISHBURGER).add(BMMItems.MCWRAP.asResourceKey());
            tag(BMMTags.Items.FOODS_ICE_CREAM).addAll(List.of(BMMItems.MCFLURRY.asResourceKey(), BMMItems.MCFLURRY_CHOCOLATE.asResourceKey()));

            tag(BMMTags.Items.BURGER).addAll(List.of(BMMItems.HAMBURGER.asResourceKey(), BMMItems.MCBACON.asResourceKey(), BMMItems.BIG_MAC.asResourceKey(), BMMItems.CHEESEBURGER.asResourceKey(), BMMItems.CHICKENBURGER.asResourceKey(), BMMItems.MCCHICKEN.asResourceKey(), BMMItems.FILET_O_FISH.asResourceKey()));
            tag(BMMTags.Items.SIDE_DISHES).addAll(List.of(BMMItems.SNACK_SALAD.asResourceKey(), BMMItems.CHICKEN_MCNUGGETS.asResourceKey(), BMMItems.FRIES.asResourceKey()));

            // Vegetable Food Tags
            tag(Tags.Items.FOODS_VEGETABLE).addTag(BMMTags.Items.FOODS_VEGETABLES_TOMATO).addTag(BMMTags.Items.FOODS_VEGETABLES_LETTUCE);
            tag(BMMTags.Items.FOODS_VEGETABLES_TOMATO).add(BMMItems.TOMATO.asResourceKey());
            tag(BMMTags.Items.FOODS_VEGETABLES_LETTUCE).add(BMMItems.LETTUCE.asResourceKey());

            // Meat Tags
            tag(ItemTags.MEAT).addAll(List.of(BMMItems.BEEF_PATTY.asResourceKey(), BMMItems.COOKED_BEEF_PATTY.asResourceKey(), BMMItems.RAW_BACON.asResourceKey(), BMMItems.COOKED_BACON.asResourceKey()));

            // Raw Meat Food Tags
            tag(Tags.Items.FOODS_RAW_MEAT).addTag(BMMTags.Items.FOODS_RAW_BEEF).addTag(BMMTags.Items.FOODS_RAW_BACON);
            tag(BMMTags.Items.FOODS_RAW_BEEF).add(BMMItems.BEEF_PATTY.asResourceKey());
            tag(BMMTags.Items.FOODS_RAW_BACON).add(BMMItems.RAW_BACON.asResourceKey());

            // Cooked Meat Food Tags
            tag(Tags.Items.FOODS_COOKED_MEAT).addTag(BMMTags.Items.FOODS_COOKED_BEEF).addTag(BMMTags.Items.FOODS_COOKED_BACON);
            tag(BMMTags.Items.FOODS_COOKED_BEEF).add(BMMItems.COOKED_BEEF_PATTY.asResourceKey());
            tag(BMMTags.Items.FOODS_COOKED_BACON).add(BMMItems.COOKED_BACON.asResourceKey());

            // Sauce Food Tags
            tag(BMMTags.Items.FOODS_SAUCES_MAYONNAISE).add(BMMItems.MAYONNAISE.asResourceKey());
            tag(BMMTags.Items.FOODS_SAUCES_SWEET_SOUR_SAUCE).add(BMMItems.SWEET_SOUR_SAUCE.asResourceKey());
            tag(BMMTags.Items.FOODS_SAUCES_KETCHUP).add(BMMItems.KETCHUP.asResourceKey());
            tag(BMMTags.Items.FOODS_SAUCES_MUSTARD).add(BMMItems.MUSTARD.asResourceKey());

            // Burger Food Tags
            tag(BMMTags.Items.FOODS_BURGERS_HAMBURGER).addAll(List.of(BMMItems.HAMBURGER.asResourceKey(), BMMItems.MCBACON.asResourceKey(), BMMItems.BIG_MAC.asResourceKey()));
            tag(BMMTags.Items.FOODS_BURGERS_CHEESEBURGER).add(BMMItems.CHEESEBURGER.asResourceKey());
            tag(BMMTags.Items.FOODS_BURGERS_CHICKENBURGER).addAll(List.of(BMMItems.CHICKENBURGER.asResourceKey(), BMMItems.MCCHICKEN.asResourceKey()));
            tag(BMMTags.Items.FOODS_BURGERS_FISHBURGER).add(BMMItems.FILET_O_FISH.asResourceKey());

            // Drink Tags
            tag(Tags.Items.DRINKS).addTag(BMMTags.Items.DRINKS_SODA).addTag(BMMTags.Items.DRINKS_TEA);
            tag(BMMTags.Items.DRINKS).addAll(List.of(BMMItems.COCA_COLA.asResourceKey(), BMMItems.FANTA.asResourceKey(), BMMItems.SPRITE.asResourceKey(), BMMItems.LIPTON_ICE_TEA_PEACH.asResourceKey()));
            tag(BMMTags.Items.DRINKS_SODA).addAll(List.of(BMMItems.COCA_COLA.asResourceKey(), BMMItems.FANTA.asResourceKey(), BMMItems.SPRITE.asResourceKey()));
            tag(BMMTags.Items.DRINKS_TEA).add(BMMItems.LIPTON_ICE_TEA_PEACH.asResourceKey());

            // Villager Tags
            tag(ItemTags.VILLAGER_PICKS_UP).addAll(List.of(BMMItems.TOMATO.asResourceKey(), BMMItems.LETTUCE.asResourceKey()));

            // Serene Season Crop Tags
            tag(BMMTags.Items.SERENE_SEASON_SUMMER_CROPS).add(BMMItems.TOMATO_SEEDS.asResourceKey());
            tag(BMMTags.Items.SERENE_SEASON_AUTUMN_CROPS).add(BMMItems.LETTUCE_SEEDS.asResourceKey());
        }
    }

    public static class Blocks extends BlockTagsProvider {
        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries, BetterMcDonaldsMod.MOD_ID);
        }

        @Override
        protected void addTags(HolderLookup.Provider registries) {
            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(BMMBlocks.SALT_BLOCK.asResourceKey());
            tag(BlockTags.CROPS).addAll(List.of(BMMBlocks.TOMATO_CROP.asResourceKey(), BMMBlocks.LETTUCE_CROP.asResourceKey()));
            tag(BlockTags.MAINTAINS_FARMLAND).addAll(List.of(BMMBlocks.TOMATO_CROP.asResourceKey(), BMMBlocks.LETTUCE_CROP.asResourceKey()));

            // Serene Season Crop Tags
            tag(BMMTags.Blocks.SERENE_SEASON_SUMMER_CROPS).add(BMMBlocks.TOMATO_CROP.asResourceKey());
            tag(BMMTags.Blocks.SERENE_SEASON_AUTUMN_CROPS).add(BMMBlocks.LETTUCE_CROP.asResourceKey());
        }
    }

    public static class VillagerTrades extends TagsProvider<VillagerTrade> {
        public VillagerTrades(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, Registries.VILLAGER_TRADE, registries, BetterMcDonaldsMod.MOD_ID);
        }

        @Override
        protected void addTags(HolderLookup.Provider registries) {
            tag(VillagerTradeTags.FARMER_LEVEL_1).addAll(List.of(BMMVillagerTrades.FARMER_1_TOMATO_EMERALD, BMMVillagerTrades.FARMER_1_LETTUCE_EMERALD));
            tag(VillagerTradeTags.BUTCHER_LEVEL_2).addAll(List.of(BMMVillagerTrades.BUTCHER_2_EMERALD_COOKED_BEEF_PATTY, BMMVillagerTrades.BUTCHER_2_EMERALD_COOKED_BACON));
        }
    }
}