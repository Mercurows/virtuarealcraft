package top.yora.virtuarealcraft.item.virtuareal16th.karisa;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TailFeatherSword extends SwordItem {
    public TailFeatherSword() {
        super(Tiers.IRON, 3, -1.5f, new Properties().durability(167));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.tail_feather_sword").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.KARISA);
    }

    public static float getBackStabDamage(float damage, LivingEntity entity) {
        if (entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemRegistry.TACTICAL_HEADSET_MK1.get()) {
            return damage * 16f;
        } else {
            return damage * 3f;
        }
    }

    /**
     * From Farmers Delight
     */
    public static boolean isLookingBehindTarget(LivingEntity target, Vec3 attackerLocation) {
        if (attackerLocation != null) {
            Vec3 lookingVector = target.getViewVector(1.0F);
            Vec3 attackAngleVector = attackerLocation.subtract(target.position()).normalize();
            attackAngleVector = new Vec3(attackAngleVector.x, 0.0D, attackAngleVector.z);
            return attackAngleVector.dot(lookingVector) < -0.5D;
        }
        return false;
    }

    @SubscribeEvent
    public static void onBackStab(LivingHurtEvent event) {
        Entity attacker = event.getSource().getEntity();
        LivingEntity target = event.getEntity();
        if (attacker instanceof Player player) {
            ItemStack weapon = player.getMainHandItem();

            if (!weapon.isEmpty() && weapon.getItem() == ItemRegistry.TAIL_FEATHER_SWORD.get()
                    && isLookingBehindTarget(event.getEntity(), event.getSource().getSourcePosition())) {
                if (!player.level().isClientSide) {
                    event.setAmount(getBackStabDamage(event.getAmount(), target));
                    player.level().playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundEvents.PLAYER_ATTACK_CRIT, SoundSource.PLAYERS, 1.0F, 1.0F);
                }
            }
        }
    }
}
