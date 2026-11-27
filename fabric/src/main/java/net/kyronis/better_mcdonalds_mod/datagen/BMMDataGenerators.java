package net.kyronis.better_mcdonalds_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.kyronis.better_mcdonalds_mod.common.world.configured_feature.BMMConfiguredFeatures;
import net.kyronis.better_mcdonalds_mod.common.world.placed_feature.BMMPlacedFeatures;
import net.kyronis.better_mcdonalds_mod.datagen.provider.*;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class BMMDataGenerators implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(BMMAdvancementProvider::new);
        pack.addProvider(BMMLanguageProvider::new);
        pack.addProvider(BMMLootTableProvider::new);
        pack.addProvider(BMMModelProvider::new);
        pack.addProvider(BMMRecipeProvider::new);
        pack.addProvider(BMMRegistryDataProvider::new);
        pack.addProvider(BMMTagsProvider.Items::new);
        pack.addProvider(BMMTagsProvider.Blocks::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, BMMConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, BMMPlacedFeatures::bootstrap);
    }
}