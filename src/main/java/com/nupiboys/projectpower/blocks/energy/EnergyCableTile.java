package com.nupiboys.projectpower.blocks.energy;

import net.minecraft.block.Block;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants;

import com.nupiboys.projectpower.blocks.ITiles;
import com.nupiboys.projectpower.blocks.Tier;
import com.nupiboys.projectpower.blocks.TileBase;
import com.nupiboys.projectpower.energy.Energy;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.IntStream;

public class EnergyCableTile extends TileBase.EnergyStorage<Tier, EnergyCableBlock> {
    public final Map<Direction, EnergyProxy> proxyMap = new HashMap<>();
    public final Set<Direction> energySides = new HashSet<>();

    public EnergyCableTile(Tier variant) {
        super(ITiles.ENERGY_CABLE, variant);
        for (Direction side : Direction.values()) {
            this.proxyMap.put(side, new EnergyProxy());
        }
    }

    public EnergyCableTile() {
        this(Tier.BASIC);
    }

    @Override
    public void readSync(CompoundNBT compound) {
        super.readSync(compound);
        ListNBT list = compound.getList("LinkedCables", Constants.NBT.TAG_COMPOUND);
        IntStream.range(0, list.size()).mapToObj(list::getCompound).forEach(nbt -> {
            Direction direction = Direction.values()[nbt.getInt("Direction")];
            this.proxyMap.put(direction, new EnergyProxy().read(nbt));
        });
        ListNBT list1 = compound.getList("EnergyDirections", Constants.NBT.TAG_COMPOUND);
        IntStream.range(0, list1.size()).mapToObj(list1::getCompound)
                .map(nbt -> Direction.values()[nbt.getInt("EnergyDirection")])
                .forEach(this.energySides::add);
    }

    @Override
    public CompoundNBT writeSync(CompoundNBT compound) {
        ListNBT list = new ListNBT();
        this.proxyMap.forEach((direction, linkedCables) -> {
            CompoundNBT nbt = new CompoundNBT();
            linkedCables.write(nbt);
            nbt.putInt("Direction", direction.ordinal());
            list.add(nbt);
        });
        compound.put("LinkedCables", list);
        ListNBT list1 = new ListNBT();
        this.energySides.forEach((direction) -> {
            CompoundNBT nbt = new CompoundNBT();
            nbt.putInt("EnergyDirection", direction.ordinal());
            list1.add(nbt);
        });
        compound.put("EnergyDirections", list1);
        return super.writeSync(compound);
    }

    @Override
    public long receiveEnergy(int maxReceive, boolean simulate, @Nullable Direction direction) {
        if (this.world == null || isRemote() || direction == null || !canReceiveEnergy(direction)) return 0;
        long received = 0;
        received += pushEnergy(maxReceive, simulate, direction, this);
        for (BlockPos cablePos : this.proxyMap.get(direction).cables()) {
            TileEntity cableTile = this.world.getTileEntity(cablePos);
            if (cableTile instanceof EnergyCableTile) {
                EnergyCableTile cable = (EnergyCableTile) cableTile;
                received += cable.pushEnergy(maxReceive, simulate, direction, this);
            }
        }
        return received;
    }

    private long pushEnergy(int maxReceive, boolean simulate, @Nullable Direction direction, EnergyCableTile cable) {
        long received = 0;
        for (Direction side : this.energySides) {
            if (cable.equals(this) && side.equals(direction) || !canExtractEnergy(side)) continue;
            BlockPos pos = this.pos.offset(side);
            if (direction != null && cable.getPos().offset(direction).equals(pos)) continue;
            TileEntity tile = getTileEntity(pos);
            long amount = maxReceive - received;
            if (amount > 0) {
                if (Energy.canReceive(tile, side)) {
                    long net = Math.min(amount, this.energy.getMaxExtract());
                    amount -= net;
                    received += Energy.receive(tile, side, net, simulate);
                    if (maxReceive - received <= 0) {
                        return received;
                    }
                }
            }
        }
        return received;
    }

    public void search(Block block, Direction side) {
        this.proxyMap.get(side).search(block, this, side).clear();
    }

    @Override
    public long defaultEnergyCapacity() {
        return 0L;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(this.pos, this.pos.add(1, 1, 1));
    }

    @Override
    public void getListedEnergyInfo(List<String> list) {}
}
