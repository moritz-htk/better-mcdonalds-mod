package net.moritz_htk.better_mcdonalds_mod.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.moritz_htk.better_mcdonalds_mod.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.item.BMMDrinkItem;
import net.moritz_htk.better_mcdonalds_mod.item.BMMKnifeItem;

public class BMMItems {
    public static final DeferredRegister<Item> MAIN_ITEMS = DeferredRegister.create(BetterMcDonaldsMod.MOD_ID, Registries.ITEM);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BetterMcDonaldsMod.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<BlockItem> SALT_BLOCK = ITEMS.register("salt_block", () -> new BlockItem(BMMBlocks.SALT_BLOCK.get(), registerItemProperties()));
    public static final RegistrySupplier<Item> SALT = MAIN_ITEMS.register("salt", () -> new Item(registerItemProperties()));
    public static final RegistrySupplier<Item> TOMATO = MAIN_ITEMS.register("tomato", () -> new Item(registerItemProperties().food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> TOMATO_SEEDS = MAIN_ITEMS.register("tomato_seeds", () -> new ItemNameBlockItem(BMMBlocks.TOMATO_CROP.get(), registerItemProperties()));
    public static final RegistrySupplier<Item> LETTUCE = MAIN_ITEMS.register("lettuce", () -> new Item(registerItemProperties().food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> LETTUCE_SEEDS = MAIN_ITEMS.register("lettuce_seeds", () -> new ItemNameBlockItem(BMMBlocks.LETTUCE_CROP.get(), registerItemProperties()));
    public static final RegistrySupplier<Item> CHEESE = MAIN_ITEMS.register("cheese", () -> new Item(registerItemProperties().food(registerFoodValues(2, 0.4f))));
    public static final RegistrySupplier<Item> TORTILLA = MAIN_ITEMS.register("tortilla", () -> new Item(registerItemProperties().food(registerFoodValues(2, 0.4f))));
    public static final RegistrySupplier<Item> BEEF_PATTY = MAIN_ITEMS.register("beef_patty", () -> new Item(registerItemProperties().food(registerFoodValues(4, 0.4f))));
    public static final RegistrySupplier<Item> COOKED_BEEF_PATTY = MAIN_ITEMS.register("cooked_beef_patty", () -> new Item(registerItemProperties().food(registerFoodValues(5, 0.4f))));
    public static final RegistrySupplier<Item> RAW_BACON = MAIN_ITEMS.register("raw_bacon", () -> new Item(registerItemProperties().food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<Item> COOKED_BACON = MAIN_ITEMS.register("cooked_bacon", () -> new Item(registerItemProperties().food(registerFoodValues(4, 0.4f))));
    public static final RegistrySupplier<Item> MAYONNAISE = MAIN_ITEMS.register("mayonnaise", () -> new Item(registerItemProperties().food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> SWEET_SOUR_SAUCE = MAIN_ITEMS.register("sweet_sour_sauce", () -> new Item(registerItemProperties().food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> KETCHUP = MAIN_ITEMS.register("ketchup", () -> new Item(registerItemProperties().food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> MUSTARD = MAIN_ITEMS.register("mustard", () -> new Item(registerItemProperties().food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> HAMBURGER = MAIN_ITEMS.register("hamburger", () -> new Item(registerItemProperties().food(registerFoodValues(6, 0.5f))));
    public static final RegistrySupplier<Item> CHEESEBURGER = MAIN_ITEMS.register("cheeseburger", () -> new Item(registerItemProperties().food(registerFoodValues(8, 0.5f))));
    public static final RegistrySupplier<Item> MCBACON = MAIN_ITEMS.register("mcbacon", () -> new Item(registerItemProperties().food(registerFoodValues(8, 0.5f))));
    public static final RegistrySupplier<Item> BIG_MAC = MAIN_ITEMS.register("big_mac", () -> new Item(registerItemProperties().food(registerFoodValues(10, 0.5f))));
    public static final RegistrySupplier<Item> CHICKENBURGER = MAIN_ITEMS.register("chickenburger", () -> new Item(registerItemProperties().food(registerFoodValues(7, 0.5f))));
    public static final RegistrySupplier<Item> MCCHICKEN = MAIN_ITEMS.register("mcchicken", () -> new Item(registerItemProperties().food(registerFoodValues(8, 0.5f))));
    public static final RegistrySupplier<Item> FILET_O_FISH = MAIN_ITEMS.register("filet_o_fish", () -> new Item(registerItemProperties().food(registerFoodValues(6, 0.5f))));
    public static final RegistrySupplier<Item> MCWRAP = MAIN_ITEMS.register("mcwrap", () -> new Item(registerItemProperties().food(registerFoodValues(5, 0.4f))));
    public static final RegistrySupplier<Item> SNACK_SALAD = MAIN_ITEMS.register("snack_salad", () -> new Item(registerItemProperties().food(registerFoodValues(4, 0.4f))));
    public static final RegistrySupplier<Item> CHICKEN_MCNUGGETS = MAIN_ITEMS.register("chicken_mcnuggets", () -> new Item(registerItemProperties().food(registerFoodValues(4, 0.4f))));
    public static final RegistrySupplier<Item> FRIES = MAIN_ITEMS.register("fries", () -> new Item(registerItemProperties().food(registerFoodValues(5, 0.4f))));
    public static final RegistrySupplier<Item> HAPPY_MEAL = MAIN_ITEMS.register("happy_meal", () -> new Item(registerItemProperties().rarity(Rarity.UNCOMMON).food(registerFoodValues(14, 0.5f))));
    public static final RegistrySupplier<BMMDrinkItem> COCA_COLA = MAIN_ITEMS.register("coca_cola", () -> new BMMDrinkItem(registerItemProperties().food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<BMMDrinkItem> FANTA = MAIN_ITEMS.register("fanta", () -> new BMMDrinkItem(registerItemProperties().food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<BMMDrinkItem> SPRITE = MAIN_ITEMS.register("sprite", () -> new BMMDrinkItem(registerItemProperties().food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<BMMDrinkItem> LIPTON_ICE_TEA_PEACH = MAIN_ITEMS.register("lipton_ice_tea_peach", () -> new BMMDrinkItem(registerItemProperties().food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<Item> MCFLURRY = MAIN_ITEMS.register("mcflurry", () -> new Item(registerItemProperties().food(registerFoodValues(6, 0.4f))));
    public static final RegistrySupplier<BMMKnifeItem> KNIFE = ITEMS.register("knife", () -> new BMMKnifeItem(registerItemProperties()));

    public static Item.Properties registerItemProperties() {
        return new Item.Properties().arch$tab(BMMCreativeTabs.BETTER_MCDONALDS_MOD_MAIN);
    }

    public static FoodProperties registerFoodValues(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build();
    }

    public static void register() {
        MAIN_ITEMS.register();
        ITEMS.register();
    }
}