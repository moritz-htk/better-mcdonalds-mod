package net.kyronis.better_mcdonalds_mod.common.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.item.BMMDrinkItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;

public class BMMItems {
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(BetterMcDonaldsMod.MOD_ID, Registries.ITEM);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BetterMcDonaldsMod.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<BlockItem> SALT_BLOCK = BLOCK_ITEMS.register("salt_block", () -> new BlockItem(BMMBlocks.SALT_BLOCK.get(), registerItemProperties()));
    public static final RegistrySupplier<Item> SALT = ITEMS.register("salt", () -> new Item(registerItemProperties()));
    public static final RegistrySupplier<Item> TOMATO = ITEMS.register("tomato", () -> new Item(registerItemProperties().food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds", () -> new ItemNameBlockItem(BMMBlocks.TOMATO_CROP.get(), registerItemProperties()));
    public static final RegistrySupplier<Item> LETTUCE = ITEMS.register("lettuce", () -> new Item(registerItemProperties().food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> LETTUCE_SEEDS = ITEMS.register("lettuce_seeds", () -> new ItemNameBlockItem(BMMBlocks.LETTUCE_CROP.get(), registerItemProperties()));
    public static final RegistrySupplier<Item> CHEESE = ITEMS.register("cheese", () -> new Item(registerItemProperties().food(registerFoodValues(2, 0.4f))));
    public static final RegistrySupplier<Item> TORTILLA = ITEMS.register("tortilla", () -> new Item(registerItemProperties().food(registerFoodValues(2, 0.4f))));
    public static final RegistrySupplier<Item> BEEF_PATTY = ITEMS.register("beef_patty", () -> new Item(registerItemProperties().food(registerFoodValues(4, 0.4f))));
    public static final RegistrySupplier<Item> COOKED_BEEF_PATTY = ITEMS.register("cooked_beef_patty", () -> new Item(registerItemProperties().food(registerFoodValues(5, 0.4f))));
    public static final RegistrySupplier<Item> RAW_BACON = ITEMS.register("raw_bacon", () -> new Item(registerItemProperties().food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<Item> COOKED_BACON = ITEMS.register("cooked_bacon", () -> new Item(registerItemProperties().food(registerFoodValues(4, 0.4f))));
    public static final RegistrySupplier<Item> MAYONNAISE = ITEMS.register("mayonnaise", () -> new Item(registerItemProperties().food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> SWEET_SOUR_SAUCE = ITEMS.register("sweet_sour_sauce", () -> new Item(registerItemProperties().food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> KETCHUP = ITEMS.register("ketchup", () -> new Item(registerItemProperties().food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> MUSTARD = ITEMS.register("mustard", () -> new Item(registerItemProperties().food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> HAMBURGER = ITEMS.register("hamburger", () -> new Item(registerItemProperties().food(registerFoodValues(6, 0.5f))));
    public static final RegistrySupplier<Item> CHEESEBURGER = ITEMS.register("cheeseburger", () -> new Item(registerItemProperties().food(registerFoodValues(8, 0.5f))));
    public static final RegistrySupplier<Item> MCBACON = ITEMS.register("mcbacon", () -> new Item(registerItemProperties().food(registerFoodValues(8, 0.5f))));
    public static final RegistrySupplier<Item> BIG_MAC = ITEMS.register("big_mac", () -> new Item(registerItemProperties().food(registerFoodValues(10, 0.5f))));
    public static final RegistrySupplier<Item> CHICKENBURGER = ITEMS.register("chickenburger", () -> new Item(registerItemProperties().food(registerFoodValues(7, 0.5f))));
    public static final RegistrySupplier<Item> MCCHICKEN = ITEMS.register("mcchicken", () -> new Item(registerItemProperties().food(registerFoodValues(8, 0.5f))));
    public static final RegistrySupplier<Item> FILET_O_FISH = ITEMS.register("filet_o_fish", () -> new Item(registerItemProperties().food(registerFoodValues(6, 0.5f))));
    public static final RegistrySupplier<Item> MCWRAP = ITEMS.register("mcwrap", () -> new Item(registerItemProperties().food(registerFoodValues(5, 0.4f))));
    public static final RegistrySupplier<Item> SNACK_SALAD = ITEMS.register("snack_salad", () -> new Item(registerItemProperties().food(registerFoodValues(4, 0.4f))));
    public static final RegistrySupplier<Item> CHICKEN_MCNUGGETS = ITEMS.register("chicken_mcnuggets", () -> new Item(registerItemProperties().food(registerFoodValues(4, 0.4f))));
    public static final RegistrySupplier<Item> FRIES = ITEMS.register("fries", () -> new Item(registerItemProperties().food(registerFoodValues(5, 0.4f))));
    public static final RegistrySupplier<Item> HAPPY_MEAL = ITEMS.register("happy_meal", () -> new Item(registerItemProperties().rarity(Rarity.UNCOMMON).food(registerFoodValues(14, 0.5f))));
    public static final RegistrySupplier<Item> COCA_COLA = ITEMS.register("coca_cola", () -> new BMMDrinkItem(registerItemProperties().food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<Item> FANTA = ITEMS.register("fanta", () -> new BMMDrinkItem(registerItemProperties().food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<Item> SPRITE = ITEMS.register("sprite", () -> new BMMDrinkItem(registerItemProperties().food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<Item> LIPTON_ICE_TEA_PEACH = ITEMS.register("lipton_ice_tea_peach", () -> new BMMDrinkItem(registerItemProperties().food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<Item> MCFLURRY = ITEMS.register("mcflurry", () -> new Item(registerItemProperties().food(registerFoodValues(6, 0.4f))));
    public static final RegistrySupplier<Item> MCFLURRY_CHOCOLATE = ITEMS.register("mcflurry_chocolate", () -> new Item(registerItemProperties().food(registerFoodValues(6, 0.4f))));

    private static Item.Properties registerItemProperties() {
        return new Item.Properties().arch$tab(BMMCreativeTabs.BETTER_MCDONALDS_MOD_MAIN);
    }

    private static FoodProperties registerFoodValues(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build();
    }

    public static void register() {
        BLOCK_ITEMS.register();
        ITEMS.register();
    }
}