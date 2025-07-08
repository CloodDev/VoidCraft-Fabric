package clood.voidcraft.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import java.util.function.Function;

import clood.voidcraft.VoidCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item ARGON_CRYSTAL = register("argon_crystal", Item::new, new Item.Settings());
    public static final Item RUBEDO = register("rubedo", Item::new, new Item.Settings());
    public static final Item RAW_FERRITE = register("raw_ferrite", Item::new, new Item.Settings());
    public static final Item FERRITE = register("ferrite", Item::new, new Item.Settings());
    public static final Item VOID_DUST = register("void_dust", Item::new, new Item.Settings());
    // CORRUPTOR_ITEM removed - now using the block's item with GeckoLib rendering
    // public static final Item CORRUPTOR_ITEM = register("corruptor_item",
    // CorruptorItem::new, new Item.Settings());

    private static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final Identifier identifier = Identifier.of(VoidCraft.MOD_ID, path);
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, identifier);

        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        VoidCraft.LOGGER.info("Registering Items for " + VoidCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ARGON_CRYSTAL);
        });
    }
}