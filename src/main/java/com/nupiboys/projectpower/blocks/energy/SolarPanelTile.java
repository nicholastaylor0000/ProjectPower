package com.nupiboys.projectpower.blocks.energy;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.world.World;

import com.nupiboys.projectpower.blocks.ITiles;
import com.nupiboys.projectpower.blocks.Tier;
import com.nupiboys.projectpower.blocks.TileBase;
import com.nupiboys.projectpower.util.Misc;
import com.nupiboys.projectpower.util.Time;

import javax.annotation.Nullable;

public class SolarPanelTile extends TileBase.EnergyProvider<Tier, SolarPanelBlock> {
    private boolean canSeeSunLight;

    public SolarPanelTile(Tier variant) {
        super(ITiles.SOLAR_PANEL, variant);
    }

    public SolarPanelTile() {
        this(Tier.BASIC);
    }

    @Override
    public void readSync(CompoundNBT compound) {
        super.readSync(compound);
        this.canSeeSunLight = compound.getBoolean("CanSeeSunLight");
    }

    @Override
    public CompoundNBT writeSync(CompoundNBT compound) {
        compound.putBoolean("CanSeeSunLight", this.canSeeSunLight);
        return super.writeSync(compound);
    }

    @Override
    protected boolean postTicks(World world) {
        if (isRemote()) return false;
        boolean flag = false;
        if (doWorkingTicks(world)) {
            if ((!Time.isDay(world) && this.canSeeSunLight || this.ticks % 40L == 0L)) {
                this.canSeeSunLight = Time.isDay(world) && Misc.canBlockSeeSky(world, this.pos);
                markDirtyAndSync();
            }
            if (!this.energy.isFull()) {
                if (Time.isDay(world) || this.canSeeSunLight) {
                    this.energy.produce(defaultGeneration());
                    flag = true;
                }
            }
        }
        return super.postTicks(world) || flag;
    }

    @Override
    public void onRemoved(World world, BlockState state, BlockState newState, boolean isMoving) {
        super.onRemoved(world, state, newState, isMoving);
    }

    @Override
    public int getChargingSlots() {
        return 1;
    }

    public boolean canSeeSunLight() {
        return this.canSeeSunLight;
    }

    @Override
    public boolean keepEnergy() {
        return true;
    }

    @Override
    public boolean isEnergyPresent(@Nullable Direction side) {
        return Direction.DOWN.equals(side);
    }

}
