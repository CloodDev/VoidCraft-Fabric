package clood.voidcraft.entity.client;

import clood.voidcraft.VoidCraft;
import clood.voidcraft.entity.custom.VoidArmEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class VoidArmRenderer extends GeoEntityRenderer<VoidArmEntity> {
    public VoidArmRenderer(EntityRendererFactory.Context context) {
        super(context, new VoidArmModel());
        this.shadowRadius = 0.0f;
    }

    @Override
    public Identifier getTextureLocation(VoidArmEntity animatable) {
        return Identifier.of(VoidCraft.MOD_ID, "textures/entity/void_arm/void_arm.png");
    }

}