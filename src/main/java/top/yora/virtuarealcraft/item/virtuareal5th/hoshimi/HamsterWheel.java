package top.yora.virtuarealcraft.item.virtuareal5th.hoshimi;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class HamsterWheel extends ArmorItem {
    public HamsterWheel() {
        super(ArmorMaterial.IRON, EquipmentSlotType.CHEST, new Properties().group(ModGroup.itemgroup).maxDamage(515));
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {


        TooltipTool.addLiverInfo(tooltip, Livers.HOSHIMI);
    }

}
