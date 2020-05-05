package com.nupiboys.projectpower.client.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import com.nupiboys.projectpower.blocks.TileBase;
import com.nupiboys.projectpower.inventory.EnergyContainerBase;

public class EnergyProviderScreen<T extends TileBase.EnergyProvider, C extends EnergyContainerBase<T>> extends EnergyScreen<T, C> {
    public EnergyProviderScreen(C container, PlayerInventory playerInventory, ITextComponent name) {
        super(container, playerInventory, name);
    }
}
