package clood.voidcraft.client.model;

import clood.voidcraft.items.ArgonCrystalItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class ArgonCrystalItemModel extends GeoModel<ArgonCrystalItem> {
  private static final Identifier MODEL_LOCATION = Identifier.of("voidcraft", "geo/item/argon_crystal.geo.json");
  private static final Identifier TEXTURE_LOCATION = Identifier.of("voidcraft", "textures/item/argon_crystal.png");
  private static final Identifier ANIMATION_LOCATION = Identifier.of("voidcraft",
      "animations/argon_crystal.animation.json");

  @Override
  public Identifier getModelResource(ArgonCrystalItem animatable, GeoRenderer<ArgonCrystalItem> renderer) {
    return MODEL_LOCATION;
  }

  @Override
  public Identifier getTextureResource(ArgonCrystalItem animatable, GeoRenderer<ArgonCrystalItem> renderer) {
    return TEXTURE_LOCATION;
  }

  @Override
  public Identifier getAnimationResource(ArgonCrystalItem animatable) {
    return ANIMATION_LOCATION;
  }
}
