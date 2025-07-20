package clood.voidcraft.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.inventory.Inventory;

public class CorruptorScreenHandler extends ScreenHandler {
  private final Inventory inventory;
  // Removed unused propertyDelegate field

  public CorruptorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory,
      PropertyDelegate propertyDelegate) {
    super(ModScreenHandlers.CORRUPTOR, syncId);
    this.inventory = inventory;
    for (int row = 0; row < 3; ++row) {
      for (int col = 0; col < 3; ++col) {
        this.addSlot(new net.minecraft.screen.slot.Slot(inventory, row * 3 + col, 30 + col * 18, 17 + row * 18));
      }
    }
    // 4 corner slots (slots 9-12)
    this.addSlot(new net.minecraft.screen.slot.Slot(inventory, 9, 12, 8)); // Top-left
    this.addSlot(new net.minecraft.screen.slot.Slot(inventory, 10, 84, 8)); // Top-right
    this.addSlot(new net.minecraft.screen.slot.Slot(inventory, 11, 12, 62)); // Bottom-left
    this.addSlot(new net.minecraft.screen.slot.Slot(inventory, 12, 84, 62)); // Bottom-right
    // Player inventory
    int startY = 84;
    for (int row = 0; row < 3; ++row) {
      for (int col = 0; col < 9; ++col) {
        this.addSlot(
            new net.minecraft.screen.slot.Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, startY + row * 18));
      }
    }
    // Hotbar
    for (int col = 0; col < 9; ++col) {
      this.addSlot(new net.minecraft.screen.slot.Slot(playerInventory, col, 8 + col * 18, startY + 58));
    }
  }

  @Override
  public boolean canUse(PlayerEntity player) {
    return this.inventory.canPlayerUse(player);
  }

  @Override
  public net.minecraft.item.ItemStack quickMove(PlayerEntity player, int slot) {
    // Default implementation: return empty stack
    return net.minecraft.item.ItemStack.EMPTY;
  }

  public static class Data {
    public final net.minecraft.util.math.BlockPos pos;

    public Data(net.minecraft.util.math.BlockPos pos) {
      this.pos = pos;
    }
  }
}
