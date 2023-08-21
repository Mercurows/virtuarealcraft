package top.yora.virtuarealcraft.item.virtuareal5th.hoshimi;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.init.SoundRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class RedSunflowerSeeds extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(0.2f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 60, 0), 1.0f).build();

    public RedSunflowerSeeds() {
        super(new Properties().food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.red_sunflower_seeds").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.HOSHIMI);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        if (entityLiving instanceof Player player) {

            if (worldIn.isClientSide) {
                worldIn.playSound(player, player.getOnPos(), SoundRegistry.HOSHIMI_MUA.get(), SoundSource.AMBIENT, 2.0f, 1.0f);
            }
        }
        return super.finishUsingItem(stack, worldIn, entityLiving);
    }
}
