package com.nupiboys.projectpower.network.packet;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

import com.nupiboys.projectpower.ProjectPower;
import com.nupiboys.projectpower.network.IPacket;

import java.util.function.Supplier;

public class SSetActiveChannel implements IPacket<SSetActiveChannel> {
    private int activeChannel;
    private BlockPos pos;

    public SSetActiveChannel(int activeChannel, BlockPos pos) {
        this.activeChannel = activeChannel;
        this.pos = pos;
    }

    public SSetActiveChannel() {
        this(0, BlockPos.ZERO);
    }

    public static void send(int activeChannel, BlockPos pos) {
        ProjectPower.NET.toServer(new SSetActiveChannel(activeChannel, pos));
    }

    @Override
    public void encode(SSetActiveChannel msg, PacketBuffer buffer) {
        buffer.writeInt(msg.activeChannel);
        buffer.writeBlockPos(msg.pos);
    }

    @Override
    public SSetActiveChannel decode(PacketBuffer buffer) {
        return new SSetActiveChannel(buffer.readInt(), buffer.readBlockPos());
    }

    @Override
    public void handle(SSetActiveChannel msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player = ctx.get().getSender();
            if (player != null) {
                TileEntity te = player.world.getTileEntity(msg.pos);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
