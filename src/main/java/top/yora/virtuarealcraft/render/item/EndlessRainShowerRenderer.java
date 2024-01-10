package top.yora.virtuarealcraft.render.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.Utils;

import javax.annotation.ParametersAreNonnullByDefault;

@OnlyIn(Dist.CLIENT)
public class EndlessRainShowerRenderer extends BlockEntityWithoutLevelRenderer {
    private static final BakedModel mainModel = Minecraft.getInstance().getModelManager().getModel(new ModelResourceLocation(Utils.MOD_ID, "endless_rain_shower", "inventory"));
    private static final BakedModel butterflyModel = Minecraft.getInstance().getModelManager().getModel(new ModelResourceLocation(Utils.MOD_ID, "endless_rain_shower_butterfly", "inventory"));
    private static final BakedModel sparkleModel = Minecraft.getInstance().getModelManager().getModel(new ModelResourceLocation(Utils.MOD_ID, "endless_rain_shower_sparkle", "inventory"));

    public EndlessRainShowerRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    @ParametersAreNonnullByDefault
    public void renderByItem(ItemStack item, ItemDisplayContext pDisplayContext, PoseStack stack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        stack.pushPose();
        stack.translate(0.5F, 0.5F, 0.5F);

        // first person
        if (pDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || pDisplayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND) {
            stack.mulPose(Axis.XP.rotationDegrees(-18.5F));
            stack.translate(-.25 / 16, 2.0 / 16, .75 / 16);
        }
        // third person
        if (pDisplayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || pDisplayContext == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {
            stack.translate(0, 12.25 / 16, 1.25 / 16);
        }
        // ground
        if (pDisplayContext == ItemDisplayContext.GROUND) {
            stack.translate(0, 20.5 / 16, 0);
        }
        // item slot
        if (pDisplayContext == ItemDisplayContext.GUI) {
            stack.mulPose(Axis.XP.rotationDegrees(90));
            stack.mulPose(Axis.YP.rotationDegrees(45));
            stack.mulPose(Axis.ZP.rotationDegrees(-90));
            stack.translate(1.5 / 16, 1.0 / 16, 0);
            stack.scale(.5F, .5F, .5F);
        }
        // item frame
        if (pDisplayContext == ItemDisplayContext.FIXED) {
            stack.mulPose(Axis.XP.rotationDegrees(90));
            stack.mulPose(Axis.YP.rotationDegrees(-45));
            stack.mulPose(Axis.ZP.rotationDegrees(90));
            stack.translate(-0.5 / 16, 2.0 / 16, 0);
            stack.scale(.65F, .65F, .65F);
        }

        // Main part
        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(180.0F));
        itemRenderer.render(item, ItemDisplayContext.NONE, false, stack, pBuffer, pPackedLight, pPackedOverlay, mainModel);
        stack.popPose();

        LocalPlayer player = Minecraft.getInstance().player;
        boolean flag = player != null && player.isSteppingCarefully();
        boolean flagView = pDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || pDisplayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND
                || pDisplayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || pDisplayContext == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;

        // Butterfly part
        stack.pushPose();

        double sin = Math.sin((System.currentTimeMillis() % 2000) * Math.PI / 1000.0);
        float deg = (float) (40 * sin);

        // right
        stack.mulPose(Axis.YP.rotationDegrees(deg));
        stack.translate(-0.005, 0, 0);
        if (flag && flagView) {
            itemRenderer.render(item, ItemDisplayContext.NONE, false, stack, pBuffer, pPackedLight, pPackedOverlay, sparkleModel);
        } else {
            itemRenderer.render(item, ItemDisplayContext.NONE, false, stack, pBuffer, pPackedLight, pPackedOverlay, butterflyModel);
        }

        // left
        stack.mulPose(Axis.YP.rotationDegrees(180 - 2 * deg));
        stack.translate(0.005, 0, 0);
        if (flag && flagView) {
            itemRenderer.render(item, ItemDisplayContext.NONE, false, stack, pBuffer, pPackedLight, pPackedOverlay, sparkleModel);
        } else {
            itemRenderer.render(item, ItemDisplayContext.NONE, false, stack, pBuffer, pPackedLight, pPackedOverlay, butterflyModel);
        }

        stack.popPose();

        stack.popPose();
    }
}