package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.common.tags.BMMTags;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class BMMLanguageProvider extends FabricLanguageProvider {
    public BMMLanguageProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        // Blocks
        translationBuilder.add(BMMBlocks.SALT_BLOCK.asBlock(), "Salt Block");
        translationBuilder.add(BMMBlocks.TOMATO_CROP.asBlock(), "Tomato Crop");
        translationBuilder.add(BMMBlocks.LETTUCE_CROP.asBlock(), "Lettuce Crop");

        // Items
        translationBuilder.add(BMMItems.TOMATO.asItem(), "Tomato");
        translationBuilder.add(BMMItems.TOMATO_SEEDS.asItem(), "Tomato Seeds");
        translationBuilder.add(BMMItems.LETTUCE.asItem(), "Lettuce");
        translationBuilder.add(BMMItems.LETTUCE_SEEDS.asItem(), "Lettuce Seeds");
        translationBuilder.add(BMMItems.SALT.asItem(), "Salt");
        translationBuilder.add(BMMItems.CHEESE.asItem(), "Cheese");
        translationBuilder.add(BMMItems.TORTILLA.asItem(), "Tortilla");
        translationBuilder.add(BMMItems.BEEF_PATTY.asItem(), "Beef Patty");
        translationBuilder.add(BMMItems.COOKED_BEEF_PATTY.asItem(), "Cooked Beef Patty");
        translationBuilder.add(BMMItems.RAW_BACON.asItem(), "Raw Bacon");
        translationBuilder.add(BMMItems.COOKED_BACON.asItem(), "Cooked Bacon");
        translationBuilder.add(BMMItems.MAYONNAISE.asItem(), "Mayonnaise");
        translationBuilder.add(BMMItems.SWEET_SOUR_SAUCE.asItem(), "Sweet ‘N Sour Sauce");
        translationBuilder.add(BMMItems.KETCHUP.asItem(), "Ketchup");
        translationBuilder.add(BMMItems.MUSTARD.asItem(), "Mustard");
        translationBuilder.add(BMMItems.HAMBURGER.asItem(), "Hamburger");
        translationBuilder.add(BMMItems.CHEESEBURGER.asItem(), "Cheeseburger");
        translationBuilder.add(BMMItems.MCBACON.asItem(), "McBacon");
        translationBuilder.add(BMMItems.BIG_MAC.asItem(), "Big Mac");
        translationBuilder.add(BMMItems.CHICKENBURGER.asItem(), "Chickenburger");
        translationBuilder.add(BMMItems.MCCHICKEN.asItem(), "McChicken");
        translationBuilder.add(BMMItems.FILET_O_FISH.asItem(), "Filet-O-Fish");
        translationBuilder.add(BMMItems.MCWRAP.asItem(), "McWrap");
        translationBuilder.add(BMMItems.SNACK_SALAD.asItem(), "Snack Salad");
        translationBuilder.add(BMMItems.CHICKEN_MCNUGGETS.asItem(), "Chicken McNuggets");
        translationBuilder.add(BMMItems.FRIES.asItem(), "Fries");
        translationBuilder.add(BMMItems.HAPPY_MEAL.asItem(), "Happy Meal");
        translationBuilder.add(BMMItems.COCA_COLA.asItem(), "Coca-Cola");
        translationBuilder.add(BMMItems.FANTA.asItem(), "Fanta");
        translationBuilder.add(BMMItems.SPRITE.asItem(), "Sprite");
        translationBuilder.add(BMMItems.LIPTON_ICE_TEA_PEACH.asItem(), "Lipton Ice Tea Peach");
        translationBuilder.add(BMMItems.MCFLURRY.asItem(), "McFlurry");
        translationBuilder.add(BMMItems.MCFLURRY_CHOCOLATE.asItem(), "McFlurry Chocolate");

        // Advancements
        translationBuilder.add("advancement.better_mcdonalds_mod.root.description", "The beginning!");
        translationBuilder.add("advancement.better_mcdonalds_mod.get_salt.title", "Very salty!");
        translationBuilder.add("advancement.better_mcdonalds_mod.get_salt.description", "Obtain salt from rivers");
        translationBuilder.add("advancement.better_mcdonalds_mod.craft_drink.title", "Your first drink");
        translationBuilder.add("advancement.better_mcdonalds_mod.craft_drink.description", "Craft a Coca-Cola");
        translationBuilder.add("advancement.better_mcdonalds_mod.craft_beef_patty.title", "Cut it into half!");
        translationBuilder.add("advancement.better_mcdonalds_mod.craft_beef_patty.description", "Craft a beef patty");
        translationBuilder.add("advancement.better_mcdonalds_mod.craft_burger.title", "Your first burger");
        translationBuilder.add("advancement.better_mcdonalds_mod.craft_burger.description", "Craft a hamburger");
        translationBuilder.add("advancement.better_mcdonalds_mod.get_seeds.title", "Where are my seeds?");
        translationBuilder.add("advancement.better_mcdonalds_mod.get_seeds.description", "Obtain lettuce seeds from grass");
        translationBuilder.add("advancement.better_mcdonalds_mod.harvest_lettuce.title", "From seed to plant!");
        translationBuilder.add("advancement.better_mcdonalds_mod.harvest_lettuce.description", "Harvest lettuce from your lettuce plant");
        translationBuilder.add("advancement.better_mcdonalds_mod.craft_snack_salad.title", "Eat something (almost) healthy!");
        translationBuilder.add("advancement.better_mcdonalds_mod.craft_snack_salad.description", "Craft a snack salad");
        translationBuilder.add("advancement.better_mcdonalds_mod.consume_everything.title", "Everything is mine!");
        translationBuilder.add("advancement.better_mcdonalds_mod.consume_everything.description", "Consume every edible item");

        // Tags
        translationBuilder.add(BMMTags.Items.BURGER, "Burgers");
        translationBuilder.add(BMMTags.Items.SIDE_DISHES, "Side Dishes");
        translationBuilder.add(BMMTags.Items.DRINKS, "Drinks");
    }
}
