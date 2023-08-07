package top.yora.virtuarealcraft.item.virtuareal10th.yua;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IceBlock;
import net.minecraft.block.SnowBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.tiers.ModArmorMaterial;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class FrozenBoots extends ArmorItem {
    public FrozenBoots() {
        super(ModArmorMaterial.YUA, EquipmentSlotType.FEET, new Properties().maxDamage(154).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.frozen_boots").mergeStyle(TextFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.YUA);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(!world.isRemote){
            BlockState state = world.getBlockState(player.getPosition().add(0, -1, 0));
            BlockState state1 = world.getBlockState(player.getPosition());
            if(state.getBlock() instanceof IceBlock || state.getBlock() == Blocks.PACKED_ICE || state.getBlock() == Blocks.BLUE_ICE){
                player.addPotionEffect(new EffectInstance(Effects.SPEED, 20, 2, false, false));
            }
            if(state1.getBlock() instanceof SnowBlock || state.getBlock() == Blocks.SNOW_BLOCK){
                if(player.isSneaking()){
                    player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 20, 1, false, false));
                }
            }
        }
    }
}
