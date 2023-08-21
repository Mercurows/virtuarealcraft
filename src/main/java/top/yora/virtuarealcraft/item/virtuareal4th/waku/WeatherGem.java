package top.yora.virtuarealcraft.item.virtuareal4th.waku;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class WeatherGem extends Item {
    public WeatherGem() {
        super(new Properties().durability(10).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.weather_gem.func").withStyle(Style.EMPTY.withColor(ChatFormatting.AQUA)));
        tooltip.add(Component.translatable("des.virtuarealcraft.weather_gem").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.WAKU);
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.HONEYCOMB;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        boolean flag = false;

        ItemStack itemStack = playerIn.getItemInHand(handIn);
        if (handIn == InteractionHand.MAIN_HAND) {
            if (!worldIn.isClientSide) {
                ItemStack off = playerIn.getOffhandItem();
                if (off.isEmpty()) {
                    return new InteractionResultHolder<>(InteractionResult.FAIL, itemStack);
                } else {
                    if (off.getItem() == Items.TORCH) {
                        off.shrink(1);

                        ((ServerLevel) worldIn).setWeatherParameters(12000, 0, false, false);
                        itemStack.hurtAndBreak(1, playerIn, p -> p.broadcastBreakEvent(handIn));
                        playerIn.getCooldowns().addCooldown(itemStack.getItem(), 6000);

                        flag = true;
                    } else if (off.getItem() == Items.WHEAT_SEEDS) {
                        off.shrink(1);

                        ((ServerLevel) worldIn).setWeatherParameters(0, 12000, true, false);
                        itemStack.hurtAndBreak(1, playerIn, p -> p.broadcastBreakEvent(handIn));
                        playerIn.getCooldowns().addCooldown(itemStack.getItem(), 6000);

                        flag = true;
                    } else if (off.getItem() == Items.GUNPOWDER) {
                        off.shrink(1);

                        ((ServerLevel) worldIn).setWeatherParameters(0, 12000, true, true);
                        itemStack.hurtAndBreak(1, playerIn, p -> p.broadcastBreakEvent(handIn));
                        playerIn.getCooldowns().addCooldown(itemStack.getItem(), 6000);

                        flag = true;
                    }

                    if (flag) {
                        return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemStack);
                    }
                }
            }

            if (worldIn.isClientSide) {
                ItemStack off = playerIn.getOffhandItem();
                if (off.getItem() == Items.TORCH || off.getItem() == Items.WHEAT_SEEDS || off.getItem() == Items.GUNPOWDER) {
                    flag = true;
                }

                if (flag) {
                    Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(ItemRegistry.WEATHER_GEM.get()));
                }
            }

        }

        return new InteractionResultHolder<>(InteractionResult.FAIL, itemStack);
    }
}
