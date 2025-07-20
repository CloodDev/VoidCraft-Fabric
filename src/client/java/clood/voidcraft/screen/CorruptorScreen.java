package clood.voidcraft.screen;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class CorruptorScreen extends HandledScreen<CorruptorScreenHandler> {
  public CorruptorScreen(CorruptorScreenHandler handler, PlayerInventory inventory, Text title) {
    super(handler, inventory, title);
  }

  @Override
  protected void drawBackground(net.minecraft.client.gui.DrawContext context, float delta, int mouseX, int mouseY) {
    // Draw your custom background here
  }

  @Override
  public void render(net.minecraft.client.gui.DrawContext context, int mouseX, int mouseY, float delta) {
    super.render(context, mouseX, mouseY, delta);
    // Draw custom elements here
  }
}
