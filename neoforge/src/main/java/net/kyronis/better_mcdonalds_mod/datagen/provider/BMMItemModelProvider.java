package net.kyronis.better_mcdonalds_mod.datagen.provider;

import dev.architectury.registry.registries.RegistrySupplier;
import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.registry.BMMItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BMMItemModelProvider extends ItemModelProvider {
    public BMMItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistrySupplier<Item> item : BMMItems.ITEMS) {
            basicItem(item.get());
        }
    }
}