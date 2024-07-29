package net.moritz_htk.better_mcdonalds_mod.fabric.loot;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMItems;

public class BMMLootTableModifiers {
    private static final ResourceKey<LootTable> GRASS_BLOCK_KEY = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("blocks/short_grass"));
    private static final ResourceKey<LootTable> FERN_BLOCK_KEY = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("blocks/fern"));

    @SuppressWarnings("deprecation")
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            addLoot(key, BuiltInLootTables.PILLAGER_OUTPOST, tableBuilder, 0.58f, BMMItems.TOMATO.get(), UniformGenerator.between(1, 3));
            addLoot(key, BuiltInLootTables.SHIPWRECK_SUPPLY, tableBuilder, 0.42f, BMMItems.TOMATO.get(), UniformGenerator.between(1, 4));
            addLoot(key, BuiltInLootTables.VILLAGE_SAVANNA_HOUSE, tableBuilder, 0.72f, BMMItems.TOMATO.get(), UniformGenerator.between(1, 7));
            addLoot(key, GRASS_BLOCK_KEY, tableBuilder, 0.15f, BMMItems.TOMATO_SEEDS.get(), ConstantValue.exactly(1));
            addLoot(key, FERN_BLOCK_KEY, tableBuilder, 0.15f, BMMItems.TOMATO_SEEDS.get(), ConstantValue.exactly(1));
            addLoot(key, BuiltInLootTables.PILLAGER_OUTPOST, tableBuilder, 0.58f, BMMItems.LETTUCE.get(), UniformGenerator.between(1, 3));
            addLoot(key, BuiltInLootTables.SHIPWRECK_SUPPLY, tableBuilder, 0.42f, BMMItems.LETTUCE.get(), UniformGenerator.between(1, 4));
            addLoot(key, BuiltInLootTables.VILLAGE_SAVANNA_HOUSE, tableBuilder, 0.72f, BMMItems.LETTUCE.get(), UniformGenerator.between(1, 7));
            addLoot(key, GRASS_BLOCK_KEY, tableBuilder, 0.15f, BMMItems.LETTUCE_SEEDS.get(), ConstantValue.exactly(1));
            addLoot(key, FERN_BLOCK_KEY, tableBuilder, 0.15f, BMMItems.LETTUCE_SEEDS.get(), ConstantValue.exactly(1));
        });
    }

    private static void addLoot(ResourceKey<LootTable> lootTable, ResourceKey<LootTable> id, LootTable.Builder tableBuilder, float chance, Item item, NumberProvider count) {
        if (!lootTable.equals(id)) return;
        tableBuilder.pool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(chance)).add(LootItem.lootTableItem(item)).apply(SetItemCountFunction.setCount(count)).build());
    }
}