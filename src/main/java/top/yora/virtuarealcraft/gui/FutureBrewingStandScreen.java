package top.yora.virtuarealcraft.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.Utils;

@OnlyIn(Dist.CLIENT)
public class FutureBrewingStandScreen extends AbstractContainerScreen<FutureBrewingStandMenu> {

    private static final ResourceLocation BREWING_STAND_LOCATION = new ResourceLocation(Utils.MOD_ID, "textures/gui/future_brewing_stand_gui.png");
    private static final int[] BUBBLELENGTHS = new int[]{29, 24, 20, 16, 11, 6, 0};

    public FutureBrewingStandScreen(FutureBrewingStandMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        imageWidth = 236;
        imageHeight = 205;
    }

    protected void init() {
        super.init();
        this.titleLabelX = 15;
        this.titleLabelY = 9;
        this.inventoryLabelX = 37;
        this.inventoryLabelY = 113;
    }

    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        pGuiGraphics.blit(BREWING_STAND_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);

        //燃料条
        int k = this.menu.getFuel();
        if (k > 0) {
            pGuiGraphics.blit(BREWING_STAND_LOCATION, i + 38, j + 95, 0, 240, k, 3);
        }

        //气泡和箭头
        int i1 = this.menu.getBrewingTicks();
        if (i1 > 0) {
            int j1 = (int) (32.0F * (1.0F - (float) i1 / 200.0F));
            if (j1 > 0) {
                pGuiGraphics.blit(BREWING_STAND_LOCATION, i + 118, j + 15, 14, 206, 7, j1);
            }

            j1 = BUBBLELENGTHS[i1 / 2 % 7];
            if (j1 > 0) {
                pGuiGraphics.blit(BREWING_STAND_LOCATION, i + 105, j + 17 + 29 - j1, 0, 237 - j1, 12, j1);
            }
        }

        //燃料补充条
        int ft = this.menu.getFuelTick();
        int f = Mth.clamp((18 * ft + 200 - 1) / 200, 0, 18);
        if (f > 0) {
            pGuiGraphics.blit(BREWING_STAND_LOCATION, i + 13, j + 78, 0, 244, f, 2);
        }

        int mode = this.menu.getBrewingMode();

        // TODO 鼠标悬停效果渲染
        // 模式切换按钮
        if (mode == 0) {
            pGuiGraphics.blit(BREWING_STAND_LOCATION, i + 14, j + 27, 56, 223, 16, 16);
        } else if (mode == 1) {
            pGuiGraphics.blit(BREWING_STAND_LOCATION, i + 14, j + 27, 73, 206, 16, 16);
        } else {
            pGuiGraphics.blit(BREWING_STAND_LOCATION, i + 14, j + 27, 73, 223, 16, 16);
        }

        // 模式指示灯
        if (mode > 0) {
            // 自动注水
            pGuiGraphics.blit(BREWING_STAND_LOCATION, i + 14, j + 43, 90, 206, 8, 8);
            if (mode > 1) {
                // 自动粗制
                pGuiGraphics.blit(BREWING_STAND_LOCATION, i + 22, j + 43, 99, 206, 8, 8);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class FutureBrewingStandButton extends AbstractButton {
        private boolean selected;

        protected FutureBrewingStandButton(int x, int y) {
            super(x, y, 16, 16, Component.translatable("button.virtuarealcraft.mode_change"));
        }

        public void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {

        }

        @Override
        public void onPress() {
            //在这里切换模式
        }

        @Override
        protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

        }
    }

}
