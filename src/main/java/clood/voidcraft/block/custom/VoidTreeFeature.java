package clood.voidcraft.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.StructureWorldAccess;
import clood.voidcraft.block.ModBlocks;

public class VoidTreeFeature extends Feature<TreeFeatureConfig> {
  public VoidTreeFeature() {
    super(TreeFeatureConfig.CODEC);
  }

  @Override
  public boolean generate(FeatureContext<TreeFeatureConfig> context) {
    StructureWorldAccess world = context.getWorld();
    BlockPos pos = context.getOrigin();
    net.minecraft.util.math.random.Random random = context.getRandom();
    BlockState log = ModBlocks.VOID_LOG.getDefaultState();

    // Generate a twisted, Duviri-style trunk
    int height = 7 + random.nextInt(5);
    double angle = random.nextDouble() * Math.PI * 2;
    double twist = 0.4 + random.nextDouble() * 0.6;
    BlockPos.Mutable mutable = pos.mutableCopy();
    for (int y = 0; y < height; y++) {
      double radius = Math.sin(y * twist) * 2.0;
      int dx = (int) Math.round(Math.cos(angle + y * twist) * radius);
      int dz = (int) Math.round(Math.sin(angle + y * twist) * radius);
      mutable.set(pos.getX() + dx, pos.getY() + y, pos.getZ() + dz);
      world.setBlockState(mutable, log, 3);
    }
    // Optionally add arching branches or roots here
    return true;
  }
}
