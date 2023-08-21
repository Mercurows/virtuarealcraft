package top.yora.virtuarealcraft.item.virtuareal10th.yua;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.tiers.ModArmorMaterial;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class FrozenBoots extends ArmorItem {
    public FrozenBoots() {
        super(ModArmorMaterial.YUA, Type.BOOTS, new Properties().durability(154));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.frozen_boots").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.YUA);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide) {
            BlockState state = world.getBlockState(player.getOnPos().offset(0, -1, 0));
            BlockState state1 = world.getBlockState(player.getOnPos());
            if(state.getBlock() instanceof IceBlock || state.getBlock() == Blocks.PACKED_ICE || state.getBlock() == Blocks.BLUE_ICE){
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 2, false, false));
            }
            if(state1.getBlock() instanceof SnowLayerBlock || state.getBlock() == Blocks.SNOW_BLOCK){
                if (player.isShiftKeyDown()) {
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 20, 1, false, false));
                }
            }
        }
    }
}
