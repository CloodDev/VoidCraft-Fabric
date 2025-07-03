package clood.voidcraft;

import clood.voidcraft.entity.ModEntities;
import clood.voidcraft.entity.client.VoidArmRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class VoidCraftClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Register entity renderers
		EntityRendererRegistry.register(ModEntities.VOID_ARM, VoidArmRenderer::new);
	}
}