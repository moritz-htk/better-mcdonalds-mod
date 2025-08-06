package net.kyronis.better_mcdonalds_mod.forge;

import dev.architectury.platform.forge.EventBuses;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.forge.registry.BMMLootModifiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BetterMcDonaldsMod.MOD_ID)
public class BMMForge {
    public BMMForge(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        EventBuses.registerModEventBus(BetterMcDonaldsMod.MOD_ID, modEventBus);

        BetterMcDonaldsMod.init();
        BMMLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }
}