package net.moritz_htk.better_mcdonalds_mod.neoforge;

import net.moritz_htk.better_mcdonalds_mod.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.neoforge.loot.BMMLootModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(BetterMcDonaldsMod.MOD_ID)
public class BetterMcDonaldsModNeoForge {
    public BetterMcDonaldsModNeoForge(IEventBus modEventBus) {
        BetterMcDonaldsMod.init();
        BMMLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }
}