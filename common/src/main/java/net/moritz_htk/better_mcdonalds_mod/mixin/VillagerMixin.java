package net.moritz_htk.better_mcdonalds_mod.mixin;

import com.google.common.collect.Sets;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(Villager.class)
public abstract class VillagerMixin extends AbstractVillager {
    @Unique private static final Set<Item> WANTED_ITEMS = Sets.newHashSet();

    public VillagerMixin(EntityType<? extends AbstractVillager> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at = @At("RETURN"), method = "wantsToPickUp", cancellable = true)
    public void wantsToPickUp(ItemStack itemStack, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        Item item = itemStack.getItem();
        callbackInfoReturnable.setReturnValue((WANTED_ITEMS.contains(item) || callbackInfoReturnable.getReturnValue() || this.getVillagerData().getProfession().requestedItems().contains(item)) && this.getInventory().canAddItem(itemStack));
    }

    @Shadow
    public VillagerData getVillagerData() {
        return null;
    }

    static {
        WANTED_ITEMS.add(BMMItems.TOMATO.get());
        WANTED_ITEMS.add(BMMItems.TOMATO_SEEDS.get());
        WANTED_ITEMS.add(BMMItems.LETTUCE.get());
        WANTED_ITEMS.add(BMMItems.LETTUCE_SEEDS.get());
    }
}