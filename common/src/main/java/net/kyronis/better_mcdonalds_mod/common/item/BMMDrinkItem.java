package net.kyronis.better_mcdonalds_mod.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import org.jetbrains.annotations.NotNull;

public class BMMDrinkItem extends Item {
    public BMMDrinkItem(Properties properties) {
        super(properties);
    }

    public @NotNull UseAnim getUseAnimation(ItemStack itemStack) {
        return itemStack.getItem().isEdible() ? UseAnim.DRINK : UseAnim.NONE;
    }
}