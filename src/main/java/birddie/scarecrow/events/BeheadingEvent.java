package birddie.scarecrow.events;

import java.util.Random;

import birddie.scarecrow.Entity.EntityScarecrow;
import birddie.scarecrow.handlers.ScarecrowRegistry;
import birddie.scarecrow.items.Scythe;
import birddie.scarecrow.proxy.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BeheadingEvent {
	
	@SubscribeEvent
	public void dropHeadOnKill(LivingDropsEvent event) {
		Random random = new Random();
		Entity entity = event.getEntityLiving();
		if(event.getSource() instanceof EntityDamageSource) {
			ItemStack weapon = ((EntityLivingBase)event.getSource().getTrueSource()).getHeldItem(EnumHand.MAIN_HAND);
			ItemStack head = getMobHead(event.getEntityLiving());
			if(weapon.getItem() instanceof Scythe) {
				EntityItem mobHead = new EntityItem(entity.getEntityWorld(), entity.posX, entity.posY, entity.posZ, head);
				mobHead.setDefaultPickupDelay();
		        event.getDrops().add(mobHead);
			}
		}
		if(entity instanceof EntityScarecrow && random.nextInt(99) < Config.scytheDropChance) {
			ItemStack item = new ItemStack(ScarecrowRegistry.scythe, 1);
			EntityItem Scythe = new EntityItem(entity.getEntityWorld(), entity.posX, entity.posY, entity.posZ, item);
			event.getDrops().add(Scythe);
		}
	}
	
	private ItemStack getMobHead(EntityLivingBase entity) {
		Random random = new Random();
	    if (entity instanceof EntitySkeleton) {
	    	if(random.nextInt(99) >= Config.skeletonBeheadRate) {return ItemStack.EMPTY;}
	        return new ItemStack(Items.SKULL, 1, 0);
	    } else if (entity instanceof EntityWitherSkeleton) {
	    	if(random.nextInt(99) >= Config.witherSkeletonBeheadRate) {return ItemStack.EMPTY;}
	    	return new ItemStack(Items.SKULL, 1, 1);
	    } else if (entity instanceof EntityZombie) {
	    	if(random.nextInt(99) >= Config.zombieBeheadRate) {return ItemStack.EMPTY;}
	    	return new ItemStack(Items.SKULL, 1, 2);
	    } else if (entity instanceof EntityCreeper) {
	    	if(random.nextInt(99) >= Config.creeperBeheadRate) {return ItemStack.EMPTY;}
	    	return new ItemStack(Items.SKULL, 1, 4);
	    } else if(entity instanceof EntityPlayerMP){
	    	if(random.nextInt(99) >= Config.playerBeheadRate) {return ItemStack.EMPTY;}
	    	ItemStack skull = new ItemStack(Items.SKULL, 1, 3);
	    	NBTTagCompound nbt = new NBTTagCompound();
		    nbt.setString("SkullOwner", entity.getName());
		    skull.setTagCompound(nbt);
	    	return skull;
	    }else {
	        return ItemStack.EMPTY;
	    }
	}
}
