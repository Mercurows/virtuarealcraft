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
public class OrangeGrenadeModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "orange_grenade_model"), "main");
	public final ModelPart main;

	public OrangeGrenadeModel(ModelPart root) {
		this.main = root.getChild("main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bone = main.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -15.6F, -6.0F, 12.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(48, 9).addBox(-6.0F, -14.85F, 5.5F, 12.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 32).addBox(-6.0F, -14.85F, -6.5F, 12.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 32).addBox(5.5F, -14.85F, -6.0F, 1.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(-6.5F, -14.85F, -6.0F, 1.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(30, 21).addBox(-5.0F, -16.4F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(-5.0F, -7.9F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(44, 42).addBox(-4.0F, -17.1F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(36, 0).addBox(-4.0F, -7.4F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(14, 32).addBox(-3.0F, -6.85F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(40, 39).addBox(-2.0F, -17.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone2 = main.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(8, 4).addBox(-0.5F, -19.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(-1.0F, -19.5F, -2.8F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-1.5F, -19.5F, -5.6F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 0).addBox(-1.0F, -19.0F, -6.4F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 2).addBox(-0.5F, -18.0F, -6.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 6).addBox(-1.5F, -19.8F, -4.6F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -20.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}