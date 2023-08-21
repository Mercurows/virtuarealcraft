package top.yora.virtuarealcraft.models;// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import top.yora.virtuarealcraft.Utils;

@SuppressWarnings("unused")
public class KuyaModel extends Model {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/kuya_texture.png");
	private final ModelPart main;

	public KuyaModel(ModelPart root) {
		super(RenderType::entitySolid);
		this.main = root.getChild("main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -12.0F, -2.5F, 7.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-2.5F, -13.0F, -2.5F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(1, 10).addBox(-2.5F, -8.75F, -2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.75F, 0.0F));

		PartDefinition ears = head.addOrReplaceChild("ears", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = ears.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(26, 11).addBox(-1.0F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -13.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r2 = ears.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(26, 4).addBox(-1.0F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 15).addBox(-3.0F, -7.0F, -1.5F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.3388F, -0.8719F, 1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r3 = arms.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 23).addBox(-1.0F, -0.7954F, -1.3681F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r4 = arms.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(18, 17).addBox(-1.0F, -0.9036F, -0.6201F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 0.0F, 0.2182F, -0.1745F, 0.0F));

		PartDefinition cube_r5 = arms.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 24).addBox(-1.0F, -0.7954F, -1.3681F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition cube_r6 = arms.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(18, 11).addBox(-1.0F, -0.9036F, -0.6201F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.0F, 0.0F, 0.2182F, 0.1745F, 0.0F));

		PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition cube_r7 = legs.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(22, 7).addBox(-4.5F, -1.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, 4.8453F, -0.9791F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r8 = legs.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(16, 23).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 0).addBox(-4.5F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, 2.75F, -0.25F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bow = body.addOrReplaceChild("bow", CubeListBuilder.create().texOffs(0, 12).addBox(-0.7677F, -0.6516F, -0.1707F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-2.7328F, -0.9623F, -0.1707F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2677F, -6.0984F, -1.8293F, 0.0F, -0.1309F, 0.0F));

		PartDefinition bow_r1 = bow.addOrReplaceChild("bow_r1", CubeListBuilder.create().texOffs(0, 3).addBox(0.0663F, 0.1892F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0663F, -0.8108F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2712F, -0.0754F, -0.2752F, 0.0F, 0.48F, 0.0F));

		PartDefinition cube_r9 = bow.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(26, 17).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9634F, -0.3798F, -0.1149F, -0.1122F, 0.4677F, -0.2449F));

		PartDefinition cube_r10 = bow.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(25, 0).addBox(-1.1603F, -0.0606F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2712F, -0.0754F, -0.2752F, 0.1966F, 0.4407F, 0.4369F));

		PartDefinition cube_r11 = bow.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(26, 19).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5002F, 0.1931F, 0.3293F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r12 = bow.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(24, 26).addBox(-1.5F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2296F, 0.1571F, 0.3293F, 0.0F, 0.0F, 0.3927F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}