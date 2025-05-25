package net.kyronis.better_mcdonalds_mod.common;

import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMCreativeTabs;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMVillagerTrades;

public class BetterMcDonaldsMod {
    public static final String MOD_ID = "better_mcdonalds_mod";

    public static void init() {
        BMMBlocks.BLOCKS.register();
        BMMCreativeTabs.TABS.register();
        BMMItems.register();
        BMMVillagerTrades.register();
    }
}