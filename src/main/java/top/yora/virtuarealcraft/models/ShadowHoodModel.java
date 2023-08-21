package top.yora.virtuarealcraft.models;// Made with Blockbench 4.8.1
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
public class ShadowHoodModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "shadow_hood_model"), "main");
	public final ModelPart main;

	public ShadowHoodModel(ModelPart root) {
		this.main = root.getChild("main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(11, 18).addBox(3.9979F, -8.0F, -5.0F, 1.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(25, 36).addBox(-4.0021F, -8.0F, 4.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0021F, -9.0F, -5.0F, 8.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(22, 26).addBox(1.9979F, 0.0F, -5.0F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(25, 0).addBox(-3.0021F, -10.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(9, 35).addBox(-6.0021F, -5.0F, -4.0F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).addBox(-5.0021F, -8.0F, -5.0F, 1.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(22, 10).addBox(-5.0021F, 0.0F, -5.0F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(36, 20).addBox(-2.0021F, 0.0F, 0.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(22, 20).addBox(-4.0021F, -8.0F, -6.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 3).addBox(-4.0021F, -6.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(2.9979F, -6.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(4.9979F, -5.0F, -4.0F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r4_r1 = main.addOrReplaceChild("cube_r4_r1", CubeListBuilder.create().texOffs(11, 10).addBox(1.5F, 0.2F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.6995F, -7.7067F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r3_r1 = main.addOrReplaceChild("cube_r3_r1", CubeListBuilder.create().texOffs(37, 25).addBox(-0.675F, -1.65F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5968F, -10.0439F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r4_r2 = main.addOrReplaceChild("cube_r4_r2", CubeListBuilder.create().texOffs(37, 7).addBox(-5.5F, 0.2F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6995F, -7.7067F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r3_r2 = main.addOrReplaceChild("cube_r3_r2", CubeListBuilder.create().texOffs(39, 41).addBox(-0.325F, -1.65F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5968F, -10.0439F, 0.0F, 0.0F, 0.0F, -0.3927F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}