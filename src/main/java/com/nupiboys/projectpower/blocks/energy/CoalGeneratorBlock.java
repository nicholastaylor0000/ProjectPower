package com.nupiboys.projectpower.blocks.energy;

import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import com.nupiboys.projectpower.blocks.AbstractEnergyProviderBlock;
import com.nupiboys.projectpower.blocks.Tier;
import com.nupiboys.projectpower.blocks.TileBase;
import com.nupiboys.projectpower.config.Configs;
import com.nupiboys.projectpower.config.IEnergyProviderConfig;
import com.nupiboys.projectpower.inventory.CoalGeneratorContainer;
import com.nupiboys.projectpower.inventory.ContainerBase;
import com.nupiboys.projectpower.inventory.IContainers;

import javax.annotation.Nullable;
import java.util.Random;

public class CoalGeneratorBlock extends AbstractEnergyProviderBlock<Tier> implements IWaterLoggable {
    public CoalGeneratorBlock(Properties properties, Tier variant) {
        super(properties, variant);
        setDefaultState();
    }

    @Override
    public IEnergyProviderConfig<Tier> getEnergyConfig() {
        return Configs.COAL_GENERATOR;
    }

    @Override
    public int stackSize() {
        return 1;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CoalGeneratorTile(this.variant);
    }

    @Override
    protected boolean semiFullShape() {
        return true;
    }

    @Nullable
    @Override
    public ContainerBase getContainer(int id, PlayerInventory playerInventory, TileBase te, BlockRayTraceResult result) {
        if (te instanceof CoalGeneratorTile) {
            return new CoalGeneratorContainer(IContainers.COAL_GENERATOR, id, playerInventory, (CoalGeneratorTile) te);
        }
        return null;
    }

    @Override
    protected boolean hasLitProp() {
        return true;
    }

    @Override
    protected Facing getFacing() {
        return Facing.HORIZONTAL;
    }

    @Override
    protected boolean isPlacerFacing() {
        return true;
    }

    @Override
    public void animateTick(BlockState state, World world, BlockPos pos, Random rand) {
        if (state.get(LIT)) {
            double d0 = (double) pos.getX() + 0.5D;
            double d1 = (double) pos.getY() + 0.5D;
            double d2 = (double) pos.getZ() + 0.5D;
            if (rand.nextDouble() < 0.1D) {
                world.playSound(d0, d1, d2, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = state.get(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d3 = 0.52D;
            double d4 = rand.nextDouble() * 0.6D - 0.3D;
            double d5 = direction$axis == Direction.Axis.X ? (double) direction.getXOffset() * 0.52D : d4;
            double d6 = rand.nextDouble() * 6.0D / 16.0D;
            double d7 = direction$axis == Direction.Axis.Z ? (double) direction.getZOffset() * 0.52D : d4;
            world.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
        }
    }
}
