package net.moritz_htk.better_mcdonalds_mod.common.registry;

import com.mojang.serialization.MapCodec;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.moritz_htk.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.common.block.BMMLettuceCropBlock;
import net.moritz_htk.better_mcdonalds_mod.common.block.BMMTomatoCropBlock;

public class BMMBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BetterMcDonaldsMod.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<FallingBlock> SALT_BLOCK = BLOCKS.register("salt_block", () -> new FallingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).mapColor(DyeColor.WHITE).setId(registerBlockId("salt_block"))) {
        @Override
        protected MapCodec<? extends FallingBlock> codec() {
            return null;
        }
    });
    public static final RegistrySupplier<BMMTomatoCropBlock> TOMATO_CROP = BLOCKS.register("tomato_crop", () -> new BMMTomatoCropBlock(BlockBehaviour.Properties.of().setId(registerBlockId("tomato_crop"))));
    public static final RegistrySupplier<BMMLettuceCropBlock> LETTUCE_CROP  = BLOCKS.register("lettuce_crop", () -> new BMMLettuceCropBlock(BlockBehaviour.Properties.of().setId(registerBlockId("lettuce_crop"))));

    private static ResourceKey<Block> registerBlockId(String id) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, id));
    }
}