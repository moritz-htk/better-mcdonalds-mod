package net.kyronis.better_mcdonalds_mod.common.world.placement;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class BMMDiskPlacement {
    public static List<PlacementModifier> modifiers(CountPlacement countPlacementModifier, InSquarePlacement squarePlacementModifier, HeightmapPlacement heightmapPlacementModifier, BlockPredicateFilter blockFilterPlacementModifier, BiomeFilter biomePlacementModifier) {
        return List.of(countPlacementModifier, squarePlacementModifier, heightmapPlacementModifier, blockFilterPlacementModifier, biomePlacementModifier);
    }
}