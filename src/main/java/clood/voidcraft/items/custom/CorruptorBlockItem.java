package clood.voidcraft.items.custom;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.RenderUtil;

import java.util.List;

public class CorruptorBlockItem extends BlockItem implements GeoItem {
  private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

  public CorruptorBlockItem(Block block, Settings settings) {
    super(block, settings);
  }

  @Override
  public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
  }

  private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> event) {
    event.getController().setAnimation(RawAnimation.begin().thenLoop("animation.corruptor.spin"));
    return PlayState.CONTINUE;
  }

  @Override
  public AnimatableInstanceCache getAnimatableInstanceCache() {
    return cache;
  }

  @Override
  public double getTick(Object itemStack) {
    return RenderUtil.getCurrentTick();
  }

  @Override
  public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
    tooltip.add(Text.translatable("block.voidcraft.corruptor.tooltip"));
    super.appendTooltip(stack, context, tooltip, type);
  }
}
