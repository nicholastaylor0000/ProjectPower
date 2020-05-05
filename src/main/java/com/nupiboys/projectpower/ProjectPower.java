package com.nupiboys.projectpower;

import com.nupiboys.projectpower.util.RegistryHandlerItems;
import com.nupiboys.projectpower.client.render.tile.TileRenderer;
import com.nupiboys.projectpower.client.screen.Screens;
import com.nupiboys.projectpower.config.Configs;
import com.nupiboys.projectpower.config.IConfig;
import com.nupiboys.projectpower.network.Network;
import com.nupiboys.projectpower.network.Packets;
import com.nupiboys.projectpower.util.FML;
import com.nupiboys.projectpower.util.RegistryHandlerBlocks ;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("projectpower")
@Mod.EventBusSubscriber(modid = ProjectPower.MOD_ID, bus = Bus.MOD)
public class ProjectPower
{

    private static final Logger LOGGER = LogManager.getLogger();
    //A public string reference for the modid within the code of the mod
    public static final String MOD_ID = "projectpower";
    public static ProjectPower instance;
    public static final Network NET = new Network(MOD_ID);
    
    public ProjectPower() {
    	
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        
        //Calls upon the class of the same name to run the item registration
        RegistryHandlerItems.ITEMS.register(modEventBus);
        
        RegistryHandlerBlocks.BLOCKS.register(modEventBus);
        Configs.register();
        
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    
    	RegistryHandlerBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
    		final Item.Properties properties = new Item.Properties().group(ProjectPower.TAB);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    	
    	LOGGER.debug("Registered BlockItems!");
    	
    }
    
    private void setup(final FMLCommonSetupEvent event){	
    	
    }

    private void doClientStuff(final FMLClientSetupEvent event) {	}

    public static final ItemGroup TAB = new ItemGroup("projectPowerTab") {
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(RegistryHandlerItems.BURNIUM_INGOT.get());
    	}
    };
    
    private void commonSetup(FMLCommonSetupEvent event) {
        Packets.register();
    }

    private void clientSetup(FMLClientSetupEvent event) {
        if (FML.isClient()) {
        	// Render Tile Entities
            TileRenderer.register();
            // Register GUI's
            Screens.register();
        }
    }

    @SuppressWarnings("unused")
	private void loadComplete(FMLLoadCompleteEvent event) {
        Configs.ENERGY.forEach(IConfig::reload);
    }
	
    
}
