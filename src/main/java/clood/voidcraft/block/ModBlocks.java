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
import clood.voidcraft.block.custom.CorruptorBlock;

public class ModBlocks {
  public static final Block DEEPSLATE_ARGON_ORE = registerBlock("deepslate_argon_ore", Block::new,
      AbstractBlock.Settings.create().strength(4.5f).requiresTool());
  public static final Block ARGON_CRYSTAL_BLOCK = registerBlock("argon_crystal_block", Block::new,
      AbstractBlock.Settings.create().strength(3.0f).requiresTool());
  public static final Block FERRITE_ORE = registerBlock("ferrite_ore", Block::new,
      AbstractBlock.Settings.create().strength(3.0f).requiresTool());
  public static final Block RUBEDO_ORE = registerBlock("rubedo_ore", Block::new,
      AbstractBlock.Settings.create().strength(3.0f).requiresTool());
  public static final Block CORRUPTOR = registerBlock("corruptor", settings -> new CorruptorBlock(settings),
      AbstractBlock.Settings.create().strength(2.5f));
  public static final Block DEEPSLATE_FERRITE_ORE = registerBlock("deepslate_ferrite_ore", Block::new,
      AbstractBlock.Settings.create().strength(4.5f).requiresTool());
  public static final Block DEEPSLATE_RUBEDO_ORE = registerBlock("deepslate_rubedo_ore", Block::new,
      AbstractBlock.Settings.create().strength(4.5f).requiresTool());

  private static Block registerBlock(String path, Function<AbstractBlock.Settings, Block> factory,
      AbstractBlock.Settings settings) {
    final Identifier identifier = Identifier.of(VoidCraft.MOD_ID, path);
    final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

    final Block block = Blocks.register(registryKey, factory, settings);
    Items.register(block);

    return block;
  }

  public static void registerModBlocks() {
    VoidCraft.LOGGER.info("Registering Blocks for " + VoidCraft.MOD_ID);

    // Add blocks to item group
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
      entries.add(DEEPSLATE_ARGON_ORE);
      entries.add(ARGON_CRYSTAL_BLOCK);
    });
  }
}
