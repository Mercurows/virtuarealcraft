package top.yora.virtuarealcraft.item.virtuareal19th.ameki;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.RarityTool;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class EndlessRainShower extends SwordItem {
    public EndlessRainShower() {
        super(Tiers.NETHERITE, 14, -2.03f, new Properties().rarity(RarityTool.LEGENDARY).durability(197).fireResistant().setNoRepair());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.endless_rain_shower_1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        tooltip.add(Component.translatable("des.virtuarealcraft.endless_rain_shower_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.AMEKI);
    }
}
