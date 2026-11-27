package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BMMAdvancementProvider extends FabricAdvancementProvider {
    public static AdvancementHolder ROOT;
    public static AdvancementHolder GET_SALT;
    public static AdvancementHolder CRAFT_DRINK;
    public static AdvancementHolder CRAFT_BEEF_PATTY;
    public static AdvancementHolder CRAFT_BURGER;
    public static AdvancementHolder GET_SEEDS;
    public static AdvancementHolder HARVEST_LETTUCE;
    public static AdvancementHolder CRAFT_SNACK_SALAD;
    public static AdvancementHolder CONSUME_EVERYTHING;

    public BMMAdvancementProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        ROOT = createRootAdvancement(BMMItems.HAPPY_MEAL.asItem(), PlayerTrigger.TriggerInstance.tick(), consumer);
        GET_SALT = createAdvancement("get_salt", BMMItems.SALT.asItem(), AdvancementType.TASK, "salt", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.SALT.asItem()), ROOT, consumer);
        CRAFT_DRINK = createAdvancement("craft_drink", BMMItems.COCA_COLA.asItem(), AdvancementType.GOAL, "coca_cola", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.COCA_COLA.asItem()), GET_SALT, consumer);
        CRAFT_BEEF_PATTY = createAdvancement("craft_beef_patty", BMMItems.BEEF_PATTY.asItem(), AdvancementType.TASK, "beef_patty", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.BEEF_PATTY.asItem()), ROOT, consumer);
        CRAFT_BURGER = createAdvancement("craft_burger", BMMItems.HAMBURGER.asItem(), AdvancementType.GOAL, "hamburger", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.HAMBURGER.asItem()), CRAFT_BEEF_PATTY, consumer);
        GET_SEEDS = createAdvancement("get_seeds", BMMItems.LETTUCE_SEEDS.asItem(), AdvancementType.TASK, "lettuce_seeds", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.LETTUCE_SEEDS.asItem()), ROOT, consumer);
        HARVEST_LETTUCE = createAdvancement("harvest_lettuce", BMMItems.LETTUCE.asItem(), AdvancementType.TASK, "lettuce", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.LETTUCE.asItem()), GET_SEEDS, consumer);
        CRAFT_SNACK_SALAD = createAdvancement("craft_snack_salad", BMMItems.SNACK_SALAD.asItem(), AdvancementType.GOAL, "snack_salad", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.SNACK_SALAD.asItem()), HARVEST_LETTUCE, consumer);
        CONSUME_EVERYTHING = createConsumeEverythingAdvancement(BMMItems.BIG_MAC.asItem(), ROOT, consumer);
    }

    private AdvancementHolder createRootAdvancement(Item item, Criterion<PlayerTrigger.TriggerInstance> criterion, Consumer<AdvancementHolder> consumer) {
        return Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        item.getDefaultInstance(),
                        Component.literal("Better McDonald's Mod"),
                        Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + ".root.description"),
                        Optional.of(ResourceLocation.withDefaultNamespace("textures/block/red_concrete_powder.png")),
                        AdvancementType.TASK, false, false, false))
                .addCriterion("tick", criterion)
                .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + "root")));
    }

    private AdvancementHolder createAdvancement(String id, Item item, AdvancementType type, String criterionName, Criterion<InventoryChangeTrigger.TriggerInstance> criterion, AdvancementHolder parent, Consumer<AdvancementHolder> consumer) {
        return Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        item.getDefaultInstance(),
                        Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + id + ".title"),
                        Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + id + ".description"),
                        Optional.empty(),
                        type, true, true, false))
                .addCriterion(criterionName, criterion)
                .parent(parent)
                .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + id)));
    }

    private AdvancementHolder createConsumeEverythingAdvancement(Item item, AdvancementHolder parent, Consumer<AdvancementHolder> consumer) {
        Advancement.Builder builder = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        item.getDefaultInstance(),
                        Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + ".consume_everything.title"),
                        Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + ".consume_everything.description"),
                        Optional.empty(),
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

        itemsList.forEach(pair -> builder.addCriterion(pair.getKey(), ConsumeItemTrigger.TriggerInstance.usedItem(pair.getValue())));

        return builder.save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + "consume_everything")));
    }
}