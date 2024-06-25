package net.moritz_htk.better_mcdonalds_mod.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMItems;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class BMMDataMapProvider extends DataMapProvider {
    public BMMDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        builder(NeoForgeDataMaps.COMPOSTABLES).add(BMMItems.TOMATO.getKey(), new Compostable(0.65f), false).add(BMMItems.TOMATO_SEEDS.getKey(), new Compostable(0.2f), false).add(BMMItems.LETTUCE.getKey(), new Compostable(0.65f), false).add(BMMItems.LETTUCE_SEEDS.getKey(), new Compostable(0.2f), false).build();
    }
}