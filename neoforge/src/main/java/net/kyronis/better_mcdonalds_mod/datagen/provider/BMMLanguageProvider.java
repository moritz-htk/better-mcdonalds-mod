package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMTags;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class BMMLanguageProvider extends LanguageProvider {
    public BMMLanguageProvider(PackOutput output) {
        super(output, BetterMcDonaldsMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Blocks
        add(BMMBlocks.SALT_BLOCK.asBlock(), "Salt Block");
        add(BMMBlocks.TOMATO_CROP.asBlock(), "Tomato Crop");
        add(BMMBlocks.LETTUCE_CROP.asBlock(), "Lettuce Crop");

        // Items
        add(BMMItems.TOMATO.asItem(), "Tomato");
        add(BMMItems.TOMATO_SEEDS.asItem(), "Tomato Seeds");
        add(BMMItems.LETTUCE.asItem(), "Lettuce");
        add(BMMItems.LETTUCE_SEEDS.asItem(), "Lettuce Seeds");
        add(BMMItems.SALT.asItem(), "Salt");
        add(BMMItems.CHEESE.asItem(), "Cheese");
        add(BMMItems.TORTILLA.asItem(), "Tortilla");
        add(BMMItems.BEEF_PATTY.asItem(), "Beef Patty");
        add(BMMItems.COOKED_BEEF_PATTY.asItem(), "Cooked Beef Patty");
        add(BMMItems.RAW_BACON.asItem(), "Raw Bacon");
        add(BMMItems.COOKED_BACON.asItem(), "Cooked Bacon");
        add(BMMItems.MAYONNAISE.asItem(), "Mayonnaise");
        add(BMMItems.SWEET_SOUR_SAUCE.asItem(), "Sweet ‘N Sour Sauce");
        add(BMMItems.KETCHUP.asItem(), "Ketchup");
        add(BMMItems.MUSTARD.asItem(), "Mustard");
        add(BMMItems.HAMBURGER.asItem(), "Hamburger");
        add(BMMItems.CHEESEBURGER.asItem(), "Cheeseburger");
        add(BMMItems.MCBACON.asItem(), "McBacon");
        add(BMMItems.BIG_MAC.asItem(), "Big Mac");
        add(BMMItems.CHICKENBURGER.asItem(), "Chickenburger");
        add(BMMItems.MCCHICKEN.asItem(), "McChicken");
        add(BMMItems.FILET_O_FISH.asItem(), "Filet-O-Fish");
        add(BMMItems.MCWRAP.asItem(), "McWrap");
        add(BMMItems.SNACK_SALAD.asItem(), "Snack Salad");
        add(BMMItems.CHICKEN_MCNUGGETS.asItem(), "Chicken McNuggets");
        add(BMMItems.FRIES.asItem(), "Fries");
        add(BMMItems.HAPPY_MEAL.asItem(), "Happy Meal");
        add(BMMItems.COCA_COLA.asItem(), "Coca-Cola");
        add(BMMItems.FANTA.asItem(), "Fanta");
        add(BMMItems.SPRITE.asItem(), "Sprite");
        add(BMMItems.LIPTON_ICE_TEA_PEACH.asItem(), "Lipton Ice Tea Peach");
        add(BMMItems.MCFLURRY.asItem(), "McFlurry");
        add(BMMItems.MCFLURRY_CHOCOLATE.asItem(), "McFlurry Chocolate");

        // Advancements
        add("advancement.better_mcdonalds_mod.root.description", "The beginning!");
        add("advancement.better_mcdonalds_mod.get_salt.title", "Very salty!");
        add("advancement.better_mcdonalds_mod.get_salt.description", "Obtain salt from rivers");
        add("advancement.better_mcdonalds_mod.craft_drink.title", "Your first drink");
        add("advancement.better_mcdonalds_mod.craft_drink.description", "Craft a Coca-Cola");
        add("advancement.better_mcdonalds_mod.craft_beef_patty.title", "Cut it into half!");
        add("advancement.better_mcdonalds_mod.craft_beef_patty.description", "Craft a beef patty");
        add("advancement.better_mcdonalds_mod.craft_burger.title", "Your first burger");
        add("advancement.better_mcdonalds_mod.craft_burger.description", "Craft a hamburger");
        add("advancement.better_mcdonalds_mod.get_seeds.title", "Where are my seeds?");
        add("advancement.better_mcdonalds_mod.get_seeds.description", "Obtain lettuce seeds from grass");
        add("advancement.better_mcdonalds_mod.harvest_lettuce.title", "From seed to plant!");
        add("advancement.better_mcdonalds_mod.harvest_lettuce.description", "Harvest lettuce from your lettuce plant");
        add("advancement.better_mcdonalds_mod.craft_snack_salad.title", "Eat something (almost) healthy!");
        add("advancement.better_mcdonalds_mod.craft_snack_salad.description", "Craft a snack salad");
        add("advancement.better_mcdonalds_mod.consume_everything.title", "Everything is mine!");
        add("advancement.better_mcdonalds_mod.consume_everything.description", "Consume every edible item");

        // Tags
        add(BMMTags.Items.BURGER, "Burgers");
        add(BMMTags.Items.SIDE_DISHES, "Side Dishes");
        add(BMMTags.Items.DRINKS, "Drinks");
    }
}
