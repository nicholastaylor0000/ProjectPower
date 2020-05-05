package com.nupiboys.projectpower.client.screen;

import net.minecraft.client.gui.ScreenManager;

import com.nupiboys.projectpower.client.screen.inventory.CoalGeneratorScreen;
import com.nupiboys.projectpower.client.screen.inventory.EnergyCableScreen;
import com.nupiboys.projectpower.client.screen.inventory.EnergyCellScreen;
import com.nupiboys.projectpower.client.screen.inventory.SolarPanelScreen;
import com.nupiboys.projectpower.inventory.IContainers;

public class Screens {
    public static void register() {
        ScreenManager.registerFactory(IContainers.ENERGY_CELL, EnergyCellScreen::new);
        ScreenManager.registerFactory(IContainers.ENERGY_CABLE, EnergyCableScreen::new);
        ScreenManager.registerFactory(IContainers.COAL_GENERATOR, CoalGeneratorScreen::new);
        ScreenManager.registerFactory(IContainers.SOLAR_PANEL, SolarPanelScreen::new);
    }
}
