package net.kyronis.better_mcdonalds_mod.datagen;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.datagen.provider.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = BetterMcDonaldsMod.MOD_ID)
public class BMMDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        DatapackBuiltinEntriesProvider datapackProvider = new BMMRegistryDataProvider(packOutput, event.getLookupProvider());
        CompletableFuture<HolderLookup.Provider> lookupProvider = datapackProvider.getRegistryProvider();

        event.addProvider(new BMMAdvancementProvider(packOutput, lookupProvider));
        event.addProvider(new BMMDataMapProvider(packOutput, lookupProvider));
        event.addProvider(new BMMLootModifierProvider(packOutput, lookupProvider));
        event.addProvider(new BMMLanguageProvider(packOutput));
        event.addProvider(new BMMLootTableProvider(packOutput, lookupProvider));
        event.addProvider(new BMMModelProvider(packOutput));
        event.addProvider(new BMMRecipeProvider(packOutput, lookupProvider));
        event.addProvider(new BMMRegistryDataProvider(packOutput, lookupProvider));
        event.addProvider(new BMMTagsProvider.Items(packOutput, lookupProvider));
        event.addProvider(new BMMTagsProvider.Blocks(packOutput, lookupProvider));
        event.addProvider(new BMMTagsProvider.VillagerTrades(packOutput, lookupProvider));
    }
}