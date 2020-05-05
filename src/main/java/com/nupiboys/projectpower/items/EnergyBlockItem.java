package com.nupiboys.projectpower.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import com.nupiboys.projectpower.blocks.AbstractEnergyBlock;
import com.nupiboys.projectpower.config.IEnergyConfig;
import com.nupiboys.projectpower.energy.Energy;
import com.nupiboys.projectpower.energy.SideConfig;
import com.nupiboys.projectpower.util.IVariant;

import javax.annotation.Nullable;

public class EnergyBlockItem<E extends IVariant, T extends AbstractEnergyBlock<E>> extends BlockItemBase<E, T> {
    public EnergyBlockItem(T block, Properties properties, @Nullable ItemGroup group) {
        super(block, properties, group);
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        IEnergyConfig config = getBlock().getEnergyConfig();
        long ext = getTransferType().isOut() ? config.getTransfer(getVariant()) : 0L;
        long rec = getTransferType().isIn() ? config.getTransfer(getVariant()) : 0L;
        return new Energy.Item.Provider(stack, config.getCapacity(getVariant()), ext, rec);
    }

    public IEnergyConfig<E> getEnergyConfig() {
        return getBlock().getEnergyConfig();
    }

    public SideConfig.Type getTransferType() {
        return getBlock().getTransferType();
    }
}
