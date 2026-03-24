package net.kyronis.better_mcdonalds_mod.common.worldgen.placed_feature;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.worldgen.configured_feature.BMMConfiguredFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class BMMPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SALT_BLOCK = registerKey("salt_block");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(SALT_BLOCK, saltBlockFeature(configuredFeatures));
    }

    private static PlacedFeature saltBlockFeature(HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures) {
        return new PlacedFeature(configuredFeatures.getOrThrow(BMMConfiguredFeatures.SALT_BLOCK), List.of(
                CountPlacement.of(2),
                InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG),
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)),
                BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String path) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, path));
    }
}