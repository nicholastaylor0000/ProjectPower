package com.nupiboys.projectpower.client.handler;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public interface IHud {
    @OnlyIn(Dist.CLIENT)
    boolean renderHud(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockRayTraceResult result, @Nullable TileEntity te);
}
