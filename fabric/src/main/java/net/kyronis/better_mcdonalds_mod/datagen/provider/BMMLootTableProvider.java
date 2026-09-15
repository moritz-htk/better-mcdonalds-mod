package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.kyronis.better_mcdonalds_mod.common.block.BMMLettuceCropBlock;
import net.kyronis.better_mcdonalds_mod.common.block.BMMTomatoCropBlock;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchBlock;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.concurrent.CompletableFuture;

public class BMMLootTableProvider extends FabricBlockLootSubProvider {
    private final HolderGetter<Block> blockLookup;

    public BMMLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
        this.blockLookup = registriesFuture.join().lookupOrThrow(Registries.BLOCK);
    }

    @Override
    public void generate() {
        add(BMMBlocks.SALT_BLOCK.asBlock(), (block) -> createOreDrop(BMMBlocks.SALT_BLOCK.asBlock(), BMMItems.SALT.asItem()).apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4))));

        LootItemCondition.Builder isTomatoMaxAge = MatchBlock.blockMatches(blockLookup, BMMBlocks.TOMATO_CROP.asBlock(), StatePropertiesPredicate.Builder.properties().hasProperty(BMMTomatoCropBlock.AGE, 3));
        add(BMMBlocks.TOMATO_CROP.asBlock(), createCropDrops(BMMBlocks.TOMATO_CROP.asBlock(), BMMItems.TOMATO.asItem(), BMMItems.TOMATO_SEEDS.asItem(), isTomatoMaxAge));

        LootItemCondition.Builder isLettuceMaxAge = MatchBlock.blockMatches(blockLookup, BMMBlocks.LETTUCE_CROP.asBlock(), StatePropertiesPredicate.Builder.properties().hasProperty(BMMLettuceCropBlock.AGE, 3));
        add(BMMBlocks.LETTUCE_CROP.asBlock(), createCropDrops(BMMBlocks.LETTUCE_CROP.asBlock(), BMMItems.LETTUCE.asItem(), BMMItems.LETTUCE_SEEDS.asItem(), isLettuceMaxAge));
    }
}
