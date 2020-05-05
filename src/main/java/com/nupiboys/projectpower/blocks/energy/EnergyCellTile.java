package com.nupiboys.projectpower.blocks.energy;

import net.minecraft.util.Direction;
import net.minecraft.world.World;

import com.nupiboys.projectpower.blocks.ITiles;
import com.nupiboys.projectpower.blocks.Tier;
import com.nupiboys.projectpower.blocks.TileBase;
import com.nupiboys.projectpower.energy.SideConfig;

import javax.annotation.Nullable;

public class EnergyCellTile extends TileBase.EnergyStorage<Tier, EnergyCellBlock> {
    public EnergyCellTile(final Tier tier) {
        super(ITiles.ENERGY_CELL, tier);
    }

    public EnergyCellTile() {
        this(Tier.BASIC);
    }

    @Override
    protected void onFirstTick(final World world) {
        super.onFirstTick(world);
        if (this.isCreative()) {
            this.energy.setStored(this.defaultEnergyCapacity());
        }
    }

    @Override
    public long extractEnergy(final int maxExtract, final boolean simulate, @Nullable final Direction side) {
        return super.extractEnergy(maxExtract, isCreative(), side);
    }

    @Override
    protected boolean doEnergyTransfer() {
        return checkRedstone();
    }

    @Override
    public int getChargingSlots() {
        return 2;
    }

    @Override
    public boolean keepEnergy() {
        return !isCreative();
    }

    @Override
    public SideConfig.Type getTransferType() {
        return isCreative() ? SideConfig.Type.OUT : super.getTransferType();
    }

    public boolean isCreative() {
        return this.getVariant().equals(Tier.CREATIVE);
    }
}
