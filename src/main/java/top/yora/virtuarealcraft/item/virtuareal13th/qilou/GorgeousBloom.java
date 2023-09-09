package top.yora.virtuarealcraft.item.virtuareal13th.qilou;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.init.BlockRegistry;

import javax.annotation.Nullable;
import java.util.List;

public class GorgeousBloom extends BlockItem {
    public GorgeousBloom() {
        super(BlockRegistry.GORGEOUS_BLOOM.get(), new Properties()
                .rarity(Rarity.create("virtuarealcraft_legacy", s -> Style.EMPTY.withColor(0x1F5E7E))));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.gorgeous_bloom").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY).withItalic(true)));
    }
}
