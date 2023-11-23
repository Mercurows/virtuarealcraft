package top.yora.virtuarealcraft.item.virtuareal19th.michiya;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class MichiyamekiRing extends Item implements ICurioItem {
    public MichiyamekiRing() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((Component.translatable("des.virtuarealcraft.michiyameki_ring")).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.MICHIYA);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        map = HashMultimap.create(map);
        LivingEntity entity = slotContext.entity();
        if (entity != null && entity.level().isRaining()) {
            map.put(Attributes.ARMOR,
                    new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 0.25f, AttributeModifier.Operation.MULTIPLY_TOTAL));
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 0.2f, AttributeModifier.Operation.MULTIPLY_TOTAL));
            map.put(Attributes.KNOCKBACK_RESISTANCE,
                    new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 0.5f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();

        if (entity instanceof Player player && !player.level().isClientSide) {
            if (player.tickCount % 400 == 0) {
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
