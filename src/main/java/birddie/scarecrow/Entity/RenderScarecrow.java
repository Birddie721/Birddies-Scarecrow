package birddie.scarecrow.Entity;

import birddie.scarecrow.Entity.Model.Scarecrow;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderScarecrow extends RenderLiving<EntityScarecrow>{
	
	public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;

	public RenderScarecrow(RenderManager renderManager, ModelBase modelBase, float shadowSize) {
		super(renderManager, modelBase, shadowSize);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityScarecrow entity) {
		return new ResourceLocation("scarecrow:textures/entity/texture.png");
	}
	
	public static class Factory implements IRenderFactory<EntityScarecrow> {

		@Override
		public Render<? super EntityScarecrow> createRenderFor(RenderManager manager) {
			return new RenderScarecrow(manager, new Scarecrow(), 0.5f);
		}
		
	}
	
	@Override
    public void doRender(EntityScarecrow entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        
    }
}
