package com.nupiboys.projectpower.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import com.nupiboys.projectpower.blocks.Tier;
import com.nupiboys.projectpower.blocks.energy.EnergyCellBlock;
import com.nupiboys.projectpower.blocks.energy.IEnderExtender;
import com.nupiboys.projectpower.energy.Energy;

import javax.annotation.Nullable;

public class EnergyCellItem extends EnergyBlockItem<Tier, EnergyCellBlock> implements IEnderExtender {
    public EnergyCellItem(EnergyCellBlock block, Properties properties, @Nullable ItemGroup group) {
        super(block, properties, group);
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        if (!getVariant().equals(Tier.CREATIVE)) {
            return super.initCapabilities(stack, nbt);
        }
        return null;
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        if (getVariant().equals(Tier.CREATIVE)) {
            return Rarity.EPIC;
        }
        return super.getRarity(stack);
    }

    @Override
    public long getExtendedCapacity(ItemStack stack) {
        return getEnergyConfig().getCapacity(getVariant());
    }

    @Override
    public long getExtendedEnergy(ItemStack stack) {
        return Energy.getStored(stack);
    }
}
