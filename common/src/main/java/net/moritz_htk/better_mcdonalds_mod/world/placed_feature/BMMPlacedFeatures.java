package net.moritz_htk.better_mcdonalds_mod.world.placed_feature;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.moritz_htk.better_mcdonalds_mod.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.world.configured_feature.BMMConfiguredFeatures;
import net.moritz_htk.better_mcdonalds_mod.world.placement.BMMDiskPlacement;

public class BMMPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SALT_BLOCK = registerKey("salt_block");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(SALT_BLOCK, saltBlockFeature(configuredFeatures));
    }

    public static PlacedFeature saltBlockFeature(HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures) {
        return new PlacedFeature(configuredFeatures.getOrThrow(BMMConfiguredFeatures.SALT_BLOCK), BMMDiskPlacement.modifiers(
                CountPlacement.of(2),
                InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG),
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)),
                BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, name));
    }
}