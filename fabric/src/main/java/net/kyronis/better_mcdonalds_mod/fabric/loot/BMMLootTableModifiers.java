package net.kyronis.better_mcdonalds_mod.fabric.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.kyronis.better_mcdonalds_mod.common.loot.conditions.BMMSmeltingConditionBuilder;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class BMMLootTableModifiers {
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            addLoot(key, BuiltInLootTables.PILLAGER_OUTPOST, tableBuilder, 0.58f, BMMItems.TOMATO.get(), UniformGenerator.between(1, 3));
            addLoot(key, BuiltInLootTables.SHIPWRECK_SUPPLY, tableBuilder, 0.42f, BMMItems.TOMATO.get(), UniformGenerator.between(1, 4));
            addLoot(key, BuiltInLootTables.VILLAGE_SAVANNA_HOUSE, tableBuilder, 0.72f, BMMItems.TOMATO.get(), UniformGenerator.between(1, 7));
            addLoot(key, Blocks.SHORT_GRASS.getLootTable(), tableBuilder, 0.15f, BMMItems.TOMATO_SEEDS.get(), ConstantValue.exactly(1));
            addLoot(key, Blocks.FERN.getLootTable(), tableBuilder, 0.15f, BMMItems.TOMATO_SEEDS.get(), ConstantValue.exactly(1));
            addLoot(key, BuiltInLootTables.PILLAGER_OUTPOST, tableBuilder, 0.58f, BMMItems.LETTUCE.get(), UniformGenerator.between(1, 3));
            addLoot(key, BuiltInLootTables.SHIPWRECK_SUPPLY, tableBuilder, 0.42f, BMMItems.LETTUCE.get(), UniformGenerator.between(1, 4));
            addLoot(key, BuiltInLootTables.VILLAGE_SAVANNA_HOUSE, tableBuilder, 0.72f, BMMItems.LETTUCE.get(), UniformGenerator.between(1, 7));
            addLoot(key, Blocks.SHORT_GRASS.getLootTable(), tableBuilder, 0.15f, BMMItems.LETTUCE_SEEDS.get(), ConstantValue.exactly(1));
            addLoot(key, Blocks.FERN.getLootTable(), tableBuilder, 0.15f, BMMItems.LETTUCE_SEEDS.get(), ConstantValue.exactly(1));
            addMobLoot(key, EntityType.COW.getDefaultLootTable(), tableBuilder, BMMItems.BEEF_PATTY.get(), registries);
            addMobLoot(key, EntityType.PIG.getDefaultLootTable(), tableBuilder, BMMItems.RAW_BACON.get(), registries);
        });
    }

    private static void addLoot(ResourceKey<LootTable> lootTable, ResourceKey<LootTable> id, LootTable.Builder tableBuilder, float chance, Item item, NumberProvider count) {
        if (!lootTable.equals(id)) return;
        tableBuilder.pool(LootPool.lootPool()
                .when(LootItemRandomChanceCondition.randomChance(chance))
                .add(LootItem.lootTableItem(item))
                .apply(SetItemCountFunction.setCount(count))
                .build());
    }

    private static void addMobLoot(ResourceKey<LootTable> lootTable, ResourceKey<LootTable> id, LootTable.Builder tableBuilder, Item item, HolderLookup.Provider registries) {
        if (!lootTable.equals(id)) return;
        tableBuilder.pool(LootPool.lootPool()
                .when(LootItemRandomChanceCondition.randomChance(0.5f))
                .add(LootItem.lootTableItem(item))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                .apply(SmeltItemFunction.smelted().when(BMMSmeltingConditionBuilder.shouldSmeltLoot(registries)))
                .build());
    }
}