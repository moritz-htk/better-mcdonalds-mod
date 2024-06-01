package net.moritz_htk.better_mcdonalds_mod.fabric;

import net.fabricmc.api.ModInitializer;
import net.moritz_htk.better_mcdonalds_mod.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.fabric.loot.BMMLootTableModifiers;
import net.moritz_htk.better_mcdonalds_mod.fabric.world.BMMWorldGeneration;

public class BetterMcDonaldsModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BetterMcDonaldsMod.init();
        BetterMcDonaldsMod.postInit();
        BMMLootTableModifiers.modifyLootTables();
        BMMWorldGeneration.generateFeatures();
    }
}