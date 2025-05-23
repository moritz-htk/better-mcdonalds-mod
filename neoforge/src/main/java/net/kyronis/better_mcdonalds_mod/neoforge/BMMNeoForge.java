package net.kyronis.better_mcdonalds_mod.neoforge;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.neoforge.registry.BMMLootModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(BetterMcDonaldsMod.MOD_ID)
public class BMMNeoForge {
    public BMMNeoForge(IEventBus modEventBus) {
        BetterMcDonaldsMod.init();
        BMMLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }
}