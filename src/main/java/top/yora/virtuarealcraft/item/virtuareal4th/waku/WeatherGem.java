package top.yora.virtuarealcraft.item.virtuareal4th.waku;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.ChatFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.init.GroupRegistry;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class WeatherGem extends Item {
    public WeatherGem() {
        super(new Properties().group(GroupRegistry.itemgroup).durability(10).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.weather_gem.func").setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA)));
        tooltip.add(Component.translatable("des.virtuarealcraft.weather_gem").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.WAKU);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.HONEYCOMB;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(Level worldIn, Player playerIn, InteractionHand handIn) {
        boolean flag = false;

        ItemStack itemStack = playerIn.getItemInHand(handIn);
        if (handIn == InteractionHand.MAIN_HAND) {
            if (!worldIn.isClientSide) {
                ItemStack off = playerIn.getMainHandItem();
                if (off.isEmpty()) {
                    return new ActionResult<>(ActionResultType.FAIL, itemStack);
                } else {
                    if (off.getItem() == Items.TORCH) {
                        off.shrink(1);

                        ((ServerLevel) worldIn).func_241113_a_(12000, 0, false, false);
                        itemStack.damageItem(1, playerIn, p -> p.sendBreakAnimation(handIn));
                        playerIn.getCooldowns().addCooldown(itemStack.getItem(), 6000);

                        flag = true;
                    } else if (off.getItem() == Items.WHEAT_SEEDS) {
                        off.shrink(1);

                        ((ServerLevel) worldIn).func_241113_a_(0, 12000, true, false);
                        itemStack.damageItem(1, playerIn, p -> p.sendBreakAnimation(handIn));
                        playerIn.getCooldowns().addCooldown(itemStack.getItem(), 6000);

                        flag = true;
                    } else if (off.getItem() == Items.GUNPOWDER) {
                        off.shrink(1);

                        ((ServerLevel) worldIn).func_241113_a_(0, 12000, true, true);
                        itemStack.damageItem(1, playerIn, p -> p.sendBreakAnimation(handIn));
                        playerIn.getCooldowns().addCooldown(itemStack.getItem(), 6000);

                        flag = true;
                    }

                    if(flag){
                        return new ActionResult<>(ActionResultType.SUCCESS, itemStack);
                    }
                }
            }

            if (worldIn.isClientSide) {
                ItemStack off = playerIn.getMainHandItem();
                if (off.getItem() == Items.TORCH || off.getItem() == Items.WHEAT_SEEDS || off.getItem() == Items.GUNPOWDER) {
                    flag = true;
                }

                if(flag) {
                    Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(ItemRegistry.WEATHER_GEM.get()));
                }
            }

        }

        return new ActionResult<>(ActionResultType.FAIL, itemStack);
    }
}
