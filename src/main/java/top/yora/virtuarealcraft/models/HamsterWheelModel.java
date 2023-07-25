package top.yora.virtuarealcraft.models;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

@SuppressWarnings("FieldCanBeLocal")
public class HamsterWheelModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer bb_main;
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer bone3;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer bone4;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer bone5;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer cube_r40;
	private final ModelRenderer bone6;
	private final ModelRenderer cube_r41;
	private final ModelRenderer cube_r42;
	private final ModelRenderer cube_r43;
	private final ModelRenderer cube_r44;
	private final ModelRenderer cube_r45;
	private final ModelRenderer cube_r46;
	private final ModelRenderer cube_r47;
	private final ModelRenderer cube_r48;
	private final ModelRenderer bone7;
	private final ModelRenderer cube_r49;
	private final ModelRenderer cube_r50;
	private final ModelRenderer cube_r51;
	private final ModelRenderer cube_r52;
	private final ModelRenderer cube_r53;
	private final ModelRenderer cube_r54;
	private final ModelRenderer cube_r55;
	private final ModelRenderer cube_r56;
	private final ModelRenderer bone8;
	private final ModelRenderer cube_r57;
	private final ModelRenderer cube_r58;
	private final ModelRenderer cube_r59;
	private final ModelRenderer cube_r60;
	private final ModelRenderer cube_r61;
	private final ModelRenderer cube_r62;
	private final ModelRenderer cube_r63;
	private final ModelRenderer cube_r64;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer cube_r65;
	private final ModelRenderer cube_r66;
	private final ModelRenderer cube_r67;
	private final ModelRenderer cube_r68;
	private final ModelRenderer cube_r69;
	private final ModelRenderer cube_r70;
	private final ModelRenderer cube_r71;
	private final ModelRenderer cube_r72;
	private final ModelRenderer bone11;
	private final ModelRenderer cube_r73;
	private final ModelRenderer cube_r74;
	private final ModelRenderer cube_r75;
	private final ModelRenderer cube_r76;
	private final ModelRenderer cube_r77;
	private final ModelRenderer cube_r78;
	private final ModelRenderer cube_r79;
	private final ModelRenderer cube_r80;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer cube_r81;
	private final ModelRenderer cube_r82;
	private final ModelRenderer cube_r83;
	private final ModelRenderer cube_r84;
	private final ModelRenderer cube_r85;
	private final ModelRenderer cube_r86;
	private final ModelRenderer cube_r87;
	private final ModelRenderer cube_r88;
	private final ModelRenderer bone14;
	private final ModelRenderer cube_r89;
	private final ModelRenderer cube_r90;
	private final ModelRenderer cube_r91;
	private final ModelRenderer cube_r92;
	private final ModelRenderer cube_r93;
	private final ModelRenderer cube_r94;
	private final ModelRenderer cube_r95;
	private final ModelRenderer cube_r96;

	public HamsterWheelModel() {
		super(1.0f);
		textureWidth = 64;
		textureHeight = 64;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -2.0F, 0.0F);
		bb_main.addChild(bone);
		bone.setTextureOffset(50, 60).addBox(-3.0F, 26.0F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 24.0F, 0.5F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.3491F);
		cube_r1.setTextureOffset(50, 60).addBox(-7.7887F, 2.8445F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 24.0F, 0.5F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 1.3963F);
		cube_r2.setTextureOffset(50, 60).addBox(-16.7874F, 13.5694F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 24.0F, 0.5F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 1.0472F);
		cube_r3.setTextureOffset(50, 60).addBox(-15.1244F, 9.0F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 24.0F, 0.5F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.6981F);
		cube_r4.setTextureOffset(50, 60).addBox(-11.9987F, 5.2751F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 24.0F, 0.5F);
		bone.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -1.3963F);
		cube_r5.setTextureOffset(50, 60).addBox(10.7874F, 13.5694F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 24.0F, 0.5F);
		bone.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -1.0472F);
		cube_r6.setTextureOffset(50, 60).addBox(9.1244F, 9.0F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, 24.0F, 0.5F);
		bone.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -0.3491F);
		cube_r7.setTextureOffset(50, 60).addBox(1.7887F, 2.8445F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, 24.0F, 0.5F);
		bone.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, -0.6981F);
		cube_r8.setTextureOffset(50, 60).addBox(5.9987F, 5.2751F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -2.0F, 0.0F);
		bb_main.addChild(bone2);
		setRotationAngle(bone2, -0.7854F, 0.0F, 0.0F);
		bone2.setTextureOffset(50, 60).addBox(-3.0F, 23.0711F, 6.5711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone2.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, 0.3491F);
		cube_r9.setTextureOffset(50, 60).addBox(-0.5818F, 22.6448F, 6.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone2.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, 1.3963F);
		cube_r10.setTextureOffset(50, 60).addBox(3.9636F, 17.2282F, 6.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone2.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, 1.0472F);
		cube_r11.setTextureOffset(50, 60).addBox(3.1237F, 19.5356F, 6.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone2.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, 0.6981F);
		cube_r12.setTextureOffset(50, 60).addBox(1.5455F, 21.4166F, 6.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone2.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, -1.3963F);
		cube_r13.setTextureOffset(50, 60).addBox(-9.9636F, 17.2282F, 6.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone2.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, -1.0472F);
		cube_r14.setTextureOffset(50, 60).addBox(-9.1237F, 19.5356F, 6.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone2.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, -0.3491F);
		cube_r15.setTextureOffset(50, 60).addBox(-5.4182F, 22.6448F, 6.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone2.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.0F, -0.6981F);
		cube_r16.setTextureOffset(50, 60).addBox(-7.5455F, 21.4166F, 6.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, -2.0F, 0.0F);
		bb_main.addChild(bone3);
		setRotationAngle(bone3, -1.5708F, 0.0F, 0.0F);
		bone3.setTextureOffset(50, 60).addBox(-3.0F, 16.0001F, 9.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone3.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, 0.3491F);
		cube_r17.setTextureOffset(50, 60).addBox(-3.0F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone3.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.0F, 1.3963F);
		cube_r18.setTextureOffset(50, 60).addBox(-2.9999F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone3.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 0.0F, 1.0472F);
		cube_r19.setTextureOffset(50, 60).addBox(-3.0F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone3.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 0.0F, 0.6981F);
		cube_r20.setTextureOffset(50, 60).addBox(-3.0F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone3.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.0F, -1.3963F);
		cube_r21.setTextureOffset(50, 60).addBox(-3.0001F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone3.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.0F, -1.0472F);
		cube_r22.setTextureOffset(50, 60).addBox(-3.0F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone3.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.0F, -0.3491F);
		cube_r23.setTextureOffset(50, 60).addBox(-3.0F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone3.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 0.0F, -0.6981F);
		cube_r24.setTextureOffset(50, 60).addBox(-3.0F, 16.0F, 9.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -2.0F, 0.0F);
		bb_main.addChild(bone4);
		setRotationAngle(bone4, -2.3562F, 0.0F, 0.0F);
		bone4.setTextureOffset(50, 60).addBox(-3.0F, 8.9289F, 6.5712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone4.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 0.0F, 0.3491F);
		cube_r25.setTextureOffset(50, 60).addBox(-5.4181F, 9.3553F, 6.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone4.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 0.0F, 1.3963F);
		cube_r26.setTextureOffset(50, 60).addBox(-9.9635F, 14.7718F, 6.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone4.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 0.0F, 1.0472F);
		cube_r27.setTextureOffset(50, 60).addBox(-9.1236F, 12.4645F, 6.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone4.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 0.0F, 0.6981F);
		cube_r28.setTextureOffset(50, 60).addBox(-7.5454F, 10.5835F, 6.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone4.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.0F, -1.3963F);
		cube_r29.setTextureOffset(50, 60).addBox(3.9635F, 14.7718F, 6.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone4.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.0F, -1.0472F);
		cube_r30.setTextureOffset(50, 60).addBox(3.1236F, 12.4645F, 6.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone4.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 0.0F, -0.3491F);
		cube_r31.setTextureOffset(50, 60).addBox(-0.5819F, 9.3553F, 6.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone4.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, 0.0F, -0.6981F);
		cube_r32.setTextureOffset(50, 60).addBox(1.5454F, 10.5835F, 6.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, -2.0F, 0.0F);
		bb_main.addChild(bone5);
		setRotationAngle(bone5, 3.1416F, 0.0F, 0.0F);
		bone5.setTextureOffset(50, 60).addBox(-3.0F, 6.0F, -0.5001F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone5.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 0.0F, 0.3491F);
		cube_r33.setTextureOffset(50, 60).addBox(-6.4198F, 6.6029F, -1.0001F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone5.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.0F, 1.3963F);
		cube_r34.setTextureOffset(50, 60).addBox(-12.848F, 14.263F, -1.0001F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone5.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 0.0F, 1.0472F);
		cube_r35.setTextureOffset(50, 60).addBox(-11.6602F, 11.0F, -1.0001F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone5.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 0.0F, 0.6981F);
		cube_r36.setTextureOffset(50, 60).addBox(-9.4282F, 8.3398F, -1.0001F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone5.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.0F, 0.0F, -1.3963F);
		cube_r37.setTextureOffset(50, 60).addBox(6.848F, 14.263F, -1.0001F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone5.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.0F, 0.0F, -1.0472F);
		cube_r38.setTextureOffset(50, 60).addBox(5.6602F, 11.0F, -1.0001F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone5.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.0F, 0.0F, -0.3491F);
		cube_r39.setTextureOffset(50, 60).addBox(0.4198F, 6.6029F, -1.0001F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone5.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0F, 0.0F, -0.6981F);
		cube_r40.setTextureOffset(50, 60).addBox(3.4282F, 8.3398F, -1.0001F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, -2.0F, 0.0F);
		bb_main.addChild(bone6);
		setRotationAngle(bone6, 2.3562F, 0.0F, 0.0F);
		bone6.setTextureOffset(50, 60).addBox(-3.0F, 8.9289F, -7.5712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone6.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.0F, 0.0F, 0.3491F);
		cube_r41.setTextureOffset(50, 60).addBox(-5.4181F, 9.3553F, -8.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone6.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0F, 0.0F, 1.3963F);
		cube_r42.setTextureOffset(50, 60).addBox(-9.9635F, 14.7718F, -8.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone6.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.0F, 0.0F, 1.0472F);
		cube_r43.setTextureOffset(50, 60).addBox(-9.1236F, 12.4645F, -8.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone6.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.0F, 0.0F, 0.6981F);
		cube_r44.setTextureOffset(50, 60).addBox(-7.5454F, 10.5835F, -8.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone6.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0F, 0.0F, -1.3963F);
		cube_r45.setTextureOffset(50, 60).addBox(3.9635F, 14.7718F, -8.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone6.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.0F, 0.0F, -1.0472F);
		cube_r46.setTextureOffset(50, 60).addBox(3.1236F, 12.4645F, -8.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone6.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0F, 0.0F, -0.3491F);
		cube_r47.setTextureOffset(50, 60).addBox(-0.5819F, 9.3553F, -8.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone6.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.0F, 0.0F, -0.6981F);
		cube_r48.setTextureOffset(50, 60).addBox(1.5454F, 10.5835F, -8.0712F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, -2.0F, 0.0F);
		bb_main.addChild(bone7);
		setRotationAngle(bone7, 1.5708F, 0.0F, 0.0F);
		bone7.setTextureOffset(50, 60).addBox(-3.0F, 16.0001F, -10.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone7.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.0F, 0.0F, 0.3491F);
		cube_r49.setTextureOffset(50, 60).addBox(-3.0F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone7.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.0F, 0.0F, 1.3963F);
		cube_r50.setTextureOffset(50, 60).addBox(-2.9999F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone7.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.0F, 0.0F, 1.0472F);
		cube_r51.setTextureOffset(50, 60).addBox(-3.0F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone7.addChild(cube_r52);
		setRotationAngle(cube_r52, 0.0F, 0.0F, 0.6981F);
		cube_r52.setTextureOffset(50, 60).addBox(-3.0F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone7.addChild(cube_r53);
		setRotationAngle(cube_r53, 0.0F, 0.0F, -1.3963F);
		cube_r53.setTextureOffset(50, 60).addBox(-3.0001F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone7.addChild(cube_r54);
		setRotationAngle(cube_r54, 0.0F, 0.0F, -1.0472F);
		cube_r54.setTextureOffset(50, 60).addBox(-3.0F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone7.addChild(cube_r55);
		setRotationAngle(cube_r55, 0.0F, 0.0F, -0.3491F);
		cube_r55.setTextureOffset(50, 60).addBox(-3.0F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r56 = new ModelRenderer(this);
		cube_r56.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone7.addChild(cube_r56);
		setRotationAngle(cube_r56, 0.0F, 0.0F, -0.6981F);
		cube_r56.setTextureOffset(50, 60).addBox(-3.0F, 16.0F, -11.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, -2.0F, 0.0F);
		bb_main.addChild(bone8);
		setRotationAngle(bone8, 0.7854F, 0.0F, 0.0F);
		bone8.setTextureOffset(50, 60).addBox(-3.0F, 23.0711F, -7.5711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r57 = new ModelRenderer(this);
		cube_r57.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone8.addChild(cube_r57);
		setRotationAngle(cube_r57, 0.0F, 0.0F, 0.3491F);
		cube_r57.setTextureOffset(50, 60).addBox(-0.5818F, 22.6448F, -8.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r58 = new ModelRenderer(this);
		cube_r58.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone8.addChild(cube_r58);
		setRotationAngle(cube_r58, 0.0F, 0.0F, 1.3963F);
		cube_r58.setTextureOffset(50, 60).addBox(3.9636F, 17.2282F, -8.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r59 = new ModelRenderer(this);
		cube_r59.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone8.addChild(cube_r59);
		setRotationAngle(cube_r59, 0.0F, 0.0F, 1.0472F);
		cube_r59.setTextureOffset(50, 60).addBox(3.1237F, 19.5356F, -8.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r60 = new ModelRenderer(this);
		cube_r60.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone8.addChild(cube_r60);
		setRotationAngle(cube_r60, 0.0F, 0.0F, 0.6981F);
		cube_r60.setTextureOffset(50, 60).addBox(1.5455F, 21.4166F, -8.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r61 = new ModelRenderer(this);
		cube_r61.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone8.addChild(cube_r61);
		setRotationAngle(cube_r61, 0.0F, 0.0F, -1.3963F);
		cube_r61.setTextureOffset(50, 60).addBox(-9.9636F, 17.2282F, -8.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r62 = new ModelRenderer(this);
		cube_r62.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone8.addChild(cube_r62);
		setRotationAngle(cube_r62, 0.0F, 0.0F, -1.0472F);
		cube_r62.setTextureOffset(50, 60).addBox(-9.1237F, 19.5356F, -8.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r63 = new ModelRenderer(this);
		cube_r63.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone8.addChild(cube_r63);
		setRotationAngle(cube_r63, 0.0F, 0.0F, -0.3491F);
		cube_r63.setTextureOffset(50, 60).addBox(-5.4182F, 22.6448F, -8.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r64 = new ModelRenderer(this);
		cube_r64.setRotationPoint(0.0F, 0.0F, 0.5F);
		bone8.addChild(cube_r64);
		setRotationAngle(cube_r64, 0.0F, 0.0F, -0.6981F);
		cube_r64.setTextureOffset(50, 60).addBox(-7.5455F, 21.4166F, -8.0711F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(-8.9F, 11.425F, 0.0F);
		bb_main.addChild(bone9);
		setRotationAngle(bone9, 0.0F, 1.5708F, 0.0F);
		

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, -13.44F, -0.075F);
		bone9.addChild(bone10);
		bone10.setTextureOffset(50, 62).addBox(-2.48F, 23.28F, -0.42F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r65 = new ModelRenderer(this);
		cube_r65.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone10.addChild(cube_r65);
		setRotationAngle(cube_r65, 0.0F, 0.0F, 0.3491F);
		cube_r65.setTextureOffset(50, 62).addBox(0.9398F, 22.6771F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r66 = new ModelRenderer(this);
		cube_r66.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone10.addChild(cube_r66);
		setRotationAngle(cube_r66, 0.0F, 0.0F, 1.3963F);
		cube_r66.setTextureOffset(50, 62).addBox(7.368F, 15.017F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r67 = new ModelRenderer(this);
		cube_r67.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone10.addChild(cube_r67);
		setRotationAngle(cube_r67, 0.0F, 0.0F, 1.0472F);
		cube_r67.setTextureOffset(50, 62).addBox(6.1802F, 18.28F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r68 = new ModelRenderer(this);
		cube_r68.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone10.addChild(cube_r68);
		setRotationAngle(cube_r68, 0.0F, 0.0F, 0.6981F);
		cube_r68.setTextureOffset(50, 62).addBox(3.9482F, 20.9402F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r69 = new ModelRenderer(this);
		cube_r69.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone10.addChild(cube_r69);
		setRotationAngle(cube_r69, 0.0F, 0.0F, -1.3963F);
		cube_r69.setTextureOffset(50, 62).addBox(-12.328F, 15.017F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r70 = new ModelRenderer(this);
		cube_r70.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone10.addChild(cube_r70);
		setRotationAngle(cube_r70, 0.0F, 0.0F, -1.0472F);
		cube_r70.setTextureOffset(50, 62).addBox(-11.1402F, 18.28F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r71 = new ModelRenderer(this);
		cube_r71.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone10.addChild(cube_r71);
		setRotationAngle(cube_r71, 0.0F, 0.0F, -0.3491F);
		cube_r71.setTextureOffset(50, 62).addBox(-5.8998F, 22.6771F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r72 = new ModelRenderer(this);
		cube_r72.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone10.addChild(cube_r72);
		setRotationAngle(cube_r72, 0.0F, 0.0F, -0.6981F);
		cube_r72.setTextureOffset(50, 62).addBox(-8.9082F, 20.9402F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, -13.44F, 0.075F);
		bone9.addChild(bone11);
		setRotationAngle(bone11, 3.1416F, 0.0F, 0.0F);
		bone11.setTextureOffset(50, 62).addBox(-2.48F, 3.28F, -0.4201F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r73 = new ModelRenderer(this);
		cube_r73.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone11.addChild(cube_r73);
		setRotationAngle(cube_r73, 0.0F, 0.0F, 0.3491F);
		cube_r73.setTextureOffset(50, 62).addBox(-5.8998F, 3.8829F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r74 = new ModelRenderer(this);
		cube_r74.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone11.addChild(cube_r74);
		setRotationAngle(cube_r74, 0.0F, 0.0F, 1.3963F);
		cube_r74.setTextureOffset(50, 62).addBox(-12.328F, 11.543F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r75 = new ModelRenderer(this);
		cube_r75.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone11.addChild(cube_r75);
		setRotationAngle(cube_r75, 0.0F, 0.0F, 1.0472F);
		cube_r75.setTextureOffset(50, 62).addBox(-11.1402F, 8.28F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r76 = new ModelRenderer(this);
		cube_r76.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone11.addChild(cube_r76);
		setRotationAngle(cube_r76, 0.0F, 0.0F, 0.6981F);
		cube_r76.setTextureOffset(50, 62).addBox(-8.9082F, 5.6198F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r77 = new ModelRenderer(this);
		cube_r77.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone11.addChild(cube_r77);
		setRotationAngle(cube_r77, 0.0F, 0.0F, -1.3963F);
		cube_r77.setTextureOffset(50, 62).addBox(7.368F, 11.543F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r78 = new ModelRenderer(this);
		cube_r78.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone11.addChild(cube_r78);
		setRotationAngle(cube_r78, 0.0F, 0.0F, -1.0472F);
		cube_r78.setTextureOffset(50, 62).addBox(6.1802F, 8.28F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r79 = new ModelRenderer(this);
		cube_r79.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone11.addChild(cube_r79);
		setRotationAngle(cube_r79, 0.0F, 0.0F, -0.3491F);
		cube_r79.setTextureOffset(50, 62).addBox(0.9398F, 3.8829F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r80 = new ModelRenderer(this);
		cube_r80.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone11.addChild(cube_r80);
		setRotationAngle(cube_r80, 0.0F, 0.0F, -0.6981F);
		cube_r80.setTextureOffset(50, 62).addBox(3.9482F, 5.6198F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(8.9F, 11.425F, 0.0F);
		bb_main.addChild(bone12);
		setRotationAngle(bone12, 0.0F, 1.5708F, 0.0F);
		

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, -13.44F, -0.075F);
		bone12.addChild(bone13);
		bone13.setTextureOffset(50, 62).addBox(-2.48F, 23.28F, -0.42F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r81 = new ModelRenderer(this);
		cube_r81.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone13.addChild(cube_r81);
		setRotationAngle(cube_r81, 0.0F, 0.0F, 0.3491F);
		cube_r81.setTextureOffset(50, 62).addBox(0.9398F, 22.6771F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r82 = new ModelRenderer(this);
		cube_r82.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone13.addChild(cube_r82);
		setRotationAngle(cube_r82, 0.0F, 0.0F, 1.3963F);
		cube_r82.setTextureOffset(50, 62).addBox(7.368F, 15.017F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r83 = new ModelRenderer(this);
		cube_r83.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone13.addChild(cube_r83);
		setRotationAngle(cube_r83, 0.0F, 0.0F, 1.0472F);
		cube_r83.setTextureOffset(50, 62).addBox(6.1802F, 18.28F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r84 = new ModelRenderer(this);
		cube_r84.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone13.addChild(cube_r84);
		setRotationAngle(cube_r84, 0.0F, 0.0F, 0.6981F);
		cube_r84.setTextureOffset(50, 62).addBox(3.9482F, 20.9402F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r85 = new ModelRenderer(this);
		cube_r85.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone13.addChild(cube_r85);
		setRotationAngle(cube_r85, 0.0F, 0.0F, -1.3963F);
		cube_r85.setTextureOffset(50, 62).addBox(-12.328F, 15.017F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r86 = new ModelRenderer(this);
		cube_r86.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone13.addChild(cube_r86);
		setRotationAngle(cube_r86, 0.0F, 0.0F, -1.0472F);
		cube_r86.setTextureOffset(50, 62).addBox(-11.1402F, 18.28F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r87 = new ModelRenderer(this);
		cube_r87.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone13.addChild(cube_r87);
		setRotationAngle(cube_r87, 0.0F, 0.0F, -0.3491F);
		cube_r87.setTextureOffset(50, 62).addBox(-5.8998F, 22.6771F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r88 = new ModelRenderer(this);
		cube_r88.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone13.addChild(cube_r88);
		setRotationAngle(cube_r88, 0.0F, 0.0F, -0.6981F);
		cube_r88.setTextureOffset(50, 62).addBox(-8.9082F, 20.9402F, -0.84F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, -13.44F, 0.075F);
		bone12.addChild(bone14);
		setRotationAngle(bone14, 3.1416F, 0.0F, 0.0F);
		bone14.setTextureOffset(50, 62).addBox(-2.48F, 3.28F, -0.4201F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r89 = new ModelRenderer(this);
		cube_r89.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone14.addChild(cube_r89);
		setRotationAngle(cube_r89, 0.0F, 0.0F, 0.3491F);
		cube_r89.setTextureOffset(50, 62).addBox(-5.8998F, 3.8829F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r90 = new ModelRenderer(this);
		cube_r90.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone14.addChild(cube_r90);
		setRotationAngle(cube_r90, 0.0F, 0.0F, 1.3963F);
		cube_r90.setTextureOffset(50, 62).addBox(-12.328F, 11.543F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r91 = new ModelRenderer(this);
		cube_r91.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone14.addChild(cube_r91);
		setRotationAngle(cube_r91, 0.0F, 0.0F, 1.0472F);
		cube_r91.setTextureOffset(50, 62).addBox(-11.1402F, 8.28F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r92 = new ModelRenderer(this);
		cube_r92.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone14.addChild(cube_r92);
		setRotationAngle(cube_r92, 0.0F, 0.0F, 0.6981F);
		cube_r92.setTextureOffset(50, 62).addBox(-8.9082F, 5.6198F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r93 = new ModelRenderer(this);
		cube_r93.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone14.addChild(cube_r93);
		setRotationAngle(cube_r93, 0.0F, 0.0F, -1.3963F);
		cube_r93.setTextureOffset(50, 62).addBox(7.368F, 11.543F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r94 = new ModelRenderer(this);
		cube_r94.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone14.addChild(cube_r94);
		setRotationAngle(cube_r94, 0.0F, 0.0F, -1.0472F);
		cube_r94.setTextureOffset(50, 62).addBox(6.1802F, 8.28F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r95 = new ModelRenderer(this);
		cube_r95.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone14.addChild(cube_r95);
		setRotationAngle(cube_r95, 0.0F, 0.0F, -0.3491F);
		cube_r95.setTextureOffset(50, 62).addBox(0.9398F, 3.8829F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r96 = new ModelRenderer(this);
		cube_r96.setRotationPoint(0.0F, 0.0F, 0.42F);
		bone14.addChild(cube_r96);
		setRotationAngle(cube_r96, 0.0F, 0.0F, -0.6981F);
		cube_r96.setTextureOffset(50, 62).addBox(3.9482F, 5.6198F, -0.8401F, 5.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}