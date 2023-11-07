package birddie.scarecrow.Entity;

import birddie.scarecrow.Entity.Model.NonlivingScarecrow;
import birddie.scarecrow.handlers.ScarecrowRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderNonlivingScarecrow extends RenderLiving<EntityNonlivingScarecrow>{
	
	public RenderNonlivingScarecrow(RenderManager renderManager, ModelBase modelBase, float shadowSize) {
		super(renderManager, modelBase, shadowSize);
		//this.addLayer(new LayerHeldItem(this));
		//this.addLayer(new doRenderLayer(this, ScarecrowRegistry.scythe, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.RIGHT));
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityNonlivingScarecrow entity) {
		return new ResourceLocation("scarecrow:textures/entity/texture.png");
	}
	
	public static class Factory implements IRenderFactory<EntityNonlivingScarecrow> {

		@Override
		public Render<? super EntityNonlivingScarecrow> createRenderFor(RenderManager manager) {
			return new RenderNonlivingScarecrow(manager, new NonlivingScarecrow(), 0.5f);
		}
		
	}
	
	@Override
    public void doRender(EntityNonlivingScarecrow entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
