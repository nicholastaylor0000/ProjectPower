package com.nupiboys.projectpower.energy;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;


public class EnergyCapability {
	
	@CapabilityInject(IElectricity.class)
    public static Capability<IElectricity> ENERGY = null;

    public static void register()
    {
        CapabilityManager.INSTANCE.register(IElectricity.class, new IStorage<IElectricity>()
        {
            @Override
            public INBT writeNBT(Capability<IElectricity> capability, IElectricity instance, Direction side)
            {
                return IntNBT.valueOf(instance.getEnergyStored());
            }

            @Override
            public void readNBT(Capability<IElectricity> capability, IElectricity instance, Direction side, INBT nbt)
            {
                if (!(instance instanceof EnergyStorage))
                    throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
                ((Electricity)instance).energy = ((IntNBT)nbt).getInt();
            }
        },
        () -> new Electricity(1000));
    }
    
}
