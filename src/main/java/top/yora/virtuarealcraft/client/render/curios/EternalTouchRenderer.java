package top.yora.virtuarealcraft.client.render.curios;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.models.curios.EternalTouchModel;
import top.yora.virtuarealcraft.tool.ArmPoseTool;

@OnlyIn(Dist.CLIENT)
public class EternalTouchRenderer implements ICurioRenderer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/models/curios/eternal_touch.png");

    private final EternalTouchModel model;

    public EternalTouchRenderer() {
        this.model = new EternalTouchModel(Minecraft.getInstance().getEntityModels().bakeLayer(EternalTouchModel.LAYER_LOCATION));
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStack.pushPose();

        LivingEntity entity = slotContext.entity();
        this.model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
        this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        if (entity instanceof AbstractClientPlayer player) {
            InteractionHand hand = entity.getMainArm() == HumanoidArm.RIGHT ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;

            if (player.getModelName().equals("slim")) {
                matrixStack.translate(-0.1f, 0f, 0f);
                matrixStack.scale(0.8f, 1f, 1f);
            }

            this.model.main.copyFrom(model.rightArm);
            this.model.attackTime = entity.getAttackAnim(partialTicks);
            this.model.rightArmPose = ArmPoseTool.getArmPose(player, hand);

            ICurioRenderer.rotateIfSneaking(matrixStack, entity);
            ICurioRenderer.translateIfSneaking(matrixStack, entity);

            if (entity.isCrouching()) {
                matrixStack.translate(0, 0, -0.2);
            }
        }

        VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(renderTypeBuffer, RenderType.armorCutoutNoCull(TEXTURE), false, stack.hasFoil());
        model.renderToBuffer(matrixStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        matrixStack.popPose();
    }


}
