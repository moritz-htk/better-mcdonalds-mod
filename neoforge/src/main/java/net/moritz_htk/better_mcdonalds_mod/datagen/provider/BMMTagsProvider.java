package net.moritz_htk.better_mcdonalds_mod.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.moritz_htk.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.moritz_htk.better_mcdonalds_mod.common.registry.BMMItems;
import net.moritz_htk.better_mcdonalds_mod.common.registry.BMMTags;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BMMTagsProvider {
    public static class Items extends TagsProvider<Item> {
        public Items(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, Registries.ITEM, registries, BetterMcDonaldsMod.MOD_ID);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            // Dust Tags
            tag(Tags.Items.DUSTS).addTag(BMMTags.Items.DUSTS_SALT);
            tag(BMMTags.Items.DUSTS_SALT).add(BMMItems.SALT.getKey());

            // Crop Tags
            tag(Tags.Items.CROPS).addTag(BMMTags.Items.CROPS_TOMATO).addTag(BMMTags.Items.CROPS_LETTUCE);
            tag(BMMTags.Items.CROPS_TOMATO).add(BMMItems.TOMATO.getKey());
            tag(BMMTags.Items.CROPS_LETTUCE).add(BMMItems.LETTUCE.getKey());

            // Seed Tags
            tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).addAll(List.of(BMMItems.TOMATO_SEEDS.getKey(), BMMItems.LETTUCE_SEEDS.getKey()));
            tag(Tags.Items.SEEDS).addTag(BMMTags.Items.SEEDS_TOMATO).addTag(BMMTags.Items.SEEDS_LETTUCE);
            tag(BMMTags.Items.SEEDS_TOMATO).add(BMMItems.TOMATO_SEEDS.getKey());
            tag(BMMTags.Items.SEEDS_LETTUCE).add(BMMItems.LETTUCE_SEEDS.getKey());

            // Food Tags
            tag(Tags.Items.FOODS).addTag(BMMTags.Items.FOODS_CHEESE).addTag(BMMTags.Items.FOODS_SAUCE).addTag(BMMTags.Items.FOODS_BURGER).addTag(BMMTags.Items.FOODS_ICE_CREAM);
            tag(BMMTags.Items.FOODS_CHEESE).add(BMMItems.CHEESE.getKey());
            tag(Tags.Items.FOODS_BREAD).add(BMMItems.TORTILLA.getKey());
            tag(BMMTags.Items.FOODS_SAUCE).addTag(BMMTags.Items.FOODS_SAUCES_MAYONNAISE).addTag(BMMTags.Items.FOODS_SAUCES_SWEET_SOUR_SAUCE).addTag(BMMTags.Items.FOODS_SAUCES_KETCHUP).addTag(BMMTags.Items.FOODS_SAUCES_MUSTARD);
            tag(BMMTags.Items.FOODS_BURGER).addTag(BMMTags.Items.FOODS_BURGERS_HAMBURGER).addTag(BMMTags.Items.FOODS_BURGERS_CHEESEBURGER).addTag(BMMTags.Items.FOODS_BURGERS_CHICKENBURGER).addTag(BMMTags.Items.FOODS_BURGERS_FISHBURGER).add(BMMItems.MCWRAP.getKey());
            tag(BMMTags.Items.FOODS_ICE_CREAM).addAll(List.of(BMMItems.MCFLURRY.getKey(), BMMItems.MCFLURRY_CHOCOLATE.getKey()));

            tag(BMMTags.Items.BURGER).addAll(List.of(BMMItems.HAMBURGER.getKey(), BMMItems.MCBACON.getKey(), BMMItems.BIG_MAC.getKey(), BMMItems.CHEESEBURGER.getKey(), BMMItems.CHICKENBURGER.getKey(), BMMItems.MCCHICKEN.getKey(), BMMItems.FILET_O_FISH.getKey()));
            tag(BMMTags.Items.SIDE_DISHES).addAll(List.of(BMMItems.SNACK_SALAD.getKey(), BMMItems.CHICKEN_MCNUGGETS.getKey(), BMMItems.FRIES.getKey()));

            // Vegetable Food Tags
            tag(Tags.Items.FOODS_VEGETABLE).addTag(BMMTags.Items.FOODS_VEGETABLES_TOMATO).addTag(BMMTags.Items.FOODS_VEGETABLES_LETTUCE);
            tag(BMMTags.Items.FOODS_VEGETABLES_TOMATO).add(BMMItems.TOMATO.getKey());
            tag(BMMTags.Items.FOODS_VEGETABLES_LETTUCE).add(BMMItems.LETTUCE.getKey());

            // Meat Tags
            tag(ItemTags.MEAT).addAll(List.of(BMMItems.BEEF_PATTY.getKey(), BMMItems.COOKED_BEEF_PATTY.getKey(), BMMItems.RAW_BACON.getKey(), BMMItems.COOKED_BACON.getKey()));

            // Raw Meat Food Tags
            tag(Tags.Items.FOODS_RAW_MEAT).addTag(BMMTags.Items.FOODS_RAW_BEEF).addTag(BMMTags.Items.FOODS_RAW_BACON);
            tag(BMMTags.Items.FOODS_RAW_BEEF).add(BMMItems.BEEF_PATTY.getKey());
            tag(BMMTags.Items.FOODS_RAW_BACON).add(BMMItems.RAW_BACON.getKey());

            // Cooked Meat Food Tags
            tag(Tags.Items.FOODS_COOKED_MEAT).addTag(BMMTags.Items.FOODS_COOKED_BEEF).addTag(BMMTags.Items.FOODS_COOKED_BACON);
            tag(BMMTags.Items.FOODS_COOKED_BEEF).add(BMMItems.COOKED_BEEF_PATTY.getKey());
            tag(BMMTags.Items.FOODS_COOKED_BACON).add(BMMItems.COOKED_BACON.getKey());

            // Sauce Food Tags
            tag(BMMTags.Items.FOODS_SAUCES_MAYONNAISE).add(BMMItems.MAYONNAISE.getKey());
            tag(BMMTags.Items.FOODS_SAUCES_SWEET_SOUR_SAUCE).add(BMMItems.SWEET_SOUR_SAUCE.getKey());
            tag(BMMTags.Items.FOODS_SAUCES_KETCHUP).add(BMMItems.KETCHUP.getKey());
            tag(BMMTags.Items.FOODS_SAUCES_MUSTARD).add(BMMItems.MUSTARD.getKey());

            // Burger Food Tags
            tag(BMMTags.Items.FOODS_BURGERS_HAMBURGER).addAll(List.of(BMMItems.HAMBURGER.getKey(), BMMItems.MCBACON.getKey(), BMMItems.BIG_MAC.getKey()));
            tag(BMMTags.Items.FOODS_BURGERS_CHEESEBURGER).add(BMMItems.CHEESEBURGER.getKey());
            tag(BMMTags.Items.FOODS_BURGERS_CHICKENBURGER).addAll(List.of(BMMItems.CHICKENBURGER.getKey(), BMMItems.MCCHICKEN.getKey()));
            tag(BMMTags.Items.FOODS_BURGERS_FISHBURGER).add(BMMItems.FILET_O_FISH.getKey());

            // Drink Tags
            tag(Tags.Items.DRINKS).addTag(BMMTags.Items.DRINKS_SODA).addTag(BMMTags.Items.DRINKS_TEA);
            tag(BMMTags.Items.DRINKS).addAll(List.of(BMMItems.COCA_COLA.getKey(), BMMItems.FANTA.getKey(), BMMItems.SPRITE.getKey(), BMMItems.LIPTON_ICE_TEA_PEACH.getKey()));
            tag(BMMTags.Items.DRINKS_SODA).addAll(List.of(BMMItems.COCA_COLA.getKey(), BMMItems.FANTA.getKey(), BMMItems.SPRITE.getKey()));
            tag(BMMTags.Items.DRINKS_TEA).add(BMMItems.LIPTON_ICE_TEA_PEACH.getKey());

            // Villager Tags
            tag(ItemTags.VILLAGER_PICKS_UP).addAll(List.of(BMMItems.TOMATO.getKey(), BMMItems.LETTUCE.getKey()));

            // Serene Season Crop Tags
            tag(BMMTags.Items.SERENE_SEASON_SUMMER_CROPS).add(BMMItems.TOMATO_SEEDS.getKey());
            tag(BMMTags.Items.SERENE_SEASON_AUTUMN_CROPS).add(BMMItems.LETTUCE_SEEDS.getKey());
        }
    }

    public static class Blocks extends TagsProvider<Block> {
        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, Registries.BLOCK, registries, BetterMcDonaldsMod.MOD_ID);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(BMMBlocks.SALT_BLOCK.getKey());
            tag(BlockTags.CROPS).addAll(List.of(BMMBlocks.TOMATO_CROP.getKey(), BMMBlocks.LETTUCE_CROP.getKey()));
            tag(BlockTags.MAINTAINS_FARMLAND).addAll(List.of(BMMBlocks.TOMATO_CROP.getKey(), BMMBlocks.LETTUCE_CROP.getKey()));

            // Serene Season Crop Tags
            tag(BMMTags.Blocks.SERENE_SEASON_SUMMER_CROPS).add(BMMBlocks.TOMATO_CROP.getKey());
            tag(BMMTags.Blocks.SERENE_SEASON_AUTUMN_CROPS).add(BMMBlocks.LETTUCE_CROP.getKey());
        }
    }
}