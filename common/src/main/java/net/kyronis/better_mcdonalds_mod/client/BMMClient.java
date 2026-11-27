package net.kyronis.better_mcdonalds_mod.client;

import net.blay09.mods.balm.client.BalmClientRegistrars;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.minecraft.client.renderer.RenderType;

public class BMMClient {
    public static void initialize(BalmClientRegistrars clientRegistrars) {
        clientRegistrars.blockRenderTypes(balmBlockRenderTypeRegistrar -> {
            balmBlockRenderTypeRegistrar.setRenderLayer(BMMBlocks.TOMATO_CROP, RenderType.cutout());
            balmBlockRenderTypeRegistrar.setRenderLayer(BMMBlocks.LETTUCE_CROP, RenderType.cutout());
        });
    }
}