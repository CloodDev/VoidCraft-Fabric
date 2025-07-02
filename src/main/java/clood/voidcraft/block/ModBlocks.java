package clood.voidcraft.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import clood.voidcraft.VoidCraft;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
  public static final Block DEEPSLATE_ARGON_ORE;

  static {
    DEEPSLATE_ARGON_ORE = registerBlock("deepslate_argon_ore",
        new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(VoidCraft.MOD_ID, "deepslate_argon_ore")))));
  }

  private static Block registerBlock(String name, Block block) {
    registerBlockItem(name, block);
    return Registry.register(Registries.BLOCK, Identifier.of(VoidCraft.MOD_ID, name), block);
  }

  private static void registerBlockItem(String name, Block block) {
    Registry.register(Registries.ITEM, Identifier.of(VoidCraft.MOD_ID, name),
        new BlockItem(block,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(VoidCraft.MOD_ID, name)))));
  }

  public static void registerModBlocks() {
    VoidCraft.LOGGER.info("Registering Blocks for " + VoidCraft.MOD_ID);

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
      entries.add(ModBlocks.DEEPSLATE_ARGON_ORE);
    });
  }
}
