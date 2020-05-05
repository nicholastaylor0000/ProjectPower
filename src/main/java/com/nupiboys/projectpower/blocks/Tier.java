package com.nupiboys.projectpower.blocks;

import java.util.Locale;

import com.nupiboys.projectpower.util.IVariant;

public enum Tier implements IVariant<Tier> {
    BASIC(0),
    CREATIVE(0);

    private final int[] colors;

    Tier(int... colors) {
        this.colors = colors;
    }

    public int[] getColors() {
        return this.colors;
    }

    @Override
    public Tier[] getAll() {
        return values();
    }

    public String getName() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
