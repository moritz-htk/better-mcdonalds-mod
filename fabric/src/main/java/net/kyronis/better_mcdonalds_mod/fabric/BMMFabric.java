package net.kyronis.better_mcdonalds_mod.fabric;

import net.fabricmc.api.ModInitializer;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.fabric.loot.BMMLootTableModifiers;
import net.kyronis.better_mcdonalds_mod.fabric.world.BMMWorldGeneration;
import net.minecraft.world.level.block.ComposterBlock;

public class BMMFabric implements ModInitializer {
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