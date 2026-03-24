package net.kyronis.better_mcdonalds_mod.common.registry;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;

import java.util.List;
import java.util.Optional;

public class BMMVillagerTrades {
    public static final ResourceKey<VillagerTrade> FARMER_1_TOMATO_EMERALD = registerKey("farmer/1/tomato_emerald");
    public static final ResourceKey<VillagerTrade> FARMER_1_LETTUCE_EMERALD = registerKey("farmer/1/lettuce_emerald");
    public static final ResourceKey<VillagerTrade> BUTCHER_2_EMERALD_COOKED_BEEF_PATTY = registerKey("butcher/2/emerald_cooked_beef_patty");
    public static final ResourceKey<VillagerTrade> BUTCHER_2_EMERALD_COOKED_BACON = registerKey("butcher/2/emerald_cooked_bacon");

    public static void bootstrap(BootstrapContext<VillagerTrade> context) {
        context.register(FARMER_1_TOMATO_EMERALD, farmer1TomatoEmerald());
        context.register(FARMER_1_LETTUCE_EMERALD, farmer1LettuceEmerald());
        context.register(BUTCHER_2_EMERALD_COOKED_BEEF_PATTY, butcher2EmeraldCookedBeefPatty());
        context.register(BUTCHER_2_EMERALD_COOKED_BACON, butcher2EmeraldCookedBacon());
    }

    private static VillagerTrade farmer1TomatoEmerald() {
        return new VillagerTrade(
                new TradeCost(BMMItems.TOMATO.asItem(), 21),
                new ItemStackTemplate(Items.EMERALD),
                16, 2, 0.05f,
                Optional.empty(), List.of());
    }

    private static VillagerTrade farmer1LettuceEmerald() {
        return new VillagerTrade(
                new TradeCost(BMMItems.LETTUCE.asItem(), 21),
                new ItemStackTemplate(Items.EMERALD),
                16, 2, 0.05f,
                Optional.empty(), List.of());
    }

    private static VillagerTrade butcher2EmeraldCookedBeefPatty() {
        return new VillagerTrade(
                new TradeCost(Items.EMERALD, 1),
                new ItemStackTemplate(BMMItems.COOKED_BEEF_PATTY.asItem(), 6),
                16, 5, 0.05f,
                Optional.empty(), List.of());
    }

    private static VillagerTrade butcher2EmeraldCookedBacon() {
        return new VillagerTrade(
                new TradeCost(Items.EMERALD, 1),
                new ItemStackTemplate(BMMItems.COOKED_BACON.asItem(), 6),
                16, 5, 0.05f,
                Optional.empty(), List.of());
    }

    private static ResourceKey<VillagerTrade> registerKey(String path) {
        return ResourceKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, path));
    }
}