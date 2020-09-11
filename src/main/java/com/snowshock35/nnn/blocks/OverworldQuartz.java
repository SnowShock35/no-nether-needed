package com.snowshock35.nnn.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class OverworldQuartz extends Block {

	public OverworldQuartz(Material rock) {
		super(rock);
		this.setBlockTextureName("nnn:OverworldQuartz");
		this.setBlockName("OverworldQuartz");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3F);
	}
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int par6) {
		player.addStat(StatList.mineBlockStatArray[getIdFromBlock(this)], 1);
		player.addExhaustion(0.025F);
		Item ItemInUse = player.getCurrentEquippedItem().getItem();
		
		if(ItemInUse instanceof ItemPickaxe) {
			this.dropXpOnBlockBreak(world, x, y, z, 3 + world.rand.nextInt(4));
		}
		
        if (this.canSilkHarvest(world, player, x, y, z, par6) && EnchantmentHelper.getSilkTouchModifier(player)) {
            ArrayList<ItemStack> items = new ArrayList<ItemStack>();
            ItemStack itemstack = this.createStackedBlock(par6);
            if (itemstack != null){ items.add(itemstack);}
            
            ForgeEventFactory.fireBlockHarvesting(items, world, this, x, y, z, par6, 0, 1.0f, true, player);
            for (ItemStack is : items){
                this.dropBlockAsItem(world, x, y, z, is);
            }
        } else{
            harvesters.set(player);
            int i1 = EnchantmentHelper.getFortuneModifier(player);
            this.dropBlockAsItem(world, x, y, z, par6, i1);
            harvesters.set(null);
        }
        
    }
	
	@Override 
	public Item getItemDropped(int damage, Random random, int fortune) {
		return Items.quartz;
	}
	
	public int quantityDropped(Random random) {
		return 1;
	}
	
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if(fortune > 1) {
			int j = random.nextInt(fortune + 2) - 1;
			if(j < 0) {
				j = 0;
			}
			return quantityDropped(random) * (j + 1);
		} else { 
			return quantityDropped(random);
		}
	}
}
