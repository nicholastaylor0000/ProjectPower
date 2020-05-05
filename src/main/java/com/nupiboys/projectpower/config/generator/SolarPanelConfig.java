package com.nupiboys.projectpower.config.generator;

import net.minecraftforge.common.ForgeConfigSpec;

public class SolarPanelConfig extends GeneratorConfig {
    public SolarPanelConfig(ForgeConfigSpec.Builder builder) {
        super(builder,
                new long[]{25000L, 8000000L},
                new long[]{150L, 4000L},
                new long[]{12L, 1200L}
        );
    }
}