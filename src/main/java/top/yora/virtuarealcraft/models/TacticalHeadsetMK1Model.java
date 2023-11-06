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

public class TacticalHeadsetMK1Model<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Utils.MOD_ID, "tactical_headset_mk1"), "main");
    public final ModelPart main;

    public TacticalHeadsetMK1Model(ModelPart root) {
        this.main = root.getChild("main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition headset = head.addOrReplaceChild("headset", CubeListBuilder.create().texOffs(4, 25).addBox(-5.9F, -6.25F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 21).addBox(4.9F, -6.25F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = headset.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 23).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7959F, -9.025F, 0.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r2 = headset.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 22).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2504F, -8.9833F, 0.0F, 0.0F, 0.0F, -1.4835F));

        PartDefinition cube_r3 = headset.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(28, 2).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0009F, -8.6763F, 0.0F, 0.0F, 0.0F, -1.0908F));

        PartDefinition cube_r4 = headset.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3217F, -8.5354F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r5 = headset.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0288F, -7.5695F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r6 = headset.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.0F, -2.0F, -2.5F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -2.5F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition cube_r7 = headset.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(7, 4).addBox(-1.0F, -2.0F, -2.5F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(6, 13).addBox(0.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -2.5F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r8 = headset.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(24, 4).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7959F, -9.025F, 0.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r9 = headset.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(24, 12).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2504F, -8.9833F, 0.0F, 0.0F, 0.0F, 1.4835F));

        PartDefinition cube_r10 = headset.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(8, 28).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0009F, -8.6763F, 0.0F, 0.0F, 0.0F, 1.0908F));

        PartDefinition cube_r11 = headset.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(28, 10).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3217F, -8.5354F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r12 = headset.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(24, 23).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0288F, -7.5695F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition earset = head.addOrReplaceChild("earset", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -0.7F));

        PartDefinition ears = earset.addOrReplaceChild("ears", CubeListBuilder.create().texOffs(20, 20).addBox(0.1448F, 0.7916F, -1.5829F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5448F, -34.2916F, 2.5829F, 0.0F, 0.0F, -0.1309F));

        PartDefinition cube_r13 = ears.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(14, 3).addBox(-2.5F, -0.5F, -0.9999F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9498F, 0.0368F, -0.5829F, 0.0F, 0.0F, 1.789F));

        PartDefinition cube_r14 = ears.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(17, 0).addBox(0.7F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 20).addBox(-2.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.538F, -0.431F, 0.4667F, -0.0804F, -0.2494F, 1.6681F));

        PartDefinition cube_r15 = ears.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 2).addBox(0.75F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 0).addBox(-2.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1048F, -0.5486F, 0.461F, -0.0233F, -0.2608F, 1.443F));

        PartDefinition cube_r16 = ears.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 9).addBox(0.7F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 8).addBox(-2.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3288F, -0.6327F, 0.4642F, 0.035F, -0.2595F, 1.2172F));

        PartDefinition cube_r17 = ears.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(28, 25).addBox(0.25F, -0.6F, -0.9998F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5382F, -2.8555F, -0.5829F, 0.0F, 0.0F, 1.3526F));

        PartDefinition cube_r18 = ears.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(14, 6).addBox(-3.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2118F, 0.1756F, -0.5829F, 0.0F, 0.0F, 1.0472F));

        PartDefinition cube_r19 = ears.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(19, 9).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6585F, 1.5692F, -0.5829F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r20 = ears.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(23, 27).addBox(-0.9F, -0.95F, -0.25F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1052F, -0.2084F, -1.0829F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r21 = ears.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(30, 5).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7092F, 1.6575F, -2.0801F, 0.009F, 0.0016F, -0.349F));

        PartDefinition cube_r22 = ears.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(29, 28).addBox(-0.1F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2449F, 1.3208F, -2.0816F, 0.0091F, 0.0F, -0.1744F));

        PartDefinition cube_r23 = ears.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(19, 0).addBox(-1.5F, -0.4F, -0.9944F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1827F, 1.2072F, 0.4115F, 0.0091F, -0.0167F, -0.1744F));

        PartDefinition ears2 = earset.addOrReplaceChild("ears2", CubeListBuilder.create().texOffs(14, 19).addBox(-2.1448F, 0.7916F, -1.5829F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5448F, -34.2916F, 2.5829F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r24 = ears2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(7, 0).addBox(-1.5F, -0.5F, -0.9999F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9498F, 0.0368F, -0.5829F, 0.0F, 0.0F, -1.789F));

        PartDefinition cube_r25 = ears2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 11).addBox(-1.7F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 18).addBox(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.538F, -0.431F, 0.4667F, -0.0804F, 0.2494F, -1.6681F));

        PartDefinition cube_r26 = ears2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 0).addBox(-1.75F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 26).addBox(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1048F, -0.5486F, 0.461F, -0.0233F, 0.2608F, -1.443F));

        PartDefinition cube_r27 = ears2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(7, 3).addBox(-1.7F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 16).addBox(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3288F, -0.6327F, 0.4642F, 0.035F, 0.2595F, -1.2172F));

        PartDefinition cube_r28 = ears2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(28, 22).addBox(-1.25F, -0.6F, -0.9998F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5382F, -2.8555F, -0.5829F, 0.0F, 0.0F, -1.3526F));

        PartDefinition cube_r29 = ears2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(12, 13).addBox(-1.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2118F, 0.1756F, -0.5829F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r30 = ears2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6585F, 1.5692F, -0.5829F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r31 = ears2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(17, 27).addBox(-1.1F, -0.95F, -0.25F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1052F, -0.2084F, -1.0829F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r32 = ears2.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7092F, 1.6575F, -2.0801F, 0.009F, -0.0016F, 0.349F));

        PartDefinition cube_r33 = ears2.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 17).addBox(-1.9F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2449F, 1.3208F, -2.0816F, 0.0091F, 0.0F, 0.1744F));

        PartDefinition cube_r34 = ears2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(16, 16).addBox(-1.5F, -0.4F, -0.9944F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1827F, 1.2072F, 0.4115F, 0.0091F, 0.0167F, 0.1744F));

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