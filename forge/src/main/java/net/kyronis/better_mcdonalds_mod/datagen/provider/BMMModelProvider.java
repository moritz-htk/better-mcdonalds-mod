package net.kyronis.better_mcdonalds_mod.datagen.provider;

import dev.architectury.registry.registries.RegistrySupplier;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.block.BMMLettuceCropBlock;
import net.kyronis.better_mcdonalds_mod.common.block.BMMTomatoCropBlock;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Set;

public class BMMModelProvider {
    public static class BlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {
        public BlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
            super(output, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerStatesAndModels() {
            this.simpleBlockWithItem(BMMBlocks.SALT_BLOCK.get(), cubeAll(BMMBlocks.SALT_BLOCK.get()));
            this.makeCrop(BMMBlocks.TOMATO_CROP.get(), BMMTomatoCropBlock.AGE, "tomato_");
            this.makeCrop(BMMBlocks.LETTUCE_CROP.get(), BMMLettuceCropBlock.AGE, "lettuce_");
        }

        private void makeCrop(Block block, IntegerProperty ageProperty, String texturePrefix) {
            getVariantBuilder(block).forAllStates(state -> {
                int age = state.getValue(ageProperty);
                String modelName = texturePrefix + "crop_stage" + age;
                ResourceLocation texture = modLoc("block/" + modelName);

                return ConfiguredModel.builder().modelFile(models().crop(modelName, texture).renderType("cutout")).build();
            });

            itemModels().basicItem(block.asItem());
        }
    }

    public static class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
        public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
            super(output, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerModels() {
            for (RegistrySupplier<Item> item : BMMItems.ITEMS) {
                Set<Item> excludedItems = Set.of(BMMItems.SALT_BLOCK.get(), BMMItems.TOMATO_SEEDS.get(), BMMItems.LETTUCE_SEEDS.get());
                if (!excludedItems.contains(item.get())) {
                    this.basicItem(item.get());
                }
            }
        }
    }
}