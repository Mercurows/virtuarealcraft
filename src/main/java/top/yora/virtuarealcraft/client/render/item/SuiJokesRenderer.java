package top.yora.virtuarealcraft.client.render.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.tool.ItemNBTTool;

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

        if (pDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND) {
            stack.translate(-0.2f, 0.35f, -0.5f);
            stack.mulPose(Axis.XP.rotationDegrees(-120.0F));
            stack.mulPose(Axis.ZP.rotationDegrees(-150.0F));
            stack.mulPose(Axis.YP.rotationDegrees(180.0F));
        }
        if (pDisplayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND) {
            stack.translate(1.2f, 0.35f, -0.5f);
            stack.mulPose(Axis.XP.rotationDegrees(60.0F));
            stack.mulPose(Axis.ZP.rotationDegrees(30.0F));
        }

        stack.translate(0, 5.0 / 16, 0);

        // Main part
        stack.pushPose();

        itemRenderer.render(item, ItemDisplayContext.NONE, false, stack, pBuffer, pPackedLight, pPackedOverlay, mainModel);
        stack.scale(0.6F, 0.6F, 0.6F);
        stack.popPose();

        // Font
        stack.pushPose();
        Font font = Minecraft.getInstance().font;
        stack.mulPose(Axis.XN.rotationDegrees(-120.0F));

        // 标题
        String subtitle = Component.translatable("des.virtuarealcraft.sui_jokes.subtitle").getString();
        String title_1 = Component.translatable("des.virtuarealcraft.sui_jokes.title_1").getString();
        String title_2 = Component.translatable("des.virtuarealcraft.sui_jokes.title_2").getString();
        String author = Component.translatable("des.virtuarealcraft.sui_jokes.author").getString();

        stack.pushPose();
        stack.scale(.0035f, .0035f, .0035f);
        stack.translate(-45, -85, -5);
        if (pDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND) {
            stack.translate(10, 0, 0);
        }
        font.drawInBatch(subtitle, 35 - font.width(subtitle) / 2f, 0, 0xdcb77f, false, stack.last().pose(), pBuffer, Font.DisplayMode.NORMAL, 0, pPackedLight);
        stack.popPose();

        stack.pushPose();
        stack.scale(.01f, .01f, .01f);
        stack.translate(-22, -25, -5);
        if (pDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND) {
            stack.translate(4.5, 0, 0);
        }
        font.drawInBatch(title_1, 18 - font.width(title_1) / 2f, 0, 0xfacddf, false, stack.last().pose(), pBuffer, Font.DisplayMode.NORMAL, 0, pPackedLight);
        stack.popPose();

        stack.pushPose();
        stack.scale(.02f, .02f, .02f);
        stack.translate(-11.5, -8, -6.5);
        if (pDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND) {
            stack.translate(2.5, 0, 0);
        }
        font.drawInBatch(title_2, 10 - font.width(title_2) / 2f, 0, 0xf3c0d4, false, stack.last().pose(), pBuffer, Font.DisplayMode.NORMAL, 0, pPackedLight);
        stack.popPose();

        stack.pushPose();
        stack.scale(.0045f, .0045f, .0045f);
        stack.translate(-30, 20, -8);
        if (pDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND) {
            stack.translate(9, 0, 0);
        }
        font.drawInBatch(author, 24 - font.width(author) / 2f, 0, 0x000000, false, stack.last().pose(), pBuffer, Font.DisplayMode.NORMAL, 0, pPackedLight);
        stack.popPose();

        String comment = Component.translatable("des.virtuarealcraft.sui_jokes.comment_" + ItemNBTTool.getInt(item, "comment", 1)).getString();
        String[] comments = comment.split("/");
        String comment_1 = comments.length > 0 ? comments[0] : "";
        String comment_2 = comments.length > 1 ? comments[1] : "";
        String comment_3 = comments.length > 2 ? comments[2] : "";

        // 腰封
        stack.pushPose();
        stack.scale(.004f, .004f, .004f);
        stack.translate(-90, 43, -40);
        if (pDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND) {
            stack.translate(6, 0, 0);
        }
        font.drawInBatch(comment_1, 0, 0, 0xdcb77f, false, stack.last().pose(), pBuffer, Font.DisplayMode.NORMAL, 0, pPackedLight);

        stack.translate(0, 11, 0);
        font.drawInBatch(comment_2, 0, 0, 0xdcb77f, false, stack.last().pose(), pBuffer, Font.DisplayMode.NORMAL, 0, pPackedLight);

        stack.translate(0, 11, 0);
        font.drawInBatch(comment_3, 0, 0, 0xdcb77f, false, stack.last().pose(), pBuffer, Font.DisplayMode.NORMAL, 0, pPackedLight);
        stack.popPose();

        stack.popPose();

        stack.popPose();
    }
}