package net.moritz_htk.better_mcdonalds_mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import org.jetbrains.annotations.NotNull;

public class BMMDrinkItem extends Item {
    public BMMDrinkItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemUseAnimation getUseAnimation(ItemStack itemStack) {
        return ItemUseAnimation.DRINK;
    }
}