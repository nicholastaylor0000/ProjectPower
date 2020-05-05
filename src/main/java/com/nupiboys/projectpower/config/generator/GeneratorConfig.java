package com.nupiboys.projectpower.config.generator;

import net.minecraftforge.common.ForgeConfigSpec;

import com.nupiboys.projectpower.blocks.Tier;
import com.nupiboys.projectpower.config.IEnergyProviderConfig;
import com.nupiboys.projectpower.energy.Energy;

import java.util.HashMap;
import java.util.Map;

public class GeneratorConfig implements IEnergyProviderConfig<Tier> {
    public final Map<Tier, Long> capacities = new HashMap<>();
    public final Map<Tier, Long> transfer = new HashMap<>();
    public final Map<Tier, Long> generation = new HashMap<>();

    public final ForgeConfigSpec.LongValue basicCap;

    public final ForgeConfigSpec.LongValue basicTransfer;

    public final ForgeConfigSpec.LongValue basicGeneration;

    public GeneratorConfig(ForgeConfigSpec.Builder builder, long[] caps, long[] trs, long[] gens) {
        builder.push("Energy_Capacity");
        this.basicCap = builder.defineInRange("basicCap", caps[0], Energy.MIN, Energy.MAX);
        builder.pop();

        builder.push("Energy_Transfer");
        this.basicTransfer = builder.defineInRange("basicTransfer", trs[0], Energy.MIN, Energy.MAX);
        builder.pop();

        builder.push("Energy_Generation");
        this.basicGeneration = builder.defineInRange("basicGeneration", gens[0], Energy.MIN, Energy.MAX);
        builder.pop();
    }

    @Override
    public void reload() {
        this.capacities.put(Tier.BASIC, this.basicCap.get());
        this.capacities.put(Tier.CREATIVE, Energy.MAX);

        this.transfer.put(Tier.BASIC, this.basicTransfer.get());
        this.transfer.put(Tier.CREATIVE, Energy.MAX);

        this.generation.put(Tier.BASIC, this.basicGeneration.get());
        this.generation.put(Tier.CREATIVE, Energy.MAX);
    }

    @Override
    public long getCapacity(Tier variant) {
        if (this.capacities.containsKey(variant)) {
            return this.capacities.get(variant);
        }
        return 0L;
    }

    @Override
    public long getTransfer(Tier variant) {
        if (this.transfer.containsKey(variant)) {
            return this.transfer.get(variant);
        }
        return 0L;
    }

    @Override
    public long getGeneration(Tier variant) {
        if (this.generation.containsKey(variant)) {
            return this.generation.get(variant);
        }
        return 0L;
    }
}
