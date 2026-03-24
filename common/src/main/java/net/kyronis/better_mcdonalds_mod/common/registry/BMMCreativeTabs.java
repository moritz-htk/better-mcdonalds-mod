package net.kyronis.better_mcdonalds_mod.common.registry;

import net.blay09.mods.balm.world.item.BalmCreativeModeTabRegistrar;
import net.blay09.mods.balm.world.item.DeferredItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class BMMCreativeTabs {
    public static void initialize(BalmCreativeModeTabRegistrar creativeModeTabs) {
        creativeModeTabs.register("main", (identifier, builder) -> builder
                .title(Component.literal("Better McDonald's Mod"))
                .icon(() -> new ItemStack(BMMItems.HAPPY_MEAL.asItem()))
                .displayItems((parameters, output) -> {
                    for (DeferredItem item : BMMItems.ITEMS) {
                        output.accept(item.asItem());
                    }
                })
        );
    }
}