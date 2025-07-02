package clood.voidcraft.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import java.util.function.Function;

import clood.voidcraft.VoidCraft;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlocks {
  public static final Block DEEPSLATE_ARGON_ORE = register("deepslate_argon_ore", Block::new,
      AbstractBlock.Settings.create().strength(4.0f));
  public static final Block ARGON_CRYSTAL_BLOCK = register("argon_crystal_block", Block::new,
      AbstractBlock.Settings.create().strength(5.0f));

  private static Block register(String path, Function<AbstractBlock.Settings, Block> factory,
      AbstractBlock.Settings settings) {
    final Identifier identifier = Identifier.of(VoidCraft.MOD_ID, path);
    final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

    final Block block = Blocks.register(registryKey, factory, settings);
    Items.register(block);
    return block;
  }

  public static void registerModBlocks() {
    VoidCraft.LOGGER.info("Registering Blocks for " + VoidCraft.MOD_ID);

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
      entries.add(ModBlocks.DEEPSLATE_ARGON_ORE);
    });
  }
}
