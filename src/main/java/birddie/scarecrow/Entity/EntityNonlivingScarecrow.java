package birddie.scarecrow.Entity;

import java.util.Calendar;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import birddie.scarecrow.handlers.ScarecrowRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Rotations;
import net.minecraft.world.World;

public class EntityNonlivingScarecrow extends EntityLiving{


	public EntityNonlivingScarecrow(World worldIn) {
		super(worldIn);
		setSize(0.6f, 3.1f);
	}
	
	@Override
	public boolean canBePushed()
    {
        return false;
    }
	
	 public boolean attackEntityFrom(DamageSource source, float amount){
	        if (!this.world.isRemote && !this.isDead){
	        	this.setDead();
	        }
	        return false;
	 }
	 
	 public EnumHandSide getPrimaryHand()
	    {
	        return EnumHandSide.LEFT;
	    }

	    protected SoundEvent getFallSound(int heightIn)
	    {
	        return null;
	    }

	    @Nullable
	    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	    {
	        return null;
	    }

	    @Nullable
	    protected SoundEvent getDeathSound()
	    {
	        return null;
	    }


	    public boolean canBeHitWithPotion()
	    {
	        return false;
	    }
	    
	    public boolean attackable()
	    {
	        return false;
	    }
	    
	    public void onLivingUpdate() {
	    	Random random = new Random();
	    	World world = this.world;
	    	Calendar calendar = world.getCurrentDate();
	    	
	        long worldTime = world.getWorldTime();
	        boolean isMidnight = worldTime >= 18000 && worldTime < 19000;
	        boolean isNight = worldTime > 12000 && worldTime <=23999;
	        
	        //if it is midnight and full moon
	    	if(isMidnight && world.getMoonPhase() == 0) {
	    		spawnScarecrow();
	    	}
	    	
	    	//if it is Halloween
	    	else if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31){
	            if(isNight) {
	            	spawnScarecrow();
	            }
	        }
	    	
	    	// 25/12000 chance when not midnight on a full moon
	    	else if(isNight && random.nextInt(12000) <= 24) {
	    		spawnScarecrow();
	    	}

	    }
	    
	    void spawnScarecrow() {
	    	this.setDead();
    		EntityScarecrow scarecrow = new EntityScarecrow(world);
			scarecrow.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
			scarecrow.setLeftHanded(true);
	        scarecrow.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ScarecrowRegistry.scythe));
			world.spawnEntity(scarecrow);
	    }
	    
	    
	    
	    
}
