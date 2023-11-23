package top.yora.virtuarealcraft.item.virtuareal17th.sui;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class DebtReliefTicket extends Item {
    public DebtReliefTicket() {
        super(new Properties().rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((Component.translatable("des.virtuarealcraft.debt_relief_ticket_1")).withStyle(ChatFormatting.GRAY));
        tooltip.add((Component.translatable("des.virtuarealcraft.debt_relief_ticket_2")).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.SUI);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if (!pPlayer.level().isClientSide) {
            if (pInteractionTarget instanceof Villager villager) {
                if (villager.getVillagerData().getProfession() == VillagerProfession.NONE) {
                    return InteractionResult.FAIL;
                }

                villager.restock();

                if (!pPlayer.isCreative()) {
                    pStack.shrink(1);
                }

                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
}
