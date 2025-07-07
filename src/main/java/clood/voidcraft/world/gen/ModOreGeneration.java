package clood.voidcraft.world.gen;

import clood.voidcraft.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
  public static void generateOres() {
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
        ModPlacedFeatures.FERRITE_ORE_PLACED_KEY);
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
        ModPlacedFeatures.RUBEDO_ORE_PLACED_KEY);
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
        ModPlacedFeatures.ARGON_ORE_PLACED_KEY);
  }
}
