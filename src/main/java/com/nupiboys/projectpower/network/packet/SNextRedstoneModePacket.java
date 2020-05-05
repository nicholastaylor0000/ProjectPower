package com.nupiboys.projectpower.network.packet;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;
import com.nupiboys.projectpower.ProjectPower;
import com.nupiboys.projectpower.blocks.TileBase;
import com.nupiboys.projectpower.energy.IRedstoneInteract;
import com.nupiboys.projectpower.network.IPacket;

import java.util.function.Supplier;

public class SNextRedstoneModePacket implements IPacket<SNextRedstoneModePacket> {
    private BlockPos pos;

    public SNextRedstoneModePacket(BlockPos pos) {
        this.pos = pos;
    }

    public SNextRedstoneModePacket() {
        this(BlockPos.ZERO);
    }

    public static void send(BlockPos pos) {
        ProjectPower.NET.toServer(new SNextRedstoneModePacket(pos));
    }

    @Override
    public void encode(SNextRedstoneModePacket msg, PacketBuffer buffer) {
        buffer.writeBlockPos(msg.pos);
    }

    @Override
    public SNextRedstoneModePacket decode(PacketBuffer buffer) {
        return new SNextRedstoneModePacket(buffer.readBlockPos());
    }

    @Override
    public void handle(SNextRedstoneModePacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player = ctx.get().getSender();
            if (player != null) {
                TileEntity tileEntity = player.world.getTileEntity(msg.pos);
                if (tileEntity instanceof TileBase) {
                    if (tileEntity instanceof IRedstoneInteract) {
                        ((IRedstoneInteract) tileEntity).nextRedstoneMode();
                        ((TileBase) tileEntity).markDirtyAndSync();
                    }
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
