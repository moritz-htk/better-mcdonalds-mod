package net.kyronis.better_mcdonalds_mod.common;

import net.kyronis.better_mcdonalds_mod.common.registry.*;

public class BetterMcDonaldsMod {
    public static final String MOD_ID = "better_mcdonalds_mod";

    public static void init() {
        BMMBlocks.BLOCKS.register();
        BMMItems.register();
        BMMCreativeTabs.TABS.register();
        BMMRecipes.register();
        BMMVillagerTrades.register();
    }
}