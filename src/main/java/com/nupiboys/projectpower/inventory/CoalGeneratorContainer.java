package com.nupiboys.projectpower.inventory;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;

import com.nupiboys.projectpower.blocks.energy.CoalGeneratorTile;
import com.nupiboys.projectpower.inventory.slot.SlotBase;
import com.nupiboys.projectpower.inventory.slot.SlotOverlay;

import javax.annotation.Nullable;

public class CoalGeneratorContainer extends EnergyContainerBase<CoalGeneratorTile> {
    public CoalGeneratorContainer(@Nullable ContainerType<?> containerType, int id, PlayerInventory playerInventory, PacketBuffer buffer) {
        super(containerType, id, playerInventory, buffer);
    }

    public CoalGeneratorContainer(@Nullable ContainerType<?> containerType, int id, PlayerInventory playerInventory, CoalGeneratorTile tile) {
        super(containerType, id, playerInventory, tile);
    }

    public static CoalGeneratorContainer create(int i, PlayerInventory playerInventory, PacketBuffer buffer) {
        return new CoalGeneratorContainer(IContainers.COAL_GENERATOR, i, playerInventory, buffer);
    }

    @Override
    protected void addContainer(PlayerInventory playerInventory, CoalGeneratorTile te) {
        addSlot(new SlotBase(te.getInventory(), te.builtInSlots(), 85, 17).bg(SlotOverlay.SLOT));
        super.addContainer(playerInventory, te);
    }
}
