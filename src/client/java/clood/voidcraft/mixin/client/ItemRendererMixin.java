package clood.voidcraft.mixin.client;

import clood.voidcraft.items.ArgonCrystalItem;
import clood.voidcraft.client.renderer.ArgonCrystalItemRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.geckolib.util.RenderUtil;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
  private static final ArgonCrystalItemRenderer ARGON_CRYSTAL_RENDERER = new ArgonCrystalItemRenderer();

  @Inject(method = "renderItem", at = @At("HEAD"), cancellable = true)
  private void renderGeoItem(ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded,
      MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel model,
      CallbackInfo ci) {
    if (stack.getItem() instanceof ArgonCrystalItem item) {
      // Create RenderData from ItemStack
      var renderData = RenderUtil.createItemRenderData(stack, renderMode);
      ARGON_CRYSTAL_RENDERER.render(renderData, renderMode, matrices, vertexConsumers, light, overlay, leftHanded);
      ci.cancel();
    }
  }
}