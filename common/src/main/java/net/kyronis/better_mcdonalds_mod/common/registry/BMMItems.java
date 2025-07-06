package net.kyronis.better_mcdonalds_mod.common.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.item.BMMDrinkItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class BMMItems {
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(BetterMcDonaldsMod.MOD_ID, Registries.ITEM);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BetterMcDonaldsMod.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<BlockItem> SALT_BLOCK = BLOCK_ITEMS.register("salt_block", () -> new BlockItem(BMMBlocks.SALT_BLOCK.get(), registerItemProperties("salt_block").useBlockDescriptionPrefix()));
    public static final RegistrySupplier<Item> SALT = ITEMS.register("salt", () -> new Item(registerItemProperties("salt")));
    public static final RegistrySupplier<Item> TOMATO = ITEMS.register("tomato", () -> new Item(registerItemProperties("tomato").food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> TOMATO_SEEDS = BLOCK_ITEMS.register("tomato_seeds", () -> new BlockItem(BMMBlocks.TOMATO_CROP.get(), registerItemProperties("tomato_seeds").useItemDescriptionPrefix()));
    public static final RegistrySupplier<Item> LETTUCE = ITEMS.register("lettuce", () -> new Item(registerItemProperties("lettuce").food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> LETTUCE_SEEDS = BLOCK_ITEMS.register("lettuce_seeds", () -> new BlockItem(BMMBlocks.LETTUCE_CROP.get(), registerItemProperties("lettuce_seeds").useItemDescriptionPrefix()));
    public static final RegistrySupplier<Item> CHEESE = ITEMS.register("cheese", () -> new Item(registerItemProperties("cheese").food(registerFoodValues(2, 0.4f))));
    public static final RegistrySupplier<Item> TORTILLA = ITEMS.register("tortilla", () -> new Item(registerItemProperties("tortilla").food(registerFoodValues(2, 0.4f))));
    public static final RegistrySupplier<Item> BEEF_PATTY = ITEMS.register("beef_patty", () -> new Item(registerItemProperties("beef_patty").food(registerFoodValues(4, 0.4f))));
    public static final RegistrySupplier<Item> COOKED_BEEF_PATTY = ITEMS.register("cooked_beef_patty", () -> new Item(registerItemProperties("cooked_beef_patty").food(registerFoodValues(5, 0.4f))));
    public static final RegistrySupplier<Item> RAW_BACON = ITEMS.register("raw_bacon", () -> new Item(registerItemProperties("raw_bacon").food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<Item> COOKED_BACON = ITEMS.register("cooked_bacon", () -> new Item(registerItemProperties("cooked_bacon").food(registerFoodValues(4, 0.4f))));
    public static final RegistrySupplier<Item> MAYONNAISE = ITEMS.register("mayonnaise", () -> new Item(registerItemProperties("mayonnaise").food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> SWEET_SOUR_SAUCE = ITEMS.register("sweet_sour_sauce", () -> new Item(registerItemProperties("sweet_sour_sauce").food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> KETCHUP = ITEMS.register("ketchup", () -> new Item(registerItemProperties("ketchup").food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> MUSTARD = ITEMS.register("mustard", () -> new Item(registerItemProperties("mustard").food(registerFoodValues(1, 0.3f))));
    public static final RegistrySupplier<Item> HAMBURGER = ITEMS.register("hamburger", () -> new Item(registerItemProperties("hamburger").food(registerFoodValues(6, 0.5f))));
    public static final RegistrySupplier<Item> CHEESEBURGER = ITEMS.register("cheeseburger", () -> new Item(registerItemProperties("cheeseburger").food(registerFoodValues(8, 0.5f))));
    public static final RegistrySupplier<Item> MCBACON = ITEMS.register("mcbacon", () -> new Item(registerItemProperties("mcbacon").food(registerFoodValues(8, 0.5f))));
    public static final RegistrySupplier<Item> BIG_MAC = ITEMS.register("big_mac", () -> new Item(registerItemProperties("big_mac").food(registerFoodValues(10, 0.5f))));
    public static final RegistrySupplier<Item> CHICKENBURGER = ITEMS.register("chickenburger", () -> new Item(registerItemProperties("chickenburger").food(registerFoodValues(7, 0.5f))));
    public static final RegistrySupplier<Item> MCCHICKEN = ITEMS.register("mcchicken", () -> new Item(registerItemProperties("mcchicken").food(registerFoodValues(8, 0.5f))));
    public static final RegistrySupplier<Item> FILET_O_FISH = ITEMS.register("filet_o_fish", () -> new Item(registerItemProperties("filet_o_fish").food(registerFoodValues(6, 0.5f))));
    public static final RegistrySupplier<Item> MCWRAP = ITEMS.register("mcwrap", () -> new Item(registerItemProperties("mcwrap").food(registerFoodValues(5, 0.4f))));
    public static final RegistrySupplier<Item> SNACK_SALAD = ITEMS.register("snack_salad", () -> new Item(registerItemProperties("snack_salad").food(registerFoodValues(4, 0.4f))));
    public static final RegistrySupplier<Item> CHICKEN_MCNUGGETS = ITEMS.register("chicken_mcnuggets", () -> new Item(registerItemProperties("chicken_mcnuggets").food(registerFoodValues(4, 0.4f))));
    public static final RegistrySupplier<Item> FRIES = ITEMS.register("fries", () -> new Item(registerItemProperties("fries").food(registerFoodValues(5, 0.4f))));
    public static final RegistrySupplier<Item> HAPPY_MEAL = ITEMS.register("happy_meal", () -> new Item(registerItemProperties("happy_meal").rarity(Rarity.UNCOMMON).food(registerFoodValues(14, 0.5f))));
    public static final RegistrySupplier<Item> COCA_COLA = ITEMS.register("coca_cola", () -> new BMMDrinkItem(registerItemProperties("coca_cola").food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<Item> FANTA = ITEMS.register("fanta", () -> new BMMDrinkItem(registerItemProperties("fanta").food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<Item> SPRITE = ITEMS.register("sprite", () -> new BMMDrinkItem(registerItemProperties("sprite").food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<Item> LIPTON_ICE_TEA_PEACH = ITEMS.register("lipton_ice_tea_peach", () -> new BMMDrinkItem(registerItemProperties("lipton_ice_tea_peach").food(registerFoodValues(3, 0.4f))));
    public static final RegistrySupplier<Item> MCFLURRY = ITEMS.register("mcflurry", () -> new Item(registerItemProperties("mcflurry").food(registerFoodValues(6, 0.4f))));
    public static final RegistrySupplier<Item> MCFLURRY_CHOCOLATE = ITEMS.register("mcflurry_chocolate", () -> new Item(registerItemProperties("mcflurry_chocolate").food(registerFoodValues(6, 0.4f))));

    private static Item.Properties registerItemProperties(String id) {
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, id))).arch$tab(BMMCreativeTabs.BETTER_MCDONALDS_MOD_MAIN);
    }

    private static FoodProperties registerFoodValues(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build();
    }

    public static void register() {
        BLOCK_ITEMS.register();
        ITEMS.register();
    }
}