package clood.voidcraft.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import java.util.List;

import clood.voidcraft.VoidCraft;

public class ModPlacedFeatures {
  public static final RegistryKey<PlacedFeature> FERRITE_ORE_PLACED_KEY = registerKey("ferrite_ore_placed");
  public static final RegistryKey<PlacedFeature> RUBEDO_ORE_PLACED_KEY = registerKey("rubedo_ore_placed");
  public static final RegistryKey<PlacedFeature> ARGON_ORE_PLACED_KEY = registerKey("argon_ore_placed");

  public static void bootstrap(Registerable<PlacedFeature> context) {
    var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

    register(context, FERRITE_ORE_PLACED_KEY,
        configuredFeatures.getOrThrow(ModConfiguredFeatures.FERRITE_ORE_KEY),
        ModOrePlacement.modifiersWithCount(20,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));
    register(context, RUBEDO_ORE_PLACED_KEY,
        configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBEDO_ORE_KEY),
        ModOrePlacement.modifiersWithCount(4,
            HeightRangePlacementModifier.uniform(YOffset.fixed(-60), YOffset.fixed(60))));
    register(context, ARGON_ORE_PLACED_KEY,
        configuredFeatures.getOrThrow(ModConfiguredFeatures.ARGON_ORE_KEY),
        ModOrePlacement.modifiersWithCount(3,
            HeightRangePlacementModifier.uniform(YOffset.fixed(-40), YOffset.fixed(40))));
  }

  public static RegistryKey<PlacedFeature> registerKey(String name) {
    return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(VoidCraft.MOD_ID, name));
  }

  private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
      RegistryEntry<ConfiguredFeature<?, ?>> configuration,
      List<PlacementModifier> modifiers) {
    context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
  }

}
