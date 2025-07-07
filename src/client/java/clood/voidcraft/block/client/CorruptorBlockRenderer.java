package clood.voidcraft.block.client;

import clood.voidcraft.block.entity.CorruptorBlockEntity;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class CorruptorBlockRenderer extends GeoBlockRenderer<CorruptorBlockEntity> {
    public CorruptorBlockRenderer(BlockEntityRendererFactory.Context context) {
        super(new CorruptorBlockModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    @Override
    public void render(CorruptorBlockEntity blockEntity, float partialTick, MatrixStack poseStack,
            VertexConsumerProvider bufferSource, int packedLight, int packedOverlay) {

        World world = blockEntity.getWorld();
        BlockPos pos = blockEntity.getPos();

        int light = packedLight;
        if (world != null) {
            int blockLight = world.getLightLevel(LightType.BLOCK, pos);
            int skyLight = world.getLightLevel(LightType.SKY, pos);
            light = LightmapTextureManager.pack(blockLight, skyLight);
        }

        super.render(blockEntity, partialTick, poseStack, bufferSource, light, packedOverlay);
    }
}