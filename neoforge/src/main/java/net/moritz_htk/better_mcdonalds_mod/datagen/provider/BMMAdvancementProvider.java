package net.moritz_htk.better_mcdonalds_mod.datagen.provider;

import com.ibm.icu.impl.Pair;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.moritz_htk.better_mcdonalds_mod.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMItems;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BMMAdvancementProvider extends AdvancementProvider {
    public BMMAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new BMMAdvancements(registries)));
    }

    private static class BMMAdvancements implements AdvancementProvider.AdvancementGenerator {
        private HolderGetter<Item> items;

        public BMMAdvancements(CompletableFuture<HolderLookup.Provider> registries) {
            registries.thenAccept(provider -> this.items = provider.lookupOrThrow(Registries.ITEM));
        }

        @Override
        public void generate(HolderLookup.@NotNull Provider provider, @NotNull Consumer<AdvancementHolder> consumer, @NotNull ExistingFileHelper existingFileHelper) {
            AdvancementHolder ROOT = createRootAdvancement(BMMItems.HAPPY_MEAL.get(), PlayerTrigger.TriggerInstance.tick(), consumer);
            AdvancementHolder GET_SALT = createAdvancement("get_salt", BMMItems.SALT.get(), AdvancementType.TASK, "salt", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.SALT.get()), ROOT, consumer);
            AdvancementHolder CRAFT_DRINK = createAdvancement("craft_drink", BMMItems.COCA_COLA.get(), AdvancementType.GOAL, "coca_cola", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.COCA_COLA.get()), GET_SALT, consumer);
            AdvancementHolder CRAFT_BEEF_PATTY = createAdvancement("craft_beef_patty", BMMItems.BEEF_PATTY.get(), AdvancementType.TASK, "beef_patty", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.BEEF_PATTY.get()), ROOT, consumer);
            AdvancementHolder CRAFT_BURGER = createAdvancement("craft_burger", BMMItems.HAMBURGER.get(), AdvancementType.GOAL, "hamburger", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.HAMBURGER.get()), CRAFT_BEEF_PATTY, consumer);
            AdvancementHolder GET_SEEDS = createAdvancement("get_seeds", BMMItems.LETTUCE_SEEDS.get(), AdvancementType.TASK, "lettuce_seeds", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.LETTUCE_SEEDS.get()), ROOT, consumer);
            AdvancementHolder HARVEST_LETTUCE = createAdvancement("harvest_lettuce", BMMItems.LETTUCE.get(), AdvancementType.TASK, "lettuce", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.LETTUCE.get()), GET_SEEDS, consumer);
            AdvancementHolder CRAFT_SNACK_SALAD = createAdvancement("craft_snack_salad", BMMItems.SNACK_SALAD.get(), AdvancementType.GOAL, "snack_salad", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.SNACK_SALAD.get()), HARVEST_LETTUCE, consumer);
            AdvancementHolder CONSUME_EVERYTHING = createConsumeEverythingAdvancement(BMMItems.BIG_MAC.get(), ROOT, consumer);
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
                            Optional.of(ResourceLocation.withDefaultNamespace("textures/block/red_concrete_powder.png")),
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
                            Optional.of(ResourceLocation.withDefaultNamespace("textures/block/red_concrete_powder.png")),
                            AdvancementType.CHALLENGE, true, true, false))
                    .parent(parent);

            List<Pair<String, Item>> items = List.of(
                    Pair.of("tomato", BMMItems.TOMATO.get()), Pair.of("lettuce", BMMItems.LETTUCE.get()),
                    Pair.of("cheese", BMMItems.CHEESE.get()), Pair.of("tortilla", BMMItems.TORTILLA.get()),
                    Pair.of("beef_patty", BMMItems.BEEF_PATTY.get()), Pair.of("cooked_beef_patty", BMMItems.COOKED_BEEF_PATTY.get()),
                    Pair.of("raw_bacon", BMMItems.RAW_BACON.get()), Pair.of("cooked_bacon", BMMItems.COOKED_BACON.get()),
                    Pair.of("mayonnaise", BMMItems.MAYONNAISE.get()), Pair.of("sweet_sour_sauce", BMMItems.SWEET_SOUR_SAUCE.get()),
                    Pair.of("ketchup", BMMItems.KETCHUP.get()), Pair.of("mustard", BMMItems.MUSTARD.get()),
                    Pair.of("hamburger", BMMItems.HAMBURGER.get()), Pair.of("cheeseburger", BMMItems.CHEESEBURGER.get()),
                    Pair.of("mcbacon", BMMItems.MCBACON.get()), Pair.of("big_mac", BMMItems.BIG_MAC.get()),
                    Pair.of("chickenburger", BMMItems.CHICKENBURGER.get()), Pair.of("mcchicken", BMMItems.MCCHICKEN.get()),
                    Pair.of("filet_o_fish", BMMItems.FILET_O_FISH.get()), Pair.of("mcwrap", BMMItems.MCWRAP.get()),
                    Pair.of("snack_salad", BMMItems.SNACK_SALAD.get()), Pair.of("chicken_mcnuggets", BMMItems.CHICKEN_MCNUGGETS.get()),
                    Pair.of("fries", BMMItems.FRIES.get()), Pair.of("happy_meal", BMMItems.HAPPY_MEAL.get()),
                    Pair.of("coca_cola", BMMItems.COCA_COLA.get()), Pair.of("fanta", BMMItems.FANTA.get()),
                    Pair.of("sprite", BMMItems.SPRITE.get()), Pair.of("lipton_ice_tea_peach", BMMItems.LIPTON_ICE_TEA_PEACH.get()),
                    Pair.of("mcflurry", BMMItems.MCFLURRY.get()), Pair.of("mcflurry_chocolate", BMMItems.MCFLURRY_CHOCOLATE.get())
            );

            items.forEach(pair -> builder.addCriterion(pair.first, ConsumeItemTrigger.TriggerInstance.usedItem(this.items, pair.second)));

            return builder.save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + "consume_everything")));
        }
    }
}