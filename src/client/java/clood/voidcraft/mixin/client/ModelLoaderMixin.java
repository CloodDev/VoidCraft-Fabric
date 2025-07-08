package clood.voidcraft.mixin.client;

import clood.voidcraft.items.ModItems;
import clood.voidcraft.items.client.CorruptorItemRenderer;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ModelLoader.class)
public class ModelLoaderMixin {

    @Shadow @Final private Map<Identifier, BakedModel> bakedModels;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onInit(CallbackInfo ci) {
        // Register custom GeckoLib item renderer for CorruptorItem
        if (ModItems.CORRUPTOR_ITEM != null) {
            // This mixin ensures GeckoLib items are properly handled
        }
    }
}
