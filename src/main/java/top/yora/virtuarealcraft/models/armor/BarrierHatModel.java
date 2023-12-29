package top.yora.virtuarealcraft.models.armor;// Made with Blockbench 4.8.1
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
public class BarrierHatModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "barrier_hat_model"), "main");
	public final ModelPart main;

	public BarrierHatModel(ModelPart root) {
		this.main = root.getChild("main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 13).addBox(-5.0F, -16.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 30).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-5.5F, -10.5F, -5.5F, 11.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(33, 0).addBox(4.0F, -7.0F, -4.0F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(30, 30).addBox(-7.0F, -7.0F, -4.0F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(30, 17).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(30, 13).addBox(-7.0F, -7.0F, 4.0F, 14.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition bow = main.addOrReplaceChild("bow", CubeListBuilder.create().texOffs(33, 0).addBox(-1.2431F, -2.5837F, -0.8F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2274F, -9.0812F, -5.3881F, -0.2182F, -0.2618F, 0.0F));

		PartDefinition cube_r1 = bow.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(30, 30).addBox(-4.1663F, -1.2537F, -0.3F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 13).addBox(-1.3598F, -0.4625F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 6).addBox(0.5292F, -2.2844F, -0.25F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2431F, -0.5013F, -0.3F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r2 = bow.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 30).addBox(-3.5292F, -2.2844F, -0.25F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 33).addBox(-0.6402F, -0.4625F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 18).addBox(1.1663F, -1.2537F, -0.3F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2431F, -0.5013F, -0.3F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r3 = bow.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1322F, 4.2947F, 0.2F, 0.0F, 0.0F, -0.1309F));

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