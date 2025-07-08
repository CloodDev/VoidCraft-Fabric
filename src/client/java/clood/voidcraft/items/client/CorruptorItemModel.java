package clood.voidcraft.items.client;

import clood.voidcraft.VoidCraft;
import clood.voidcraft.items.custom.CorruptorBlockItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class CorruptorItemModel extends GeoModel<CorruptorBlockItem> {
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

    @Override
    public void setCustomAnimations(CorruptorBlockItem animatable, long instanceId, AnimationState<CorruptorBlockItem> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);

        GeoBone targetBone = getAnimationProcessor().getBone("Eye");
        if (targetBone == null)
            return;

        MinecraftClient client = MinecraftClient.getInstance();
        if (client.world == null || !client.world.isClient())
            return;

        PlayerEntity player = client.player;
        if (player == null)
            return;

        // For items, we'll use the player's position as the reference point for the eye tracking
        Vec3d itemCenter = player.getEyePos();
        Vec3d playerLookDirection = player.getRotationVec(1.0F);
        Vec3d lookTarget = itemCenter.add(playerLookDirection.multiply(5.0));

        Vec3d delta = lookTarget.subtract(itemCenter);
        double yaw = Math.atan2(delta.z, delta.x);
        double pitch = Math.asin(delta.y / delta.length());

        targetBone.setRotY((float) (-(yaw - Math.toRadians(90))));
        targetBone.setRotX((float) (-pitch));
    }
}
