package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.blay09.mods.balm.world.item.DeferredItem;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.block.BMMLettuceCropBlock;
import net.kyronis.better_mcdonalds_mod.common.block.BMMTomatoCropBlock;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

import java.util.Set;

public class BMMModelProvider extends ModelProvider {
    public BMMModelProvider(PackOutput output) {
        super(output, BetterMcDonaldsMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        generateBlockStateModels(blockModels);
        generateItemModels(itemModels);
    }

    private void generateBlockStateModels(BlockModelGenerators blockModels) {
        blockModels.createTrivialCube(BMMBlocks.SALT_BLOCK.asBlock());
        blockModels.createCropBlock(BMMBlocks.TOMATO_CROP.asBlock(), BMMTomatoCropBlock.AGE, 0, 1, 2, 3);
        blockModels.createCropBlock(BMMBlocks.LETTUCE_CROP.asBlock(), BMMLettuceCropBlock.AGE, 0, 1, 2, 3);
    }

    private void generateItemModels(ItemModelGenerators itemModels) {
        for (DeferredItem item : BMMItems.ITEMS) {
            Set<Item> excludedItems = Set.of(BMMItems.SALT_BLOCK.asItem(), BMMItems.TOMATO_SEEDS.asItem(), BMMItems.LETTUCE_SEEDS.asItem());
            if (!excludedItems.contains(item.asItem())) {
                itemModels.generateFlatItem(item.asItem(), ModelTemplates.FLAT_ITEM);
            }
        }
    }
}