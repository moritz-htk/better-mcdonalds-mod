package net.moritz_htk.better_mcdonalds_mod.datagen.provider;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.moritz_htk.better_mcdonalds_mod.BetterMcDonaldsMod;
import net.moritz_htk.better_mcdonalds_mod.registry.BMMItems;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class BMMItemModelProvider extends ItemModelProvider {
    public BMMItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistrySupplier<Item> item : BMMItems.MAIN_ITEMS) {
            basicItem(item.get());
        }
        handheldItem(BMMItems.KNIFE.get());
    }

    public void handheldItem(Item item) {
        ResourceLocation location = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        getBuilder(location.toString()).parent(new ModelFile.UncheckedModelFile("item/handheld")).texture("layer0", new ResourceLocation(location.getNamespace(), "item/" + location.getPath()));
    }
}