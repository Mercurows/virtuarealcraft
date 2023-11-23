package top.yora.virtuarealcraft.item.virtuareal19th.ameki;

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
import top.yora.virtuarealcraft.tool.ItemNBTTool;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class AmekichiyaRing extends Item implements ICurioItem {
    public AmekichiyaRing() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE).fireResistant());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((Component.translatable("des.virtuarealcraft.amekichiya_ring")).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.AMEKI);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();

        if (entity != null && !entity.level().isClientSide) {
            ItemNBTTool.setBoolean(stack, "isNight", !entity.level().isDay());

            if (entity instanceof Player player) {
                AABB box = new AABB(player.getOnPos().offset(10, 10, 10), player.getOnPos().offset(-10, -10, -10));

                List<LivingEntity> entities = entity.level().getEntitiesOfClass(LivingEntity.class, box);
                entities.forEach(e -> {
                    if (e instanceof Phantom phantom) {
                        if (phantom.getTarget() == player) {
                            phantom.addDeltaMovement(new Vec3(phantom.getX() - player.getX(), 0, phantom.getZ() - player.getZ()).normalize().scale(3));
                            phantom.setTarget(null);
                        }
                    }
                });
            }
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        map = HashMultimap.create(map);
        if (ItemNBTTool.getBoolean(stack, "isNight", false)) {
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 0.3f, AttributeModifier.Operation.MULTIPLY_TOTAL));
            map.put(Attributes.ATTACK_SPEED,
                    new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 0.2f, AttributeModifier.Operation.MULTIPLY_TOTAL));
            map.put(Attributes.ATTACK_KNOCKBACK,
                    new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 0.3f, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return map;
    }
}
