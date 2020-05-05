package com.nupiboys.projectpower.blocks.energy;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import com.nupiboys.projectpower.blocks.ITiles;
import com.nupiboys.projectpower.blocks.Tier;
import com.nupiboys.projectpower.blocks.TileBase;
import com.nupiboys.projectpower.config.Configs;

public class CoalGeneratorTile extends TileBase.EnergyProvider<Tier, CoalGeneratorBlock> {
    public CoalGeneratorTile(Tier variant) {
        super(ITiles.CoalGenerator, variant);
        this.inv.add(1);
    }

    public CoalGeneratorTile() {
        this(Tier.BASIC);
    }

    @Override
    protected void generate(World world) {
        final ItemStack fuelStack = this.inv.getStackInSlot(builtInSlots());
        if (this.nextBuff <= 0 && !fuelStack.isEmpty()) {
            this.buffer = ForgeHooks.getBurnTime(fuelStack) * Configs.GENERAL.fuelTicks.get();
            if (this.buffer <= 0) return;
            this.nextBuff = this.buffer;
            if (fuelStack.hasContainerItem())
                this.inv.setStack(1, fuelStack.getContainerItem());
            else {
                fuelStack.shrink(1);
            }
        }
    }

    @Override
    public boolean hasEnergyBuffer() {
        return true;
    }

    @Override
    public boolean keepEnergy() {
        return true;
    }

    @Override
    public int getChargingSlots() {
        return 1;
    }

    @Override
    public boolean canInsert(int index, ItemStack stack) {
        return index == builtInSlots() ? ForgeHooks.getBurnTime(stack) > 0 : super.canInsert(index, stack);
    }
}
