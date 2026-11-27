package net.kyronis.better_mcdonalds_mod.common.mixin;

import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Villager.class)
public abstract class VillagerMixin {
    @Inject(method = "wantsToPickUp", at = @At("RETURN"), cancellable = true)
    private void bmm$acceptCustomItems(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValueZ()) return;

        boolean acceptsItem = stack.is(
                BMMItems.TOMATO.asItem()) ||
                stack.is(BMMItems.TOMATO_SEEDS.asItem()) ||
                stack.is(BMMItems.LETTUCE.asItem()) ||
                stack.is(BMMItems.LETTUCE_SEEDS.asItem());

        if (acceptsItem) {
            Villager villager = (Villager) (Object) this;
            cir.setReturnValue(villager.getInventory().canAddItem(stack));
        }
    }
}