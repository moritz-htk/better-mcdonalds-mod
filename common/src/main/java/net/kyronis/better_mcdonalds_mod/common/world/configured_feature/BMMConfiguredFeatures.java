package net.kyronis.better_mcdonalds_mod.common.world.configured_feature;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;

import java.util.List;

public class BMMConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_SALT = registerKey("disk_salt");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(DISK_SALT, saltDiskFeature());
    }

    private static ConfiguredFeature<?, ?> saltDiskFeature() {
        return new ConfiguredFeature<>(Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(BMMBlocks.SALT_BLOCK.asBlock()),
                BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.SAND)),
                UniformInt.of(2, 3), 1));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, name));
    }
}