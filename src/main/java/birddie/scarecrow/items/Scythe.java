package birddie.scarecrow.items;

import birddie.scarecrow.scarecrow;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;

public class Scythe extends ItemSword{

	public Scythe(ToolMaterial material) {
		super(material);
		setUnlocalizedName("scythe");
		setRegistryName(scarecrow.MODID+":scythe");
		setCreativeTab(CreativeTabs.COMBAT);
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
	}
	
	
	
}
