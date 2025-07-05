package clood.voidcraft.block.client;

import clood.voidcraft.VoidCraft;
import clood.voidcraft.block.entity.CorruptorBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;

import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class CorruptorBlockModel extends GeoModel<CorruptorBlockEntity> {
  @Override
  public Identifier getModelResource(CorruptorBlockEntity corruptorBlockEntity,
      @Nullable GeoRenderer<CorruptorBlockEntity> geoRenderer) {
    return Identifier.of(VoidCraft.MOD_ID, "geo/corruptor.geo.json");
  }

  @Override
  public Identifier getTextureResource(CorruptorBlockEntity corruptorBlockEntity,
      @Nullable GeoRenderer<CorruptorBlockEntity> geoRenderer) {
    return Identifier.of(VoidCraft.MOD_ID, "textures/block/corruptor.png");
  }

  @Override
  public Identifier getAnimationResource(CorruptorBlockEntity animatable) {
    return Identifier.of(VoidCraft.MOD_ID, "animations/corruptor.animation.json");
  }

  @Override
  public void setCustomAnimations(CorruptorBlockEntity animatable, long instanceId,
      AnimationState<CorruptorBlockEntity> animationState) {
    super.setCustomAnimations(animatable, instanceId, animationState);

    GeoBone targetBone = getAnimationProcessor().getBone("Eye"); // Replace with your bone name
    if (targetBone == null)
      return;

    // Get nearest player
    World world = animatable.getWorld();
    if (world == null || world.isClient() == false)
      return;

    PlayerEntity player = world.getClosestPlayer(animatable.getPos().getX(), animatable.getPos().getY(),
        animatable.getPos().getZ(), 64, false);
    if (player == null)
      return;

    // Get relative yaw and pitch between block and player
    Vec3d blockCenter = Vec3d.ofCenter(animatable.getPos());
    Vec3d playerEyePos = player.getCameraPosVec(1.0F);
    playerEyePos = playerEyePos.subtract(0, 1, 0); // Adjust for eye height
    Vec3d delta = playerEyePos.subtract(blockCenter);
    double yaw = Math.atan2(delta.z, delta.x);
    double pitch = Math.asin(delta.y / delta.length());

    // Apply rotation to the bone (flip if needed depending on model orientation)
    targetBone.setRotY((float) (-(yaw - Math.toRadians(90)))); // Yaw is horizontal (left-right)
    targetBone.setRotX((float) (-pitch)); // Pitch is vertical (up-down)
  }
}