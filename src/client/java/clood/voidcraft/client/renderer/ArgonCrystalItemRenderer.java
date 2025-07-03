package clood.voidcraft.client.renderer;

import clood.voidcraft.client.model.ArgonCrystalItemModel;
import clood.voidcraft.items.ArgonCrystalItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ArgonCrystalItemRenderer extends GeoItemRenderer<ArgonCrystalItem> {
  public ArgonCrystalItemRenderer() {
    super(new ArgonCrystalItemModel());
  }
}
