package com.nupiboys.projectpower.blocks;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.nupiboys.projectpower.blocks.energy.CoalGeneratorTile;
import com.nupiboys.projectpower.blocks.energy.EnergyCableTile;
import com.nupiboys.projectpower.blocks.energy.EnergyCellTile;
import com.nupiboys.projectpower.blocks.energy.SolarPanelTile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ITiles {
    public static final List<TileEntityType<?>> TYPES = new ArrayList<>();
    public static final TileEntityType<EnergyCellTile> ENERGY_CELL = register("energy_cell", EnergyCellTile::new, IBlocks.ENERGY_CELL_BASIC,  IBlocks.ENERGY_CELL_CREATIVE);
    public static final TileEntityType<EnergyCableTile> ENERGY_CABLE = register("energy_cable", EnergyCableTile::new,  IBlocks.ENERGY_CABLE_BASIC);
    public static final TileEntityType<SolarPanelTile> SOLAR_PANEL = register("solar_panel", SolarPanelTile::new, IBlocks.SOLAR_PANEL_BASIC);
    public static final TileEntityType<CoalGeneratorTile> CoalGenerator = register("coal_generator", CoalGeneratorTile::new, IBlocks.COAL_GENERATOR_BASIC);

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    static <T extends TileEntity> TileEntityType<T> register(final String name, final Supplier<? extends T> factoryIn, final Block... b) {
        @SuppressWarnings("rawtypes")
		final TileEntityType<T> type = TileEntityType.Builder.create((Supplier) factoryIn, b).build(null);
        type.setRegistryName(name);
        ITiles.TYPES.add(type);
        return type;
    }

    @SubscribeEvent
    public static void onRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
        ITiles.TYPES.forEach(tileType -> event.getRegistry().register(tileType));
    }

}
