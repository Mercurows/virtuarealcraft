package top.yora.virtuarealcraft.item.virtuareal19th.awu;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.tool.ItemNBTTool;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class ChengHuangCrystal extends Item {
    private static final String TAG_ENERGY = "vrc_energy";

    public ChengHuangCrystal() {
        super(new Properties().stacksTo(1));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.cheng_huang_crystal").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.AWU);
    }

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return ItemNBTTool.getInt(pStack, TAG_ENERGY, 0) != 30;
    }

    @Override
    public int getBarWidth(ItemStack pStack) {
        return Math.round((float)ItemNBTTool.getInt(pStack, TAG_ENERGY, 0) * 13.0F / 30.0F);
    }

    @Override
    public int getBarColor(ItemStack pStack) {
        return 0xF9A699;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide) {
            int energy = ItemNBTTool.getInt(stack, TAG_ENERGY, 0);

            if (pPlayer.isSteppingCarefully()) {
                if (pPlayer.getFoodData().getSaturationLevel() >= 1.5) {
                    if (energy >= 30) {
                        return InteractionResultHolder.fail(stack);
                    }

                    ItemNBTTool.setInt(stack, TAG_ENERGY, Math.min(30, energy + 1));

                    pPlayer.getFoodData().setSaturation(pPlayer.getFoodData().getSaturationLevel() - 1.5f);
                    return InteractionResultHolder.success(stack);
                }
            } else {
                int heal = (int) (pPlayer.getMaxHealth() - pPlayer.getHealth());

                if (heal == 0 || energy == 0) {
                    return InteractionResultHolder.fail(stack);
                }

                if (heal < energy) {
                    pPlayer.heal(heal);
                    ItemNBTTool.setInt(stack, TAG_ENERGY, energy - heal);
                } else {
                    pPlayer.heal(energy);
                    ItemNBTTool.setInt(stack, TAG_ENERGY, 0);
                }

                pPlayer.getCooldowns().addCooldown(stack.getItem(), 1200);

                return InteractionResultHolder.success(stack);
            }
        }
        return InteractionResultHolder.fail(stack);
    }
}
