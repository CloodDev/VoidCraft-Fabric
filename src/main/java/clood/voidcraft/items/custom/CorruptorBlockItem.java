package clood.voidcraft.items.custom;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class CorruptorBlockItem extends BlockItem implements GeoAnimatable {
  private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

  public CorruptorBlockItem(Block block, Settings settings) {
    super(block, settings);
  }

  @Override
  public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
  }

  private PlayState predicate(AnimationState<CorruptorBlockItem> state) {
    state.getController().setAnimation(RawAnimation.begin().thenLoop("idle"));
    return PlayState.CONTINUE;
  }

  @Override
  public AnimatableInstanceCache getAnimatableInstanceCache() {
    return cache;
  }

  @Override
  public double getTick(Object object) {
    return 1.0;
  }
}
