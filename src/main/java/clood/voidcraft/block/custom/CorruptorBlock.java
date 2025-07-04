package clood.voidcraft.block.custom;

import com.mojang.serialization.MapCodec;
import org.jetbrains.annotations.Nullable;

import clood.voidcraft.block.entity.CorruptorBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class CorruptorBlock extends BlockWithEntity {
  public CorruptorBlock(Settings settings) {
    super(settings);
  }

  @Override
  protected MapCodec<? extends BlockWithEntity> getCodec() {
    return null;
  }

  @Nullable
  @Override
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new CorruptorBlockEntity(pos, state);
  }

  @Override
  public BlockRenderType getRenderType(BlockState state) {
    return BlockRenderType.INVISIBLE;
  }
}
