package top.yora.virtuarealcraft.item.virtuareal13th.joi;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class OrangeGrenade extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().alwaysEat().nutrition(4).saturationMod(0.2f).build();

    public OrangeGrenade() {
        super(new Properties().food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(tooltip);
        tooltip.add(Component.translatable("des.virtuarealcraft.orange_grenade_1").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltip.add(Component.translatable("des.virtuarealcraft.orange_grenade_2").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY).withItalic(Boolean.TRUE)));

        TooltipTool.addLiverInfo(tooltip, Livers.JOI);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        if (playerIn.isShiftKeyDown()) {
            playerIn.displayClientMessage(Component.literal("丢橘子"), true);

            itemstack.shrink(1);
        } else {
            playerIn.startUsingItem(handIn);
        }
        return InteractionResultHolder.success(itemstack);
    }


}
