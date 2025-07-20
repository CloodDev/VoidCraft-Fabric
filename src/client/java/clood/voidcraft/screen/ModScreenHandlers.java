package clood.voidcraft.screen;

import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
  public static ExtendedScreenHandlerType<CorruptorScreenHandler, CorruptorScreenHandler.Data> CORRUPTOR;

  // Custom PacketCodec for BlockPos
  public static final PacketCodec<RegistryByteBuf, BlockPos> BLOCK_POS_CODEC = new PacketCodec<>() {
    @Override
    public void encode(RegistryByteBuf buf, BlockPos value) {
      buf.writeInt(value.getX());
      buf.writeInt(value.getY());
      buf.writeInt(value.getZ());
    }

    @Override
    public BlockPos decode(RegistryByteBuf buf) {
      int x = buf.readInt();
      int y = buf.readInt();
      int z = buf.readInt();
      return new BlockPos(x, y, z);
    }
  };

  public static final PacketCodec<RegistryByteBuf, CorruptorScreenHandler.Data> DATA_CODEC = PacketCodec.tuple(
      BLOCK_POS_CODEC,
      (CorruptorScreenHandler.Data data) -> data.pos,
      (BlockPos pos) -> new CorruptorScreenHandler.Data(pos));

  public static void registerAllScreenHandlers() {
    CORRUPTOR = new ExtendedScreenHandlerType<>(
        (syncId, inventory, data) -> {
          net.minecraft.world.World world = inventory.player.getWorld();
          net.minecraft.block.entity.BlockEntity be = world.getBlockEntity(data.pos);
          Inventory inv;
          if (be instanceof Inventory) {
            inv = (Inventory) be;
          } else {
            // Fallback to a simple inventory with 13 slots if block entity is missing or
            // invalid
            inv = new net.minecraft.inventory.SimpleInventory(13);
          }
          return new CorruptorScreenHandler(syncId, inventory, inv, null);
        },
        DATA_CODEC);
    Registry.register(Registries.SCREEN_HANDLER, Identifier.of("voidcraft", "corruptor"), CORRUPTOR);
  }
}
