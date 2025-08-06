package net.kyronis.better_mcdonalds_mod.forge.loot;

import com.google.common.base.Suppliers;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.common.loot.LootModifierManager;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class BMMAddItemModifier extends LootModifier {
    private static final Codec<LootItemFunction> LOOT_ITEM_FUNCTION_CODEC = Codec.PASSTHROUGH.flatXmap(
        d -> {
            try {
                LootItemFunction function = LootModifierManager.GSON_INSTANCE.fromJson(getJson(d), LootItemFunction.class);
                return DataResult.success(function);
            } catch (JsonSyntaxException e) {
                return DataResult.error(() -> "Failed to decode LootItemFunction: " + e.getMessage());
            }
        },
        function -> {
            try {
                JsonElement element = LootModifierManager.GSON_INSTANCE.toJsonTree(function);
                return DataResult.success(new Dynamic<>(JsonOps.INSTANCE, element));
            } catch (JsonSyntaxException e) {
                return DataResult.error(() -> "Failed to encode LootItemFunction: " + e.getMessage());
            }
        }
    );

    public static final Supplier<Codec<BMMAddItemModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst ->
                    codecStart(inst)
                            .and(ForgeRegistries.ITEMS.getCodec()
                                    .fieldOf("item")
                                    .forGetter(m -> m.item))
                            .and(LOOT_ITEM_FUNCTION_CODEC.listOf()
                                    .optionalFieldOf("functions", List.of())
                                    .forGetter(m -> m.functions))
                            .apply(inst, BMMAddItemModifier::new)
            ));

    private final Item item;
    private final List<LootItemFunction> functions;

    public BMMAddItemModifier(LootItemCondition[] conditionsIn, Item item, final List<LootItemFunction> functions) {
        super(conditionsIn);
        this.item = item;
        this.functions = functions;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(@NotNull ObjectArrayList<ItemStack> generatedLoot, @NotNull LootContext context) {
        ItemStack baseStack = new ItemStack(item);

        ItemStack stack = functions.stream().reduce(baseStack, (currentStack, func) -> func.apply(currentStack, context), (a, b) -> b);

        if (!stack.isEmpty()) {
            generatedLoot.add(stack);
        }
        return generatedLoot;
    }

    @Override
    public @NotNull Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }

    private static <T> JsonElement getJson(Dynamic<T> dynamic) {
        T val = dynamic.getValue();
        if (val instanceof JsonElement) {
            return (JsonElement) val;
        }
        return dynamic.getOps().convertTo(JsonOps.INSTANCE, val);
    }
}