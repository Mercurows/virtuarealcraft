package top.yora.virtuarealcraft.models;// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

@SuppressWarnings("FieldCanBeLocal")
public class ShadowHoodModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer cube_r4_r1;
	private final ModelRenderer cube_r3_r1;
	private final ModelRenderer cube_r4_r2;
	private final ModelRenderer cube_r3_r2;

	public ShadowHoodModel() {
		super(1.0f);
		textureWidth = 64;
		textureHeight = 64;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		main.setTextureOffset(11, 18).addBox(3.9979F, -8.0F, -5.0F, 1.0F, 8.0F, 9.0F, 0.0F, false);
		main.setTextureOffset(25, 36).addBox(-4.0021F, -8.0F, 4.0F, 8.0F, 8.0F, 1.0F, 0.0F, false);
		main.setTextureOffset(0, 0).addBox(-4.0021F, -9.0F, -5.0F, 8.0F, 1.0F, 9.0F, 0.0F, false);
		main.setTextureOffset(22, 26).addBox(1.9979F, 0.0F, -5.0F, 3.0F, 1.0F, 9.0F, 0.0F, false);
		main.setTextureOffset(25, 0).addBox(-3.0021F, -10.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		main.setTextureOffset(9, 35).addBox(-6.0021F, -5.0F, -4.0F, 1.0F, 5.0F, 7.0F, 0.0F, false);
		main.setTextureOffset(0, 10).addBox(-5.0021F, -8.0F, -5.0F, 1.0F, 8.0F, 9.0F, 0.0F, false);
		main.setTextureOffset(22, 10).addBox(-5.0021F, 0.0F, -5.0F, 3.0F, 1.0F, 9.0F, 0.0F, false);
		main.setTextureOffset(36, 20).addBox(-2.0021F, 0.0F, 0.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		main.setTextureOffset(22, 20).addBox(-4.0021F, -8.0F, -6.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		main.setTextureOffset(0, 3).addBox(-4.0021F, -6.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		main.setTextureOffset(0, 0).addBox(2.9979F, -6.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		main.setTextureOffset(0, 28).addBox(4.9979F, -5.0F, -4.0F, 1.0F, 5.0F, 7.0F, 0.0F, false);

		cube_r4_r1 = new ModelRenderer(this);
		cube_r4_r1.setRotationPoint(-6.6995F, -7.7067F, 0.0F);
		main.addChild(cube_r4_r1);
		setRotationAngle(cube_r4_r1, 0.0F, 0.0F, -0.7854F);
		cube_r4_r1.setTextureOffset(11, 10).addBox(1.5F, 0.2F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r3_r1 = new ModelRenderer(this);
		cube_r3_r1.setRotationPoint(-3.5968F, -10.0439F, 0.0F);
		main.addChild(cube_r3_r1);
		setRotationAngle(cube_r3_r1, 0.0F, 0.0F, 0.3927F);
		cube_r3_r1.setTextureOffset(37, 25).addBox(-0.675F, -1.65F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r4_r2 = new ModelRenderer(this);
		cube_r4_r2.setRotationPoint(6.6995F, -7.7067F, 0.0F);
		main.addChild(cube_r4_r2);
		setRotationAngle(cube_r4_r2, 0.0F, 0.0F, 0.7854F);
		cube_r4_r2.setTextureOffset(37, 7).addBox(-5.5F, 0.2F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r3_r2 = new ModelRenderer(this);
		cube_r3_r2.setRotationPoint(3.5968F, -10.0439F, 0.0F);
		main.addChild(cube_r3_r2);
		setRotationAngle(cube_r3_r2, 0.0F, 0.0F, -0.3927F);
		cube_r3_r2.setTextureOffset(39, 41).addBox(-0.325F, -1.65F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		main.copyModelAngles(this.bipedHead);
		main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}