package com.nupiboys.projectpower.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class GeneralConfig {
	
    public final ForgeConfigSpec.LongValue fuelTicks;

    public GeneralConfig(ForgeConfigSpec.Builder builder) {
       
        builder.push("Materials");
        
        this.fuelTicks = builder.comment("Energy per solid fuel tick. [default: 30]", "Eg: Coal has 1600 fuel tick, so will generate 48000 FE.")
                .defineInRange("solidFuelEnergyBase", 30L, 1L, 1000000L);
        builder.pop();
    }
}
