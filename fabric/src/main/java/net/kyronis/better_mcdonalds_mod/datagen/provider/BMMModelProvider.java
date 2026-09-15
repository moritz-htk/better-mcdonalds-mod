package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.blay09.mods.balm.world.item.DeferredItem;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.kyronis.better_mcdonalds_mod.common.block.BMMLettuceCropBlock;
import net.kyronis.better_mcdonalds_mod.common.block.BMMTomatoCropBlock;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;

import java.util.Set;

public class BMMModelProvider extends FabricModelProvider {
    public BMMModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(BMMBlocks.SALT_BLOCK.asBlock());
        blockModelGenerators.createCropBlock(BMMBlocks.TOMATO_CROP.asBlock(), BMMTomatoCropBlock.AGE, 0, 1, 2, 3);
        blockModelGenerators.createCropBlock(BMMBlocks.LETTUCE_CROP.asBlock(), BMMLettuceCropBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        for (DeferredItem item : BMMItems.ITEMS) {
            Set<Item> excludedItems = Set.of(BMMItems.SALT_BLOCK.asItem(), BMMItems.TOMATO_SEEDS.asItem(), BMMItems.LETTUCE_SEEDS.asItem());
            if (!excludedItems.contains(item.asItem())) {
                itemModelGenerators.generateFlatItem(item.asItem(), ModelTemplates.FLAT_ITEM);
            }
        }
    }
}