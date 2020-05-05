package com.nupiboys.projectpower.client.screen.inventory;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.nupiboys.projectpower.blocks.energy.EnergyCellTile;
import com.nupiboys.projectpower.client.screen.EnergyScreen;
import com.nupiboys.projectpower.inventory.EnergyCellContainer;

@OnlyIn(Dist.CLIENT)
public class EnergyCellScreen extends EnergyScreen<EnergyCellTile, EnergyCellContainer> {
    public EnergyCellScreen(EnergyCellContainer container, PlayerInventory playerInventory, ITextComponent name) {
        super(container, playerInventory, name);
    }
}
