package com.nupiboys.projectpower.client.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import com.nupiboys.projectpower.blocks.TileBase;
import com.nupiboys.projectpower.inventory.ContainerBase;

public class TileContainerScreen<T extends TileBase, C extends ContainerBase<T>> extends ContainerScreenBase<C> {
    protected final T te;

    public TileContainerScreen(C container, PlayerInventory playerInventory, ITextComponent name) {
        super(container, playerInventory, name);
        this.te = container.getTile();
    }
}
