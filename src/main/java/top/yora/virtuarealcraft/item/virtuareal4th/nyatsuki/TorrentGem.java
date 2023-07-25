package top.yora.virtuarealcraft.item.virtuareal4th.nyatsuki;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class TorrentGem extends Item {
    public TorrentGem() {
        super(new Properties().group(ModGroup.itemgroup).maxDamage(99));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.torrent_gem").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));

        TooltipTool.addLiverInfo(tooltip, Livers.NYATSUKI);
    }
}
