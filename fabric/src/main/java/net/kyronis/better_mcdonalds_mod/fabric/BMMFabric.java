package net.kyronis.better_mcdonalds_mod.fabric;

import net.blay09.mods.balm.Balm;
import net.blay09.mods.balm.fabric.platform.runtime.FabricLoadContext;
import net.fabricmc.api.ModInitializer;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.fabric.loot.BMMLootTableModifiers;
import net.minecraft.world.level.block.ComposterBlock;

public class BMMFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Balm.initializeMod(BetterMcDonaldsMod.MOD_ID, FabricLoadContext.INSTANCE, BetterMcDonaldsMod::initialize);
        BMMLootTableModifiers.initialize();
        initializeCompostables();
    }

    private static void initializeCompostables() {
        ComposterBlock.COMPOSTABLES.put(BMMItems.TOMATO.asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BMMItems.TOMATO_SEEDS.asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(BMMItems.LETTUCE.asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BMMItems.LETTUCE_SEEDS.asItem(), 0.3f);
    }
}