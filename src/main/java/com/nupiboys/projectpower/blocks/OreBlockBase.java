package com.nupiboys.projectpower.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

import com.nupiboys.projectpower.util.IVariant;

public class OreBlockBase<E extends IVariant> extends OreBlock implements IBlock<E> {
    private int minXpDrop;
    private int maxXpDrop;

    public OreBlockBase(Properties properties) {
        super(properties);
    }

    @Override
    public E getVariant() {
        return IVariant.getEmpty();
    }

    public OreBlockBase setExperience(int minXpDrop, int maxXpDrop) {
        this.minXpDrop = minXpDrop;
        this.maxXpDrop = maxXpDrop;
        return this;
    }

    @Override
    protected int getExperience(Random random) {
        return MathHelper.nextInt(random, this.minXpDrop, this.maxXpDrop);
    }
}
