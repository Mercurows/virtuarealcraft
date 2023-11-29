package top.yora.virtuarealcraft.item.virtuareal17th.sui;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundExplodePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class SuimashedCookie extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().fast().alwaysEat().nutrition(2).saturationMod(0.25f).build();

    public SuimashedCookie() {
        super(new Properties().food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((Component.translatable("des.virtuarealcraft.suimashed_cookie")).withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.SUI);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if (pInteractionTarget instanceof Villager villager && !pPlayer.level().isClientSide) {
            if (villager.getVillagerData().getProfession().name().equals("elifaus")) {
                Explosion explosion = new Explosion(pPlayer.level(), villager, pPlayer.level().damageSources().explosion(villager, villager),
                        null, villager.getX(), villager.getY(), villager.getZ(), 2, false, Explosion.BlockInteraction.KEEP);
                explosion.explode();
                explosion.finalizeExplosion(true);

                explosion.clearToBlow();

                for (ServerPlayer serverPlayer : ((ServerLevel) pPlayer.level()).players()) {
                    if (serverPlayer.distanceToSqr(villager.getX(), villager.getY(), villager.getZ()) < 1024) {
                        serverPlayer.connection.send(new ClientboundExplodePacket(villager.getX(), villager.getY(), villager.getZ(), 2, explosion.getToBlow(), explosion.getHitPlayers().get(serverPlayer)));
                    }
                }

                villager.hurt(pPlayer.level().damageSources().explosion(null, null), 100.0f);

                if (!pPlayer.isCreative()) {
                    pStack.shrink(1);
                }

                return InteractionResult.SUCCESS;
            }
        }
        return super.interactLivingEntity(pStack, pPlayer, pInteractionTarget, pUsedHand);
    }
}
