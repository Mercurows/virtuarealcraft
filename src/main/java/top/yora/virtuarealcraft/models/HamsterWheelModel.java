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
public class HamsterWheelModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "hamster_wheel_model"), "main");
	public final ModelPart bb_main;

	public HamsterWheelModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition bone = bb_main.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 26.0F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(50, 60).addBox(-7.7887F, 2.8445F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(50, 60).addBox(-16.7874F, 13.5694F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.5F, 0.0F, 0.0F, 1.3963F));

		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(50, 60).addBox(-15.1244F, 9.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.5F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(50, 60).addBox(-11.9987F, 5.2751F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(50, 60).addBox(10.7874F, 13.5694F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.5F, 0.0F, 0.0F, -1.3963F));

		PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(50, 60).addBox(9.1244F, 9.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.5F, 0.0F, 0.0F, -1.0472F));

		PartDefinition cube_r7 = bone.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(50, 60).addBox(1.7887F, 2.8445F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.5F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r8 = bone.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(50, 60).addBox(5.9987F, 5.2751F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.5F, 0.0F, 0.0F, -0.6981F));

		PartDefinition bone2 = bb_main.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 23.0711F, 6.5711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r9 = bone2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(50, 60).addBox(-0.5818F, 22.6448F, 6.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r10 = bone2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(50, 60).addBox(3.9636F, 17.2282F, 6.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.3963F));

		PartDefinition cube_r11 = bone2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(50, 60).addBox(3.1237F, 19.5356F, 6.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r12 = bone2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(50, 60).addBox(1.5455F, 21.4166F, 6.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r13 = bone2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(50, 60).addBox(-9.9636F, 17.2282F, 6.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.3963F));

		PartDefinition cube_r14 = bone2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(50, 60).addBox(-9.1237F, 19.5356F, 6.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.0472F));

		PartDefinition cube_r15 = bone2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(50, 60).addBox(-5.4182F, 22.6448F, 6.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r16 = bone2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(50, 60).addBox(-7.5455F, 21.4166F, 6.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.6981F));

		PartDefinition bone3 = bb_main.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0001F, 9.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r17 = bone3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r18 = bone3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(50, 60).addBox(-2.9999F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.3963F));

		PartDefinition cube_r19 = bone3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r20 = bone3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r21 = bone3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0001F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.3963F));

		PartDefinition cube_r22 = bone3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.0472F));

		PartDefinition cube_r23 = bone3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r24 = bone3.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.6981F));

		PartDefinition bone4 = bb_main.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 8.9289F, 6.5712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r25 = bone4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(50, 60).addBox(-5.4181F, 9.3553F, 6.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r26 = bone4.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(50, 60).addBox(-9.9635F, 14.7718F, 6.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.3963F));

		PartDefinition cube_r27 = bone4.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(50, 60).addBox(-9.1236F, 12.4645F, 6.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r28 = bone4.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(50, 60).addBox(-7.5454F, 10.5835F, 6.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r29 = bone4.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(50, 60).addBox(3.9635F, 14.7718F, 6.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.3963F));

		PartDefinition cube_r30 = bone4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(50, 60).addBox(3.1236F, 12.4645F, 6.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.0472F));

		PartDefinition cube_r31 = bone4.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(50, 60).addBox(-0.5819F, 9.3553F, 6.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r32 = bone4.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(50, 60).addBox(1.5454F, 10.5835F, 6.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.6981F));

		PartDefinition bone5 = bb_main.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 6.0F, -0.5001F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition cube_r33 = bone5.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(50, 60).addBox(-6.4198F, 6.6029F, -1.0001F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r34 = bone5.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(50, 60).addBox(-12.848F, 14.263F, -1.0001F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.3963F));

		PartDefinition cube_r35 = bone5.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(50, 60).addBox(-11.6602F, 11.0F, -1.0001F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r36 = bone5.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(50, 60).addBox(-9.4282F, 8.3398F, -1.0001F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r37 = bone5.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(50, 60).addBox(6.848F, 14.263F, -1.0001F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.3963F));

		PartDefinition cube_r38 = bone5.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(50, 60).addBox(5.6602F, 11.0F, -1.0001F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.0472F));

		PartDefinition cube_r39 = bone5.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(50, 60).addBox(0.4198F, 6.6029F, -1.0001F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r40 = bone5.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(50, 60).addBox(3.4282F, 8.3398F, -1.0001F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.6981F));

		PartDefinition bone6 = bb_main.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 8.9289F, -7.5712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r41 = bone6.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(50, 60).addBox(-5.4181F, 9.3553F, -8.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r42 = bone6.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(50, 60).addBox(-9.9635F, 14.7718F, -8.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.3963F));

		PartDefinition cube_r43 = bone6.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(50, 60).addBox(-9.1236F, 12.4645F, -8.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r44 = bone6.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(50, 60).addBox(-7.5454F, 10.5835F, -8.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r45 = bone6.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(50, 60).addBox(3.9635F, 14.7718F, -8.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.3963F));

		PartDefinition cube_r46 = bone6.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(50, 60).addBox(3.1236F, 12.4645F, -8.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.0472F));

		PartDefinition cube_r47 = bone6.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(50, 60).addBox(-0.5819F, 9.3553F, -8.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r48 = bone6.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(50, 60).addBox(1.5454F, 10.5835F, -8.0712F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.6981F));

		PartDefinition bone7 = bb_main.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0001F, -10.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r49 = bone7.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r50 = bone7.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(50, 60).addBox(-2.9999F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.3963F));

		PartDefinition cube_r51 = bone7.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r52 = bone7.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r53 = bone7.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0001F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.3963F));

		PartDefinition cube_r54 = bone7.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.0472F));

		PartDefinition cube_r55 = bone7.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r56 = bone7.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.6981F));

		PartDefinition bone8 = bb_main.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(50, 60).addBox(-3.0F, 23.0711F, -7.5711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r57 = bone8.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(50, 60).addBox(-0.5818F, 22.6448F, -8.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r58 = bone8.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(50, 60).addBox(3.9636F, 17.2282F, -8.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.3963F));

		PartDefinition cube_r59 = bone8.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(50, 60).addBox(3.1237F, 19.5356F, -8.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r60 = bone8.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(50, 60).addBox(1.5455F, 21.4166F, -8.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r61 = bone8.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(50, 60).addBox(-9.9636F, 17.2282F, -8.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.3963F));

		PartDefinition cube_r62 = bone8.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(50, 60).addBox(-9.1237F, 19.5356F, -8.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.0472F));

		PartDefinition cube_r63 = bone8.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(50, 60).addBox(-5.4182F, 22.6448F, -8.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r64 = bone8.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(50, 60).addBox(-7.5455F, 21.4166F, -8.0711F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.6981F));

		PartDefinition bone9 = bb_main.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.9F, 11.425F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bone10 = bone9.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(50, 62).addBox(-2.48F, 23.28F, -0.42F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.44F, -0.075F));

		PartDefinition cube_r65 = bone10.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(50, 62).addBox(0.9398F, 22.6771F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r66 = bone10.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(50, 62).addBox(7.368F, 15.017F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 1.3963F));

		PartDefinition cube_r67 = bone10.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(50, 62).addBox(6.1802F, 18.28F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r68 = bone10.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(50, 62).addBox(3.9482F, 20.9402F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r69 = bone10.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(50, 62).addBox(-12.328F, 15.017F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -1.3963F));

		PartDefinition cube_r70 = bone10.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(50, 62).addBox(-11.1402F, 18.28F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -1.0472F));

		PartDefinition cube_r71 = bone10.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(50, 62).addBox(-5.8998F, 22.6771F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r72 = bone10.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(50, 62).addBox(-8.9082F, 20.9402F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -0.6981F));

		PartDefinition bone11 = bone9.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(50, 62).addBox(-2.48F, 3.28F, -0.4201F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.44F, 0.075F, 3.1416F, 0.0F, 0.0F));

		PartDefinition cube_r73 = bone11.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(50, 62).addBox(-5.8998F, 3.8829F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r74 = bone11.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(50, 62).addBox(-12.328F, 11.543F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 1.3963F));

		PartDefinition cube_r75 = bone11.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(50, 62).addBox(-11.1402F, 8.28F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r76 = bone11.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(50, 62).addBox(-8.9082F, 5.6198F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r77 = bone11.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(50, 62).addBox(7.368F, 11.543F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -1.3963F));

		PartDefinition cube_r78 = bone11.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(50, 62).addBox(6.1802F, 8.28F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -1.0472F));

		PartDefinition cube_r79 = bone11.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(50, 62).addBox(0.9398F, 3.8829F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r80 = bone11.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(50, 62).addBox(3.9482F, 5.6198F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -0.6981F));

		PartDefinition bone12 = bb_main.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offsetAndRotation(8.9F, 11.425F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bone13 = bone12.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(50, 62).addBox(-2.48F, 23.28F, -0.42F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.44F, -0.075F));

		PartDefinition cube_r81 = bone13.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(50, 62).addBox(0.9398F, 22.6771F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r82 = bone13.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(50, 62).addBox(7.368F, 15.017F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 1.3963F));

		PartDefinition cube_r83 = bone13.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(50, 62).addBox(6.1802F, 18.28F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r84 = bone13.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(50, 62).addBox(3.9482F, 20.9402F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r85 = bone13.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(50, 62).addBox(-12.328F, 15.017F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -1.3963F));

		PartDefinition cube_r86 = bone13.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(50, 62).addBox(-11.1402F, 18.28F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -1.0472F));

		PartDefinition cube_r87 = bone13.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(50, 62).addBox(-5.8998F, 22.6771F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r88 = bone13.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(50, 62).addBox(-8.9082F, 20.9402F, -0.84F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -0.6981F));

		PartDefinition bone14 = bone12.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(50, 62).addBox(-2.48F, 3.28F, -0.4201F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.44F, 0.075F, 3.1416F, 0.0F, 0.0F));

		PartDefinition cube_r89 = bone14.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(50, 62).addBox(-5.8998F, 3.8829F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r90 = bone14.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(50, 62).addBox(-12.328F, 11.543F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 1.3963F));

		PartDefinition cube_r91 = bone14.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(50, 62).addBox(-11.1402F, 8.28F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r92 = bone14.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(50, 62).addBox(-8.9082F, 5.6198F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r93 = bone14.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(50, 62).addBox(7.368F, 11.543F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -1.3963F));

		PartDefinition cube_r94 = bone14.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(50, 62).addBox(6.1802F, 8.28F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -1.0472F));

		PartDefinition cube_r95 = bone14.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(50, 62).addBox(0.9398F, 3.8829F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r96 = bone14.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(50, 62).addBox(3.9482F, 5.6198F, -0.8401F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.42F, 0.0F, 0.0F, -0.6981F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}