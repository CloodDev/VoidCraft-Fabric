package clood.voidcraft.items.client;

import clood.voidcraft.items.custom.CorruptorBlockItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class CorruptorBlockItemRenderer extends GeoItemRenderer<CorruptorBlockItem> {
  public CorruptorBlockItemRenderer() {
    super(new CorruptorBlockItemModel());
  }
}
