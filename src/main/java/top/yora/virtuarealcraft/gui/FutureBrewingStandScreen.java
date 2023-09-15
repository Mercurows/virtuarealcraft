package top.yora.virtuarealcraft.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import top.yora.virtuarealcraft.Utils;

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
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2 - 76;
        this.titleLabelY = 9;
        //测试数据
        this.inventoryLabelX = 37;
        this.inventoryLabelY = 113;
    }

    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    //TODO 好好滴渲染
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        pGuiGraphics.blit(BREWING_STAND_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);

        //燃料条
        int k = this.menu.getFuel();
        int l = Mth.clamp((18 * k + 20 - 1) / 160, 0, 18);
        if (l > 0) {
            pGuiGraphics.blit(BREWING_STAND_LOCATION, i + 60, j + 44, 176, 29, l, 4);
        }

        //气泡和箭头
        int i1 = this.menu.getBrewingTicks();
        if (i1 > 0) {
            int j1 = (int) (28.0F * (1.0F - (float) i1 / 400.0F));
            if (j1 > 0) {
                pGuiGraphics.blit(BREWING_STAND_LOCATION, i + 97, j + 16, 176, 0, 9, j1);
            }

            j1 = BUBBLELENGTHS[i1 / 2 % 7];
            if (j1 > 0) {
                pGuiGraphics.blit(BREWING_STAND_LOCATION, i + 63, j + 14 + 29 - j1, 185, 29 - j1, 12, j1);
            }
        }

    }

}
