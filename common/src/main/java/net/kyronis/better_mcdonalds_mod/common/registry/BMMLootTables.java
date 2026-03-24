package net.kyronis.better_mcdonalds_mod.common.registry;

import net.blay09.mods.balm.world.level.storage.loot.BalmLootTables;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.loot.modifier.BMMSeedLootModifier;
import net.minecraft.resources.Identifier;

public class BMMLootTables {
    public static void initialize(BalmLootTables lootTables) {
        lootTables.registerLootModifier(Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, "grass_seeds"), new BMMSeedLootModifier());
    }
}