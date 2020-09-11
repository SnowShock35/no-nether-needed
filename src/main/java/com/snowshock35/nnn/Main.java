package com.snowshock35.nnn;

import java.io.File;

import com.snowshock35.nnn.blocks.OverworldQuartz;
import com.snowshock35.nnn.blocks.OverworldQuartz;
import com.snowshock35.nnn.config.ConfigHandler;
import com.snowshock35.nnn.handlers.RecipesHandler;
import com.snowshock35.nnn.help.Reference;
import com.snowshock35.nnn.items.EmptyGate;
import com.snowshock35.nnn.items.NetherGate;
import com.snowshock35.nnn.proxies.ProxyCommon;
import com.snowshock35.nnn.worldgen.Generation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    @SidedProxy(clientSide = "com.snowshock35.nnn.proxies.ProxyClient", serverSide = "com.snowshock35.nnn.proxies.ProxyCommon")
    public static ProxyCommon proxy;
    @Instance(Reference.MODID)
    
    public static Main instance;
	public static Configuration config;
    public static Generation WorldGen = new Generation();
    public static Item EmptyGate;
	public static Item NetherGate;
	public static Block OverworldQuartz;

    @EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(Main.instance);

    	config = new Configuration(new File("config/nnn.cfg"));
    	GameRegistry.registerWorldGenerator(WorldGen, 1);
    	
		ConfigHandler.loadConfigs();

		EmptyGate = new EmptyGate();
    	NetherGate = new NetherGate();
		OverworldQuartz = new OverworldQuartz(Material.rock);

    }
    
    @EventHandler
	public void init(FMLInitializationEvent event) {
    	GameRegistry.registerItem(NetherGate, "NetherGate");
        GameRegistry.registerItem(EmptyGate, "EmptyGate");
    	GameRegistry.registerBlock(OverworldQuartz, "OverworldQuartz");
    	RecipesHandler.registerRecipes();
    }
    
    @EventHandler
	public void postInit(FMLPostInitializationEvent event) {
    	
    }
    
    @SubscribeEvent
 	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
 		if(event.modID.equals(Reference.MODID)) {
 			ConfigHandler.loadConfigs();
 		}
 	}
    
}