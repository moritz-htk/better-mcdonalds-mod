package net.kyronis.better_mcdonalds_mod.common.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.block.BMMLettuceCropBlock;
import net.kyronis.better_mcdonalds_mod.common.block.BMMSaltBlock;
import net.kyronis.better_mcdonalds_mod.common.block.BMMTomatoCropBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BMMBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BetterMcDonaldsMod.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<Block> SALT_BLOCK = BLOCKS.register("salt_block", () -> new BMMSaltBlock(BlockBehaviour.Properties.of()));
    public static final RegistrySupplier<Block> TOMATO_CROP = BLOCKS.register("tomato_crop", () -> new BMMTomatoCropBlock(BlockBehaviour.Properties.of()));
    public static final RegistrySupplier<Block> LETTUCE_CROP  = BLOCKS.register("lettuce_crop", () -> new BMMLettuceCropBlock(BlockBehaviour.Properties.of()));
}