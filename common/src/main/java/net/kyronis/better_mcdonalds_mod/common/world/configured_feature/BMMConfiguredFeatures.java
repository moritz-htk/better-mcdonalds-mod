package net.kyronis.better_mcdonalds_mod.common.world.configured_feature;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> SALT_BLOCK = registerKey("salt_block");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        context.register(SALT_BLOCK, saltBlockFeature());
    }

    private static ConfiguredFeature<?, ?> saltBlockFeature() {
        return new ConfiguredFeature<>(Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(BMMBlocks.SALT_BLOCK.get()),
                BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.SAND)),
                UniformInt.of(2, 3), 1));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, name));
    }
}