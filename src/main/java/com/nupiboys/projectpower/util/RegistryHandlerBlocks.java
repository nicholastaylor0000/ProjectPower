package com.nupiboys.projectpower.util;

import com.nupiboys.projectpower.ProjectPower;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandlerBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ProjectPower.MOD_ID);
    
    public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)));
    public static final RegistryObject<Block> ALUMINUM_BLOCK = BLOCKS.register("aluminum_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
    public static final RegistryObject<Block> ALUMINUM_ORE = BLOCKS.register("aluminum_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)));
    public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
    public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)));
    public static final RegistryObject<Block> BURNIUM_BLOCK = BLOCKS.register("burnium_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
    public static final RegistryObject<Block> BURNIUM_ORE = BLOCKS.register("burnium_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)));
    public static final RegistryObject<Block> SCARIUM_BLOCK = BLOCKS.register("scarium_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
    public static final RegistryObject<Block> SCARIUM_ORE = BLOCKS.register("scarium_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)));
	
    
}
