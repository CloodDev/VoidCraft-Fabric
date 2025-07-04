package clood.voidcraft.block.entity;

import clood.voidcraft.VoidCraft;
import clood.voidcraft.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
  public static BlockEntityType<CorruptorBlockEntity> CORRUPTOR;

  public static void registerBlockEntities() {
    CORRUPTOR = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(VoidCraft.MOD_ID, "corruptor"),
        FabricBlockEntityTypeBuilder.create(CorruptorBlockEntity::new, ModBlocks.CORRUPTOR).build());
  }
}
