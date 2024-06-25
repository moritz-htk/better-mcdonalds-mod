package net.moritz_htk.better_mcdonalds_mod;

import net.moritz_htk.better_mcdonalds_mod.registry.BMMBlocks;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMCreativeTabs;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMItems;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMVillagerTrades;

public class BetterMcDonaldsMod {
    public static final String MOD_ID = "better_mcdonalds_mod";

    public static void init() {
        BMMBlocks.BLOCKS.register();
        BMMCreativeTabs.TABS.register();
        BMMItems.register();
        BMMVillagerTrades.register();
    }
}