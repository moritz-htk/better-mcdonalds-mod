package net.kyronis.better_mcdonalds_mod.common.worldgen.placed_feature;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.worldgen.feature.BMMFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class BMMPlacedFeatures {
    public static final ResourceKey<PlacedFeature> DISK_SALT = registerKey("disk_salt");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<Feature> features = context.lookup(Registries.FEATURE);

        context.register(DISK_SALT, saltBlockFeature(features));
    }

    private static PlacedFeature saltBlockFeature(HolderGetter<Feature> features) {
        return new PlacedFeature(features.getOrThrow(BMMFeatures.DISK_SALT), List.of(
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