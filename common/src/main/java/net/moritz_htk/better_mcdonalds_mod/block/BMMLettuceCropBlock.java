package net.moritz_htk.better_mcdonalds_mod.block;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMItems;
import org.jetbrains.annotations.NotNull;

public class BMMLettuceCropBlock extends CropBlock {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 3);

    public BMMLettuceCropBlock(Properties properties) {
        super(properties.noCollission().noOcclusion());
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return BMMItems.LETTUCE_SEEDS.get();
    }

    @Override
    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(AGE);
    }
}