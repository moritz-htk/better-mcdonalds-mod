package net.moritz_htk.better_mcdonalds_mod.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.moritz_htk.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.common.world.configured_feature.BMMConfiguredFeatures;
import net.moritz_htk.better_mcdonalds_mod.common.world.placed_feature.BMMPlacedFeatures;
import net.moritz_htk.better_mcdonalds_mod.neoforge.world.biome_modifier.BMMBiomeModifiers;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class BMMWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public BMMWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(BetterMcDonaldsMod.MOD_ID));
    }

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, BMMConfiguredFeatures::bootstrap).add(Registries.PLACED_FEATURE, BMMPlacedFeatures::bootstrap).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BMMBiomeModifiers::bootstrap);
}