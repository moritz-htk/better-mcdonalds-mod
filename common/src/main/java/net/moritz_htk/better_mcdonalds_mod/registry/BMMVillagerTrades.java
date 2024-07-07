package net.moritz_htk.better_mcdonalds_mod.registry;

import dev.architectury.registry.level.entity.trade.TradeRegistry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

public class BMMVillagerTrades {
    public static void register() {
        TradeRegistry.registerVillagerTrade(VillagerProfession.FARMER, 1,
                (entity, randomSource) -> new MerchantOffer(new ItemCost(BMMItems.TOMATO.get(), 21), new ItemStack(Items.EMERALD), 16, 2, 0.05f),
                (entity, randomSource) -> new MerchantOffer(new ItemCost(BMMItems.LETTUCE.get(), 21), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
        TradeRegistry.registerVillagerTrade(VillagerProfession.BUTCHER, 2,
                (entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), new ItemStack(BMMItems.COOKED_BEEF_PATTY.get(), 6), 16, 5, 0.05f),
                (entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), new ItemStack(BMMItems.COOKED_BACON.get(), 6), 16, 5, 0.05f));
    }
}