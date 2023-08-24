package top.yora.virtuarealcraft.item.virtuareal16th.kiyuu;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class GameConsole extends Item {
    public GameConsole() {
        super(new Properties().stacksTo(1));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.game_console_1").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltip.add(Component.translatable("des.virtuarealcraft.game_console_2").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY).withItalic(true)));

        TooltipTool.addLiverInfo(tooltip, Livers.KIYUU);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 200;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if(pLivingEntity instanceof Player player){
               int level = player.experienceLevel;
               double prob = Math.min(0.3 + level * 0.01, 0.8);
               double rand = Math.random();

               if(rand < prob){
                   if(!pLevel.isClientSide){
                       player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 1));
                       player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 1));
                       player.addEffect(new MobEffectInstance(MobEffects.LUCK, 2400, 0));
                   }else {
                       player.playSound(SoundEvents.ARROW_HIT_PLAYER, 1, 1);
                   }
               }else {
                   if(!pLevel.isClientSide){
                       player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, 0));
                       player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200, 0));
                       player.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 1200, 0));
                   }else {
                       player.playSound(SoundEvents.VILLAGER_NO, 1, 1);
                   }
               }

               player.getCooldowns().addCooldown(pStack.getItem(), 6000);
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.EMPTY;
    }
}
