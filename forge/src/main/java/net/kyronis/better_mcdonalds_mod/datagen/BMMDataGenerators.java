package net.kyronis.better_mcdonalds_mod.datagen;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.datagen.provider.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = BetterMcDonaldsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BMMDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new BMMAdvancementProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new BMMGlobalLootModifierProvider(packOutput));
        generator.addProvider(event.includeServer(), BMMLootTableProvider.create(packOutput));
        generator.addProvider(event.includeClient(), new BMMModelProvider.BlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new BMMModelProvider.ItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new BMMRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new BMMTagsProvider.Items(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new BMMTagsProvider.Blocks(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new BMMWorldGenProvider(packOutput, lookupProvider));
    }
}