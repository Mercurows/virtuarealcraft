package top.yora.virtuarealcraft.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Quaternionf;
import top.yora.virtuarealcraft.Utils;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CurseFireRenderer {

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public static void onRenderCurseFlame(RenderLivingEvent<LivingEntity, ? extends EntityModel<? extends LivingEntity>> event) {
        LivingEntity entity = event.getEntity();
        if (entity.getPersistentData().getInt("CurseFlame") > 0) {
            PoseStack stack = event.getPoseStack();

            TextureAtlasSprite sprite1 = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("block/soul_fire_0")).sprite();
            TextureAtlasSprite sprite2 = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("block/soul_fire_1")).sprite();

            stack.pushPose();
            float size = entity.getBbWidth() * 1.6F;
            stack.scale(size, size, size);

            float hwRatio = entity.getBbHeight() / size;
            float xOffset = 0.5F;
            float yOffset = (float) (entity.getY() - entity.getBoundingBox().minY);
            float zOffset = 0.0F;

            Quaternionf camera = Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation();
            stack.mulPose(new Quaternionf(0, camera.y, 0, camera.w));

            stack.translate(0.0F, 0.0F, hwRatio * 0.02F);

            int i = 0;
            VertexConsumer vertexconsumer = event.getMultiBufferSource().getBuffer(Sheets.cutoutBlockSheet());

            for (PoseStack.Pose pose = stack.last(); hwRatio > 0.0F; ++i) {
                TextureAtlasSprite atlasSprite = i % 2 == 0 ? sprite1 : sprite2;
                float u0 = atlasSprite.getU0();
                float v0 = atlasSprite.getV0();
                float u1 = atlasSprite.getU1();
                float v1 = atlasSprite.getV1();
                if (i / 2 % 2 == 0) {
                    float temp = u1;
                    u1 = u0;
                    u0 = temp;
                }

                fireVertex(pose, vertexconsumer, xOffset - 0.0F, 0.0F - yOffset, zOffset, u1, v1);
                fireVertex(pose, vertexconsumer, -xOffset - 0.0F, 0.0F - yOffset, zOffset, u0, v1);
                fireVertex(pose, vertexconsumer, -xOffset - 0.0F, 1.4F - yOffset, zOffset, u0, v0);
                fireVertex(pose, vertexconsumer, xOffset - 0.0F, 1.4F - yOffset, zOffset, u1, v0);

                hwRatio -= 0.45F;
                yOffset -= 0.45F;
                xOffset *= 0.9F;
                zOffset += 0.03F;
            }

            stack.popPose();
        }
    }

    private static void fireVertex(PoseStack.Pose pMatrixEntry, VertexConsumer pBuffer, float pX, float pY, float pZ, float pTexU, float pTexV) {
        pBuffer.vertex(pMatrixEntry.pose(), pX, pY, pZ).color(150, 150, 255, 255).uv(pTexU, pTexV).overlayCoords(0, 10).uv2(240).normal(pMatrixEntry.normal(), 0.0F, 1.0F, 0.0F).endVertex();
    }
}
