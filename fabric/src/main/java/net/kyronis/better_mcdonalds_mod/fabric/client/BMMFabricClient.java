package net.kyronis.better_mcdonalds_mod.fabric.client;

import net.blay09.mods.balm.api.EmptyLoadContext;
import net.blay09.mods.balm.api.client.BalmClient;
import net.fabricmc.api.ClientModInitializer;
import net.kyronis.better_mcdonalds_mod.client.BMMClient;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;

public class BMMFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BalmClient.initializeMod(BetterMcDonaldsMod.MOD_ID, EmptyLoadContext.INSTANCE, BMMClient::initialize);
    }
}