package net.moritz_htk.better_mcdonalds_mod.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.moritz_htk.better_mcdonalds_mod.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMBlocks;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMItems;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BMMTagsProvider {
    public static class Items extends TagsProvider<Item> {
        public static final TagKey<Item> DUSTS_SALT = registerKey("dusts/salt");
        public static final TagKey<Item> CROPS_TOMATO = registerKey("crops/tomato");
        public static final TagKey<Item> CROPS_LETTUCE = registerKey("crops/lettuce");
        public static final TagKey<Item> FOODS_VEGETABLES_TOMATO = registerKey("foods/vegetables/tomato");
        public static final TagKey<Item> FOODS_VEGETABLES_LETTUCE = registerKey("foods/vegetables/lettuce");
        public static final TagKey<Item> SEEDS_TOMATO = registerKey("seeds/tomato");
        public static final TagKey<Item> SEEDS_LETTUCE = registerKey("seeds/lettuce");
        public static final TagKey<Item> FOODS_SAUCES = registerKey("foods/sauces");
        public static final TagKey<Item> FOODS_SAUCES_MAYONNAISE = registerKey("foods/sauces/mayonnaise");
        public static final TagKey<Item> FOODS_SAUCES_SWEET_SOUR_SAUCE = registerKey("foods/sauces/sweet_sour_sauce");
        public static final TagKey<Item> FOODS_SAUCES_KETCHUP = registerKey("foods/sauces/ketchup");
        public static final TagKey<Item> FOODS_SAUCES_MUSTARD = registerKey("foods/sauces/mustard");
        public static final TagKey<Item> FOODS_BURGERS = registerKey("foods/burgers");
        public static final TagKey<Item> FOODS_BURGERS_HAMBURGER = registerKey("foods/burgers/hamburger");
        public static final TagKey<Item> FOODS_BURGERS_CHEESEBURGER = registerKey("foods/burgers/cheeseburger");
        public static final TagKey<Item> FOODS_BURGERS_CHICKENBURGER = registerKey("foods/burgers/chickenburger");
        public static final TagKey<Item> FOODS_BURGERS_FISHBURGER = registerKey("foods/burgers/fishburger");
        public static final TagKey<Item> FOODS_SIDE_DISHES = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, "foods/side_dishes"));
        public static final TagKey<Item> FOODS_DRINKS = registerKey("foods/drinks");
        public static final TagKey<Item> FOODS_DRINKS_COLA = registerKey("foods/drinks/cola");
        public static final TagKey<Item> FOODS_DRINKS_ORANGE_JUICE = registerKey("foods/drinks/orange_juice");
        public static final TagKey<Item> FOODS_DRINKS_LEMON_JUICE = registerKey("foods/drinks/lemon_juice");
        public static final TagKey<Item> FOODS_DRINKS_ICE_TEA = registerKey("foods/drinks/ice_tea");

        public Items(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, Registries.ITEM, registries, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            tag(Tags.Items.DUSTS).addOptionalTag(DUSTS_SALT);
            tag(DUSTS_SALT).add(BMMItems.SALT.getKey());
            tag(Tags.Items.CROPS).addOptionalTag(CROPS_TOMATO).addOptionalTag(CROPS_LETTUCE);
            tag(CROPS_TOMATO).add(BMMItems.TOMATO.getKey());
            tag(CROPS_LETTUCE).add(BMMItems.LETTUCE.getKey());
            tag(Tags.Items.FOODS_VEGETABLES).addOptionalTag(FOODS_VEGETABLES_TOMATO).addOptionalTag(FOODS_VEGETABLES_LETTUCE);
            tag(FOODS_VEGETABLES_TOMATO).add(BMMItems.TOMATO.getKey());
            tag(FOODS_VEGETABLES_LETTUCE).add(BMMItems.LETTUCE.getKey());
            tag(Tags.Items.SEEDS).addOptionalTag(SEEDS_TOMATO).addOptionalTag(SEEDS_LETTUCE);
            tag(SEEDS_TOMATO).add(BMMItems.TOMATO_SEEDS.getKey());
            tag(SEEDS_LETTUCE).add(BMMItems.LETTUCE_SEEDS.getKey());
            tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).add(BMMItems.TOMATO_SEEDS.getKey()).add(BMMItems.LETTUCE_SEEDS.getKey());
            tag(Tags.Items.FOODS).add(BMMItems.CHEESE.getKey()).add(BMMItems.TORTILLA.getKey()).add(BMMItems.MCWRAP.getKey()).add(BMMItems.MCFLURRY.getKey()).addOptionalTag(FOODS_SAUCES).addOptionalTag(FOODS_BURGERS);
            tag(Tags.Items.FOODS_RAW_MEATS).add(BMMItems.BEEF_PATTY.getKey()).add(BMMItems.RAW_BACON.getKey());
            tag(Tags.Items.FOODS_COOKED_MEATS).add(BMMItems.COOKED_BEEF_PATTY.getKey()).add(BMMItems.COOKED_BACON.getKey());
            tag(ItemTags.WOLF_FOOD).add(BMMItems.BEEF_PATTY.getKey()).add(BMMItems.COOKED_BEEF_PATTY.getKey()).add(BMMItems.RAW_BACON.getKey()).add(BMMItems.COOKED_BACON.getKey());
            tag(FOODS_SAUCES).addOptionalTag(FOODS_SAUCES_MAYONNAISE).addOptionalTag(FOODS_SAUCES_SWEET_SOUR_SAUCE).addOptionalTag(FOODS_SAUCES_KETCHUP).addOptionalTag(FOODS_SAUCES_MUSTARD);
            tag(FOODS_SAUCES_MAYONNAISE).add(BMMItems.MAYONNAISE.getKey());
            tag(FOODS_SAUCES_SWEET_SOUR_SAUCE).add(BMMItems.SWEET_SOUR_SAUCE.getKey());
            tag(FOODS_SAUCES_KETCHUP).add(BMMItems.KETCHUP.getKey());
            tag(FOODS_SAUCES_MUSTARD).add(BMMItems.MUSTARD.getKey());
            tag(FOODS_BURGERS).addOptionalTag(FOODS_BURGERS_HAMBURGER).addOptionalTag(FOODS_BURGERS_CHEESEBURGER).addOptionalTag(FOODS_BURGERS_CHICKENBURGER).addOptionalTag(FOODS_BURGERS_FISHBURGER);
            tag(FOODS_BURGERS_HAMBURGER).add(BMMItems.HAMBURGER.getKey()).add(BMMItems.MCBACON.getKey()).add(BMMItems.BIG_MAC.getKey());
            tag(FOODS_BURGERS_CHEESEBURGER).add(BMMItems.CHEESEBURGER.getKey());
            tag(FOODS_BURGERS_CHICKENBURGER).add(BMMItems.CHICKENBURGER.getKey()).add(BMMItems.MCCHICKEN.getKey());
            tag(FOODS_BURGERS_FISHBURGER).add(BMMItems.FILET_O_FISH.getKey());
            tag(FOODS_SIDE_DISHES).add(BMMItems.SNACK_SALAD.getKey()).add(BMMItems.CHICKEN_MCNUGGETS.getKey()).add(BMMItems.FRIES.getKey());
            tag(FOODS_DRINKS).addOptionalTag(FOODS_DRINKS_COLA).addOptionalTag(FOODS_DRINKS_ORANGE_JUICE).addOptionalTag(FOODS_DRINKS_LEMON_JUICE).addOptionalTag(FOODS_DRINKS_ICE_TEA);
            tag(FOODS_DRINKS_COLA).add(TagEntry.element(BMMItems.COCA_COLA.getId()));
            tag(FOODS_DRINKS_ORANGE_JUICE).add(TagEntry.element(BMMItems.FANTA.getId()));
            tag(FOODS_DRINKS_LEMON_JUICE).add(TagEntry.element(BMMItems.SPRITE.getId()));
            tag(FOODS_DRINKS_ICE_TEA).add(TagEntry.element(BMMItems.LIPTON_ICE_TEA_PEACH.getId()));
        }

        private static TagKey<Item> registerKey(String path) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", path));
        }
    }

    public static class Blocks extends TagsProvider<Block> {
        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, Registries.BLOCK, registries, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(TagEntry.element(BMMBlocks.SALT_BLOCK.getId()));
            tag(BlockTags.CROPS).add(TagEntry.element(BMMBlocks.TOMATO_CROP.getId())).add(TagEntry.element(BMMBlocks.LETTUCE_CROP.getId()));
            tag(BlockTags.MAINTAINS_FARMLAND).add(TagEntry.element(BMMBlocks.TOMATO_CROP.getId())).add(TagEntry.element(BMMBlocks.LETTUCE_CROP.getId()));
        }
    }
}