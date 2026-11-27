package net.kyronis.better_mcdonalds_mod.fabric.registry;

import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.world.level.block.ComposterBlock;

public class BMMCompostables {
    public static void initialize() {
        ComposterBlock.COMPOSTABLES.put(BMMItems.TOMATO, 0.65f);
        ComposterBlock.COMPOSTABLES.put(BMMItems.TOMATO_SEEDS, 0.3f);
        ComposterBlock.COMPOSTABLES.put(BMMItems.LETTUCE, 0.65f);
        ComposterBlock.COMPOSTABLES.put(BMMItems.LETTUCE_SEEDS, 0.3f);
    }
}