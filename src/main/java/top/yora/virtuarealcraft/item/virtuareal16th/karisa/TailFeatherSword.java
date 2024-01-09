package top.yora.virtuarealcraft.item.virtuareal16th.karisa;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
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

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.getItem() == Items.FEATHER;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            pPlayer.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 160, 0, false, false));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 160, 2, false, false));

            pPlayer.hurt(pLevel.damageSources().magic(), pPlayer.getHealth() * 0.2f);
            pPlayer.getCooldowns().addCooldown(this, 320);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
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
        DamageSource source = event.getSource();
        if (attacker instanceof Player player) {
            ItemStack weapon = player.getMainHandItem();

            if (!weapon.isEmpty() && weapon.getItem() == ItemRegistry.TAIL_FEATHER_SWORD.get() && source.is(DamageTypes.PLAYER_ATTACK)) {
                if (!player.level().isClientSide) {
                    float amp = 1.0f;
                    if (target.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemRegistry.TACTICAL_HEADSET_MK1.get()) {
                        amp *= 16;
                    }

                    if (target instanceof Ocelot || target.getClass().getName().toLowerCase().contains("cat")) {
                        amp *= 8;
                    }

                    if (isLookingBehindTarget(event.getEntity(), event.getSource().getSourcePosition())) {
                        amp *= 3;
                        player.heal(0.048f * player.getMaxHealth());
                        player.level().playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundEvents.PLAYER_ATTACK_CRIT, SoundSource.PLAYERS, 1.0F, 1.0F);
                    }

                    event.setAmount(amp * event.getAmount());
                }
            }
        }
    }
}
