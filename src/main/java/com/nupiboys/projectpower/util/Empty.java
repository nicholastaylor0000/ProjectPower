package com.nupiboys.projectpower.util;

import net.minecraft.util.ResourceLocation;
import com.nupiboys.projectpower.ProjectPower;

public class Empty {
    public static final ResourceLocation LOCATION = new ResourceLocation(ProjectPower.MOD_ID, "empty");
    public static final String STRING = "";

    public static boolean check(ResourceLocation location) {
        return LOCATION.equals(location);
    }
}
