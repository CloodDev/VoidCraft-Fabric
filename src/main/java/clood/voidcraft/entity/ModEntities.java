
package clood.voidcraft.entity;

import clood.voidcraft.VoidCraft;
import clood.voidcraft.entity.custom.VoidArmEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
  public static final EntityType<VoidArmEntity> VOID_ARM = Registry.register(Registries.ENTITY_TYPE,
      Identifier.of(VoidCraft.MOD_ID, "void_arm"),
      EntityType.Builder.create(VoidArmEntity::new, SpawnGroup.CREATURE)
          .dimensions(1f, 2.5f).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE,
              Identifier.of(VoidCraft.MOD_ID, "void_arm"))));

  public static void registerModEntities() {
    VoidCraft.LOGGER.info("Registering Mod Entities for " + VoidCraft.MOD_ID);
    FabricDefaultAttributeRegistry.register(VOID_ARM, VoidArmEntity.createAttributes());
  }
}