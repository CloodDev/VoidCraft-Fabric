package clood.voidcraft.block.client;

import clood.voidcraft.VoidCraft;
import clood.voidcraft.block.entity.CorruptorBlockEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class CorruptorBlockModel extends GeoModel<CorruptorBlockEntity> {
  @Override
  public Identifier getModelResource(CorruptorBlockEntity corruptorBlockEntity, @Nullable GeoRenderer<CorruptorBlockEntity> geoRenderer) {
    return Identifier.of(VoidCraft.MOD_ID, "geo/corruptor.geo.json");
  }

  @Override
  public Identifier getTextureResource(CorruptorBlockEntity corruptorBlockEntity, @Nullable GeoRenderer<CorruptorBlockEntity> geoRenderer) {
    return Identifier.of(VoidCraft.MOD_ID, "textures/block/corruptor.png");
  }

  @Override
  public Identifier getAnimationResource(CorruptorBlockEntity animatable) {
    return Identifier.of(VoidCraft.MOD_ID, "animations/corruptor.animation.json");
  }
}