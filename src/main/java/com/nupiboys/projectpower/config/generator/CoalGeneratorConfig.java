package com.nupiboys.projectpower.config.generator;

import net.minecraftforge.common.ForgeConfigSpec;

public class CoalGeneratorConfig extends GeneratorConfig {
    public CoalGeneratorConfig(ForgeConfigSpec.Builder builder) {
        super(builder,
                new long[]{100000L, 10000000L},
                new long[]{200L, 10000L},
                new long[]{70L, 4800L}
        );
    }
}
