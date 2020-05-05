package com.nupiboys.projectpower.client.render.tile;

import com.nupiboys.projectpower.blocks.ITiles;

import net.minecraftforge.fml.client.registry.ClientRegistry;

public class TileRenderer {
    public static void register() {
        ClientRegistry.bindTileEntityRenderer(ITiles.ENERGY_CABLE, EnergyCableRenderer::new);
    }
}
