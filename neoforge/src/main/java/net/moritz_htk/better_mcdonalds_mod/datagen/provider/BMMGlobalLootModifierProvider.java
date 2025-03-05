package net.moritz_htk.better_mcdonalds_mod.datagen.provider;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.moritz_htk.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.common.registry.BMMItems;
import net.moritz_htk.better_mcdonalds_mod.neoforge.loot.BMMAddItemModifier;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BMMGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public BMMGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BetterMcDonaldsMod.MOD_ID);
    }

    @Override
    protected void start() {
        addChestLoot("tomato_pillager_outpost", BMMItems.TOMATO.get(), 0.58f, UniformGenerator.between(1, 3), BuiltInLootTables.PILLAGER_OUTPOST.location());
        addChestLoot("tomato_shipwreck_supply", BMMItems.TOMATO.get(), 0.42f, UniformGenerator.between(1, 4), BuiltInLootTables.SHIPWRECK_SUPPLY.location());
        addChestLoot("tomato_villager_savanna_house", BMMItems.TOMATO.get(), 0.72f, UniformGenerator.between(1, 7), BuiltInLootTables.VILLAGE_SAVANNA_HOUSE.location());
        addBlockLoot("tomato_seeds_grass", BMMItems.TOMATO_SEEDS.get(), Blocks.SHORT_GRASS);
        addBlockLoot("tomato_seeds_fern", BMMItems.TOMATO_SEEDS.get(), Blocks.FERN);
        addChestLoot("lettuce_pillager_outpost", BMMItems.LETTUCE.get(), 0.58f, UniformGenerator.between(1, 3), BuiltInLootTables.PILLAGER_OUTPOST.location());
        addChestLoot("lettuce_shipwreck_supply", BMMItems.LETTUCE.get(), 0.42f, UniformGenerator.between(1, 4), BuiltInLootTables.SHIPWRECK_SUPPLY.location());
        addChestLoot("lettuce_villager_savanna_house", BMMItems.LETTUCE.get(), 0.72f, UniformGenerator.between(1, 7), BuiltInLootTables.VILLAGE_SAVANNA_HOUSE.location());
        addBlockLoot("lettuce_seeds_grass", BMMItems.LETTUCE_SEEDS.get(), Blocks.SHORT_GRASS);
        addBlockLoot("lettuce_seeds_fern", BMMItems.LETTUCE_SEEDS.get(), Blocks.FERN);
    }

    private void addBlockLoot(String id, Item item, Block block) {
        add(id, new BMMAddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()
        }, item, List.of(Holder.direct(SetItemCountFunction.setCount(ConstantValue.exactly(1)).build()))));
    }

    private void addChestLoot(String id, Item item, float probability, NumberProvider count, ResourceLocation lootTable) {
        add(id, new BMMAddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(probability).build(),
                new LootTableIdCondition.Builder(lootTable).build()
        }, item, List.of(Holder.direct(SetItemCountFunction.setCount(count).build()))));
    }
}