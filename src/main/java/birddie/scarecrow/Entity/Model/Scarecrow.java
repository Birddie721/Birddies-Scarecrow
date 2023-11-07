package birddie.scarecrow.Entity.Model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class Scarecrow extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer LegLeftTop;
	private final ModelRenderer LegLeftBottom;
	private final ModelRenderer ArmLeftTop;
	private final ModelRenderer ArmLeftBottom;
	private final ModelRenderer ScytheHandle;
	private final ModelRenderer Blade1;
	private final ModelRenderer Blade2;
	private final ModelRenderer Blade3;
	private final ModelRenderer ArmRightTop;
	private final ModelRenderer ArmRightBottom;
	private final ModelRenderer Head;
	private final ModelRenderer HatBrim;
	private final ModelRenderer Hat;
	private final ModelRenderer LegRightTop;
	private final ModelRenderer LegRightBottom;
	
	protected double distanceMovedTotal = 0.0D;
	protected static final double CYCLES_PER_BLOCK = 1.0D;
	
	protected double lastAge = 0.0D;
	protected double lastDistance = 0.0D;
	protected boolean standingStill = true;
	
	protected int cycleIndex = 0;
	protected float[] gravityCycle = {    0F, -0.2F, -0.5F, -0.7F, -0.5F, -0.2F, 0.0F, -0.2F, -0.5f, -0.7f, -0.5f, -0.2f};
	protected float[] bodyRotateCycle = {15F,   10F,  7.5F,  0.0F, -7.5F,  -10f, -15F,  -10f, -7.5f,  0.0f, 7.5f,  10.0f};
	
	//-39.43
	protected float[] leftArmTopRotateCycle = {-100f, -80f, -60f, -39.41f, -35f, -30.3f, -26f, -30.3f, -35f, -39.41f, -60f, -80f};
	//-110.3
	protected float[] leftArmBottomRotateCycle = {};
	
	//28.31
	protected float[] rightArmTopRotateCycle = {18.26f, 21.5f, 25f, 28.31f, 31.5f, 34f, 36.52f, 34f, 31.5f, 28.31f, 25f, 21,5f};
	protected float[] rightArmBottomRotateCycle = {};
	
	//-9.13
	protected float[] leftLegTopRotateCycle = {-14F, -9F, -4.5F, 0F, 0F, -2F, -6.5F, -2F, 0F, 0F, -4.5F, -9F};
	protected float[] leftLegBottomRotateCycle = {};
	
	//8.4
	protected float[] rightLegTopRotateCycle = {8.4F, 8.4F, 8.4F, 8.4F, 6.5F, 13.5F, 20.0F, 13.5F, 6.5F, 8.4F, 8.4F, 8.4F};
	protected float[] rightLegBottomRotateCycle = {};
	
	

	public Scarecrow() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(-1.3F, -1.4F, -1.7F);
		setRotationAngle(Body, 0.2824F, -0.3529F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 32, 0.0F, -16.0F, 0.0F, 7, 16, 3, 0.0F, false));

		LegLeftTop = new ModelRenderer(this);
		LegLeftTop.setRotationPoint(4.6F, -1.7F, 1.6F);
		Body.addChild(LegLeftTop);
		setRotationAngle(LegLeftTop, -0.5198F, 0.0F, -0.1593F);
		LegLeftTop.cubeList.add(new ModelBox(LegLeftTop, 28, 40, 0.0F, 0.0F, 0.0F, 1, 13, 1, 0.0F, false));

		LegLeftBottom = new ModelRenderer(this);
		LegLeftBottom.setRotationPoint(0.3F, 12.6F, -0.3F);
		LegLeftTop.addChild(LegLeftBottom);
		setRotationAngle(LegLeftBottom, 0.3366F, -0.5222F, 0.0F);
		LegLeftBottom.cubeList.add(new ModelBox(LegLeftBottom, 24, 32, 0.0F, 0.0F, 0.0F, 1, 16, 1, 0.0F, false));

		ArmLeftTop = new ModelRenderer(this);
		ArmLeftTop.setRotationPoint(6.0F, -14.0F, 1.2F);
		Body.addChild(ArmLeftTop);
		setRotationAngle(ArmLeftTop, -0.3176F, 0.0F, -0.6882F);
		ArmLeftTop.cubeList.add(new ModelBox(ArmLeftTop, 40, 40, 0.0F, 0.0F, 0.0F, 1, 11, 1, 0.0F, false));

		ArmLeftBottom = new ModelRenderer(this);
		ArmLeftBottom.setRotationPoint(0.6F, 11.5F, 0.0F);
		ArmLeftTop.addChild(ArmLeftBottom);
		setRotationAngle(ArmLeftBottom, -0.2869F, 0.0F, -1.926F);
		ArmLeftBottom.cubeList.add(new ModelBox(ArmLeftBottom, 36, 40, 0.0F, 0.0F, 0.0F, 1, 11, 1, 0.0F, false));

		ScytheHandle = new ModelRenderer(this);
		ScytheHandle.setRotationPoint(-18.8F, 15.6F, 0.5F);
		ArmLeftBottom.addChild(ScytheHandle);
		setRotationAngle(ScytheHandle, 0.0F, -0.0314F, 0.5918F);
		ScytheHandle.cubeList.add(new ModelBox(ScytheHandle, 0, 0, 0.0F, -15.0F, 0.0F, 42, 1, 1, 0.0F, false));

		Blade1 = new ModelRenderer(this);
		Blade1.setRotationPoint(41.1F, 0.0F, 0.0F);
		ScytheHandle.addChild(Blade1);
		setRotationAngle(Blade1, 0.0F, 0.0F, 3.1416F);
		Blade1.cubeList.add(new ModelBox(Blade1, 0, 2, 0.0F, 15.0F, 0.0F, 4, 12, 1, 0.0F, false));

		Blade2 = new ModelRenderer(this);
		Blade2.setRotationPoint(9.0F, -4.7F, 0.0F);
		Blade1.addChild(Blade2);
		Blade2.cubeList.add(new ModelBox(Blade2, 0, 19, -7.0F, 31.0F, 0.0F, 3, 6, 1, 0.0F, false));

		Blade3 = new ModelRenderer(this);
		Blade3.setRotationPoint(1.8F, 6.0F, 0.0F);
		Blade2.addChild(Blade3);
		Blade3.cubeList.add(new ModelBox(Blade3, 27, 19, -7.0F, 31.0F, 0.0F, 2, 4, 1, 0.0F, false));

		ArmRightTop = new ModelRenderer(this);
		ArmRightTop.setRotationPoint(0.3F, -15.2F, 0.9F);
		Body.addChild(ArmRightTop);
		setRotationAngle(ArmRightTop, 0.0F, 0.0F, 0.4941F);
		ArmRightTop.cubeList.add(new ModelBox(ArmRightTop, 32, 40, 0.0F, 0.0F, 0.0F, 1, 11, 1, 0.0F, false));

		ArmRightBottom = new ModelRenderer(this);
		ArmRightBottom.setRotationPoint(1.3F, 12.4F, 1.7F);
		ArmRightTop.addChild(ArmRightBottom);
		setRotationAngle(ArmRightBottom, -0.3353F, 0.0F, -0.4057F);
		ArmRightBottom.cubeList.add(new ModelBox(ArmRightBottom, 44, 40, -0.8F, -1.0F, -2.0F, 1, 11, 1, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-1.9F, -24.3F, 0.4F);
		Body.addChild(Head);
		setRotationAngle(Head, -0.2824F, 0.3407F, -0.1093F);
		Head.cubeList.add(new ModelBox(Head, 28, 24, 0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F, false));

		HatBrim = new ModelRenderer(this);
		HatBrim.setRotationPoint(-2.7F, 2.9F, -2.3F);
		Head.addChild(HatBrim);
		HatBrim.cubeList.add(new ModelBox(HatBrim, 0, 2, -1.0F, 0.0F, -2.0F, 16, 1, 16, 0.0F, false));

		Hat = new ModelRenderer(this);
		Hat.setRotationPoint(0.8F, 1.4F, 1.2F);
		Head.addChild(Hat);
		Hat.cubeList.add(new ModelBox(Hat, 0, 19, -1.0F, -2.0F, -2.0F, 9, 4, 9, 0.0F, false));

		LegRightTop = new ModelRenderer(this);
		LegRightTop.setRotationPoint(1.1F, -0.9F, 2.2F);
		Body.addChild(LegRightTop);
		setRotationAngle(LegRightTop, -0.7269F, 0.3079F, 0.1466F);
		LegRightTop.cubeList.add(new ModelBox(LegRightTop, 10, 2, 0.0F, 0.0F, 0.0F, 1, 13, 1, 0.0F, false));

		LegRightBottom = new ModelRenderer(this);
		LegRightBottom.setRotationPoint(-0.2F, 13.1F, 0.6F);
		LegRightTop.addChild(LegRightBottom);
		setRotationAngle(LegRightBottom, 0.8053F, 0.1651F, 0.0F);
		LegRightBottom.cubeList.add(new ModelBox(LegRightBottom, 20, 32, 0.0F, 0.0F, 0.0F, 1, 16, 1, 0.0F, false));
	}

	
	/**
	 * Entity entityIn, f limbSwing, f1 limbSwingAmount, f2 ageInTicks, f3 netHeadYaw, f4 headPitch, f5 scale
	 */
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
	    Body.render(f5);
	}
	
	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
	    lastDistance = distanceMovedTotal;
		updateDistanceMovedTotal(entity);
	    cycleIndex = (int) ((getDistanceMovedTotal(entity)*CYCLES_PER_BLOCK)%gravityCycle.length);
	    if (f2 > lastAge && lastDistance == distanceMovedTotal) {
	    	cycleIndex = 0;
	    	Body.offsetY = 0f;
	    	Body.rotateAngleZ = 0f;
	    	LegLeftTop.rotateAngleZ = (float) Math.toRadians(-9.13f);
	    	LegRightTop.rotateAngleZ = (float) Math.toRadians(8.4f);
	    	ArmRightTop.rotateAngleZ = (float) Math.toRadians(28.31f);
	    	ArmLeftTop.rotateAngleZ = (float) Math.toRadians(-39.43f);
	    }else {
	    	Body.offsetY = gravityCycle[cycleIndex];
		    Body.rotateAngleZ = (float) Math.toRadians(bodyRotateCycle[cycleIndex]);
		    LegLeftTop.rotateAngleZ = (float) Math.toRadians(-9.13f + leftLegTopRotateCycle[cycleIndex]);
		    LegRightTop.rotateAngleZ = (float) Math.toRadians(rightLegTopRotateCycle[cycleIndex]);
		    ArmRightTop.rotateAngleZ = (float) Math.toRadians(rightArmTopRotateCycle[cycleIndex]);
		    ArmLeftTop.rotateAngleZ = (float) Math.toRadians(leftArmTopRotateCycle[cycleIndex]);
	    }
	    if(lastDistance != distanceMovedTotal) {
	    	lastAge = f2;
	    }  
	}
	
	
	protected void updateDistanceMovedTotal(Entity parEntity) 
	{
	    distanceMovedTotal += parEntity.getDistance(parEntity.prevPosX, parEntity.prevPosY, parEntity.prevPosZ);
	}
	    
	protected double getDistanceMovedTotal(Entity parEntity) 
	{
	    return (distanceMovedTotal);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}