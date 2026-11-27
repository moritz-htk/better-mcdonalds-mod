package net.kyronis.better_mcdonalds_mod.neoforge.client;

import net.blay09.mods.balm.api.client.BalmClient;
import net.blay09.mods.balm.neoforge.NeoForgeLoadContext;
import net.kyronis.better_mcdonalds_mod.client.BMMClient;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = BetterMcDonaldsMod.MOD_ID, dist = Dist.CLIENT)
public class BMMNeoForgeClient {
    public BMMNeoForgeClient(IEventBus modEventBus) {
        BalmClient.initializeMod(BetterMcDonaldsMod.MOD_ID, new NeoForgeLoadContext(modEventBus), BMMClient::initialize);
    }
}