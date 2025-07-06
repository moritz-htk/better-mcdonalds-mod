package net.kyronis.better_mcdonalds_mod.datagen.provider;

import dev.architectury.registry.registries.RegistrySupplier;
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
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BMMModelProvider extends ModelProvider {
    public BMMModelProvider(PackOutput output) {
        super(output, BetterMcDonaldsMod.MOD_ID);
    }

    @Override
    protected void registerModels(@NotNull BlockModelGenerators blockModels, @NotNull ItemModelGenerators itemModels) {
        generateBlockStateModels(blockModels);
        generateItemModels(itemModels);
    }

    private void generateBlockStateModels(BlockModelGenerators blockModels) {
        blockModels.createTrivialCube(BMMBlocks.SALT_BLOCK.get());
        blockModels.createCropBlock(BMMBlocks.TOMATO_CROP.get(), BMMTomatoCropBlock.AGE, 0, 1, 2, 3);
        blockModels.createCropBlock(BMMBlocks.LETTUCE_CROP.get(), BMMLettuceCropBlock.AGE, 0, 1, 2, 3);
    }

    private void generateItemModels(ItemModelGenerators itemModels) {
        for (RegistrySupplier<Item> item : BMMItems.ITEMS) {
            boolean isBlockItem = false;
            for (RegistrySupplier<Item> blockItem : BMMItems.BLOCK_ITEMS) {
                if (blockItem.get() == item.get()) {
                    isBlockItem = true;
                    break;
                }
            }
            if (!isBlockItem) {
                itemModels.generateFlatItem(item.get(), ModelTemplates.FLAT_ITEM);
            }
        }
    }
}