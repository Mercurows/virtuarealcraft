package top.yora.virtuarealcraft.item.virtuareal5th.hoshimi;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.models.HamsterWheelModel;
import top.yora.virtuarealcraft.tool.ItemNBTTool;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class HamsterWheel extends ArmorItem {
    public static final String TAG_SPIRIT = "spiriting";

    public HamsterWheel() {
        super(ArmorMaterials.IRON, EquipmentSlot.CHEST, new Item.Properties().group(ModGroup.itemgroup).durability(515));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.hamster_wheel").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.HOSHIMI);
    }

    @SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, A _default) {
        return (A) new HamsterWheelModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/hamster_wheel.png";
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot, stack);
        UUID uuid = new UUID(ItemRegistry.HAMSTER_WHEEL.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, -0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 1, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20, 0, false, false));

            if (player.isSprinting()) {
                ItemNBTTool.setInt(stack, TAG_SPIRIT, Math.min(100, ItemNBTTool.getInt(stack, TAG_SPIRIT, 0) + 1));

                if (ItemNBTTool.getInt(stack, TAG_SPIRIT, 0) >= 100) {
                    ItemNBTTool.setInt(stack, TAG_SPIRIT, 0);

                    player.addItem(new ItemStack(ItemRegistry.RED_SUNFLOWER_SEEDS.get()));
                    player.addItem(new ItemStack(ItemRegistry.GREEN_SUNFLOWER_SEEDS.get()));
                }
            }
        }
        super.onArmorTick(stack, world, player);
    }
}
