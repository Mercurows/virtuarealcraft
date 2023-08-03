package top.yora.virtuarealcraft.item.virtuareal5th.hoshimi;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
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
        super(ArmorMaterial.IRON, EquipmentSlotType.CHEST, new Properties().group(ModGroup.itemgroup).maxDamage(515));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.hamster_wheel").mergeStyle(TextFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.HOSHIMI);
    }

    @SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new HamsterWheelModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/hamster_wheel.png";
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.HAMSTER_WHEEL.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, -0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isRemote) {
            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 20, 1, false, false));
            player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 20, 0, false, false));

            if (player.isSprinting()) {
                ItemNBTTool.setInt(stack, TAG_SPIRIT, Math.min(100, ItemNBTTool.getInt(stack, TAG_SPIRIT, 0) + 1));

                if (ItemNBTTool.getInt(stack, TAG_SPIRIT, 0) >= 100) {
                    ItemNBTTool.setInt(stack, TAG_SPIRIT, 0);

                    player.addItemStackToInventory(new ItemStack(ItemRegistry.RED_SUNFLOWER_SEEDS.get()));
                    player.addItemStackToInventory(new ItemStack(ItemRegistry.GREEN_SUNFLOWER_SEEDS.get()));
                }
            }
        }
        super.onArmorTick(stack, world, player);
    }
}
