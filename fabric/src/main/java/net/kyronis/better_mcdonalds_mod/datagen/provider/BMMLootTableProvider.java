package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kyronis.better_mcdonalds_mod.common.block.BMMLettuceCropBlock;
import net.kyronis.better_mcdonalds_mod.common.block.BMMTomatoCropBlock;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class BMMLootTableProvider extends FabricBlockLootTableProvider {
    public BMMLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        add(BMMBlocks.SALT_BLOCK.asBlock(), (block) -> createOreDrop(BMMBlocks.SALT_BLOCK.asBlock(), BMMItems.SALT.asItem()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))));

        LootItemCondition.Builder tomatoConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BMMBlocks.TOMATO_CROP.asBlock()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BMMTomatoCropBlock.AGE, 3));
        add(BMMBlocks.TOMATO_CROP.asBlock(), createCropDrops(BMMBlocks.TOMATO_CROP.asBlock(), BMMItems.TOMATO.asItem(), BMMItems.TOMATO_SEEDS.asItem(), tomatoConditionBuilder));

        LootItemCondition.Builder lettuceConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BMMBlocks.LETTUCE_CROP.asBlock()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BMMLettuceCropBlock.AGE, 3));
        add(BMMBlocks.LETTUCE_CROP.asBlock(), createCropDrops(BMMBlocks.LETTUCE_CROP.asBlock(), BMMItems.LETTUCE.asItem(), BMMItems.LETTUCE_SEEDS.asItem(), lettuceConditionBuilder));
    }
}