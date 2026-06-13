package net.kyronis.better_mcdonalds_mod.fabric;

import net.blay09.mods.balm.Balm;
import net.blay09.mods.balm.fabric.platform.runtime.FabricLoadContext;
import net.fabricmc.api.ModInitializer;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;

public class BMMFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Balm.initializeMod(BetterMcDonaldsMod.MOD_ID, FabricLoadContext.INSTANCE, BetterMcDonaldsMod::initialize);
    }
}