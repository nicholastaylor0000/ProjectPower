package com.nupiboys.projectpower.util;

import com.nupiboys.projectpower.ProjectPower;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandlerItems {
    
    // Items ONLY
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ProjectPower.MOD_ID);
    	
    //Ingots
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SCARIUM_INGOT = ITEMS.register("scarium_ingot", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> BURNIUM_INGOT = ITEMS.register("burnium_ingot", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));

    //Dusts
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SILVER_DUST = ITEMS.register("silver_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> ALUMINUM_DUST = ITEMS.register("aluminum_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> SCARIUM_DUST = ITEMS.register("scarium_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    public static final RegistryObject<Item> BURNIUM_DUST = ITEMS.register("burnium_dust", () -> new Item(new Item.Properties().group(ProjectPower.TAB)));
    
}