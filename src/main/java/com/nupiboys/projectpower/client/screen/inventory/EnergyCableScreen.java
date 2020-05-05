package com.nupiboys.projectpower.client.screen.inventory;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.nupiboys.projectpower.ProjectPower;
import com.nupiboys.projectpower.blocks.energy.EnergyCableTile;
import com.nupiboys.projectpower.client.screen.EnergyScreen;
import com.nupiboys.projectpower.inventory.EnergyCableContainer;

@OnlyIn(Dist.CLIENT)
public class EnergyCableScreen extends EnergyScreen<EnergyCableTile, EnergyCableContainer> {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(ProjectPower.MOD_ID, "textures/gui/container/energy_cable.png");


    private Direction side;

    public EnergyCableScreen(EnergyCableContainer container, PlayerInventory playerInventory, ITextComponent name) {
        super(container, playerInventory, name);
        this.xSize = 153;
        this.ySize = 88;
        this.side = container.getSide();
    }

    @Override
    protected void refreshScreen() {
    }

    @Override
    protected void drawBackground(float partialTicks, int mouseX, int mouseY) {
        bindTexture(GUI_TEXTURE);
        blit(this.x, this.y, 0, 0, this.xSize, this.ySize);
        String s = I18n.format("info.projectpower.side." + this.side.getName(), TextFormatting.DARK_GRAY);
        int sw = this.font.getStringWidth(s);
        this.font.drawString(s, this.x + (this.xSize / 2f) - (sw / 2f), this.y + 10, 0x444444);
    }
}
