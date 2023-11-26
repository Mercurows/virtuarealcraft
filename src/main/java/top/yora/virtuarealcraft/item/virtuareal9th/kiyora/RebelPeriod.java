package top.yora.virtuarealcraft.item.virtuareal9th.kiyora;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class RebelPeriod extends Item {
    public RebelPeriod() {
        super(new Properties().stacksTo(1));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((Component.translatable("des.virtuarealcraft.rebel_period")).withStyle(ChatFormatting.RED));

        TooltipTool.addLiverInfo(tooltip, Livers.KIYORA);
    }

    @SubscribeEvent
    public static void rebelEffect(ItemTooltipEvent event) {
        Player player = event.getEntity();

        if (player != null && player.level().isClientSide && player.getInventory().contains(ItemRegistry.REBEL_PERIOD.get().getDefaultInstance())) {
            List<Component> tooltip = event.getToolTip();

            tooltip.replaceAll(c -> c.copy().append(Component.literal("").withStyle(ChatFormatting.RESET)
                    .append(Component.translatable("des.virtuarealcraft.rebel_period.period")).withStyle(ChatFormatting.GRAY)));
        }
    }
}
