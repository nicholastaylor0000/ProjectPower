package com.nupiboys.projectpower.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import com.nupiboys.projectpower.config.generator.CoalGeneratorConfig;
import com.nupiboys.projectpower.config.generator.SolarPanelConfig;
import com.nupiboys.projectpower.config.item.BatteryConfig;

import java.util.HashSet;
import java.util.Set;

public class Configs {
    public static final Set<IConfig> ENERGY = new HashSet<>();
    public static final GeneralConfig GENERAL;
    private static final ForgeConfigSpec GENERAL_SPEC;

    public static final EnergyCellConfig ENERGY_CELL;
    public static final EnergyCableConfig ENERGY_CABLE;

    private static final ForgeConfigSpec ENERGY_CELL_SPEC;
    private static final ForgeConfigSpec ENERGY_CABLE_SPEC;

    public static final CoalGeneratorConfig COAL_GENERATOR;
    public static final SolarPanelConfig SOLAR_PANEL;

    private static final ForgeConfigSpec COAL_GENERATOR_SPEC;
    private static final ForgeConfigSpec SOLAR_PANEL_SPEC;

    public static final BatteryConfig BATTERY;

    private static final ForgeConfigSpec BATTERY_SPEC;

    public static void register() {
        final String path = Config.createConfigDir("projectpower/config");
        Config.registerCommon(GENERAL_SPEC, "projectpower/general_common.toml");
        Config.registerCommon(ENERGY_CELL_SPEC, path + "/energy_cell.toml");
        Config.registerCommon(ENERGY_CABLE_SPEC, path + "/energy_cable.toml");

        final String genPath = Config.createConfigDir("projectpower/config/generators");
        Config.registerCommon(COAL_GENERATOR_SPEC, genPath + "/coal_generator.toml");
        Config.registerCommon(SOLAR_PANEL_SPEC, genPath + "/solar_panel.toml");

        final String itemPath = Config.createConfigDir("projectpower/config/items");
        Config.registerCommon(BATTERY_SPEC, itemPath + "/battery.toml");
    }

    static <T extends IEnergyConfig> T registerEnergy(final T config) {
        ENERGY.add(config);
        return config;
    }

    static <T extends IConfig> T register(final T config) {
        return config;
    }

    static {
        final Pair<GeneralConfig, ForgeConfigSpec> generalPair = Config.get(GeneralConfig::new);
        GENERAL = generalPair.getLeft();
        GENERAL_SPEC = generalPair.getRight();

        final Pair<EnergyCellConfig, ForgeConfigSpec> energyCellPair = Config.get(EnergyCellConfig::new);
        ENERGY_CELL = registerEnergy(energyCellPair.getLeft());
        ENERGY_CELL_SPEC = energyCellPair.getRight();
        final Pair<EnergyCableConfig, ForgeConfigSpec> energyCablePair = Config.get(EnergyCableConfig::new);
        ENERGY_CABLE = registerEnergy(energyCablePair.getLeft());
        ENERGY_CABLE_SPEC = energyCablePair.getRight();

        final Pair<CoalGeneratorConfig, ForgeConfigSpec> coalGeneratorPair = Config.get(CoalGeneratorConfig::new);
        COAL_GENERATOR = registerEnergy(coalGeneratorPair.getLeft());
        COAL_GENERATOR_SPEC = coalGeneratorPair.getRight();
        final Pair<SolarPanelConfig, ForgeConfigSpec> solarPair = Config.get(SolarPanelConfig::new);
        SOLAR_PANEL = registerEnergy(solarPair.getLeft());
        SOLAR_PANEL_SPEC = solarPair.getRight();

        final Pair<BatteryConfig, ForgeConfigSpec> batteryPair = Config.get(BatteryConfig::new);
        BATTERY = registerEnergy(batteryPair.getLeft());
        BATTERY_SPEC = batteryPair.getRight();
    }
}
