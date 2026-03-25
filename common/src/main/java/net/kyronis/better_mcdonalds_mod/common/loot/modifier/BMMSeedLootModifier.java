package net.kyronis.better_mcdonalds_mod.common.loot.modifier;

import net.blay09.mods.balm.world.item.DeferredItem;
import net.blay09.mods.balm.world.level.storage.loot.BalmLootModifier;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.List;
import java.util.Set;

public class BMMSeedLootModifier implements BalmLootModifier {
    private static final float DROP_CHANCE = 0.15f;
    private static final Set<Block> GRASS_BLOCKS = Set.of(Blocks.SHORT_GRASS, Blocks.FERN);
    private static final Set<DeferredItem> SEEDS = Set.of(BMMItems.TOMATO_SEEDS, BMMItems.LETTUCE_SEEDS);

    @Override
    public void apply(LootContext context, List<ItemStack> loot) {
        if (!context.hasParameter(LootContextParams.BLOCK_STATE)) {
            return;
        }

        BlockState state = context.getOptionalParameter(LootContextParams.BLOCK_STATE);

        if (!GRASS_BLOCKS.contains(state.getBlock())) return;

        var random = context.getRandom();
        for (DeferredItem seed : SEEDS) {
            if (random.nextFloat() < DROP_CHANCE) {
                loot.add(seed.createStack());
            }
        }
    }
}