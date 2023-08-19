package top.yora.virtuarealcraft.models;// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.world.entity.LivingEntity;

@SuppressWarnings("FieldCanBeLocal")
public class MihiruTailModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer bone2;
	private final ModelRenderer bone;
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;

	public MihiruTailModel() {
		super(1.0f);
		textureWidth = 32;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F,24.0F,0.0F);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -2.0F, 0.0F);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -2.0F, 0.0F);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, -2.0F, 0.0F);

		main.addChild(bone);
		main.addChild(bone2);
		main.addChild(bb_main);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-0.025F, -1.7855F, 1.0226F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 2.7222F, 0.7405F, 2.8495F);
		cube_r1.setTextureOffset(11, 29).addBox(-4.8776F, 18.8983F, -4.8523F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-0.025F, -1.7855F, 1.0226F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 2.7222F, -0.7405F, -2.8495F);
		cube_r2.setTextureOffset(22, 19).addBox(3.8599F, 18.8983F, -4.8699F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-0.025F, -1.7855F, 1.0226F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, 2.8362F, 0.0F, 3.1416F);
		cube_r3.setTextureOffset(14, 25).addBox(-0.475F, 18.8983F, -6.2158F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-0.025F, -1.7855F, 1.0226F);
		bb_main.addChild(cube_r4);
		setRotationAngle(cube_r4, -3.0543F, 0.0F, 3.1416F);
		cube_r4.setTextureOffset(20, 22).addBox(-0.475F, 16.153F, -10.5858F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-0.025F, -1.7855F, 1.0226F);
		bb_main.addChild(cube_r5);
		setRotationAngle(cube_r5, -2.2689F, 0.0F, 3.1416F);
		cube_r5.setTextureOffset(20, 14).addBox(-0.475F, 7.9446F, -14.231F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-0.025F, -1.7855F, 1.0226F);
		bb_main.addChild(cube_r6);
		setRotationAngle(cube_r6, -2.6616F, 0.0F, 3.1416F);
		cube_r6.setTextureOffset(20, 28).addBox(-0.475F, 12.7097F, -11.7248F, 1.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.copyModelAngles(this.bipedBody);
		main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}
}