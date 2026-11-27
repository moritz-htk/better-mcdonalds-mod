package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.common.tags.BMMTags;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class BMMLanguageProvider extends FabricLanguageProvider {
    public BMMLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
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
        translationBuilder.add(getAdvancementDescription(BMMAdvancementProvider.ROOT), "The beginning!");
        translationBuilder.add(getAdvancementTitle(BMMAdvancementProvider.GET_SALT), "Very salty!");
        translationBuilder.add(getAdvancementDescription(BMMAdvancementProvider.GET_SALT), "Obtain salt from rivers");
        translationBuilder.add(getAdvancementTitle(BMMAdvancementProvider.CRAFT_DRINK), "Your first drink");
        translationBuilder.add(getAdvancementDescription(BMMAdvancementProvider.CRAFT_DRINK), "Craft a Coca-Cola");
        translationBuilder.add(getAdvancementTitle(BMMAdvancementProvider.CRAFT_BEEF_PATTY), "Cut it into half!");
        translationBuilder.add(getAdvancementDescription(BMMAdvancementProvider.CRAFT_BEEF_PATTY), "Craft a beef patty");
        translationBuilder.add(getAdvancementTitle(BMMAdvancementProvider.CRAFT_BURGER), "Your first burger");
        translationBuilder.add(getAdvancementDescription(BMMAdvancementProvider.CRAFT_BURGER), "Craft a hamburger");
        translationBuilder.add(getAdvancementTitle(BMMAdvancementProvider.GET_SEEDS), "Where are my seeds?");
        translationBuilder.add(getAdvancementDescription(BMMAdvancementProvider.GET_SEEDS), "Obtain lettuce seeds from grass");
        translationBuilder.add(getAdvancementTitle(BMMAdvancementProvider.HARVEST_LETTUCE), "From seed to plant!");
        translationBuilder.add(getAdvancementDescription(BMMAdvancementProvider.HARVEST_LETTUCE), "Harvest lettuce from your lettuce plant");
        translationBuilder.add(getAdvancementTitle(BMMAdvancementProvider.CRAFT_SNACK_SALAD), "Eat something (almost) healthy!");
        translationBuilder.add(getAdvancementDescription(BMMAdvancementProvider.CRAFT_SNACK_SALAD), "Craft a snack salad");
        translationBuilder.add(getAdvancementTitle(BMMAdvancementProvider.CONSUME_EVERYTHING), "Everything is mine!");
        translationBuilder.add(getAdvancementDescription(BMMAdvancementProvider.CONSUME_EVERYTHING), "Consume every edible item");

        // Tags
        translationBuilder.add(BMMTags.Items.BURGER, "Burgers");
        translationBuilder.add(BMMTags.Items.SIDE_DISHES, "Side Dishes");
        translationBuilder.add(BMMTags.Items.DRINKS, "Drinks");
    }
    
    private String getAdvancementTitle(AdvancementHolder advancement) {
        return advancement.value().display().orElseThrow().getTitle().getString();
    }

    private String getAdvancementDescription(AdvancementHolder advancement) {
        return advancement.value().display().orElseThrow().getDescription().getString();
    }
}