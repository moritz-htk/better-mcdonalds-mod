package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.block.BMMLettuceCropBlock;
import net.kyronis.better_mcdonalds_mod.common.block.BMMTomatoCropBlock;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class BMMLootTableProvider {
    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        return new LootTableProvider(output, Set.of(), List.of(new LootTableProvider.SubProviderEntry(BMMBlockLootTables::new, LootContextParamSets.BLOCK)), completableFuture);
    }

    public static class BMMBlockLootTables extends BlockLootSubProvider {
        protected BMMBlockLootTables(HolderLookup.Provider lookupProvider) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
        }

        @Override
        protected void generate() {
            add(BMMBlocks.SALT_BLOCK.get(), (block) -> createOreDrop(BMMBlocks.SALT_BLOCK.get(), BMMItems.SALT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))));

            LootItemCondition.Builder tomatoConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BMMBlocks.TOMATO_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BMMTomatoCropBlock.AGE, 3));
            add(BMMBlocks.TOMATO_CROP.get(), createCropDrops(BMMBlocks.TOMATO_CROP.get(), BMMItems.TOMATO.get(), BMMItems.TOMATO_SEEDS.get(), tomatoConditionBuilder));

            LootItemCondition.Builder lettuceConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BMMBlocks.LETTUCE_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BMMLettuceCropBlock.AGE, 3));
            add(BMMBlocks.LETTUCE_CROP.get(), createCropDrops(BMMBlocks.LETTUCE_CROP.get(), BMMItems.LETTUCE.get(), BMMItems.LETTUCE_SEEDS.get(), lettuceConditionBuilder));
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            return BuiltInRegistries.BLOCK.entrySet().stream().filter(e -> e.getKey().location().getNamespace().equals(BetterMcDonaldsMod.MOD_ID)).map(Map.Entry::getValue).toList();
        }
    }
}