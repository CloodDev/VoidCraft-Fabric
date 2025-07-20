package clood.voidcraft.block.custom;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.block.Blocks;
import java.util.Optional;
import net.minecraft.util.math.random.Random;

public class VoidSaplingGenerator {
  public Optional<ConfiguredFeature<TreeFeatureConfig, ?>> getTreeFeature(Random random, boolean bees) {
    return Optional.of(new ConfiguredFeature<>(
        new VoidTreeFeature(),
        new TreeFeatureConfig.Builder(
            BlockStateProvider.of(clood.voidcraft.block.ModBlocks.VOID_LOG.getDefaultState()),
            new StraightTrunkPlacer(1, 0, 0),
            BlockStateProvider.of(Blocks.AIR.getDefaultState()),
            new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
            new TwoLayersFeatureSize(1, 0, 1)).build()));
  }
}
