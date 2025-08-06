package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.forge.loot.BMMAddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
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
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.List;

public class BMMGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public BMMGlobalLootModifierProvider(PackOutput output) {
        super(output, BetterMcDonaldsMod.MOD_ID);
    }

    @Override
    protected void start() {
        addChestLoot("tomato_pillager_outpost", BMMItems.TOMATO.get(), 0.58f, UniformGenerator.between(1, 3), BuiltInLootTables.PILLAGER_OUTPOST);
        addChestLoot("tomato_shipwreck_supply", BMMItems.TOMATO.get(), 0.42f, UniformGenerator.between(1, 4), BuiltInLootTables.SHIPWRECK_SUPPLY);
        addChestLoot("tomato_villager_savanna_house", BMMItems.TOMATO.get(), 0.72f, UniformGenerator.between(1, 7), BuiltInLootTables.VILLAGE_SAVANNA_HOUSE);
        addBlockLoot("tomato_seeds_grass", BMMItems.TOMATO_SEEDS.get(), Blocks.TALL_GRASS);
        addBlockLoot("tomato_seeds_fern", BMMItems.TOMATO_SEEDS.get(), Blocks.FERN);
        addChestLoot("lettuce_pillager_outpost", BMMItems.LETTUCE.get(), 0.58f, UniformGenerator.between(1, 3), BuiltInLootTables.PILLAGER_OUTPOST);
        addChestLoot("lettuce_shipwreck_supply", BMMItems.LETTUCE.get(), 0.42f, UniformGenerator.between(1, 4), BuiltInLootTables.SHIPWRECK_SUPPLY);
        addChestLoot("lettuce_villager_savanna_house", BMMItems.LETTUCE.get(), 0.72f, UniformGenerator.between(1, 7), BuiltInLootTables.VILLAGE_SAVANNA_HOUSE);
        addBlockLoot("lettuce_seeds_grass", BMMItems.LETTUCE_SEEDS.get(), Blocks.TALL_GRASS);
        addBlockLoot("lettuce_seeds_fern", BMMItems.LETTUCE_SEEDS.get(), Blocks.FERN);
        addMobLoot("beef_patty_cow", BMMItems.BEEF_PATTY.get(), UniformGenerator.between(1, 2), EntityType.COW.getDefaultLootTable());
        addMobLoot("raw_bacon_pig", BMMItems.RAW_BACON.get(), UniformGenerator.between(1, 2), EntityType.PIG.getDefaultLootTable());
    }

    private void addBlockLoot(String id, Item item, Block block) {
        add(id, new BMMAddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()
        }, item, List.of(SetItemCountFunction.setCount(ConstantValue.exactly(1)).build())));
    }

    private void addChestLoot(String id, Item item, float probability, NumberProvider count, ResourceLocation lootTable) {
        add(id, new BMMAddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(probability).build(),
                new LootTableIdCondition.Builder(lootTable).build()
        }, item, List.of(SetItemCountFunction.setCount(count).build())));
    }

    private void addMobLoot(String id, Item item, NumberProvider count, ResourceLocation lootTable) {
        add(id, new BMMAddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.5f).build(),
                new LootTableIdCondition.Builder(lootTable).build()
        }, item, List.of(SetItemCountFunction.setCount(count).build())));
    }
}