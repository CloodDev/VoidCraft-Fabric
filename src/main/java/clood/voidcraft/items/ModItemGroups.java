package clood.voidcraft.items;

import clood.voidcraft.VoidCraft;
import clood.voidcraft.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.text.Text;

public class ModItemGroups {

  public static final ItemGroup VOIDCRAFT_GROUP = Registry.register(Registries.ITEM_GROUP,
      Identifier.of(VoidCraft.MOD_ID, "voidcraft"),
      FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ARGON_CRYSTAL))
          .displayName(Text.translatable("itemgroup.voidcraft.group"))
          .entries((context, entries) -> {
            entries.add(new ItemStack(ModItems.RAW_FERRITE));
            entries.add(new ItemStack(ModItems.ARGON_CRYSTAL));
            entries.add(new ItemStack(ModItems.RUBEDO));
            entries.add(new ItemStack(ModItems.FERRITE));
            entries.add(new ItemStack(ModItems.VOID_DUST));
            entries.add(new ItemStack(ModBlocks.CORRUPTOR.asItem())); // Use the GeckoLib item
            entries.add(new ItemStack(ModBlocks.FERRITE_ORE));
            entries.add(new ItemStack(ModBlocks.RUBEDO_ORE));
            entries.add(new ItemStack(ModBlocks.DEEPSLATE_FERRITE_ORE));
            entries.add(new ItemStack(ModBlocks.DEEPSLATE_RUBEDO_ORE));
            entries.add(new ItemStack(ModBlocks.DEEPSLATE_ARGON_ORE));
            entries.add(new ItemStack(ModBlocks.ARGON_CRYSTAL_BLOCK));
            entries.add(new ItemStack(ModBlocks.VOID_LOG));
            entries.add(new ItemStack(ModBlocks.VOID_SAPLING));
          })
          .build());

  public static void registerItemGroups() {
    VoidCraft.LOGGER.info("Registering Item Groups for " + VoidCraft.MOD_ID);
  }
}
