package clood.voidcraft;

import clood.voidcraft.block.ModBlocks;
import clood.voidcraft.items.ModItemGroups;
import clood.voidcraft.items.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VoidCraft implements ModInitializer {
	public static final String MOD_ID = "voidcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}