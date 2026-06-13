package net.kyronis.better_mcdonalds_mod.common.loot.modifier;

import net.blay09.mods.balm.world.level.storage.loot.BalmLootModifier;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class BMMMobLootModifier implements BalmLootModifier {
    private static final float DROP_CHANCE = 0.5f;

    @Override
    public void apply(LootContext context, List<ItemStack> loot, @Nullable ResourceKey<LootTable> lootTableId) {
        if (lootTableId == null) {
            return;
        }

        addMobLoot(context, loot, lootTableId, EntityType.COW.getDefaultLootTable().get(), BMMItems.BEEF_PATTY.asItem(), UniformGenerator.between(1, 2));
        addMobLoot(context, loot, lootTableId, EntityType.PIG.getDefaultLootTable().get(), BMMItems.RAW_BACON.asItem(), UniformGenerator.between(1, 2));
    }

    private static void addMobLoot(LootContext context, List<ItemStack> loot, ResourceKey<LootTable> currentLootTable, ResourceKey<LootTable> targetLootTable, Item item, NumberProvider count) {
        if (!currentLootTable.equals(targetLootTable)) {
            return;
        }

        if (context.getRandom().nextFloat() >= DROP_CHANCE) {
            return;
        }

        ItemStack stack = new ItemStack(item, count.getInt(context));

        if (shouldSmeltLoot(context)) {
            stack = SmeltItemFunction.smelted().build().apply(stack, context);
        }

        if (!stack.isEmpty()) {
            loot.add(stack);
        }
    }

    private static boolean shouldSmeltLoot(LootContext context) {
        Entity entity = context.getOptionalParameter(LootContextParams.THIS_ENTITY);
        if (entity != null && entity.isOnFire()) {
            return true;
        }

        Entity attacker = context.getOptionalParameter(LootContextParams.DIRECT_ATTACKING_ENTITY);
        if (!(attacker instanceof LivingEntity livingAttacker)) {
            return false;
        }

        ItemStack weapon = livingAttacker.getMainHandItem();
        ItemEnchantments enchantments = weapon.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);

        for (Holder<Enchantment> enchantment : enchantments.keySet()) {
            if (enchantment.is(EnchantmentTags.SMELTS_LOOT)) {
                return true;
            }
        }

        return false;
    }
}