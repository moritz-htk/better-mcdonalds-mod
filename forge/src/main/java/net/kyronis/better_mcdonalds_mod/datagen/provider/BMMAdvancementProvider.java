package net.kyronis.better_mcdonalds_mod.datagen.provider;

import com.ibm.icu.impl.Pair;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BMMAdvancementProvider extends ForgeAdvancementProvider {
    public BMMAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new Advancements()));
    }

    private static class Advancements implements ForgeAdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.@NotNull Provider arg, @NotNull Consumer<Advancement> consumer, @NotNull ExistingFileHelper existingFileHelper) {
            Advancement ROOT = createRootAdvancement(BMMItems.HAPPY_MEAL.get(), consumer, existingFileHelper);
            Advancement GET_SALT = createAdvancement("get_salt", BMMItems.SALT.get(), FrameType.TASK, "salt", ROOT, consumer, existingFileHelper);
            Advancement CRAFT_DRINK = createAdvancement("craft_drink", BMMItems.COCA_COLA.get(), FrameType.GOAL, "coca_cola", GET_SALT, consumer, existingFileHelper);
            Advancement CRAFT_BEEF_PATTY = createAdvancement("craft_beef_patty", BMMItems.BEEF_PATTY.get(), FrameType.TASK, "beef_patty", ROOT, consumer, existingFileHelper);
            Advancement CRAFT_BURGER = createAdvancement("craft_burger", BMMItems.HAMBURGER.get(), FrameType.GOAL, "hamburger", CRAFT_BEEF_PATTY, consumer, existingFileHelper);
            Advancement GET_SEEDS = createAdvancement("get_seeds", BMMItems.LETTUCE_SEEDS.get(), FrameType.TASK, "lettuce_seeds", ROOT, consumer, existingFileHelper);
            Advancement HARVEST_LETTUCE = createAdvancement("harvest_lettuce", BMMItems.LETTUCE.get(), FrameType.TASK, "lettuce", GET_SEEDS, consumer, existingFileHelper);
            Advancement CRAFT_SNACK_SALAD = createAdvancement("craft_snack_salad", BMMItems.SNACK_SALAD.get(), FrameType.GOAL, "snack_salad", HARVEST_LETTUCE, consumer, existingFileHelper);
            Advancement CONSUME_EVERYTHING = createConsumeEverythingAdvancement(BMMItems.BIG_MAC.get(), ROOT, consumer, existingFileHelper);
        }

        private Advancement createRootAdvancement(Item item, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
            return Advancement.Builder.advancement()
                    .display(new DisplayInfo(
                            item.getDefaultInstance(),
                            Component.literal("Better McDonald's Mod"),
                            Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + ".root.description"),
                            ResourceLocation.withDefaultNamespace("textures/block/red_concrete_powder.png"),
                            FrameType.TASK, false, false, false))
                    .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + "root"), existingFileHelper);
        }

        private Advancement createAdvancement(String id, Item item, FrameType type, String criterionName, Advancement parent, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
            return Advancement.Builder.advancement()
                    .display(new DisplayInfo(
                            item.getDefaultInstance(),
                            Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + id + ".title"),
                            Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + id + ".description"),
                            ResourceLocation.withDefaultNamespace("textures/block/red_concrete_powder.png"),
                            type, true, true, false))
                    .addCriterion(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(item))
                    .parent(parent)
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + id), existingFileHelper);
        }

        private Advancement createConsumeEverythingAdvancement(Item item, Advancement parent, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
            Advancement.Builder builder = Advancement.Builder.advancement()
                    .display(new DisplayInfo(
                            item.getDefaultInstance(),
                            Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + ".consume_everything.title"),
                            Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + ".consume_everything.description"),
                            ResourceLocation.withDefaultNamespace("textures/block/red_concrete_powder.png"),
                            FrameType.CHALLENGE, true, true, false))
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

            items.forEach(pair -> builder.addCriterion(pair.first, ConsumeItemTrigger.TriggerInstance.usedItem(pair.second)));

            return builder.save(consumer, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + "consume_everything"), existingFileHelper);
        }
    }
}