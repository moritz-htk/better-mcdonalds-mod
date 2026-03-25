package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMTags;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMVillagerTrades;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
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
            tag(BMMTags.Items.DUSTS_SALT).add(BMMItems.SALT.asItem());

            // Crop Tags
            tag(Tags.Items.CROPS).addTag(BMMTags.Items.CROPS_TOMATO).addTag(BMMTags.Items.CROPS_LETTUCE);
            tag(BMMTags.Items.CROPS_TOMATO).add(BMMItems.TOMATO.asItem());
            tag(BMMTags.Items.CROPS_LETTUCE).add(BMMItems.LETTUCE.asItem());

            // Seed Tags
            tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).addAll(List.of(BMMItems.TOMATO_SEEDS.asItem(), BMMItems.LETTUCE_SEEDS.asItem()));
            tag(Tags.Items.SEEDS).addTag(BMMTags.Items.SEEDS_TOMATO).addTag(BMMTags.Items.SEEDS_LETTUCE);
            tag(BMMTags.Items.SEEDS_TOMATO).add(BMMItems.TOMATO_SEEDS.asItem());
            tag(BMMTags.Items.SEEDS_LETTUCE).add(BMMItems.LETTUCE_SEEDS.asItem());

            // Food Tags
            tag(Tags.Items.FOODS).addTag(BMMTags.Items.FOODS_CHEESE).addTag(BMMTags.Items.FOODS_SAUCE).addTag(BMMTags.Items.FOODS_BURGER).addTag(BMMTags.Items.FOODS_ICE_CREAM);
            tag(BMMTags.Items.FOODS_CHEESE).add(BMMItems.CHEESE.asItem());
            tag(Tags.Items.FOODS_BREAD).add(BMMItems.TORTILLA.asItem());
            tag(BMMTags.Items.FOODS_SAUCE).addTag(BMMTags.Items.FOODS_SAUCES_MAYONNAISE).addTag(BMMTags.Items.FOODS_SAUCES_SWEET_SOUR_SAUCE).addTag(BMMTags.Items.FOODS_SAUCES_KETCHUP).addTag(BMMTags.Items.FOODS_SAUCES_MUSTARD);
            tag(BMMTags.Items.FOODS_BURGER).addTag(BMMTags.Items.FOODS_BURGERS_HAMBURGER).addTag(BMMTags.Items.FOODS_BURGERS_CHEESEBURGER).addTag(BMMTags.Items.FOODS_BURGERS_CHICKENBURGER).addTag(BMMTags.Items.FOODS_BURGERS_FISHBURGER).add(BMMItems.MCWRAP.asItem());
            tag(BMMTags.Items.FOODS_ICE_CREAM).addAll(List.of(BMMItems.MCFLURRY.asItem(), BMMItems.MCFLURRY_CHOCOLATE.asItem()));

            tag(BMMTags.Items.BURGER).addAll(List.of(BMMItems.HAMBURGER.asItem(), BMMItems.MCBACON.asItem(), BMMItems.BIG_MAC.asItem(), BMMItems.CHEESEBURGER.asItem(), BMMItems.CHICKENBURGER.asItem(), BMMItems.MCCHICKEN.asItem(), BMMItems.FILET_O_FISH.asItem()));
            tag(BMMTags.Items.SIDE_DISHES).addAll(List.of(BMMItems.SNACK_SALAD.asItem(), BMMItems.CHICKEN_MCNUGGETS.asItem(), BMMItems.FRIES.asItem()));

            // Vegetable Food Tags
            tag(Tags.Items.FOODS_VEGETABLE).addTag(BMMTags.Items.FOODS_VEGETABLES_TOMATO).addTag(BMMTags.Items.FOODS_VEGETABLES_LETTUCE);
            tag(BMMTags.Items.FOODS_VEGETABLES_TOMATO).add(BMMItems.TOMATO.asItem());
            tag(BMMTags.Items.FOODS_VEGETABLES_LETTUCE).add(BMMItems.LETTUCE.asItem());

            // Meat Tags
            tag(ItemTags.MEAT).addAll(List.of(BMMItems.BEEF_PATTY.asItem(), BMMItems.COOKED_BEEF_PATTY.asItem(), BMMItems.RAW_BACON.asItem(), BMMItems.COOKED_BACON.asItem()));

            // Raw Meat Food Tags
            tag(Tags.Items.FOODS_RAW_MEAT).addTag(BMMTags.Items.FOODS_RAW_BEEF).addTag(BMMTags.Items.FOODS_RAW_BACON);
            tag(BMMTags.Items.FOODS_RAW_BEEF).add(BMMItems.BEEF_PATTY.asItem());
            tag(BMMTags.Items.FOODS_RAW_BACON).add(BMMItems.RAW_BACON.asItem());

            // Cooked Meat Food Tags
            tag(Tags.Items.FOODS_COOKED_MEAT).addTag(BMMTags.Items.FOODS_COOKED_BEEF).addTag(BMMTags.Items.FOODS_COOKED_BACON);
            tag(BMMTags.Items.FOODS_COOKED_BEEF).add(BMMItems.COOKED_BEEF_PATTY.asItem());
            tag(BMMTags.Items.FOODS_COOKED_BACON).add(BMMItems.COOKED_BACON.asItem());

            // Sauce Food Tags
            tag(BMMTags.Items.FOODS_SAUCES_MAYONNAISE).add(BMMItems.MAYONNAISE.asItem());
            tag(BMMTags.Items.FOODS_SAUCES_SWEET_SOUR_SAUCE).add(BMMItems.SWEET_SOUR_SAUCE.asItem());
            tag(BMMTags.Items.FOODS_SAUCES_KETCHUP).add(BMMItems.KETCHUP.asItem());
            tag(BMMTags.Items.FOODS_SAUCES_MUSTARD).add(BMMItems.MUSTARD.asItem());

            // Burger Food Tags
            tag(BMMTags.Items.FOODS_BURGERS_HAMBURGER).addAll(List.of(BMMItems.HAMBURGER.asItem(), BMMItems.MCBACON.asItem(), BMMItems.BIG_MAC.asItem()));
            tag(BMMTags.Items.FOODS_BURGERS_CHEESEBURGER).add(BMMItems.CHEESEBURGER.asItem());
            tag(BMMTags.Items.FOODS_BURGERS_CHICKENBURGER).addAll(List.of(BMMItems.CHICKENBURGER.asItem(), BMMItems.MCCHICKEN.asItem()));
            tag(BMMTags.Items.FOODS_BURGERS_FISHBURGER).add(BMMItems.FILET_O_FISH.asItem());

            // Drink Tags
            tag(Tags.Items.DRINKS).addTag(BMMTags.Items.DRINKS_SODA).addTag(BMMTags.Items.DRINKS_TEA);
            tag(BMMTags.Items.DRINKS).addAll(List.of(BMMItems.COCA_COLA.asItem(), BMMItems.FANTA.asItem(), BMMItems.SPRITE.asItem(), BMMItems.LIPTON_ICE_TEA_PEACH.asItem()));
            tag(BMMTags.Items.DRINKS_SODA).addAll(List.of(BMMItems.COCA_COLA.asItem(), BMMItems.FANTA.asItem(), BMMItems.SPRITE.asItem()));
            tag(BMMTags.Items.DRINKS_TEA).add(BMMItems.LIPTON_ICE_TEA_PEACH.asItem());

            // Villager Tags
            tag(ItemTags.VILLAGER_PICKS_UP).addAll(List.of(BMMItems.TOMATO.asItem(), BMMItems.LETTUCE.asItem()));

            // Serene Season Crop Tags
            tag(BMMTags.Items.SERENE_SEASON_SUMMER_CROPS).add(BMMItems.TOMATO_SEEDS.asItem());
            tag(BMMTags.Items.SERENE_SEASON_AUTUMN_CROPS).add(BMMItems.LETTUCE_SEEDS.asItem());
        }
    }

    public static class Blocks extends BlockTagsProvider {
        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries, BetterMcDonaldsMod.MOD_ID);
        }

        @Override
        protected void addTags(HolderLookup.Provider registries) {
            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(BMMBlocks.SALT_BLOCK.asBlock());
            tag(BlockTags.CROPS).addAll(List.of(BMMBlocks.TOMATO_CROP.asBlock(), BMMBlocks.LETTUCE_CROP.asBlock()));
            tag(BlockTags.MAINTAINS_FARMLAND).addAll(List.of(BMMBlocks.TOMATO_CROP.asBlock(), BMMBlocks.LETTUCE_CROP.asBlock()));

            // Serene Season Crop Tags
            tag(BMMTags.Blocks.SERENE_SEASON_SUMMER_CROPS).add(BMMBlocks.TOMATO_CROP.asBlock());
            tag(BMMTags.Blocks.SERENE_SEASON_AUTUMN_CROPS).add(BMMBlocks.LETTUCE_CROP.asBlock());
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

        private TagAppender<ResourceKey<VillagerTrade>, VillagerTrade> tag(TagKey<VillagerTrade> tag) {
            return TagAppender.forBuilder(this.getOrCreateRawBuilder(tag));
        }
    }
}