package top.yora.virtuarealcraft.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.entity.KouichiDartsEntity;
import top.yora.virtuarealcraft.models.KouichiDartsModel;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@OnlyIn(Dist.CLIENT)
public class KouichiDartsEntityRenderer extends EntityRenderer<KouichiDartsEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/kouichi_darts.png");
    private final KouichiDartsModel<KouichiDartsEntity> kouichiDartsModel;

    public KouichiDartsEntityRenderer(EntityRendererProvider.Context manager) {
        super(manager);
        kouichiDartsModel = new KouichiDartsModel<>(manager.bakeLayer(KouichiDartsModel.LAYER_LOCATION));
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(KouichiDartsEntity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pushPose();

        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot()) + 90.0F));

        matrixStackIn.translate(0.0f, -1.0f, 0.0f);
        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(bufferIn, this.kouichiDartsModel.renderType(this.getTextureLocation(entityIn)), false, false);
        this.kouichiDartsModel.renderToBuffer(matrixStackIn, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ResourceLocation getTextureLocation(KouichiDartsEntity entity) {
        return TEXTURE;
    }
}
