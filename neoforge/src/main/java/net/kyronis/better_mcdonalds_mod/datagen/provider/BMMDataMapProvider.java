package net.kyronis.better_mcdonalds_mod.datagen.provider;

import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BMMDataMapProvider extends DataMapProvider {
    public BMMDataMapProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.@NotNull Provider arg) {
        builder(NeoForgeDataMaps.COMPOSTABLES).add(BMMItems.TOMATO.getId(), new Compostable(0.65f), false).add(BMMItems.TOMATO_SEEDS.getId(), new Compostable(0.2f), false).add(BMMItems.LETTUCE.getId(), new Compostable(0.65f), false).add(BMMItems.LETTUCE_SEEDS.getId(), new Compostable(0.2f), false).build();
    }
}