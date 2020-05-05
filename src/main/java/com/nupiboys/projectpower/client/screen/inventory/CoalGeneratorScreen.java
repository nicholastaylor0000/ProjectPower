package com.nupiboys.projectpower.client.screen.inventory;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.nupiboys.projectpower.blocks.energy.CoalGeneratorTile;
import com.nupiboys.projectpower.client.screen.EnergyProviderScreen;
import com.nupiboys.projectpower.client.screen.widget.Gauge;
import com.nupiboys.projectpower.inventory.CoalGeneratorContainer;
import com.nupiboys.projectpower.util.Safe;

@OnlyIn(Dist.CLIENT)
public class CoalGeneratorScreen extends EnergyProviderScreen<CoalGeneratorTile, CoalGeneratorContainer> {
    private Gauge buffer = GAUGE;

    public CoalGeneratorScreen(CoalGeneratorContainer container, PlayerInventory playerInventory, ITextComponent name) {
        super(container, playerInventory, name);
    }

    @Override
    public void init(Minecraft mc, int w, int h) {
        super.init(mc, w, h);
        this.buffer = gauge(this.x + 87, this.y + 40, 11, 18, 13, 0, GUI_BUFFER)
                .setBG(this.x + 86, this.y + 39, 13, 20, 0, 0);
    }

    @Override
    protected void refreshScreen() {
        super.refreshScreen();
        if (this.buffer.isHovered()) {
            int percent = Safe.integer(this.te.getBuffer() > 0 ? (100 * this.te.getNextBuff()) / this.te.getBuffer() : 0);
            this.buffer.clearToolTip().tooltip("info.projectpower.buffer", TextFormatting.GRAY, "" + TextFormatting.DARK_GRAY + percent + "%");
        }
    }

    @Override
    protected void drawBackground(float partialTicks, int mouseX, int mouseY) {
        super.drawBackground(partialTicks, mouseX, mouseY);
        this.buffer.render(this.te.getBuffer(), this.te.getNextBuff(), mouseX, mouseY);
    }

    @Override
    protected void renderHoveredToolTip(int mouseX, int mouseY) {
        if (!this.buffer.renderToolTip(mouseX, mouseY)) {
            super.renderHoveredToolTip(mouseX, mouseY);
        }
    }
}
