package net.kyronis.better_mcdonalds_mod.datagen;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.datagen.provider.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = BetterMcDonaldsMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class BMMDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new BMMBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new BMMItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new BMMAdvancementProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new BMMDataMapProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new BMMGlobalLootModifierProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new BMMTagsProvider.Items(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new BMMTagsProvider.Blocks(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), BMMLootTableProvider.create(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new BMMRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new BMMWorldGenProvider(packOutput, lookupProvider));
    }
}