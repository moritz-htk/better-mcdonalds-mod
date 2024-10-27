package net.moritz_htk.better_mcdonalds_mod.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.moritz_htk.better_mcdonalds_mod.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMBlocks;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMItems;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BMMTagsProvider {
    public static class Items extends TagsProvider<Item> {
        public Items(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, Registries.ITEM, registries, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            // Dust Tags
            tag(Tags.Items.DUSTS).addTag(BMMTags.Items.DUSTS_SALT);
            tag(BMMTags.Items.DUSTS_SALT).add(TagEntry.element(BMMItems.SALT.getId()));

            // Crop Tags
            tag(Tags.Items.CROPS).addTags(BMMTags.Items.CROPS_TOMATO, BMMTags.Items.CROPS_LETTUCE);
            tag(BMMTags.Items.CROPS_TOMATO).add(TagEntry.element(BMMItems.TOMATO.getId()));
            tag(BMMTags.Items.CROPS_LETTUCE).add(TagEntry.element(BMMItems.LETTUCE.getId()));

            // Seed Tags
            tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).addTags(BMMTags.Items.SEEDS_TOMATO, BMMTags.Items.SEEDS_LETTUCE);
            tag(Tags.Items.SEEDS).addTags(BMMTags.Items.SEEDS_TOMATO, BMMTags.Items.SEEDS_LETTUCE);
            tag(BMMTags.Items.SEEDS_TOMATO).add(TagEntry.element(BMMItems.TOMATO_SEEDS.getId()));
            tag(BMMTags.Items.SEEDS_LETTUCE).add(TagEntry.element(BMMItems.LETTUCE_SEEDS.getId()));

            // Food Tags
            tag(Tags.Items.FOODS).addTags(BMMTags.Items.FOODS_CHEESES, BMMTags.Items.FOODS_SAUCES, BMMTags.Items.FOODS_BURGERS, BMMTags.Items.FOODS_DRINKS).add(TagEntry.element(BMMItems.TORTILLA.getId())).add(TagEntry.element(BMMItems.MCWRAP.getId())).add(TagEntry.element(BMMItems.MCFLURRY.getId())).add(TagEntry.element(BMMItems.MCFLURRY_CHOCOLATE.getId()));
            tag(BMMTags.Items.FOODS_CHEESES).add(TagEntry.element(BMMItems.CHEESE.getId()));
            tag(BMMTags.Items.FOODS_SAUCES).addTags(BMMTags.Items.FOODS_SAUCES_MAYONNAISE, BMMTags.Items.FOODS_SAUCES_SWEET_SOUR_SAUCE, BMMTags.Items.FOODS_SAUCES_KETCHUP, BMMTags.Items.FOODS_SAUCES_MUSTARD);
            tag(BMMTags.Items.FOODS_BURGERS).addTags(BMMTags.Items.FOODS_BURGERS_HAMBURGER, BMMTags.Items.FOODS_BURGERS_CHEESEBURGER, BMMTags.Items.FOODS_BURGERS_CHICKENBURGER, BMMTags.Items.FOODS_BURGERS_FISHBURGER);
            tag(BMMTags.Items.FOODS_SIDE_DISHES).add(TagEntry.element(BMMItems.SNACK_SALAD.getId())).add(TagEntry.element(BMMItems.CHICKEN_MCNUGGETS.getId())).add(TagEntry.element(BMMItems.FRIES.getId()));
            tag(BMMTags.Items.FOODS_DRINKS).addTags(BMMTags.Items.FOODS_DRINKS_COKE, BMMTags.Items.FOODS_DRINKS_ORANGE_JUICE, BMMTags.Items.FOODS_DRINKS_LEMON_JUICE, BMMTags.Items.FOODS_DRINKS_ICE_TEA);

            // Vegetable Food Tags
            tag(Tags.Items.FOODS_VEGETABLES).addTags(BMMTags.Items.FOODS_VEGETABLES_TOMATO, BMMTags.Items.FOODS_VEGETABLES_LETTUCE);
            tag(BMMTags.Items.FOODS_VEGETABLES_TOMATO).add(TagEntry.element(BMMItems.TOMATO.getId()));
            tag(BMMTags.Items.FOODS_VEGETABLES_LETTUCE).add(TagEntry.element(BMMItems.LETTUCE.getId()));

            // Wolf Food Tags
            tag(ItemTags.WOLF_FOOD).addTags(BMMTags.Items.FOODS_RAW_MEAT_RAW_BEEF, BMMTags.Items.FOODS_RAW_MEAT_RAW_BACON, BMMTags.Items.FOODS_COOKED_MEAT_COOKED_BEEF, BMMTags.Items.FOODS_COOKED_MEAT_COOKED_BACON);

            // Raw Meat Food Tags
            tag(Tags.Items.FOODS_RAW_MEATS).addTags(BMMTags.Items.FOODS_RAW_MEAT_RAW_BEEF, BMMTags.Items.FOODS_RAW_MEAT_RAW_BACON);
            tag(BMMTags.Items.FOODS_RAW_MEAT_RAW_BEEF).add(TagEntry.element(BMMItems.BEEF_PATTY.getId()));
            tag(BMMTags.Items.FOODS_RAW_MEAT_RAW_BACON).add(TagEntry.element(BMMItems.RAW_BACON.getId()));

            // Cooked Meat Food Tags
            tag(Tags.Items.FOODS_COOKED_MEATS).addTags(BMMTags.Items.FOODS_COOKED_MEAT_COOKED_BEEF, BMMTags.Items.FOODS_COOKED_MEAT_COOKED_BACON);
            tag(BMMTags.Items.FOODS_COOKED_MEAT_COOKED_BEEF).add(TagEntry.element(BMMItems.COOKED_BEEF_PATTY.getId()));
            tag(BMMTags.Items.FOODS_COOKED_MEAT_COOKED_BACON).add(TagEntry.element(BMMItems.COOKED_BACON.getId()));

            // Sauce Food Tags
            tag(BMMTags.Items.FOODS_SAUCES_MAYONNAISE).add(TagEntry.element(BMMItems.MAYONNAISE.getId()));
            tag(BMMTags.Items.FOODS_SAUCES_SWEET_SOUR_SAUCE).add(TagEntry.element(BMMItems.SWEET_SOUR_SAUCE.getId()));
            tag(BMMTags.Items.FOODS_SAUCES_KETCHUP).add(TagEntry.element(BMMItems.KETCHUP.getId()));
            tag(BMMTags.Items.FOODS_SAUCES_MUSTARD).add(TagEntry.element(BMMItems.MUSTARD.getId()));

            // Burger Food Tags
            tag(BMMTags.Items.FOODS_BURGERS_HAMBURGER).add(TagEntry.element(BMMItems.HAMBURGER.getId())).add(TagEntry.element(BMMItems.MCBACON.getId())).add(TagEntry.element(BMMItems.BIG_MAC.getId()));
            tag(BMMTags.Items.FOODS_BURGERS_CHEESEBURGER).add(TagEntry.element(BMMItems.CHEESEBURGER.getId()));
            tag(BMMTags.Items.FOODS_BURGERS_CHICKENBURGER).add(TagEntry.element(BMMItems.CHICKENBURGER.getId())).add(TagEntry.element(BMMItems.MCCHICKEN.getId()));
            tag(BMMTags.Items.FOODS_BURGERS_FISHBURGER).add(TagEntry.element(BMMItems.FILET_O_FISH.getId()));

            // Drink Food Tag
            tag(BMMTags.Items.FOODS_DRINKS_COKE).add(TagEntry.element(BMMItems.COCA_COLA.getId()));
            tag(BMMTags.Items.FOODS_DRINKS_ORANGE_JUICE).add(TagEntry.element(BMMItems.FANTA.getId()));
            tag(BMMTags.Items.FOODS_DRINKS_LEMON_JUICE).add(TagEntry.element(BMMItems.SPRITE.getId()));
            tag(BMMTags.Items.FOODS_DRINKS_ICE_TEA).add(TagEntry.element(BMMItems.LIPTON_ICE_TEA_PEACH.getId()));

            // Serene Season Crop Tags
            tag(BMMTags.Items.SERENE_SEASON_SUMMER_CROPS).add(TagEntry.element(BMMItems.TOMATO_SEEDS.getId()));
            tag(BMMTags.Items.SERENE_SEASON_AUTUMN_CROPS).add(TagEntry.element(BMMItems.LETTUCE_SEEDS.getId()));
        }
    }

    public static class Blocks extends TagsProvider<Block> {
        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, Registries.BLOCK, registries, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(TagEntry.element(BMMBlocks.SALT_BLOCK.getId()));
            tag(BlockTags.CROPS).add(TagEntry.element(BMMBlocks.TOMATO_CROP.getId())).add(TagEntry.element(BMMBlocks.LETTUCE_CROP.getId()));
            tag(BlockTags.MAINTAINS_FARMLAND).add(TagEntry.element(BMMBlocks.TOMATO_CROP.getId())).add(TagEntry.element(BMMBlocks.LETTUCE_CROP.getId()));

            // Serene Season Crop Tags
            tag(BMMTags.Blocks.SERENE_SEASON_SUMMER_CROPS).add(TagEntry.element(BMMBlocks.TOMATO_CROP.getId()));
            tag(BMMTags.Blocks.SERENE_SEASON_AUTUMN_CROPS).add(TagEntry.element(BMMBlocks.LETTUCE_CROP.getId()));
        }
    }
}