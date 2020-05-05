package com.nupiboys.projectpower.blocks;

import com.nupiboys.projectpower.energy.SideConfig;
import com.nupiboys.projectpower.util.IVariant;

public abstract class AbstractMachineBlock<T extends IVariant> extends AbstractEnergyBlock<T> {
    public AbstractMachineBlock(Properties properties, T variant) {
        super(properties, variant);
    }

    public AbstractMachineBlock(Properties properties) {
        super(properties);
    }

    @Override
    public SideConfig.Type getTransferType() {
        return SideConfig.Type.IN;
    }
}
