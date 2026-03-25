package net.kyronis.better_mcdonalds_mod.common.registry;

import net.blay09.mods.balm.world.item.BalmItemRegistrar;
import net.blay09.mods.balm.world.item.DeferredItem;
import net.kyronis.better_mcdonalds_mod.common.item.BMMDrinkItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BMMItems {
    public static DeferredItem SALT_BLOCK;

    public static DeferredItem TOMATO;
    public static DeferredItem TOMATO_SEEDS;
    public static DeferredItem LETTUCE;
    public static DeferredItem LETTUCE_SEEDS;

    public static DeferredItem SALT;
    public static DeferredItem CHEESE;
    public static DeferredItem TORTILLA;
    public static DeferredItem BEEF_PATTY;
    public static DeferredItem COOKED_BEEF_PATTY;
    public static DeferredItem RAW_BACON;
    public static DeferredItem COOKED_BACON;
    public static DeferredItem MAYONNAISE;
    public static DeferredItem SWEET_SOUR_SAUCE;
    public static DeferredItem KETCHUP;
    public static DeferredItem MUSTARD;

    public static DeferredItem HAMBURGER;
    public static DeferredItem CHEESEBURGER;
    public static DeferredItem MCBACON;
    public static DeferredItem BIG_MAC;
    public static DeferredItem CHICKENBURGER;
    public static DeferredItem MCCHICKEN;
    public static DeferredItem FILET_O_FISH;
    public static DeferredItem MCWRAP;

    public static DeferredItem SNACK_SALAD;
    public static DeferredItem CHICKEN_MCNUGGETS;
    public static DeferredItem FRIES;

    public static DeferredItem HAPPY_MEAL;

    public static DeferredItem COCA_COLA;
    public static DeferredItem FANTA;
    public static DeferredItem SPRITE;
    public static DeferredItem LIPTON_ICE_TEA_PEACH;

    public static DeferredItem MCFLURRY;
    public static DeferredItem MCFLURRY_CHOCOLATE;

    public static final List<DeferredItem> ITEMS = new ArrayList<>();

    public static void initialize(BalmItemRegistrar items) {
        SALT_BLOCK = registerItem(items, "salt_block", properties -> new BlockItem(BMMBlocks.SALT_BLOCK.asBlock(), properties.useBlockDescriptionPrefix()));

        TOMATO = registerItem(items, "tomato", properties -> new Item(properties.food(registerFoodValues(1, 0.3f))));
        TOMATO_SEEDS = registerItem(items, "tomato_seeds", properties -> new BlockItem(BMMBlocks.TOMATO_CROP.asBlock(), properties.useItemDescriptionPrefix()));
        LETTUCE = registerItem(items, "lettuce", properties -> new Item(properties.food(registerFoodValues(1, 0.3f))));
        LETTUCE_SEEDS = registerItem(items, "lettuce_seeds", properties -> new BlockItem(BMMBlocks.LETTUCE_CROP.asBlock(), properties.useItemDescriptionPrefix()));

        SALT = registerItem(items, "salt", Item::new);
        CHEESE = registerItem(items, "cheese", properties -> new Item(properties.food(registerFoodValues(2, 0.4f))));
        TORTILLA = registerItem(items, "tortilla", properties -> new Item(properties.food(registerFoodValues(2, 0.4f))));
        BEEF_PATTY = registerItem(items, "beef_patty", properties -> new Item(properties.food(registerFoodValues(4, 0.4f))));
        COOKED_BEEF_PATTY = registerItem(items, "cooked_beef_patty", properties -> new Item(properties.food(registerFoodValues(5, 0.4f))));
        RAW_BACON = registerItem(items, "raw_bacon", properties -> new Item(properties.food(registerFoodValues(3, 0.4f))));
        COOKED_BACON = registerItem(items, "cooked_bacon", properties -> new Item(properties.food(registerFoodValues(4, 0.4f))));
        MAYONNAISE = registerItem(items, "mayonnaise", properties -> new Item(properties.food(registerFoodValues(1, 0.3f))));
        SWEET_SOUR_SAUCE = registerItem(items, "sweet_sour_sauce", properties -> new Item(properties.food(registerFoodValues(1, 0.3f))));
        KETCHUP = registerItem(items, "ketchup", properties -> new Item(properties.food(registerFoodValues(1, 0.3f))));
        MUSTARD = registerItem(items, "mustard", properties -> new Item(properties.food(registerFoodValues(1, 0.3f))));

        HAMBURGER = registerItem(items, "hamburger", properties -> new Item(properties.food(registerFoodValues(6, 0.5f))));
        CHEESEBURGER = registerItem(items, "cheeseburger", properties -> new Item(properties.food(registerFoodValues(8, 0.5f))));
        MCBACON = registerItem(items, "mcbacon", properties -> new Item(properties.food(registerFoodValues(8, 0.5f))));
        BIG_MAC = registerItem(items, "big_mac", properties -> new Item(properties.food(registerFoodValues(10, 0.5f))));
        CHICKENBURGER = registerItem(items, "chickenburger", properties -> new Item(properties.food(registerFoodValues(7, 0.5f))));
        MCCHICKEN = registerItem(items, "mcchicken", properties -> new Item(properties.food(registerFoodValues(8, 0.5f))));
        FILET_O_FISH = registerItem(items, "filet_o_fish", properties -> new Item(properties.food(registerFoodValues(6, 0.5f))));
        MCWRAP = registerItem(items, "mcwrap", properties -> new Item(properties.food(registerFoodValues(5, 0.4f))));

        SNACK_SALAD = registerItem(items, "snack_salad", properties -> new Item(properties.food(registerFoodValues(4, 0.4f))));
        CHICKEN_MCNUGGETS = registerItem(items, "chicken_mcnuggets", properties -> new Item(properties.food(registerFoodValues(4, 0.4f))));
        FRIES = registerItem(items, "fries", properties -> new Item(properties.food(registerFoodValues(5, 0.4f))));

        HAPPY_MEAL = registerItem(items, "happy_meal", properties -> new Item(properties.rarity(Rarity.UNCOMMON).food(registerFoodValues(14, 0.5f))));

        COCA_COLA = registerItem(items, "coca_cola", properties -> new BMMDrinkItem(properties.food(registerFoodValues(3, 0.4f))));
        FANTA = registerItem(items, "fanta", properties -> new BMMDrinkItem(properties.food(registerFoodValues(3, 0.4f))));
        SPRITE = registerItem(items, "sprite", properties -> new BMMDrinkItem(properties.food(registerFoodValues(3, 0.4f))));
        LIPTON_ICE_TEA_PEACH = registerItem(items, "lipton_ice_tea_peach", properties -> new BMMDrinkItem(properties.food(registerFoodValues(3, 0.4f))));

        MCFLURRY = registerItem(items, "mcflurry", properties -> new Item(properties.food(registerFoodValues(6, 0.4f))));
        MCFLURRY_CHOCOLATE = registerItem(items, "mcflurry_chocolate", properties -> new Item(properties.food(registerFoodValues(6, 0.4f))));
    }

    private static DeferredItem registerItem(BalmItemRegistrar items, String name, Function<Item.Properties, Item> factory) {
        DeferredItem item = items.register(name, factory, new Item.Properties()).asDeferredItem();
        ITEMS.add(item);
        return item;
    }

    private static FoodProperties registerFoodValues(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build();
    }
}