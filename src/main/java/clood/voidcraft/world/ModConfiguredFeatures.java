package clood.voidcraft.world;

import clood.voidcraft.VoidCraft;
import clood.voidcraft.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
  public static final RegistryKey<ConfiguredFeature<?, ?>> FERRITE_ORE_KEY = registerKey("ferrite_ore");
  public static final RegistryKey<ConfiguredFeature<?, ?>> RUBEDO_ORE_KEY = registerKey("rubedo_ore");
  public static final RegistryKey<ConfiguredFeature<?, ?>> ARGON_ORE_KEY = registerKey("argon_ore");

  public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
    RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    List<OreFeatureConfig.Target> overworldFerriteOres = List.of(
        OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.FERRITE_ORE.getDefaultState()),
        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_FERRITE_ORE.getDefaultState()));
    List<OreFeatureConfig.Target> overworldRubedoOres = List.of(
        OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.RUBEDO_ORE.getDefaultState()),
        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_RUBEDO_ORE.getDefaultState()));
    List<OreFeatureConfig.Target> overworldArgonOres = List.of(
        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_ARGON_ORE.getDefaultState()));
    register(context, ARGON_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldArgonOres, 3));
    register(context, RUBEDO_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldRubedoOres, 6));
    register(context, FERRITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldFerriteOres, 9));
  }

  public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
    return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(VoidCraft.MOD_ID, name));
  }

  private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
      Registerable<ConfiguredFeature<?, ?>> context,
      RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
    context.register(key, new ConfiguredFeature<>(feature, configuration));
  }
}
