package net.kyronis.better_mcdonalds_mod.common.registry;

import net.blay09.mods.balm.world.item.BalmCompostableRegistrar;

public class BMMCompostables {
    public static void initialize(BalmCompostableRegistrar compostables) {
        compostables.register(BMMItems.TOMATO.asItem(), 0.65f);
        compostables.register(BMMItems.TOMATO_SEEDS.asItem(), 0.3f);
        compostables.register(BMMItems.LETTUCE.asItem(), 0.65f);
        compostables.register(BMMItems.LETTUCE_SEEDS.asItem(), 0.3f);
    }
}