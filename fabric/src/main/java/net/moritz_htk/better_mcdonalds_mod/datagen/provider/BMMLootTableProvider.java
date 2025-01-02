package net.moritz_htk.better_mcdonalds_mod.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.moritz_htk.better_mcdonalds_mod.common.block.BMMLettuceCropBlock;
import net.moritz_htk.better_mcdonalds_mod.common.block.BMMTomatoCropBlock;
import net.moritz_htk.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.moritz_htk.better_mcdonalds_mod.common.registry.BMMItems;

import java.util.concurrent.CompletableFuture;

public class BMMLootTableProvider extends FabricBlockLootTableProvider {
    public BMMLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        add(BMMBlocks.SALT_BLOCK.get(), (block) -> createOreDrop(BMMBlocks.SALT_BLOCK.get(), BMMItems.SALT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))));

        LootItemCondition.Builder tomatoConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BMMBlocks.TOMATO_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BMMTomatoCropBlock.AGE, 3));
        add(BMMBlocks.TOMATO_CROP.get(), createCropDrops(BMMBlocks.TOMATO_CROP.get(), BMMItems.TOMATO.get(), BMMItems.TOMATO_SEEDS.get(), tomatoConditionBuilder));

        LootItemCondition.Builder lettuceConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BMMBlocks.LETTUCE_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BMMLettuceCropBlock.AGE, 3));
        add(BMMBlocks.LETTUCE_CROP.get(), createCropDrops(BMMBlocks.LETTUCE_CROP.get(), BMMItems.LETTUCE.get(), BMMItems.LETTUCE_SEEDS.get(), lettuceConditionBuilder));
    }
}