package com.nupiboys.projectpower.config;

import net.minecraftforge.common.ForgeConfigSpec;

import com.nupiboys.projectpower.blocks.Tier;
import com.nupiboys.projectpower.energy.Energy;

import java.util.HashMap;
import java.util.Map;

public class EnergyConfig implements IEnergyConfig<Tier> {
    public final Map<Tier, Long> capacities = new HashMap<>();
    public final Map<Tier, Long> transfer = new HashMap<>();

    public final ForgeConfigSpec.LongValue basicCap;

    public final ForgeConfigSpec.LongValue basicTransfer;

    public EnergyConfig(ForgeConfigSpec.Builder builder, long[] caps, long[] trs) {
        builder.push("Energy_Capacity");
        this.basicCap = builder.defineInRange("basicCap", caps[0], Energy.MIN, Energy.MAX);
        builder.pop();

        builder.push("Energy_Transfer");
        this.basicTransfer = builder.defineInRange("basicTransfer", trs[0], Energy.MIN, Energy.MAX);
        builder.pop();
    }

    @Override
    public void reload() {
        this.capacities.put(Tier.BASIC, this.basicCap.get());
        this.capacities.put(Tier.CREATIVE, Energy.MAX);

        this.transfer.put(Tier.BASIC, this.basicTransfer.get());
        this.transfer.put(Tier.CREATIVE, Energy.MAX);
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
}
