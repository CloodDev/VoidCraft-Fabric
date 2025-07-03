package clood.voidcraft.entity.client;

import clood.voidcraft.VoidCraft;
import clood.voidcraft.entity.custom.VoidArmEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.Animation;

public class VoidArmModel extends GeoModel<VoidArmEntity> {
    private static final Identifier MODEL_RESOURCE = Identifier.of(VoidCraft.MOD_ID, "geo/void_arm.geo.json");
    private static final Identifier TEXTURE_RESOURCE = Identifier.of(VoidCraft.MOD_ID,
            "textures/entity/void_arm/void_arm.png");
    private static final Identifier ANIMATION_RESOURCE = Identifier.of(VoidCraft.MOD_ID,
            "animations/void_arm.animation.json");

    @Override
    public Identifier getModelResource(VoidArmEntity animatable, GeoRenderer<VoidArmEntity> renderer) {
        return MODEL_RESOURCE;
    }

    @Override
    public Identifier getTextureResource(VoidArmEntity animatable, GeoRenderer<VoidArmEntity> renderer) {
        return TEXTURE_RESOURCE;
    }

    @Override
    public Identifier getAnimationResource(VoidArmEntity animatable) {
        return ANIMATION_RESOURCE;
    }

    @Override
    public void setCustomAnimations(VoidArmEntity animatable, long instanceId,
            AnimationState<VoidArmEntity> animationState) {
    }

}
