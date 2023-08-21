package top.yora.virtuarealcraft.item.virtuareal5th.miki;

import net.minecraft.ChatFormatting;
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
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class Mi extends Item {
    public Mi() {
        super(new Properties());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.mi").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.MIKI);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mi = pPlayer.getItemInHand(pUsedHand);
        if(!pLevel.isClientSide){
            ItemStack stack = pPlayer.getItemBySlot(EquipmentSlot.LEGS);
            if(stack.getItem() == ItemRegistry.MIKI_TAIL.get()){
                pPlayer.heal(1.0f);
                mi.shrink(1);
                pPlayer.getCooldowns().addCooldown(mi.getItem(), 10);
            }else {
                pPlayer.addItem(new ItemStack(ItemRegistry.MI.get()));
                pPlayer.getCooldowns().addCooldown(mi.getItem(), 20);
            }
            return InteractionResultHolder.success(mi);
        }
        return InteractionResultHolder.fail(mi);
    }
}
