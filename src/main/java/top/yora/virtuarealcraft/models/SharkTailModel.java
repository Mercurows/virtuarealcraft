package top.yora.virtuarealcraft.models;// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

@SuppressWarnings("FieldCanBeLocal")
public class SharkTailModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;

	public SharkTailModel() {
		super(1.0f);
		textureWidth = 32;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		main.setTextureOffset(21, 6).addBox(-1.0F, 11.2534F, 5.5253F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		main.setTextureOffset(10, 17).addBox(-0.5F, 10.4F, 9.425F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 10.8278F, 6.1549F);
		main.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.7418F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(6, 16).addBox(-0.5F, -3.7072F, 0.7593F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 10.8278F, 6.1549F);
		main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.1745F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(-0.5F, -3.4146F, 2.5669F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 10.8278F, 6.1549F);
		main.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.7974F, 0.1536F, -0.0103F);
		cube_r3.setTextureOffset(0, 16).addBox(-1.2328F, 1.2414F, -1.6083F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 10.8278F, 6.1549F);
		main.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.7974F, -0.1536F, 0.0103F);
		cube_r4.setTextureOffset(16, 0).addBox(0.2328F, 1.2414F, -1.6083F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 10.8278F, 6.1549F);
		main.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.2209F, 0.1878F, -0.1876F);
		cube_r5.setTextureOffset(0, 8).addBox(-1.3662F, 0.2847F, -5.4574F, 1.0F, 3.0F, 5.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 10.8278F, 6.1549F);
		main.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.8249F, 0.274F, -0.2849F);
		cube_r6.setTextureOffset(17, 19).addBox(-1.0407F, 1.7668F, -5.7139F, 1.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, 10.8278F, 6.1549F);
		main.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.2209F, -0.1878F, 0.1876F);
		cube_r7.setTextureOffset(9, 3).addBox(0.3662F, 0.2847F, -5.4574F, 1.0F, 3.0F, 5.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, 10.8278F, 6.1549F);
		main.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.3054F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(0, 0).addBox(-1.0F, 0.4564F, -4.5703F, 2.0F, 3.0F, 5.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.0F, 10.8278F, 6.1549F);
		main.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.8249F, -0.274F, 0.2849F);
		cube_r9.setTextureOffset(0, 22).addBox(0.0407F, 1.7668F, -5.7139F, 1.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(0.0F, 10.8278F, 6.1549F);
		main.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.7854F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(12, 11).addBox(-2.0F, 1.7668F, -4.1091F, 4.0F, 4.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		main.copyModelAngles(this.bipedBody);
		main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}