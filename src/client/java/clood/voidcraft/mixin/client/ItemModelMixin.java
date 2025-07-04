package clood.voidcraft.mixin.client;

import clood.voidcraft.items.ArgonCrystalItem;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemRenderer.class)
public class ItemModelMixin {

  @Inject(method = "getModel", at = @At("HEAD"), cancellable = true)
  private void getArgonCrystalModel(ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded,
      CallbackInfoReturnable<BakedModel> cir) {
    if (stack.getItem() instanceof ArgonCrystalItem) {
      // For GeoItems, return null to let GeckoLib handle the rendering
      // This should force the use of the builtin/entity renderer
      cir.setReturnValue(null);
    }
  }
}
