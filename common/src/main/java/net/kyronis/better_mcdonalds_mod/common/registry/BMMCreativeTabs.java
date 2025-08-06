package net.kyronis.better_mcdonalds_mod.common.registry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class BMMCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(BetterMcDonaldsMod.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> BETTER_MCDONALDS_MOD_MAIN = TABS.register(BetterMcDonaldsMod.MOD_ID + "_main", () -> CreativeTabRegistry.create(Component.literal("Better McDonald's Mod"), () -> new ItemStack(BMMItems.HAPPY_MEAL.get())));
}