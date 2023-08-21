package top.yora.virtuarealcraft.item.virtuareal5th.hoshimi;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.protocol.game.ClientboundExplodePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.init.SoundRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class GreenSunflowerSeeds extends Item {
    private static final FoodProperties food = new FoodProperties.Builder().alwaysEat().nutrition(2).saturationMod(0.2f).fast().build();

    public GreenSunflowerSeeds() {
        super(new Properties().food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.green_sunflower_seeds").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.HOSHIMI);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        if (entityLiving instanceof Player player) {
            if (worldIn.isClientSide) {
                worldIn.playSound(player, player.getOnPos(), SoundRegistry.NNCB.get(), SoundSource.AMBIENT, 1.0f, 1.0f);
            } else {
                Explosion explosion = new Explosion(worldIn, player, worldIn.damageSources().explosion(player, player),
                        null, player.getX(), player.getY(), player.getZ(), 1, false, Explosion.BlockInteraction.KEEP);
                explosion.explode();
                explosion.finalizeExplosion(true);

                explosion.clearToBlow();

                for (ServerPlayer serverPlayer : ((ServerLevel) worldIn).players()) {
                    if (serverPlayer.distanceToSqr(player.getX(), player.getY(), player.getZ()) < 100) {
                        serverPlayer.connection.send(new ClientboundExplodePacket(player.getX(), player.getY(), player.getZ(), 2, explosion.getToBlow(), explosion.getHitPlayers().get(player)));
                    }
                }
            }

        }
        return super.finishUsingItem(stack, worldIn, entityLiving);
    }
}
