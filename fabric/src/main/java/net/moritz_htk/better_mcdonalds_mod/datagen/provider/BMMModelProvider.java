package net.moritz_htk.better_mcdonalds_mod.datagen.provider;

import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMBlocks;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMItems;

import java.util.Set;

public class BMMModelProvider extends FabricModelProvider {
    public BMMModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(BMMBlocks.SALT_BLOCK.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        for (RegistrySupplier<Item> item : BMMItems.ITEMS) {
            Set<Item> excludedItems = Set.of(BMMItems.SALT_BLOCK.get());
            if (!excludedItems.contains(item.get())) {
                itemModelGenerators.generateFlatItem(item.get(), ModelTemplates.FLAT_ITEM);
            }
        }
    }
}