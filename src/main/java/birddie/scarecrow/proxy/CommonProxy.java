package birddie.scarecrow.proxy;

import birddie.scarecrow.scarecrow;
import birddie.scarecrow.Entity.EntityNonlivingScarecrow;
import birddie.scarecrow.Entity.EntityScarecrow;
import birddie.scarecrow.events.BeheadingEvent;
import birddie.scarecrow.handlers.ScarecrowRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy {
	public static SimpleNetworkWrapper NETWORK_TO_CLIENT;
	public static SimpleNetworkWrapper NETWORK_TO_SERVER;
	public static SimpleNetworkWrapper ADVANCEMENT_MESSAGE;
	@EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		event.getModMetadata().modId = scarecrow.MODID;
    	event.getModMetadata().version = scarecrow.VERSION;
    	MinecraftForge.EVENT_BUS.register(new ScarecrowRegistry());
    	ScarecrowRegistry.preInit();
    	EntityRegistry.registerModEntity(new ResourceLocation(scarecrow.MODID+":scarecrow"), EntityScarecrow.class, "scarecrow",7,scarecrow.instance,64,1,true);
    	EntityRegistry.registerModEntity(new ResourceLocation(scarecrow.MODID+":nonliving_scarecrow"), EntityNonlivingScarecrow.class, "nonliving_scarecrow", 13, scarecrow.instance, 64, 1, true);
    	/*
    	NetworkRegistry.INSTANCE.registerGuiHandler(scarecrow.instance, new GuiHandler());
    	NETWORK_TO_CLIENT = NetworkRegistry.INSTANCE.newSimpleChannel(scarecrow.MODID + "CLIENT");
    	NETWORK_TO_CLIENT.registerMessage(RaceSyncHandler.class, RaceMessage.class, 1, Side.CLIENT);
    	NETWORK_TO_SERVER = NetworkRegistry.INSTANCE.newSimpleChannel(scarecrow.MODID + "SERVER");
    	NETWORK_TO_SERVER.registerMessage(NewRaceSyncHandler.class, NewRaceMessage.class, 1, Side.SERVER);
    	ADVANCEMENT_MESSAGE = NetworkRegistry.INSTANCE.newSimpleChannel(scarecrow.MODID + "SERVER ADVANCEMENT");
    	ADVANCEMENT_MESSAGE.registerMessage(AdvancementMessageHelper.class, AdvancementEffectMessage.class, 1, Side.SERVER);
    	CapabilityManager.INSTANCE.register(IRace.class, new RaceStorage(), Race::new);*/
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	MinecraftForge.EVENT_BUS.register(new BeheadingEvent());
    	

    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
    
    public IThreadListener getListener(MessageContext ctx) {
    	return (WorldServer) ctx.getServerHandler().player.world;
    }
    
    public EntityPlayer getPlayer(MessageContext ctx) {
    	return ctx.getServerHandler().player;
    }
    
}
