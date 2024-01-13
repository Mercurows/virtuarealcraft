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
public class SuiJokesRenderer extends BlockEntityWithoutLevelRenderer {
    private static final BakedModel mainModel = Minecraft.getInstance().getModelManager().getModel(new ModelResourceLocation(Utils.MOD_ID, "special/sui_jokes_3d", "inventory"));

    public SuiJokesRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    @ParametersAreNonnullByDefault
    public void renderByItem(ItemStack item, ItemDisplayContext pDisplayContext, PoseStack stack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        stack.pushPose();
        stack.scale(0.6F, 0.6F, 0.6F);

        stack.mulPose(Axis.XP.rotationDegrees(60.0F));
        stack.mulPose(Axis.ZP.rotationDegrees(30.0F));
        stack.translate(0, 5.0 / 16, 0);

        // Main part
        stack.pushPose();
//        stack.mulPose(Axis.YP.rotationDegrees(180.0F));
        itemRenderer.render(item, ItemDisplayContext.NONE, false, stack, pBuffer, pPackedLight, pPackedOverlay, mainModel);
        stack.popPose();

        LocalPlayer player = Minecraft.getInstance().player;

        stack.pushPose();


        stack.popPose();

        stack.popPose();
    }
}