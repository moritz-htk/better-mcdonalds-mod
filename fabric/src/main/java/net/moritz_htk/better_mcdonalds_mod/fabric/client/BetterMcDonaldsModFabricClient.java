package net.moritz_htk.better_mcdonalds_mod.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMBlocks;

public class BetterMcDonaldsModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BMMBlocks.TOMATO_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BMMBlocks.LETTUCE_CROP.get(), RenderType.cutout());
    }
}