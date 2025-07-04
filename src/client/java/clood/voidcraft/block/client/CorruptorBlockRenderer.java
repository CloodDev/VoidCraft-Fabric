package clood.voidcraft.block.client;

import clood.voidcraft.block.entity.CorruptorBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class CorruptorBlockRenderer extends GeoBlockRenderer<CorruptorBlockEntity> {
    public CorruptorBlockRenderer(BlockEntityRendererFactory.Context context) {
        super(new CorruptorBlockModel());
    }
};