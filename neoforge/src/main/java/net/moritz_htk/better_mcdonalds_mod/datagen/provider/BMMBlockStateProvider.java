package net.moritz_htk.better_mcdonalds_mod.datagen.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.moritz_htk.better_mcdonalds_mod.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.block.BMMLettuceCropBlock;
import net.moritz_htk.better_mcdonalds_mod.block.BMMTomatoCropBlock;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMBlocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class BMMBlockStateProvider extends BlockStateProvider {
    public BMMBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BetterMcDonaldsMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(BMMBlocks.SALT_BLOCK.get(), cubeAll(BMMBlocks.SALT_BLOCK.get()));
        makeCrop(BMMBlocks.TOMATO_CROP.get(), BMMTomatoCropBlock.AGE, "tomato_crop");
        makeCrop(BMMBlocks.LETTUCE_CROP.get(), BMMLettuceCropBlock.AGE, "lettuce_crop");
    }

    private void makeCrop(CropBlock block, IntegerProperty ageProperty, String cropName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cropStates(state, ageProperty, cropName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cropStates(BlockState state, IntegerProperty ageProperty, String cropName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(cropName + "_stage" + state.getValue(ageProperty), ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, "block/" + cropName + "_stage" + state.getValue(ageProperty))).renderType("cutout"));
        return models;
    }
}