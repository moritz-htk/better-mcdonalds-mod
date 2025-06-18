package net.kyronis.better_mcdonalds_mod.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class BMMFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, BMMBlocks.TOMATO_CROP.get(), BMMBlocks.LETTUCE_CROP.get());
    }
}