package top.yora.virtuarealcraft.item.virtuareal21st.pako;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class KindnessBottle extends Item {
    public KindnessBottle() {
        super(new Properties().stacksTo(1));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(tooltip);
        tooltip.add(Component.translatable("des.virtuarealcraft.kindness_bottle").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.PAKO);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if (pInteractionTarget instanceof ZombieVillager zombieVillager) {
            if (zombieVillager.hasEffect(MobEffects.WEAKNESS)) {
                if (!pPlayer.getAbilities().instabuild) {
                    pStack.setDamageValue(pStack.getMaxDamage());
                }

                if (!pPlayer.level().isClientSide) {
                    zombieVillager.startConverting(pPlayer.getUUID(), 200);
                }

                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.CONSUME;
            }
        }

        return super.interactLivingEntity(pStack, pPlayer, pInteractionTarget, pUsedHand);
    }
}
