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
            entries.add(new ItemStack(ModItems.ARGON_CRYSTAL));
            entries.add(new ItemStack(ModBlocks.DEEPSLATE_ARGON_ORE));
          })
          .build());

  public static void registerItemGroups() {
    VoidCraft.LOGGER.info("Registering Item Groups for " + VoidCraft.MOD_ID);
  }
}
