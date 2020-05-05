package com.nupiboys.projectpower.inventory.slot;

import com.nupiboys.projectpower.ProjectPower;
import net.minecraft.util.ResourceLocation;

public class SlotOverlay {
    public static SlotOverlay SLOT = new SlotOverlay("slot");
    public static SlotOverlay ENERGY = new SlotOverlay("ov_energy");
    public static SlotOverlay FILTER = new SlotOverlay("filter");

    private ResourceLocation location;

    public SlotOverlay(String s) {
        this.location = new ResourceLocation(ProjectPower.MOD_ID, "textures/gui/container/slot/" + s + ".png");
    }

    public ResourceLocation getLocation() {
        return this.location;
    }

    public SlotOverlay setLocation(ResourceLocation location) {
        this.location = location;
        return this;
    }
}
