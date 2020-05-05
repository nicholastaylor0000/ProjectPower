package com.nupiboys.projectpower.energy;

public interface IRedstoneInteract {
    Redstone getRedstoneMode();

    void setRedstone(Redstone mode);

    default void nextRedstoneMode() {
        setRedstone(getRedstoneMode().next());
    }
}
