package top.yora.virtuarealcraft.item.virtuareal5th.miki;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class Mi extends Item {
    public Mi() {
        super(new Properties());
    }

    private long startHoverTime = 0;
    private long lastHoverTime = 0;

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        long time = System.currentTimeMillis();
        if (time - lastHoverTime > 100) {
            startHoverTime = time;
        }
        lastHoverTime = time;

        String text = Component.translatable("des.virtuarealcraft.mi").getString();
        StringBuilder builder = new StringBuilder(text);

        long count = (time - startHoverTime) / 10;
        if (count > 1919) {
            count = 1919 + (count - 300) % getCharCount(pStack, text);
        }
        for (int i = 0; i < count; i++) {
            builder.append(text);
        }

        tooltip.add(Component.literal(builder.toString()).withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        TooltipTool.addLiverInfo(tooltip, Livers.MIKI);
    }

    public int getCharCount(ItemStack stack, String text) {
        int mouseX = (int) (Minecraft.getInstance().mouseHandler.xpos() * (double) Minecraft.getInstance().getWindow().getGuiScaledWidth() / (double) Minecraft.getInstance().getWindow().getScreenWidth());
        Font font = IClientItemExtensions.of(stack).getFont(stack, IClientItemExtensions.FontContext.TOOLTIP);
        if (font == null) font = Minecraft.getInstance().font;

        int width = font.width(text);
        int tooltipTextWidth = 0;

        if (Minecraft.getInstance().screen != null && mouseX > Minecraft.getInstance().screen.width / 2)
            tooltipTextWidth = mouseX - 12 - 8;
        return tooltipTextWidth / width + 1;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mi = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide) {
            ItemStack stack = pPlayer.getItemBySlot(EquipmentSlot.LEGS);
            if (stack.getItem() == ItemRegistry.MIKI_TAIL.get()) {
                pPlayer.heal(1.0f);
                mi.shrink(1);
                pPlayer.getCooldowns().addCooldown(mi.getItem(), 10);
            } else {
                pPlayer.addItem(new ItemStack(ItemRegistry.MI.get()));
                pPlayer.getCooldowns().addCooldown(mi.getItem(), 20);
            }
            return InteractionResultHolder.success(mi);
        }
        return InteractionResultHolder.fail(mi);
    }
}
