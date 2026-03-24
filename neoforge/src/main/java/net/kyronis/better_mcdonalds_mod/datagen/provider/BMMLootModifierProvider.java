package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.loot.conditions.BMMSmeltingConditionBuilder;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.neoforge.loot.BMMAddItemModifier;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BMMLootModifierProvider extends GlobalLootModifierProvider {
    public BMMLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BetterMcDonaldsMod.MOD_ID);
    }

    @Override
    protected void start() {
        addChestLoot("tomato_pillager_outpost", BMMItems.TOMATO.asItem(), 0.58f, UniformGenerator.between(1, 3), BuiltInLootTables.PILLAGER_OUTPOST.identifier());
        addChestLoot("tomato_shipwreck_supply", BMMItems.TOMATO.asItem(), 0.42f, UniformGenerator.between(1, 4), BuiltInLootTables.SHIPWRECK_SUPPLY.identifier());
        addChestLoot("tomato_villager_savanna_house", BMMItems.TOMATO.asItem(), 0.72f, UniformGenerator.between(1, 7), BuiltInLootTables.VILLAGE_SAVANNA_HOUSE.identifier());
        addChestLoot("lettuce_pillager_outpost", BMMItems.LETTUCE.asItem(), 0.58f, UniformGenerator.between(1, 3), BuiltInLootTables.PILLAGER_OUTPOST.identifier());
        addChestLoot("lettuce_shipwreck_supply", BMMItems.LETTUCE.asItem(), 0.42f, UniformGenerator.between(1, 4), BuiltInLootTables.SHIPWRECK_SUPPLY.identifier());
        addChestLoot("lettuce_villager_savanna_house", BMMItems.LETTUCE.asItem(), 0.72f, UniformGenerator.between(1, 7), BuiltInLootTables.VILLAGE_SAVANNA_HOUSE.identifier());
        addMobLoot("beef_patty_cow", BMMItems.BEEF_PATTY.asItem(), UniformGenerator.between(1, 2), EntityType.COW.getDefaultLootTable().get());
        addMobLoot("raw_bacon_pig", BMMItems.RAW_BACON.asItem(), UniformGenerator.between(1, 2), EntityType.PIG.getDefaultLootTable().get());
    }

    private void addChestLoot(String id, Item item, float probability, NumberProvider count, Identifier lootTable) {
        add(id, new BMMAddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(probability).build(),
                new LootTableIdCondition.Builder(lootTable).build()
        }, item, List.of(Holder.direct(SetItemCountFunction.setCount(count).build()))));
    }

    private void addMobLoot(String id, Item item, NumberProvider count, ResourceKey<LootTable> lootTable) {
        add(id, new BMMAddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.5f).build(),
                new LootTableIdCondition.Builder(lootTable.identifier()).build()
        }, item, List.of(Holder.direct(SetItemCountFunction.setCount(count).build()), Holder.direct(SmeltItemFunction.smelted().when(BMMSmeltingConditionBuilder.shouldSmeltLoot(registries)).build()))));
    }
}