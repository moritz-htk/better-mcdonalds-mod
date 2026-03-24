package net.kyronis.better_mcdonalds_mod.neoforge;

import net.blay09.mods.balm.Balm;
import net.blay09.mods.balm.neoforge.platform.runtime.NeoForgeLoadContext;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.neoforge.registry.BMMLootModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(BetterMcDonaldsMod.MOD_ID)
public class BMMNeoForge {
    public BMMNeoForge(ModContainer modContainer, IEventBus modEventBus) {
        Balm.initializeMod(BetterMcDonaldsMod.MOD_ID, new NeoForgeLoadContext(modContainer, modEventBus), BetterMcDonaldsMod::initialize);
        BMMLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }
}