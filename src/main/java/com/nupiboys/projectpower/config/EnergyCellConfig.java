package com.nupiboys.projectpower.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class EnergyCellConfig extends EnergyConfig {
    public EnergyCellConfig(ForgeConfigSpec.Builder builder) {
        super(builder,
                new long[]{1000_000L, 140_000_000L},
                new long[]{2500L, 400_000L}
        );
    }
}
