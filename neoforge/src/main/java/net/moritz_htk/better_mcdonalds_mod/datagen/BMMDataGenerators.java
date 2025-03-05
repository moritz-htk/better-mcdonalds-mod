package net.moritz_htk.better_mcdonalds_mod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.moritz_htk.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.datagen.provider.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = BetterMcDonaldsMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class BMMDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.addProvider(new BMMAdvancementProvider(packOutput, lookupProvider));
        event.addProvider(new BMMDataMapProvider(packOutput, lookupProvider));
        event.addProvider(new BMMGlobalLootModifierProvider(packOutput, lookupProvider));
        event.addProvider(BMMLootTableProvider.create(packOutput, lookupProvider));
        event.createProvider(BMMModelProvider::new);
        event.addProvider(new BMMRecipeProvider.Runner(packOutput, lookupProvider));
        event.addProvider(new BMMTagsProvider.Items(packOutput, lookupProvider));
        event.addProvider(new BMMTagsProvider.Blocks(packOutput, lookupProvider));
        event.createProvider(BMMWorldGenProvider::new);
    }
}