package net.kyronis.better_mcdonalds_mod.common.loot.modifier;

import net.blay09.mods.balm.world.level.storage.loot.BalmLootModifier;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;

public class BMMChestLootModifier implements BalmLootModifier {
    @Override
    public void apply(LootContext context, List<ItemStack> loot, ResourceKey<LootTable> lootTableId) {
        addLoot(context, loot, lootTableId, BuiltInLootTables.PILLAGER_OUTPOST, 0.58f, BMMItems.TOMATO.asItem(), UniformGenerator.between(1, 3));
        addLoot(context, loot, lootTableId, BuiltInLootTables.SHIPWRECK_SUPPLY, 0.42f, BMMItems.TOMATO.asItem(), UniformGenerator.between(1, 4));
        addLoot(context, loot, lootTableId, BuiltInLootTables.VILLAGE_SAVANNA_HOUSE, 0.72f, BMMItems.TOMATO.asItem(), UniformGenerator.between(1, 7));

        addLoot(context, loot, lootTableId, BuiltInLootTables.PILLAGER_OUTPOST, 0.58f, BMMItems.LETTUCE.asItem(), UniformGenerator.between(1, 3));
        addLoot(context, loot, lootTableId, BuiltInLootTables.SHIPWRECK_SUPPLY, 0.42f, BMMItems.LETTUCE.asItem(), UniformGenerator.between(1, 4));
        addLoot(context, loot, lootTableId, BuiltInLootTables.VILLAGE_SAVANNA_HOUSE, 0.72f, BMMItems.LETTUCE.asItem(), UniformGenerator.between(1, 7));
    }

    private static void addLoot(LootContext context, List<ItemStack> loot, ResourceKey<LootTable> currentLootTable, ResourceKey<LootTable> targetLootTable, float chance, Item item, NumberProvider count) {
        if (!currentLootTable.equals(targetLootTable)) {
            return;
        }

        if (context.getRandom().nextFloat() >= chance) {
            return;
        }

        loot.add(new ItemStack(item, count.getInt(context)));
    }
}