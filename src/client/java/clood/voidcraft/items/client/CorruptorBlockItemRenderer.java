package clood.voidcraft.items.client;

import clood.voidcraft.items.custom.CorruptorBlockItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class CorruptorBlockItemRenderer extends GeoItemRenderer<CorruptorBlockItem> {
  public CorruptorBlockItemRenderer() {
    super(new CorruptorBlockItemModel());
    // Add the same glow layer as the block entity
    addRenderLayer(new AutoGlowingGeoLayer<>(this));
  }
}
