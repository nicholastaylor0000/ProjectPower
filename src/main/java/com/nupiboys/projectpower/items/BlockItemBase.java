package com.nupiboys.projectpower.items;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.nupiboys.projectpower.blocks.IBlock;
import com.nupiboys.projectpower.client.renderer.TEItemRenderer;
import com.nupiboys.projectpower.util.IVariant;

import javax.annotation.Nullable;

public class BlockItemBase<E extends IVariant, T extends Block & IBlock<E>> extends BlockItem implements IItemBase {
    private final T block;

    @SuppressWarnings("ConstantConditions")
    public BlockItemBase(T block, Properties properties, @Nullable ItemGroup group) {
        super(block, properties.group(block instanceof IBlock && block.hideGroup() ? null : group)
                .setISTER(() -> TEItemRenderer::new).maxStackSize(block.stackSize()));
        this.block = block;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return getBlock().hasEffect(stack);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderByItem(ItemStack stack, MatrixStack matrix, IRenderTypeBuffer rtb, int light, int ov) {
        getBlock().renderByItem(stack, matrix, rtb, light, ov);
    }

    public E getVariant() {
        return this.block.getVariant();
    }

    @Override
    public T getBlock() {
        return this.block;
    }
}
