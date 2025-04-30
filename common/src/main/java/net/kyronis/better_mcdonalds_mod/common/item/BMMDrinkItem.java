package net.kyronis.better_mcdonalds_mod.common.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumables;

public class BMMDrinkItem extends Item {
    public BMMDrinkItem(Properties properties) {
        super(properties.component(DataComponents.CONSUMABLE, Consumables.DEFAULT_DRINK));
    }
}