package top.yora.virtuarealcraft.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.entity.KuyaEntity;
import top.yora.virtuarealcraft.models.KuyaModel;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class KuyaEntityRenderer extends EntityRenderer<KuyaEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/kuya_texture.png");
    private final EntityModel<KuyaEntity> kuyaEntityEntityModel;

    public KuyaEntityRenderer(EntityRendererProvider.Context manager) {
        super(manager);
        kuyaEntityEntityModel = new KuyaModel();
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(KuyaEntity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pushPose();

        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90.0F));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch) + 90.0F));
        matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));

        matrixStackIn.translate(0.0f, -1.0f, 0.0f);
        MultiBufferSource MultiBufferSource = bufferIn.getBuffer(this.kuyaEntityEntityModel.getRenderType(this.getEntityTexture(entityIn)));
        this.kuyaEntityEntityModel.render(matrixStackIn, MultiBufferSource, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ResourceLocation getTextureLocation(KuyaEntity entity) {
        return TEXTURE;
    }
}
