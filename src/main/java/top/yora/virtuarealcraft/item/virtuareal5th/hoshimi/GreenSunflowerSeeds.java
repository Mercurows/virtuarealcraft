package top.yora.virtuarealcraft.item.virtuareal5th.hoshimi;

import net.minecraft.ChatFormatting;
import net.minecraft.item.Food;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.play.server.SExplosionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.init.GroupRegistry;
import top.yora.virtuarealcraft.init.SoundRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class GreenSunflowerSeeds extends Item {
    private static final Food food = new Food.Builder().setAlwaysEdible().hunger(2).saturation(0.2f).fastToEat().build();

    public GreenSunflowerSeeds() {
        super(new Properties().group(GroupRegistry.itemgroup).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.green_sunflower_seeds").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.HOSHIMI);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        if (entityLiving instanceof Player player) {

            if (worldIn.isClientSide) {
                worldIn.playSound(player, player.getPosition(), SoundRegistry.NNCB.get(), SoundCategory.AMBIENT, 1.0f, 1.0f);
            } else {
                Explosion explosion = new Explosion(worldIn, player, DamageSource.causeExplosionDamage(player),
                        null, player.getX(), player.getY(), player.getZ(), 1, false, Explosion.Mode.NONE);
                explosion.doExplosionA();
                explosion.doExplosionB(true);

                explosion.clearAffectedBlockPositions();

                for (ServerPlayer serverPlayer : ((ServerLevel) worldIn).getPlayers()) {
                    if (serverPlayer.getDistanceSq(player.getX(), player.getY(), player.getZ()) < 100) {
                        serverPlayer.connection.send(new SExplosionPacket(player.getX(), player.getY(), player.getZ(), 2, explosion.getAffectedBlockPositions(), explosion.getPlayerKnockbackMap().get(player)));
                    }
                }
            }

        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
