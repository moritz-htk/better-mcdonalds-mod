package net.moritz_htk.better_mcdonalds_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.moritz_htk.better_mcdonalds_mod.common.world.configured_feature.BMMConfiguredFeatures;
import net.moritz_htk.better_mcdonalds_mod.common.world.placed_feature.BMMPlacedFeatures;
import net.moritz_htk.better_mcdonalds_mod.datagen.provider.*;

public class BMMDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(BMMAdvancementProvider::new);
        pack.addProvider(BMMLootTableProvider::new);
        pack.addProvider(BMMModelProvider::new);
        pack.addProvider(BMMRecipeProvider::new);
        pack.addProvider(BMMTagsProvider.Blocks::new);
        pack.addProvider(BMMTagsProvider.Items::new);
        pack.addProvider(BMMWorldGenProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, BMMConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, BMMPlacedFeatures::bootstrap);
    }
}
