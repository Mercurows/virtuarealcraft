package top.yora.virtuarealcraft.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.ForgeIngameGui;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.tool.ItemNBTTool;

@OnlyIn(Dist.CLIENT)
public class RainyButterflyHUD extends GuiGraphics {
    private final ResourceLocation HUD = new ResourceLocation(Utils.MOD_ID, "textures/gui/rainy_butterfly_hud.png");
    private final PoseStack matrixStack;
    private final ItemStack stack;
    private final boolean rain;

    public RainyButterflyHUD(PoseStack matrixStack, ItemStack stack, boolean rain) {
        this.matrixStack = matrixStack;
        this.stack = stack;
        this.rain = rain;
    }

    public void render() {
        Minecraft minecraft = Minecraft.getInstance();

        int max_count = rain ? 9 : 3;
        int count = ItemNBTTool.getInt(stack, "rainy_butterfly_count", 0);

        // TODO 不知道color4f是不是这个，有待验证
        RenderSystem.clearColor(1.0F, 1.0F, 1.0F, 1.0F);

        RenderSystem.enableBlend();

        int top = minecraft.getWindow().getHeight() - ForgeIngameGui.right_height;
        int left = minecraft.getWindow().getWidth() / 2 + 82;
        minecraft.getTextureManager().bindForSetup(HUD);

        //渲染空蝴蝶
        for (int i = 0; i < max_count; i++) {
            blit(HUD, left - i * 8, top, 0, 0, 9, 9, 20, 9);
        }

        //渲染彩蝴蝶
        for (int i = 0; i < count; i++) {
            blit(HUD, left - i * 8, top, 10, 0, 9, 9, 20, 9);
        }

    }
}
