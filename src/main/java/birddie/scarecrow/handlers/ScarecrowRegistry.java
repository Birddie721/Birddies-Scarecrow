package birddie.scarecrow.handlers;

import java.util.ArrayList;

import birddie.scarecrow.Entity.EntityNonlivingScarecrow;
import birddie.scarecrow.items.Scythe;
import birddie.scarecrow.proxy.Config;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.common.util.EnumHelper;

public class ScarecrowRegistry {
	public static Item scythe;
	
	public static ArrayList<Item> items = new ArrayList<Item>();
	
	public static void preInit() {
		Item.ToolMaterial SCYTHE = EnumHelper.addToolMaterial("SCYTHE", 4, 2000, 16.0F, 6.0F, 10);
		items.add(scythe = new Scythe(SCYTHE));
		EntityRegistry.addSpawn(EntityNonlivingScarecrow.class, Config.scarecrowSpawnWeight, 1, 1, EnumCreatureType.CREATURE, Biomes.PLAINS);
	}
	
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		for(Item i : items){
			event.getRegistry().register(i);
		}
	}
}
