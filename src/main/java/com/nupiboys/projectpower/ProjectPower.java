package com.nupiboys.projectpower;

import com.nupiboys.projectpower.util.RegistryHandler;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("projectpower")
public class ProjectPower
{

    private static final Logger LOGGER = LogManager.getLogger();
    
    //A public string reference for the modid within the code of the mod
    public static final String MOD_ID = "projectpower";

    public ProjectPower() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
        //Calls upon the class of the same name to run the item registration
        RegistryHandler.init();
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){	}

    private void doClientStuff(final FMLClientSetupEvent event) {	}


}
