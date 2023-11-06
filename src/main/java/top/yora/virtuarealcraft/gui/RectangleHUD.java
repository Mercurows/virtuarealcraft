package top.yora.virtuarealcraft.gui;

import net.minecraft.client.gui.GuiGraphics;

import java.util.Random;

public class RectangleHUD {
    public static long lastActiveTime = 0;

    public static void render(GuiGraphics gui) {

        long currentTime = System.currentTimeMillis();

        // 距开始使用时间小于8秒或大于18秒则不渲染
        if (currentTime - lastActiveTime < 8000 || currentTime - lastActiveTime > 18000) {
            return;
        }

        // 以开始使用时间作为随机数种子
        Random r = new Random(lastActiveTime);

        // 3~5个随机框
        int count = r.nextInt(3, 6);

        for (int i = 0; i < count; i++) {
            int left = r.nextInt(gui.guiWidth() - 100) + 50;
            int top = r.nextInt(gui.guiHeight() - 100) + 50;
            int width = r.nextInt(10, 20);
            int height = width * 2;

            gui.fillGradient(left, top, left + width, top + 1, 0xffffffff, 0xffffffff);
            gui.fillGradient(left, top, left + 1, top + height, 0xffffffff, 0xffffffff);
            gui.fillGradient(left + width, top, left + width + 1, top + height, 0xffffffff, 0xffffffff);
            gui.fillGradient(left, top + height, left + width + 1, top + height + 1, 0xffffffff, 0xffffffff);
        }
    }
}
