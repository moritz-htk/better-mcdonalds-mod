package net.kyronis.better_mcdonalds_mod.fabric.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.kyronis.better_mcdonalds_mod.common.world.placed_feature.BMMPlacedFeatures;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;

public class BMMWorldGeneration {
    public static void generateFeatures() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_RIVER), GenerationStep.Decoration.RAW_GENERATION, BMMPlacedFeatures.SALT_BLOCK);
    }
}