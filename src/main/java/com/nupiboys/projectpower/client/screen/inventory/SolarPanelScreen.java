package com.nupiboys.projectpower.client.screen.inventory;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.nupiboys.projectpower.blocks.energy.SolarPanelTile;
import com.nupiboys.projectpower.client.screen.EnergyScreen;
import com.nupiboys.projectpower.inventory.SolarPanelContainer;

@OnlyIn(Dist.CLIENT)
public class SolarPanelScreen extends EnergyScreen<SolarPanelTile, SolarPanelContainer> {
    public SolarPanelScreen(SolarPanelContainer container, PlayerInventory playerInventory, ITextComponent name) {
        super(container, playerInventory, name);
    }
}
