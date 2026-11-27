package net.kyronis.better_mcdonalds_mod.common.registry;

import net.blay09.mods.balm.world.entity.npc.villager.BalmVillagerTradeRegistrar;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

public class BMMVillagerTrades {
    public static void initialize(BalmVillagerTradeRegistrar villagerTrades) {
        villagerTrades.registerTrade(ResourceKey.create(Registries.VILLAGER_PROFESSION, ResourceLocation.withDefaultNamespace("farmer")), 1,
                (entity, randomSource) -> new MerchantOffer(new ItemCost(BMMItems.TOMATO.asItem(), 21), new ItemStack(Items.EMERALD), 16, 2, 0.05f),
                (entity, randomSource) -> new MerchantOffer(new ItemCost(BMMItems.LETTUCE.asItem(), 21), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
        villagerTrades.registerTrade(ResourceKey.create(Registries.VILLAGER_PROFESSION, ResourceLocation.withDefaultNamespace("butcher")), 2,
                (entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), new ItemStack(BMMItems.COOKED_BEEF_PATTY.asItem(), 6), 16, 5, 0.05f),
                (entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), new ItemStack(BMMItems.COOKED_BACON.asItem(), 6), 16, 5, 0.05f));
    }
}