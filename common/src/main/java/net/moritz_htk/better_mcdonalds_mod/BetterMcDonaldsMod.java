package net.moritz_htk.better_mcdonalds_mod;

import net.minecraft.world.level.block.ComposterBlock;
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

    public static void postInit() {
        ComposterBlock.COMPOSTABLES.put(BMMItems.TOMATO.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BMMItems.TOMATO_SEEDS.get(), 0.2f);
        ComposterBlock.COMPOSTABLES.put(BMMItems.LETTUCE.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BMMItems.LETTUCE_SEEDS.get(), 0.2f);
    }
}