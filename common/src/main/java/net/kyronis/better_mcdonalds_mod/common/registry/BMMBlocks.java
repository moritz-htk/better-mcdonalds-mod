package net.kyronis.better_mcdonalds_mod.common.registry;

import net.blay09.mods.balm.world.level.block.BalmBlockRegistrar;
import net.blay09.mods.balm.world.level.block.DeferredBlock;
import net.kyronis.better_mcdonalds_mod.common.block.BMMLettuceCropBlock;
import net.kyronis.better_mcdonalds_mod.common.block.BMMSaltBlock;
import net.kyronis.better_mcdonalds_mod.common.block.BMMTomatoCropBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class BMMBlocks {
    public static DeferredBlock SALT_BLOCK;
    public static DeferredBlock TOMATO_CROP;
    public static DeferredBlock LETTUCE_CROP;

    public static void initialize(BalmBlockRegistrar blocks) {
        SALT_BLOCK = registerBlock(blocks, "salt_block", BMMSaltBlock::new);
        TOMATO_CROP = registerBlock(blocks, "tomato_crop", BMMTomatoCropBlock::new);
        LETTUCE_CROP = registerBlock(blocks, "lettuce_crop", BMMLettuceCropBlock::new);
    }

    private static DeferredBlock registerBlock(BalmBlockRegistrar blocks, String name, Function<BlockBehaviour.Properties, Block> factory) {
        return blocks.register(name, factory, BlockBehaviour.Properties.of()).asDeferredBlock();
    }
}