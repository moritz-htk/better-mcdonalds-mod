package net.kyronis.better_mcdonalds_mod.fabric.loot;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class BMMLootTableModifiers {
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            addLoot(id, BuiltInLootTables.PILLAGER_OUTPOST, tableBuilder, 0.58f, BMMItems.TOMATO.get(), UniformGenerator.between(1, 3));
            addLoot(id, BuiltInLootTables.SHIPWRECK_SUPPLY, tableBuilder, 0.42f, BMMItems.TOMATO.get(), UniformGenerator.between(1, 4));
            addLoot(id, BuiltInLootTables.VILLAGE_SAVANNA_HOUSE, tableBuilder, 0.72f, BMMItems.TOMATO.get(), UniformGenerator.between(1, 7));
            addLoot(id, Blocks.TALL_GRASS.getLootTable(), tableBuilder, 0.15f, BMMItems.TOMATO_SEEDS.get(), ConstantValue.exactly(1));
            addLoot(id, Blocks.FERN.getLootTable(), tableBuilder, 0.15f, BMMItems.TOMATO_SEEDS.get(), ConstantValue.exactly(1));
            addLoot(id, BuiltInLootTables.PILLAGER_OUTPOST, tableBuilder, 0.58f, BMMItems.LETTUCE.get(), UniformGenerator.between(1, 3));
            addLoot(id, BuiltInLootTables.SHIPWRECK_SUPPLY, tableBuilder, 0.42f, BMMItems.LETTUCE.get(), UniformGenerator.between(1, 4));
            addLoot(id, BuiltInLootTables.VILLAGE_SAVANNA_HOUSE, tableBuilder, 0.72f, BMMItems.LETTUCE.get(), UniformGenerator.between(1, 7));
            addLoot(id, Blocks.TALL_GRASS.getLootTable(), tableBuilder, 0.15f, BMMItems.LETTUCE_SEEDS.get(), ConstantValue.exactly(1));
            addLoot(id, Blocks.FERN.getLootTable(), tableBuilder, 0.15f, BMMItems.LETTUCE_SEEDS.get(), ConstantValue.exactly(1));
            addMobLoot(id, EntityType.COW.getDefaultLootTable(), tableBuilder, BMMItems.BEEF_PATTY.get());
            addMobLoot(id, EntityType.PIG.getDefaultLootTable(), tableBuilder, BMMItems.RAW_BACON.get());
        });
    }

    private static void addLoot(ResourceLocation lootTable, ResourceLocation id, LootTable.Builder tableBuilder, float chance, Item item, NumberProvider count) {
        if (!lootTable.equals(id)) return;
        tableBuilder.pool(LootPool.lootPool()
                .when(LootItemRandomChanceCondition.randomChance(chance))
                .add(LootItem.lootTableItem(item))
                .apply(SetItemCountFunction.setCount(count))
                .build());
    }

    private static void addMobLoot(ResourceLocation lootTable, ResourceLocation id, LootTable.Builder tableBuilder, Item item) {
        if (!lootTable.equals(id)) return;
        tableBuilder.pool(LootPool.lootPool()
                .when(LootItemRandomChanceCondition.randomChance(0.5f))
                .add(LootItem.lootTableItem(item))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                .build());
    }
}