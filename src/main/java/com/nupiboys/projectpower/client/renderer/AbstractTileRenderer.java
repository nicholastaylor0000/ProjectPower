package com.nupiboys.projectpower.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.nupiboys.projectpower.blocks.TileBase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.world.ClientWorld;

public abstract class AbstractTileRenderer<T extends TileBase> extends TileEntityRenderer<T> {

    public AbstractTileRenderer(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public final void render(T te, float pt, MatrixStack matrix, IRenderTypeBuffer rtb, int light, int ov) {
        Minecraft mc = Minecraft.getInstance();
        ClientPlayerEntity player = mc.player;
        if (player != null) {
            render(te, pt, matrix, rtb, mc, player.worldClient, player, light, ov);
        }
    }

    public abstract void render(T te, float pt, MatrixStack matrix, IRenderTypeBuffer rtb, Minecraft mc, ClientWorld world, ClientPlayerEntity player, int light, int ov);
}
