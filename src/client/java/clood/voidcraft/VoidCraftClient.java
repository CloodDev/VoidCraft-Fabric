package clood.voidcraft;

import clood.voidcraft.block.client.CorruptorBlockRenderer;
import clood.voidcraft.block.entity.ModBlockEntities;
import clood.voidcraft.entity.ModEntities;
import clood.voidcraft.entity.client.VoidArmRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class VoidCraftClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.VOID_ARM, VoidArmRenderer::new);
		BlockEntityRendererFactories.register(ModBlockEntities.CORRUPTOR, CorruptorBlockRenderer::new);

		// Register GeoItem renderer for CorruptorBlockItem
		// In GeckoLib 4, items implementing GeoItem are automatically rendered
		// The renderer is detected through reflection/annotation processing
		// No manual registration needed as long as the item implements GeoItem properly
		// and the renderer class exists in the correct package structure
	}
}