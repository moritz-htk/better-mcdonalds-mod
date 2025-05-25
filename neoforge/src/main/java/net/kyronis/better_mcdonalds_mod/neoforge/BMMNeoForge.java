package net.kyronis.better_mcdonalds_mod.neoforge;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMBlocks;
import net.kyronis.better_mcdonalds_mod.neoforge.registry.BMMLootModifiers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(BetterMcDonaldsMod.MOD_ID)
public class BMMNeoForge {
    public BMMNeoForge(IEventBus modEventBus) {
        BetterMcDonaldsMod.init();
        BMMLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }

    @EventBusSubscriber(modid = BetterMcDonaldsMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class BMMClientEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(BMMBlocks.TOMATO_CROP.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(BMMBlocks.LETTUCE_CROP.get(), RenderType.CUTOUT);
        }
    }
}