package net.kyronis.better_mcdonalds_mod.common;

import net.blay09.mods.balm.Balm;
import net.blay09.mods.balm.core.BalmRegistrars;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMCreativeTabs;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMLootTables;
import net.kyronis.better_mcdonalds_mod.common.worldgen.BMMWorldGen;

public class BetterMcDonaldsMod {
    public static final String MOD_ID = "better_mcdonalds_mod";

    public static void initialize(BalmRegistrars registrars) {
        registrars.blocks(BMMBlocks::initialize);
        registrars.items(BMMItems::initialize);
        registrars.creativeModeTabs(BMMCreativeTabs::initialize);
        BMMLootTables.initialize(Balm.lootModifiers());
        BMMWorldGen.initialize(Balm.biomeModifications());
    }
}