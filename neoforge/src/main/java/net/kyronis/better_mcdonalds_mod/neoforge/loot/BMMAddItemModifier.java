package net.kyronis.better_mcdonalds_mod.neoforge.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctions;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class BMMAddItemModifier extends LootModifier {
    public static final Supplier<MapCodec<BMMAddItemModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.mapCodec(inst ->
                    codecStart(inst)
                            .and(BuiltInRegistries.ITEM.byNameCodec()
                                    .fieldOf("item")
                                    .forGetter(m -> m.item))
                            .and(LootItemFunctions.CODEC.listOf()
                                    .optionalFieldOf("functions", List.of())
                                    .forGetter(m -> m.functions))
                            .apply(inst, BMMAddItemModifier::new)));

    private final Item item;
    private final List<Holder<LootItemFunction>> functions;

    public BMMAddItemModifier(LootItemCondition[] conditionsIn, Item item, final List<Holder<LootItemFunction>> functions) {
        super(conditionsIn);
        this.item = item;
        this.functions = functions;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(@NotNull ObjectArrayList<ItemStack> generatedLoot, @NotNull LootContext context) {
        ItemStack stack = functions.stream().map(Holder::value).reduce(new ItemStack(item), (s, f) -> f.apply(s, context), (a, b) -> b);
        if (!stack.isEmpty()) generatedLoot.add(stack);
        return generatedLoot;
    }

    @Override
    public @NotNull MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}