package net.kyronis.better_mcdonalds_mod.common.registry;

import net.blay09.mods.balm.world.level.levelgen.BalmWorldGen;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.worldgen.placed_feature.BMMPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.GenerationStep;

public class BMMWorldGen {
    public static void initialize(BalmWorldGen worldGen) {
        worldGen.modifyBiome(
                Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, "salt_block"),
                biomeHolder -> biomeHolder.is(TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath("c", "is_aquatic"))),
                (biome, builder) -> builder.addFeature(
                        GenerationStep.Decoration.RAW_GENERATION,
                        BMMPlacedFeatures.SALT_BLOCK
                ));
    }
}