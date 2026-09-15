package net.kyronis.better_mcdonalds_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.kyronis.better_mcdonalds_mod.common.trading.BMMVillagerTrades;
import net.kyronis.better_mcdonalds_mod.common.worldgen.feature.BMMFeatures;
import net.kyronis.better_mcdonalds_mod.common.worldgen.placed_feature.BMMPlacedFeatures;
import net.kyronis.better_mcdonalds_mod.datagen.provider.*;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class BMMDataGenerators implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(BMMAdvancementProvider::new);
        pack.addProvider(BMMModelProvider::new);
        pack.addProvider(BMMLanguageProvider::new);
        pack.addProvider(BMMLootTableProvider::new);
        pack.addProvider(BMMRecipeProvider::new);
        pack.addProvider(BMMRegistryDataProvider::new);
        pack.addProvider(BMMTagsProvider.Items::new);
        pack.addProvider(BMMTagsProvider.Blocks::new);
        pack.addProvider(BMMTagsProvider.VillagerTrades::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.FEATURE, BMMFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, BMMPlacedFeatures::bootstrap);
        registryBuilder.add(Registries.VILLAGER_TRADE, BMMVillagerTrades::bootstrap);
    }
}