package top.yora.virtuarealcraft.item.virtuareal10th.yua;

import net.minecraft.block.SnowBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockState;
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
        super(ModArmorMaterial.YUA, EquipmentSlot.FEET, new Properties().durability(154).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.frozen_boots").mergeStyle(TextFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.YUA);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide) {
            BlockState state = world.getBlockState(player.getPosition().add(0, -1, 0));
            BlockState state1 = world.getBlockState(player.getPosition());
            if(state.getBlock() instanceof IceBlock || state.getBlock() == Blocks.PACKED_ICE || state.getBlock() == Blocks.BLUE_ICE){
                player.addEffect(new MobEffectInstance(MobEffects.SPEED, 20, 2, false, false));
            }
            if(state1.getBlock() instanceof SnowBlock || state.getBlock() == Blocks.SNOW_BLOCK){
                if (player.isShiftKeyDown()) {
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 20, 1, false, false));
                }
            }
        }
    }
}
