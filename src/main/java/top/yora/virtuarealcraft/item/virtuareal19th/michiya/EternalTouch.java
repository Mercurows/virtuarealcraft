package top.yora.virtuarealcraft.item.virtuareal19th.michiya;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
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
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.init.EffectRegistry;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EternalTouch extends Item implements ICurioItem {
    public EternalTouch() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(tooltip);
        tooltip.add(Component.translatable("des.virtuarealcraft.eternal_touch_1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("des.virtuarealcraft.eternal_touch_2").withStyle(ChatFormatting.GRAY));

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
        map.put(Attributes.MAX_HEALTH,
                new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, -0.1f, AttributeModifier.Operation.MULTIPLY_BASE));
        map.put(Attributes.ATTACK_DAMAGE,
                new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 0.1f, AttributeModifier.Operation.MULTIPLY_BASE));
        return map;
    }


    @SubscribeEvent
    public static void eternalTouchEffect(AttackEntityEvent event) {
        Player player = event.getEntity();

        if (event.getTarget() instanceof LivingEntity living) {
            CuriosApi.getCuriosInventory(player).ifPresent(s -> s.findFirstCurio(ItemRegistry.ETERNAL_TOUCH.get()).ifPresent(
                    r -> living.addEffect(new MobEffectInstance(EffectRegistry.CURSE_FLAME.get(), 100, 0))
            ));
        }
    }
}
