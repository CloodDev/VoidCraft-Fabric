package clood.voidcraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.WorldView;
import net.minecraft.util.math.random.Random;

public class VoidSaplingBlock extends Block {
  public VoidSaplingBlock(Settings settings) {
    super(settings);
  }

  public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
    // Vanilla big oak: 2x2 trunk, large branches, and a canopy
    int trunkHeight = 3 + random.nextInt(3); // 3-5 (shorter trunk)
    // Build 1x1 trunk
    for (int y = 0; y < trunkHeight; y++) {
      BlockPos logPos = pos.up(y);
      world.setBlockState(logPos, clood.voidcraft.block.ModBlocks.VOID_LOG.getDefaultState());
    }
    // Generate large branches
    int branches = 4 + random.nextInt(2); // 4-5
    for (int i = 0; i < branches; i++) {
      double angle = (2 * Math.PI / branches) * i + random.nextDouble() * 0.3;
      int branchLen = 8 + random.nextInt(5); // 8-12 (longer branches)
      int baseY = 1 + random.nextInt(trunkHeight); // start low on trunk
      BlockPos branchStart = pos.add(0, baseY, 0);
      BlockPos branchPos = branchStart;
      for (int b = 0; b < branchLen; b++) {
        int dx = (int) Math.round(Math.cos(angle) * b * 0.5); // less horizontal
        int dz = (int) Math.round(Math.sin(angle) * b * 0.5);
        branchPos = branchStart.add(dx, b, dz); // more vertical
        world.setBlockState(branchPos, clood.voidcraft.block.ModBlocks.VOID_LOG.getDefaultState());
      }
    }
    // Replace original sapling with log
    world.setBlockState(pos, clood.voidcraft.block.ModBlocks.VOID_LOG.getDefaultState());
  }

  public VoxelShape getOutlineShape(BlockState state, WorldView world, BlockPos pos, ShapeContext context) {
    return VoxelShapes.cuboid(0.3, 0.0, 0.3, 0.7, 0.8, 0.7);
  }

  @Override
  public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
    // Allow placement if any adjacent block (except air) is present in any
    // direction
    for (Direction dir : Direction.values()) {
      if (!world.getBlockState(pos.offset(dir)).isAir()) {
        return true;
      }
    }
    return false;
  }
}
