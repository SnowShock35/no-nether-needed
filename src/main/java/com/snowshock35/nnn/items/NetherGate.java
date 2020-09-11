package com.snowshock35.nnn.items;

import com.snowshock35.nnn.config.ConfigHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NetherGate extends Item {
    
	public NetherGate () {
    	this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabTools); 
        if(!ConfigHandler.GateInfiniteDurabilityBoolean)
    		this.setMaxDamage(ConfigHandler.GateDurabilityInt - 1);
		this.setUnlocalizedName("NetherGate");
		this.setTextureName("nnn:NetherGate");
    } 
	
    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {    	
      return false;
    }

    @Override
    public boolean getShareTag() {
        return true;
    }
    
    @Override
    public boolean hasContainerItem(ItemStack stack) {
       return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemstack) {
        ItemStack stack = itemstack.copy();
        if(!ConfigHandler.GateInfiniteDurabilityBoolean) {
            stack.setItemDamage(stack.getItemDamage() + 1);
        }
        return stack;
    }
    
    @Override
    public boolean isRepairable() {
        return canRepair && isDamageable();
    }
   
}