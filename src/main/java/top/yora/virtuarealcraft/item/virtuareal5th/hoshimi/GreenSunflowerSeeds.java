package top.yora.virtuarealcraft.item.virtuareal5th.hoshimi;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SExplosionPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.init.SoundRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class GreenSunflowerSeeds extends Item {
    private static final Food food = new Food.Builder().setAlwaysEdible().hunger(2).saturation(0.2f).fastToEat().build();

    public GreenSunflowerSeeds() {
        super(new Properties().group(ModGroup.itemgroup).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.green_sunflower_seeds").mergeStyle(TextFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.HOSHIMI);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityLiving;

            if (worldIn.isRemote) {
                worldIn.playSound(player, player.getPosition(), SoundRegistry.NNCB.get(), SoundCategory.AMBIENT, 1.0f, 1.0f);
            } else {
                Explosion explosion = new Explosion(worldIn, player, DamageSource.causeExplosionDamage(player),
                        null, player.getPosX(), player.getPosY(), player.getPosZ(), 1, false, Explosion.Mode.NONE);
                explosion.doExplosionA();
                explosion.doExplosionB(true);

                explosion.clearAffectedBlockPositions();

                for (ServerPlayerEntity serverPlayer : ((ServerWorld) worldIn).getPlayers()) {
                    if (serverPlayer.getDistanceSq(player.getPosX(), player.getPosY(), player.getPosZ()) < 100) {
                        serverPlayer.connection.sendPacket(new SExplosionPacket(player.getPosX(), player.getPosY(), player.getPosZ(), 2, explosion.getAffectedBlockPositions(), explosion.getPlayerKnockbackMap().get(player)));
                    }
                }
            }

        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
