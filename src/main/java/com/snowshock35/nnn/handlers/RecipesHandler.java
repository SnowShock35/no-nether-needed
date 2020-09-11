package com.snowshock35.nnn.handlers;


import com.snowshock35.nnn.Main;
import com.snowshock35.nnn.config.ConfigHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesHandler {
	
	public static void registerRecipes() {
		registerCrafting();
		registerSmelting();
		oreDictionary();
	}
	
	public static void registerCrafting() {
    	//sand + Main.NetherGate = soul sand
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.soul_sand, 1), new ItemStack(Main.NetherGate, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.sand));
    	//cobble + Main.NetherGate = netherrack
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.netherrack, 1), new ItemStack(Main.NetherGate, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.cobblestone));
    	//stonebrick + Main.NetherGate = nether brick
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.nether_brick, 1), new ItemStack(Main.NetherGate, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stonebrick));
    	//wheatseed + soulsand + Main.NetherGate = nether wart
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.nether_wart, 1), new ItemStack(Main.NetherGate, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.wheat_seeds), new ItemStack(Blocks.soul_sand));
    	//nether wart + dia + quartz + nether gate = ghast tear
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.ghast_tear, 1), new ItemStack(Main.NetherGate, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.nether_wart), new ItemStack(Items.diamond), new ItemStack(Items.quartz));
    	//blaze  powser + bone + nether gate = blaze rod
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.blaze_rod, 1), new ItemStack(Main.NetherGate, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.bone), new ItemStack(Items.blaze_powder), new ItemStack(Items.iron_ingot));
    	//gunpowder+redstone+bonemeal+Main.NetherGate=blaze powdeer
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.blaze_powder, 1), new ItemStack(Main.NetherGate, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.gunpowder), new ItemStack(Items.redstone), new ItemStack(Items.dye, 1, 15));
    	//gunpowder + torch + Main.NetherGate = glowdust
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.glowstone_dust, 1), new ItemStack(Main.NetherGate, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.gunpowder), new ItemStack(Blocks.torch));
    	//skeleton head + coal + dia = wither head
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.skull, 1, 1), new ItemStack(Main.NetherGate, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.skull), new ItemStack(Items.diamond), new ItemStack(Items.coal));
    	//quartz ore + Main.NetherGate = nether quartz ore
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.quartz_ore), new ItemStack(Main.NetherGate, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Main.OverworldQuartz));
    	
    	if(ConfigHandler.RitualEnabledBoolean == false) {
    		GameRegistry.addShapedRecipe(new ItemStack(Main.NetherGate), new Object[] {"XXX", "XYX", "XXX", 'X',Blocks.obsidian, 'Y', new ItemStack(Items.flint_and_steel)});
    	}
    	
    	if(ConfigHandler.RitualEnabledBoolean == true) {
        	GameRegistry.addShapedRecipe(new ItemStack(Main.EmptyGate), new Object[] {"XXX", "XXX", "XXX", 'X', Blocks.obsidian});
    	}
    	
	}
	
	public static void registerSmelting() {
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Main.OverworldQuartz), new ItemStack(Items.quartz, 4), 1F);
    	GameRegistry.addSmelting(Main.OverworldQuartz, new ItemStack(Items.quartz, 4), 1.0F);
	}
	
	public static void oreDictionary() {
		OreDictionary.registerOre("oreQuartz", Main.OverworldQuartz);
	}

}
