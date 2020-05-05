package com.nupiboys.projectpower.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;

import com.nupiboys.projectpower.blocks.TileBase;
import com.nupiboys.projectpower.client.renderer.AbstractTileRenderer;

import java.util.function.Function;

public abstract class AbstractModel<T extends TileBase, R extends AbstractTileRenderer<T>> extends EmptyModel {
    public AbstractModel(Function<ResourceLocation, RenderType> function) {
        super(function);
    }

    public abstract void render(T te, R renderer, MatrixStack matrix, IRenderTypeBuffer rtb, int light, int ov);

    protected void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
