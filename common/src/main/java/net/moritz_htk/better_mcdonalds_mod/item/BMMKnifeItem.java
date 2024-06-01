package net.moritz_htk.better_mcdonalds_mod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class BMMKnifeItem extends SwordItem {
    public static Tier KNIFE_IRON = new Tier() {
        @Override
        public int getUses() {
            return 125;
        }

        @Override
        public float getSpeed() {
            return 3;
        }

        @Override
        public float getAttackDamageBonus() {
            return 1;
        }

        @Override
        public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
            return BlockTags.INCORRECT_FOR_IRON_TOOL;
        }

        @Override
        public int getEnchantmentValue() {
            return 0;
        }

        @Override
        public @NotNull Ingredient getRepairIngredient() {
            return Ingredient.of(Items.IRON_INGOT);
        }
    };

    public BMMKnifeItem(Properties properties) {
        super(KNIFE_IRON, properties);
    }

    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }
}