package net.kyronis.better_mcdonalds_mod.common.registry;

import net.blay09.mods.balm.api.world.BalmWorldGen;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.world.placed_feature.BMMPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.GenerationStep;

public class BMMWorldGen {
    public static void initialize(BalmWorldGen worldGen) {
        worldGen.modifyBiome(
                ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, "salt_block"),
                (key, biomeHolder) -> biomeHolder.is(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", "is_aquatic"))),
                (biome, builder) -> builder.addFeature(
                        GenerationStep.Decoration.RAW_GENERATION,
                        BMMPlacedFeatures.DISK_SALT
                ));
    }
}