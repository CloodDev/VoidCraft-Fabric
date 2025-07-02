package clood.voidcraft.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import clood.voidcraft.VoidCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ARGON_CRYSTAL = registerItem("argon_crystal", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(VoidCraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        VoidCraft.LOGGER.info("Registering Items for " + VoidCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ARGON_CRYSTAL);
        });
    }
}