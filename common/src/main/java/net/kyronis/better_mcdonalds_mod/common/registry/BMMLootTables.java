package net.kyronis.better_mcdonalds_mod.common.registry;

import net.blay09.mods.balm.api.loot.BalmLootTables;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.loot.modifier.BMMChestLootModifier;
import net.kyronis.better_mcdonalds_mod.common.loot.modifier.BMMMobLootModifier;
import net.kyronis.better_mcdonalds_mod.common.loot.modifier.BMMSeedLootModifier;
import net.minecraft.resources.ResourceLocation;

public class BMMLootTables {
    public static void initialize(BalmLootTables lootTables) {
        lootTables.registerLootModifier(ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, "grass_seeds"), new BMMSeedLootModifier());
        lootTables.registerLootModifier(ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, "chest_loot"), new BMMChestLootModifier());
        lootTables.registerLootModifier(ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, "mob_loot"), new BMMMobLootModifier());
    }
}