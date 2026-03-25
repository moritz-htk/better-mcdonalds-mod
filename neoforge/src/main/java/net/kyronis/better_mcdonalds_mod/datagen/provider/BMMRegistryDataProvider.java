package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMVillagerTrades;
import net.kyronis.better_mcdonalds_mod.common.worldgen.configured_feature.BMMConfiguredFeatures;
import net.kyronis.better_mcdonalds_mod.common.worldgen.placed_feature.BMMPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.RegistryPatchGenerator;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class BMMRegistryDataProvider extends DatapackBuiltinEntriesProvider {
    public BMMRegistryDataProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, RegistryPatchGenerator.createLookup(registries, BUILDER), Set.of(BetterMcDonaldsMod.MOD_ID));
    }

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, BMMConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, BMMPlacedFeatures::bootstrap)
            .add(Registries.VILLAGER_TRADE, BMMVillagerTrades::bootstrap);
}