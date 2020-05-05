package com.nupiboys.projectpower.blocks;

import com.nupiboys.projectpower.config.IEnergyProviderConfig;
import com.nupiboys.projectpower.energy.SideConfig;
import com.nupiboys.projectpower.util.IVariant;

public abstract class AbstractEnergyProviderBlock<E extends IVariant> extends AbstractEnergyBlock<E> {
    public AbstractEnergyProviderBlock(Properties properties, E variant) {
        super(properties, variant);
    }

    public AbstractEnergyProviderBlock(Properties properties) {
        super(properties);
    }

    public abstract IEnergyProviderConfig<E> getEnergyConfig();

    @Override
    public SideConfig.Type getTransferType() {
        return SideConfig.Type.OUT;
    }

}
