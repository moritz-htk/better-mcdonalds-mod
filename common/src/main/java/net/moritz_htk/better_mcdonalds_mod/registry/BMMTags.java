package net.moritz_htk.better_mcdonalds_mod.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.moritz_htk.better_mcdonalds_mod.BetterMcDonaldsMod;

public class BMMTags {
    public static class Items {
        // Dust Tags
        public static final TagKey<Item> DUSTS_SALT = registerCommonKey("dusts/salt");

        // Crop Tags
        public static final TagKey<Item> CROPS_TOMATO = registerCommonKey("crops/tomato");
        public static final TagKey<Item> CROPS_LETTUCE = registerCommonKey("crops/lettuce");

        // Seed Tags
        public static final TagKey<Item> SEEDS_TOMATO = registerCommonKey("seeds/tomato");
        public static final TagKey<Item> SEEDS_LETTUCE = registerCommonKey("seeds/lettuce");

        // Food Tags
        public static final TagKey<Item> FOODS_CHEESE = registerCommonKey("foods/cheese");
        public static final TagKey<Item> FOODS_SAUCE = registerCommonKey("foods/sauce");
        public static final TagKey<Item> FOODS_BURGER = registerCommonKey("foods/burger");
        public static final TagKey<Item> FOODS_SIDE_DISH = registerModKey("foods/side_dish");
        public static final TagKey<Item> FOODS_DRINK = registerCommonKey("foods/drink");

        // Vegetable Food Tags
        public static final TagKey<Item> FOODS_VEGETABLES_TOMATO = registerCommonKey("foods/vegetables/tomato");
        public static final TagKey<Item> FOODS_VEGETABLES_LETTUCE = registerCommonKey("foods/vegetables/lettuce");

        // Raw Meat Food Tags
        public static final TagKey<Item> FOODS_RAW_MEAT_RAW_BEEF = registerCommonKey("foods/raw_meat/raw_beef");
        public static final TagKey<Item> FOODS_RAW_MEAT_RAW_BACON = registerCommonKey("foods/raw_meat/raw_bacon");

        // Cooked Meat Food Tags
        public static final TagKey<Item> FOODS_COOKED_MEAT_COOKED_BEEF = registerCommonKey("foods/cooked_meat/cooked_beef");
        public static final TagKey<Item> FOODS_COOKED_MEAT_COOKED_BACON = registerCommonKey("foods/cooked_meat/cooked_bacon");

        // Sauce Food Tags
        public static final TagKey<Item> FOODS_SAUCES_MAYONNAISE = registerCommonKey("foods/sauces/mayonnaise");
        public static final TagKey<Item> FOODS_SAUCES_SWEET_SOUR_SAUCE = registerCommonKey("foods/sauces/sweet_sour_sauce");
        public static final TagKey<Item> FOODS_SAUCES_KETCHUP = registerCommonKey("foods/sauces/ketchup");
        public static final TagKey<Item> FOODS_SAUCES_MUSTARD = registerCommonKey("foods/sauces/mustard");

        // Burger Food Tags
        public static final TagKey<Item> FOODS_BURGERS_HAMBURGER = registerCommonKey("foods/burgers/hamburger");
        public static final TagKey<Item> FOODS_BURGERS_CHEESEBURGER = registerCommonKey("foods/burgers/cheeseburger");
        public static final TagKey<Item> FOODS_BURGERS_CHICKENBURGER = registerCommonKey("foods/burgers/chickenburger");
        public static final TagKey<Item> FOODS_BURGERS_FISHBURGER = registerCommonKey("foods/burgers/fishburger");

        // Drink Food Tag
        public static final TagKey<Item> FOODS_DRINKS_COKE = registerCommonKey("foods/drinks/coke");
        public static final TagKey<Item> FOODS_DRINKS_ORANGE_JUICE = registerCommonKey("foods/drinks/orange_juice");
        public static final TagKey<Item> FOODS_DRINKS_LEMON_JUICE = registerCommonKey("foods/drinks/lemon_juice");
        public static final TagKey<Item> FOODS_DRINKS_ICE_TEA = registerCommonKey("foods/drinks/ice_tea");

        // Serene Season Crop Tags
        public static final TagKey<Item> SERENE_SEASON_SUMMER_CROPS = registerCompatibilityKey("sereneseasons", "summer_crops");
        public static final TagKey<Item> SERENE_SEASON_AUTUMN_CROPS = registerCompatibilityKey("sereneseasons", "autumn_crops");

        private static TagKey<Item> registerCommonKey(String path) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", path));
        }

        private static TagKey<Item> registerModKey(String path) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, path));
        }

        private static TagKey<Item> registerCompatibilityKey(String namespace, String path) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(namespace, path));
        }
    }

    public static class Blocks {
        // Serene Season Crop Tags
        public static final TagKey<Block> SERENE_SEASON_SUMMER_CROPS = registerCompatibilityKey("sereneseasons", "summer_crops");
        public static final TagKey<Block> SERENE_SEASON_AUTUMN_CROPS = registerCompatibilityKey("sereneseasons", "autumn_crops");

        private static TagKey<Block> registerCompatibilityKey(String namespace, String path) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(namespace, path));
        }
    }
}