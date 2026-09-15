package net.kyronis.better_mcdonalds_mod.common.worldgen.feature;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.DiskFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class BMMFeatures {
    public static final ResourceKey<Feature> DISK_SALT = registerKey("disk_salt");

    public static void bootstrap(BootstrapContext<Feature> context) {
        context.register(DISK_SALT, saltDiskFeature());
    }

    private static Feature saltDiskFeature() {
        return new DiskFeature(
                BlockStateProvider.holderOf(BMMBlocks.SALT_BLOCK.asBlock()),
                BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.SAND),
                UniformInt.of(2, 3), 1);
    }

    private static ResourceKey<Feature> registerKey(String path) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, path));
    }
}