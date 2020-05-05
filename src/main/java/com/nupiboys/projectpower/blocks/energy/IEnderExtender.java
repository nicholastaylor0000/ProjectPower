package com.nupiboys.projectpower.blocks.energy;

import net.minecraft.item.ItemStack;

public interface IEnderExtender {
    long getExtendedCapacity(ItemStack stack);

    long getExtendedEnergy(ItemStack stack);
}
