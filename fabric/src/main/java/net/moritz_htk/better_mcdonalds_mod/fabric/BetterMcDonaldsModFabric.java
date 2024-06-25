package net.moritz_htk.better_mcdonalds_mod.fabric;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.level.block.ComposterBlock;
import net.moritz_htk.better_mcdonalds_mod.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.fabric.loot.BMMLootTableModifiers;
import net.moritz_htk.better_mcdonalds_mod.fabric.world.BMMWorldGeneration;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMItems;

public class BetterMcDonaldsModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BetterMcDonaldsMod.init();
        onPostInitialize();
        BMMLootTableModifiers.modifyLootTables();
        BMMWorldGeneration.generateFeatures();
    }

    private void onPostInitialize() {
        ComposterBlock.COMPOSTABLES.put(BMMItems.TOMATO.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BMMItems.TOMATO_SEEDS.get(), 0.2f);
        ComposterBlock.COMPOSTABLES.put(BMMItems.LETTUCE.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BMMItems.LETTUCE_SEEDS.get(), 0.2f);
    }
}