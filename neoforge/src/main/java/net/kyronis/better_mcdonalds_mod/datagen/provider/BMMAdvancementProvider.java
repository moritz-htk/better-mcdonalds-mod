package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.advancements.*;
import net.minecraft.advancements.criterion.ConsumeItemTrigger;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.PlayerTrigger;
import net.minecraft.core.ClientAsset;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BMMAdvancementProvider extends AdvancementProvider {
    public BMMAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of(new BMMAdvancements()));
    }

    private static class BMMAdvancements implements AdvancementSubProvider {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> output) {
            HolderGetter<Item> items = registries.lookupOrThrow(Registries.ITEM);

            AdvancementHolder root = createRootAdvancement(BMMItems.HAPPY_MEAL.asItem(), PlayerTrigger.TriggerInstance.tick(), output);
            AdvancementHolder getSalt = createAdvancement("get_salt", BMMItems.SALT.asItem(), AdvancementType.TASK, "salt", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.SALT.asItem()), root, output);
            AdvancementHolder craftDrink = createAdvancement("craft_drink", BMMItems.COCA_COLA.asItem(), AdvancementType.GOAL, "coca_cola", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.COCA_COLA.asItem()), getSalt, output);
            AdvancementHolder craftBeefPatty = createAdvancement("craft_beef_patty", BMMItems.BEEF_PATTY.asItem(), AdvancementType.TASK, "beef_patty", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.BEEF_PATTY.asItem()), root, output);
            AdvancementHolder craftBurger = createAdvancement("craft_burger", BMMItems.HAMBURGER.asItem(), AdvancementType.GOAL, "hamburger", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.HAMBURGER.asItem()), craftBeefPatty, output);
            AdvancementHolder getSeeds = createAdvancement("get_seeds", BMMItems.LETTUCE_SEEDS.asItem(), AdvancementType.TASK, "lettuce_seeds", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.LETTUCE_SEEDS.asItem()), root, output);
            AdvancementHolder harvestLettuce = createAdvancement("harvest_lettuce", BMMItems.LETTUCE.asItem(), AdvancementType.TASK, "lettuce", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.LETTUCE.asItem()), getSeeds, output);
            AdvancementHolder craftSnackSalad = createAdvancement("craft_snack_salad", BMMItems.SNACK_SALAD.asItem(), AdvancementType.GOAL, "snack_salad", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.SNACK_SALAD.asItem()), harvestLettuce, output);
            AdvancementHolder consumeEverything = createConsumeEverythingAdvancement(BMMItems.BIG_MAC.asItem(), items, root, output);
        }

        private AdvancementHolder createRootAdvancement(Item item, Criterion<PlayerTrigger.TriggerInstance> criterion, Consumer<AdvancementHolder> consumer) {
            return Advancement.Builder.advancement()
                    .display(new DisplayInfo(
                            new ItemStackTemplate(item),
                            Component.literal("Better McDonald's Mod"),
                            Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + ".root.description"),
                            Optional.of(new ClientAsset.ResourceTexture(Identifier.withDefaultNamespace("block/red_concrete_powder"))),
                            AdvancementType.TASK, false, false, false))
                    .addCriterion("tick", criterion)
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + "root")));
        }

        private AdvancementHolder createAdvancement(String id, Item item, AdvancementType type, String criterionName, Criterion<InventoryChangeTrigger.TriggerInstance> criterion, AdvancementHolder parent, Consumer<AdvancementHolder> consumer) {
            return Advancement.Builder.advancement()
                    .display(new DisplayInfo(
                            new ItemStackTemplate(item),
                            Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + id + ".title"),
                            Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + id + ".description"),
                            Optional.of(new ClientAsset.ResourceTexture(Identifier.withDefaultNamespace("block/red_concrete_powder"))),
                            type, true, true, false))
                    .addCriterion(criterionName, criterion)
                    .parent(parent)
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + id)));
        }

        private AdvancementHolder createConsumeEverythingAdvancement(Item item, HolderGetter<Item> items, AdvancementHolder parent, Consumer<AdvancementHolder> consumer) {
            Advancement.Builder builder = Advancement.Builder.advancement()
                    .display(new DisplayInfo(
                            new ItemStackTemplate(item),
                            Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + ".consume_everything.title"),
                            Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + ".consume_everything.description"),
                            Optional.of(new ClientAsset.ResourceTexture(Identifier.withDefaultNamespace("block/red_concrete_powder"))),
                            AdvancementType.CHALLENGE, true, true, false))
                    .parent(parent);

            List<Map.Entry<String, Item>> itemsList = List.of(
                    Map.entry("tomato", BMMItems.TOMATO.asItem()), Map.entry("lettuce", BMMItems.LETTUCE.asItem()),
                    Map.entry("cheese", BMMItems.CHEESE.asItem()), Map.entry("tortilla", BMMItems.TORTILLA.asItem()),
                    Map.entry("beef_patty", BMMItems.BEEF_PATTY.asItem()), Map.entry("cooked_beef_patty", BMMItems.COOKED_BEEF_PATTY.asItem()),
                    Map.entry("raw_bacon", BMMItems.RAW_BACON.asItem()), Map.entry("cooked_bacon", BMMItems.COOKED_BACON.asItem()),
                    Map.entry("mayonnaise", BMMItems.MAYONNAISE.asItem()), Map.entry("sweet_sour_sauce", BMMItems.SWEET_SOUR_SAUCE.asItem()),
                    Map.entry("ketchup", BMMItems.KETCHUP.asItem()), Map.entry("mustard", BMMItems.MUSTARD.asItem()),
                    Map.entry("hamburger", BMMItems.HAMBURGER.asItem()), Map.entry("cheeseburger", BMMItems.CHEESEBURGER.asItem()),
                    Map.entry("mcbacon", BMMItems.MCBACON.asItem()), Map.entry("big_mac", BMMItems.BIG_MAC.asItem()),
                    Map.entry("chickenburger", BMMItems.CHICKENBURGER.asItem()), Map.entry("mcchicken", BMMItems.MCCHICKEN.asItem()),
                    Map.entry("filet_o_fish", BMMItems.FILET_O_FISH.asItem()), Map.entry("mcwrap", BMMItems.MCWRAP.asItem()),
                    Map.entry("snack_salad", BMMItems.SNACK_SALAD.asItem()), Map.entry("chicken_mcnuggets", BMMItems.CHICKEN_MCNUGGETS.asItem()),
                    Map.entry("fries", BMMItems.FRIES.asItem()), Map.entry("happy_meal", BMMItems.HAPPY_MEAL.asItem()),
                    Map.entry("coca_cola", BMMItems.COCA_COLA.asItem()), Map.entry("fanta", BMMItems.FANTA.asItem()),
                    Map.entry("sprite", BMMItems.SPRITE.asItem()), Map.entry("lipton_ice_tea_peach", BMMItems.LIPTON_ICE_TEA_PEACH.asItem()),
                    Map.entry("mcflurry", BMMItems.MCFLURRY.asItem()), Map.entry("mcflurry_chocolate", BMMItems.MCFLURRY_CHOCOLATE.asItem())
            );

            itemsList.forEach(pair -> builder.addCriterion(pair.getKey(), ConsumeItemTrigger.TriggerInstance.usedItem(items, pair.getValue())));

            return builder.save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + "consume_everything")));
        }
    }
}