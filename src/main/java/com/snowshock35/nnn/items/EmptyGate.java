package com.snowshock35.nnn.items;

import com.snowshock35.nnn.Main;
import com.snowshock35.nnn.help.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EmptyGate extends Item {
	
	public EmptyGate() {
		this.setUnlocalizedName("EmptyGate");
		this.setTextureName(Reference.MODID + ":" + "EmptyGate");
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		if(world.getBlock(x, y, z) == Main.OverworldQuartz && checkPortals(world,x,y,z) && player.getHeldItem().getItem() ==  this) {
			System.out.println("Nether gate ritual succesfull !");
			--stack.stackSize;
			world.playSoundEffect(x, y, z, "fireworks.twinkle1", 1F, 1.5F);
			player.inventory.addItemStackToInventory(new ItemStack(Main.NetherGate));
			deletePortals(world,x,y,z);
			return true;
		}
		return false;
    }
	
	public static boolean checkPortals(World world, int x, int y, int z) {
		if(world.getBlock(x    , y + 1, z + 3) == Blocks.obsidian &&
           world.getBlock(x + 1, y + 1, z + 3) == Blocks.obsidian &&
           world.getBlock(x - 1, y + 1, z + 3) == Blocks.obsidian &&
           world.getBlock(x    , y + 2, z + 3) == Blocks.portal   &&
           
           world.getBlock(x - 3, y + 1, z    ) == Blocks.obsidian &&
           world.getBlock(x - 3, y + 1, z + 1) == Blocks.obsidian &&
   		   world.getBlock(x - 3, y + 1, z - 1) == Blocks.obsidian &&
           world.getBlock(x - 3, y + 2, z    ) == Blocks.portal   &&
           
           world.getBlock(x + 3, y + 1, z    ) == Blocks.obsidian &&
           world.getBlock(x + 3, y + 1, z + 1) == Blocks.obsidian &&
           world.getBlock(x + 3, y + 1, z - 1) == Blocks.obsidian &&
           world.getBlock(x + 3, y + 2, z    ) == Blocks.portal   &&
           
           world.getBlock(x    , y + 1, z - 3) == Blocks.obsidian &&
           world.getBlock(x + 1, y + 1, z - 3) == Blocks.obsidian &&
           world.getBlock(x - 1, y + 1, z - 3) == Blocks.obsidian &&
           world.getBlock(x    , y + 2, z - 3) == Blocks.portal) {
			return true;
		}
		return false;
	}
	
	public static void deletePortals(World world, int x, int y, int z) {
		world.setBlockToAir(x    , y + 1, z + 3); world.setBlockToAir(x    , y + 1, z - 3);
		world.setBlockToAir(x + 1, y + 1, z + 3); world.setBlockToAir(x + 1, y + 1, z - 3);
		world.setBlockToAir(x - 1, y + 1, z + 3); world.setBlockToAir(x - 1, y + 1, z - 3);
		world.setBlockToAir(x - 2, y + 2, z + 3); world.setBlockToAir(x - 2, y + 2, z - 3);
		world.setBlockToAir(x + 2, y + 2, z + 3); world.setBlockToAir(x + 2, y + 2, z - 3);
		world.setBlockToAir(x - 2, y + 3, z + 3); world.setBlockToAir(x - 2, y + 3, z - 3);
		world.setBlockToAir(x + 2, y + 3, z + 3); world.setBlockToAir(x + 2, y + 3, z - 3);
		world.setBlockToAir(x - 2, y + 4, z + 3); world.setBlockToAir(x - 2, y + 4, z - 3);
		world.setBlockToAir(x + 2, y + 4, z + 3); world.setBlockToAir(x + 2, y + 4, z - 3);
		world.setBlockToAir(x    , y + 5, z + 3); world.setBlockToAir(x    , y + 5, z - 3);
		world.setBlockToAir(x + 1, y + 5, z + 3); world.setBlockToAir(x + 1, y + 5, z - 3);
		world.setBlockToAir(x - 1, y + 5, z + 3); world.setBlockToAir(x - 1, y + 5, z - 3);
		
		world.setBlockToAir(x - 3, y + 1, z    ); world.setBlockToAir(x + 3, y + 1, z    );
		world.setBlockToAir(x - 3, y + 1, z + 1); world.setBlockToAir(x + 3, y + 1, z + 1);
		world.setBlockToAir(x - 3, y + 1, z - 1); world.setBlockToAir(x + 3, y + 1, z - 1);
		world.setBlockToAir(x - 3, y + 2, z - 2); world.setBlockToAir(x + 3, y + 2, z - 2);
		world.setBlockToAir(x - 3, y + 2, z + 2); world.setBlockToAir(x + 3, y + 2, z + 2);
		world.setBlockToAir(x - 3, y + 3, z - 2); world.setBlockToAir(x + 3, y + 3, z - 2);
		world.setBlockToAir(x - 3, y + 3, z + 2); world.setBlockToAir(x + 3, y + 3, z + 2);
		world.setBlockToAir(x - 3, y + 4, z - 2); world.setBlockToAir(x + 3, y + 4, z - 2);
		world.setBlockToAir(x - 3, y + 4, z + 2); world.setBlockToAir(x + 3, y + 4, z + 2);
		world.setBlockToAir(x - 3, y + 5, z    ); world.setBlockToAir(x + 3, y + 5, z    );
		world.setBlockToAir(x - 3, y + 5, z - 1); world.setBlockToAir(x + 3, y + 5, z - 1);
		world.setBlockToAir(x - 3, y + 5, z + 1); world.setBlockToAir(x + 3, y + 5, z + 1);
	}
}
