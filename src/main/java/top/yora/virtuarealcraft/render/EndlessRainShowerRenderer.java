package top.yora.virtuarealcraft.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import top.yora.virtuarealcraft.Utils;

public class EndlessRainShowerRenderer extends BlockEntityWithoutLevelRenderer {
    private static final BakedModel mainModel = Minecraft.getInstance().getModelManager().getModel(new ModelResourceLocation(Utils.MOD_ID, "endless_rain_shower", "inventory"));
    private static final BakedModel butterflyModel = Minecraft.getInstance().getModelManager().getModel(new ModelResourceLocation(Utils.MOD_ID, "endless_rain_shower_butterfly", "inventory"));

    public EndlessRainShowerRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack pStack, ItemDisplayContext pDisplayContext, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        // tanslate start
        pPoseStack.pushPose();
        pPoseStack.translate(0.5F, 0.5F, 0.5F);
//        pPoseStack.mulPose(Axis.ZP.rotationDegrees(new Random().nextFloat() * 30));

        // Main part
        itemRenderer.render(pStack, ItemDisplayContext.NONE, false, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, mainModel);

        // Butterfly part
        itemRenderer.render(pStack, ItemDisplayContext.NONE, false, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, butterflyModel);

        // translate end
        pPoseStack.popPose();

    }
}