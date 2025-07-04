package clood.voidcraft.block.client;

import clood.voidcraft.VoidCraft;
import clood.voidcraft.items.custom.CorruptorBlockItem;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class CorruptorBlockItemModel extends GeoModel<CorruptorBlockItem> {
    @Override
    public Identifier getModelResource(CorruptorBlockItem corruptorBlockItem, @Nullable GeoRenderer<CorruptorBlockItem> geoRenderer) {
        return Identifier.of(VoidCraft.MOD_ID, "geo/animated_block.geo.json");
    }

    @Override
    public Identifier getTextureResource(CorruptorBlockItem corruptorBlockItem, @Nullable GeoRenderer<CorruptorBlockItem> geoRenderer) {
        return Identifier.of(VoidCraft.MOD_ID, "textures/block/animated_block.png");
    }

    @Override
    public Identifier getAnimationResource(CorruptorBlockItem animatable) {
        return Identifier.of(VoidCraft.MOD_ID, "animations/animated_block.animation.json");
    }
}
