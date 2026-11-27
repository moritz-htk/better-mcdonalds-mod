package net.kyronis.better_mcdonalds_mod.fabric;

import net.blay09.mods.balm.api.Balm;
import net.blay09.mods.balm.api.EmptyLoadContext;
import net.fabricmc.api.ModInitializer;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.fabric.registry.BMMCompostables;

public class BMMFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Balm.initializeMod(BetterMcDonaldsMod.MOD_ID, EmptyLoadContext.INSTANCE, BetterMcDonaldsMod::initialize);
        BMMCompostables.initialize();
    }
}