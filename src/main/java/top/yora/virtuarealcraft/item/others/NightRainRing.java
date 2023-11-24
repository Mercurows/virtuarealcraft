package top.yora.virtuarealcraft.item.others;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.ItemNBTTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class NightRainRing extends Item implements ICurioItem {
    public NightRainRing() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((Component.translatable("des.virtuarealcraft.night_rain_ring_1")).withStyle(ChatFormatting.GRAY));
        tooltip.add((Component.translatable("des.virtuarealcraft.night_rain_ring_2")).withStyle(ChatFormatting.GRAY));
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(ItemRegistry.AMEKICHIYA_RING.get()).ifPresent(s -> flag.set(false)));
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(ItemRegistry.MICHIYAMEKI_RING.get()).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();

        if (entity != null && !entity.level().isClientSide) {
            ItemNBTTool.setBoolean(stack, "isNight", !entity.level().isDay());

            if (entity instanceof Player player) {
                AABB box = new AABB(player.getOnPos().offset(15, 15, 15), player.getOnPos().offset(-15, -15, -15));

                List<LivingEntity> entities = entity.level().getEntitiesOfClass(LivingEntity.class, box);
                entities.forEach(e -> {
                    if (e instanceof Phantom phantom) {
                        if (phantom.getTarget() == player) {
                            phantom.addDeltaMovement(new Vec3(phantom.getX() - player.getX(), 0, phantom.getZ() - player.getZ()).normalize().scale(3));
                            phantom.setTarget(null);
                        }
                    }
                });

                if (player.tickCount % 300 == 0) {
                    player.getInventory().items.forEach(s -> {
                        if (s.isDamageableItem()) {
                            s.hurtAndBreak(-1, player, p -> p.broadcastBreakEvent(p.getUsedItemHand()));
                        }
                    });
                    player.getInventory().armor.forEach(s -> {
                        if (s.isDamageableItem()) {
                            s.hurtAndBreak(-1, player, p -> p.broadcastBreakEvent(p.getUsedItemHand()));
                        }
                    });
                }
            }
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        boolean flag_night = ItemNBTTool.getBoolean(stack, "isNight", false);
        LivingEntity entity = slotContext.entity();
        boolean flag_rain = entity != null && entity.level().isRaining();
        float bonus = 0;
        if (flag_night || flag_rain) {
            bonus += 0.09f;
        }
        if (flag_night && flag_rain) {
            bonus += 0.1f;
        }

        map = HashMultimap.create(map);
        map.put(Attributes.ATTACK_DAMAGE,
                new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 0.16f + bonus, AttributeModifier.Operation.MULTIPLY_TOTAL));
        map.put(Attributes.ATTACK_SPEED,
                new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 0.06f + bonus, AttributeModifier.Operation.MULTIPLY_TOTAL));
        map.put(Attributes.ATTACK_KNOCKBACK,
                new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 0.11f + bonus, AttributeModifier.Operation.MULTIPLY_TOTAL));
        map.put(Attributes.ARMOR,
                new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 0.11f + bonus, AttributeModifier.Operation.MULTIPLY_TOTAL));
        map.put(Attributes.ARMOR_TOUGHNESS,
                new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 0.06f + bonus, AttributeModifier.Operation.MULTIPLY_TOTAL));
        map.put(Attributes.KNOCKBACK_RESISTANCE,
                new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 0.6f, AttributeModifier.Operation.ADDITION));
        return map;
    }
}
