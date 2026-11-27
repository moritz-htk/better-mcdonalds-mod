package net.kyronis.better_mcdonalds_mod.forge;

import net.blay09.mods.balm.api.Balm;
import net.blay09.mods.balm.api.client.BalmClient;
import net.blay09.mods.balm.forge.ForgeLoadContext;
import net.kyronis.better_mcdonalds_mod.client.BMMClient;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(BetterMcDonaldsMod.MOD_ID)
public class BMMForge {
    public BMMForge(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        final var loadContext = new ForgeLoadContext(context.getModEventBus());
        Balm.initializeMod(BetterMcDonaldsMod.MOD_ID, loadContext, BetterMcDonaldsMod::initialize);

        if (FMLEnvironment.dist.isClient()) {
            BalmClient.initializeMod(BetterMcDonaldsMod.MOD_ID, loadContext, BMMClient::initialize);
        }

        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(BMMItems.TOMATO, 0.65f);
            ComposterBlock.COMPOSTABLES.put(BMMItems.TOMATO_SEEDS, 0.3f);
            ComposterBlock.COMPOSTABLES.put(BMMItems.LETTUCE, 0.65f);
            ComposterBlock.COMPOSTABLES.put(BMMItems.LETTUCE_SEEDS, 0.3f);
        });
    }
}