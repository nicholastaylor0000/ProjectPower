package com.nupiboys.projectpower.config;

import com.nupiboys.projectpower.blocks.Tier;

import net.minecraftforge.common.ForgeConfigSpec;

public class EnergyCableConfig extends EnergyConfig {
    public EnergyCableConfig(ForgeConfigSpec.Builder builder) {
        super(builder,
                new long[]{0, 0},
                new long[]{1400, 200000}
        );
    }

    @Override
    public long getCapacity(Tier variant) {
        return 0;
    }
}
