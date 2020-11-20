package AOChips.ArmorUp.client.gui;

import AOChips.ArmorUp.containers.ForgingTableContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.AbstractRepairScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.SmithingTableContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ForgingTableScreen extends AbstractRepairScreen<ForgingTableContainer> {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("textures/gui/container/smithing.png");

    public ForgingTableScreen(ForgingTableContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, playerInventory, title, GUI_TEXTURE);
        this.titleX = 60;
        this.titleY = 18;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack,mouseX,mouseY);
    }


    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        RenderSystem.disableBlend();
        super.drawGuiContainerForegroundLayer(matrixStack, x, y);
    }
}

