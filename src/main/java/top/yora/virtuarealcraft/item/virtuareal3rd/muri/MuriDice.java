package top.yora.virtuarealcraft.item.virtuareal3rd.muri;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.ItemNBTTool;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class MuriDice extends Item {
    public MuriDice() {
        super(new Properties().stacksTo(1));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.muri_dice").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.MURI);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof Player player) {
            ItemNBTTool.setInt(stack, "time", Math.min(60, ItemNBTTool.getInt(stack, "time", 0) + 1));

            if (ItemNBTTool.getInt(stack, "time", 0) >= 60) {
                if (!worldIn.isClientSide) {
                    int rand = (int) (Math.random() * 6 + 1);

                    player.displayClientMessage(Component.literal("1D6 = " + rand).withStyle(Style.EMPTY.withColor(ChatFormatting.BOLD)), true);

                    if (rand > 3) {
                        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
                        player.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 0));
                        player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 0));
                        player.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 200, 0));
                    }
                } else {
                    Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(ItemRegistry.MURI_DICE.get()));
                }

                stack.shrink(1);
            }
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}
