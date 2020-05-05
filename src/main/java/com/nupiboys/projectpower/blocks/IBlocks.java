package com.nupiboys.projectpower.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.nupiboys.projectpower.blocks.energy.CoalGeneratorBlock;
import com.nupiboys.projectpower.blocks.energy.EnergyCableBlock;
import com.nupiboys.projectpower.blocks.energy.EnergyCellBlock;
import com.nupiboys.projectpower.blocks.energy.SolarPanelBlock;
import com.nupiboys.projectpower.ProjectPower;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IBlocks {
    public static final List<BlockItem> BLOCK_ITEMS = new ArrayList<>();
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block ENERGY_CELL_BASIC = register("energy_cell_basic", new EnergyCellBlock(Properties.metalNoSolid(2.0f, 20.0f), Tier.BASIC));
    public static final Block ENERGY_CELL_CREATIVE = register("energy_cell_creative", new EnergyCellBlock(Properties.metalNoSolid(2.0f, 20.0f), Tier.CREATIVE));

    public static final Block ENERGY_CABLE_BASIC = register("energy_cable_basic", new EnergyCableBlock(Properties.metalNoSolid(2.0f, 20.0f).doesNotBlockMovement(), Tier.BASIC));

    public static final Block COAL_GENERATOR_BASIC = register("coal_generator_basic", new CoalGeneratorBlock(Properties.metalNoSolid(2.0f, 20.0f), Tier.BASIC));

    public static final Block SOLAR_PANEL_BASIC = register("solar_panel_basic", new SolarPanelBlock(Properties.metalNoSolid(2.0f, 20.0f), Tier.BASIC));

    static <T extends net.minecraft.block.Block> T register(final String name, final T block) {
        final BlockItem itemBlock = ((IBlock) block).getBlockItem(new Item.Properties(), ProjectPower.TAB);
        itemBlock.setRegistryName(name);
        block.setRegistryName(name);
        IBlocks.BLOCK_ITEMS.add(itemBlock);
        IBlocks.BLOCKS.add(block);
        return block;
    }

    @SubscribeEvent
    public static void onRegistry(final RegistryEvent.Register<Block> event) {
        IBlocks.BLOCKS.forEach(block -> event.getRegistry().register(block));
    }
}
