package top.yora.virtuarealcraft.models;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import top.yora.virtuarealcraft.Utils;

@SuppressWarnings("unused")
public class BloodWingsModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "blood_wings_model"), "main");
	public final ModelPart main;

	public BloodWingsModel(ModelPart root) {
		this.main = root.getChild("main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 2.7589F, -0.0554F));

		PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 11).addBox(1.5813F, -1.7965F, -1.7266F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 5).addBox(-1.4187F, -2.7965F, -1.7266F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, -0.0928F, -0.0924F, 0.7897F));

		PartDefinition cube_r2 = main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 5).mirror().addBox(-2.5813F, -2.7965F, -1.7266F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(8, 11).mirror().addBox(-4.5813F, -1.7965F, -1.7266F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, -0.0928F, 0.0924F, -0.7897F));

		PartDefinition cube_r3 = main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(15, 1).mirror().addBox(-11.5519F, -3.9749F, -1.8695F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).mirror().addBox(-9.5519F, -3.9749F, -2.3695F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, 0.0F, 0.2618F, 0.1745F));

		PartDefinition cube_r4 = main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(17, 14).mirror().addBox(-9.4842F, -3.9225F, -2.3028F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(18, 3).mirror().addBox(-11.7012F, -2.2191F, -2.3028F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, -0.1593F, 0.4002F, -0.6316F));

		PartDefinition cube_r5 = main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(16, 11).mirror().addBox(-7.5809F, -6.3928F, -2.2495F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, -0.3041F, 0.2951F, -1.0504F));

		PartDefinition cube_r6 = main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(14, 15).mirror().addBox(-11.6597F, -0.5723F, -2.3028F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, 0.0155F, 0.4289F, -0.2031F));

		PartDefinition cube_r7 = main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(6, 15).mirror().addBox(-11.3334F, 3.7629F, -2.3028F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, 0.3226F, 0.288F, 0.6261F));

		PartDefinition cube_r8 = main.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(10, 15).mirror().addBox(-9.0307F, 3.8135F, -2.3028F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, 0.4048F, 0.1466F, 1.0017F));

		PartDefinition cube_r9 = main.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(14, 7).mirror().addBox(-7.4347F, -1.8998F, -2.2495F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, 0.0033F, 0.4206F, -0.2188F));

		PartDefinition cube_r10 = main.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-7.5958F, -1.91F, -2.2495F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, 0.1725F, 0.3855F, 0.207F));

		PartDefinition cube_r11 = main.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(-10.9912F, 0.9333F, -2.3028F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, 0.1871F, 0.3885F, 0.2231F));

		PartDefinition cube_r12 = main.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(-6.0047F, 4.5942F, -1.8695F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, 0.2427F, 0.0992F, 1.3647F));

		PartDefinition cube_r13 = main.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-9.8607F, 0.0053F, -2.2495F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, 0.3084F, 0.2906F, 0.6114F));

		PartDefinition cube_r14 = main.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(8, 3).mirror().addBox(-4.9397F, 0.8893F, -1.8695F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, 0.1022F, 0.2415F, 0.5796F));

		PartDefinition cube_r15 = main.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(10, 0).mirror().addBox(-5.8407F, 2.6359F, -1.8695F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.5397F, 3.2455F, 0.1872F, 0.1841F, 0.9773F));

		PartDefinition cube_r16 = main.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 3).addBox(6.8607F, 0.0053F, -2.2495F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, 0.3084F, -0.2906F, -0.6114F));

		PartDefinition cube_r17 = main.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(10, 15).addBox(8.0307F, 3.8135F, -2.3028F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, 0.4048F, -0.1466F, -1.0017F));

		PartDefinition cube_r18 = main.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(6, 15).addBox(10.3334F, 3.7629F, -2.3028F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, 0.3226F, -0.288F, -0.6261F));

		PartDefinition cube_r19 = main.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 15).addBox(5.5958F, -1.91F, -2.2495F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, 0.1725F, -0.3855F, -0.207F));

		PartDefinition cube_r20 = main.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(14, 7).addBox(5.4347F, -1.8998F, -2.2495F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, 0.0033F, -0.4206F, 0.2188F));

		PartDefinition cube_r21 = main.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(14, 15).addBox(10.6597F, -0.5723F, -2.3028F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, 0.0155F, -0.4289F, 0.2031F));

		PartDefinition cube_r22 = main.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(18, 3).addBox(10.7012F, -2.2191F, -2.3028F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(17, 14).addBox(8.4842F, -3.9225F, -2.3028F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, -0.1593F, -0.4002F, 0.6316F));

		PartDefinition cube_r23 = main.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(16, 11).addBox(6.5809F, -6.3928F, -2.2495F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, -0.3041F, -0.2951F, 1.0504F));

		PartDefinition cube_r24 = main.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 11).addBox(7.9912F, 0.9333F, -2.3028F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, 0.1871F, -0.3885F, -0.2231F));

		PartDefinition cube_r25 = main.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 0).addBox(5.5519F, -3.9749F, -2.3695F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(15, 1).addBox(9.5519F, -3.9749F, -1.8695F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, 0.0F, -0.2618F, -0.1745F));

		PartDefinition cube_r26 = main.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(10, 0).addBox(3.8407F, 2.6359F, -1.8695F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, 0.1872F, -0.1841F, -0.9773F));

		PartDefinition cube_r27 = main.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 9).addBox(4.0047F, 4.5942F, -1.8695F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, 0.2427F, -0.0992F, -1.3647F));

		PartDefinition cube_r28 = main.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(8, 3).addBox(0.9397F, 0.8893F, -1.8695F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.5397F, 3.2455F, 0.1022F, -0.2415F, -0.5796F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}