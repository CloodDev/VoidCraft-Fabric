package clood.voidcraft.items.client;

import clood.voidcraft.VoidCraft;
import clood.voidcraft.items.custom.CorruptorBlockItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class CorruptorBlockItemModel extends GeoModel<CorruptorBlockItem> {
  @Override
  public Identifier getModelResource(CorruptorBlockItem animatable, GeoRenderer<CorruptorBlockItem> renderer) {
    return Identifier.of(VoidCraft.MOD_ID, "geo/corruptor.geo.json");
  }

  @Override
  public Identifier getTextureResource(CorruptorBlockItem animatable, GeoRenderer<CorruptorBlockItem> renderer) {
    return Identifier.of(VoidCraft.MOD_ID, "textures/block/corruptor.png");
  }

  @Override
  public Identifier getAnimationResource(CorruptorBlockItem animatable) {
    return Identifier.of(VoidCraft.MOD_ID, "animations/corruptor.animation.json");
  }
}
