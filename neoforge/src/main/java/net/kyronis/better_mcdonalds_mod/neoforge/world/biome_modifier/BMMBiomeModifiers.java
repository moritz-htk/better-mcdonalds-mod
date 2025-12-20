package net.kyronis.better_mcdonalds_mod.neoforge.world.biome_modifier;

import net.kyronis.better_mcdonalds_mod.common.BetterMcDonaldsMod;
import net.kyronis.better_mcdonalds_mod.common.world.placed_feature.BMMPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class BMMBiomeModifiers {
    private static final ResourceKey<BiomeModifier> SALT_BLOCK = registerKey("salt_block");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomeGetter = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatureGetter = context.lookup(Registries.PLACED_FEATURE);

        context.register(SALT_BLOCK, new BiomeModifiers.AddFeaturesBiomeModifier(biomeGetter.getOrThrow(Tags.Biomes.IS_AQUATIC), HolderSet.direct(placedFeatureGetter.getOrThrow(BMMPlacedFeatures.SALT_BLOCK)), GenerationStep.Decoration.RAW_GENERATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(BetterMcDonaldsMod.MOD_ID, name));
    }
}