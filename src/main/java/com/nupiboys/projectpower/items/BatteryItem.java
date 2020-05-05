package com.nupiboys.projectpower.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.energy.IEnergyStorage;

import com.nupiboys.projectpower.blocks.Tier;
import com.nupiboys.projectpower.blocks.energy.IEnderExtender;
import com.nupiboys.projectpower.config.Configs;
import com.nupiboys.projectpower.config.IEnergyConfig;
import com.nupiboys.projectpower.energy.Energy;

public class BatteryItem extends EnergyItem<Tier> implements IEnderExtender {
    public BatteryItem(Properties properties, Tier variant) {
        super(properties, variant);
    }

    @Override
    public IEnergyConfig<Tier> getEnergyConfig() {
        return Configs.BATTERY;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (entity instanceof PlayerEntity && isCharging(stack)) {
            Energy.ifPresent(stack, storage -> {
                if (storage instanceof Energy) {
                    ((Energy) storage).chargeInventory((PlayerEntity) entity, stack1 -> !(stack1.getItem() instanceof BatteryItem));
                }
            });
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (player.isShiftKeyDown()) {
            switchCharging(stack);
            return ActionResult.resultSuccess(stack);
        }
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        IEnergyStorage energy = Energy.get(stack).orElse(Energy.Item.create(0));
        return energy.getEnergyStored() < energy.getMaxEnergyStored();
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        IEnergyStorage energy = Energy.get(stack).orElse(Energy.Item.create(0));
        return 1.0F - ((double) energy.getEnergyStored() / energy.getMaxEnergyStored());
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return isCharging(stack);
    }

    private void switchCharging(ItemStack stack) {
        setCharging(stack, !isCharging(stack));
    }

    private boolean isCharging(ItemStack stack) {
        return stack.getOrCreateTag().getBoolean("Charging");
    }

    private void setCharging(ItemStack stack, boolean charging) {
        stack.getOrCreateTag().putBoolean("Charging", charging);
    }

    @Override
    public long getExtendedCapacity(ItemStack stack) {
        return getEnergyConfig().getCapacity(getVariant());
    }

    @Override
    public long getExtendedEnergy(ItemStack stack) {
        return Energy.getStored(stack);
    }
}
