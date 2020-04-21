package com.nupiboys.projectpower.util;

import com.nupiboys.projectpower.ProjectPower;
import com.nupiboys.projectpower.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ProjectPower.MOD_ID);
    
    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items ONLY
    //Ingots
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", ItemBase::new);
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", ItemBase::new);
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", ItemBase::new);
    public static final RegistryObject<Item> SCARIUM_INGOT = ITEMS.register("scarium_ingot", ItemBase::new);
    public static final RegistryObject<Item> BURNIUM_INGOT = ITEMS.register("burnium_ingot", ItemBase::new);

    //Dusts
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", ItemBase::new);
    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust", ItemBase::new);
    public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust", ItemBase::new);
    public static final RegistryObject<Item> SILVER_DUST = ITEMS.register("silver_dust", ItemBase::new);
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust", ItemBase::new);
    public static final RegistryObject<Item> ALUMINUM_DUST = ITEMS.register("aluminum_dust", ItemBase::new);
    public static final RegistryObject<Item> SCARIUM_DUST = ITEMS.register("scarium_dust", ItemBase::new);
    public static final RegistryObject<Item> BURNIUM_DUST = ITEMS.register("burnium_dust", ItemBase::new);
    
}