package top.yora.virtuarealcraft.item.virtuareal19th.ameki;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.ItemNBTTool;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class RainyButterfly extends SwordItem {
    public static final String TAG_RAINY_BUTTERFLY_COUNT = "rainy_butterfly_count";
    public static final String TAG_RAINY_BUTTERFLY_TIME = "rainy_butterfly_time";
    public static final String TAG_RAINY_BUTTERFLY_OPEN = "rainy_butterfly_open";
    public static final String TAG_RAINY_BUTTERFLY_RAIN = "rainy_butterfly_rain";

    public RainyButterfly() {
        super(Tiers.IRON, -2, -2.1f, new Properties().durability(1206).rarity(Rarity.EPIC));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((Component.translatable("des.virtuarealcraft.rainy_butterfly_1")).withStyle(ChatFormatting.GRAY));
        tooltip.add((Component.translatable("des.virtuarealcraft.rainy_butterfly_2")).withStyle(ChatFormatting.GRAY));
        tooltip.add((Component.translatable("des.virtuarealcraft.rainy_butterfly_3")).withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.AMEKI);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = attacker.level();
        if (!world.isClientSide) {
            if (!ItemNBTTool.getBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false)) {
                int count = ItemNBTTool.getInt(stack, TAG_RAINY_BUTTERFLY_COUNT, 0);
                if (count > 0) {
                    if (!world.isRaining()) {
                        attacker.heal(2.0f);
                    } else {
                        attacker.heal(5.0f);
                    }
                    ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_COUNT, count - 1);
                }
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level pLevel, Player pPlayer) {
        ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_COUNT, 0);
        ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_TIME, 0);
        ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
        ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_RAIN, false);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isClientSide) {
            if (entityIn instanceof Player player) {
                boolean isMainhand = player.getMainHandItem() == stack;
                boolean isOffHand = player.getOffhandItem() == stack;

                if (isMainhand || isOffHand) {
                    boolean open = ItemNBTTool.getBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
                    if (open) {
                        if (player.tickCount % 20 == 0 && getRainyButterflyTime(stack) < 20
                                && getRainyButterflyCount(stack) < (worldIn.isRaining() ? 9 : 3)) {
                            setRainyButterflyTime(stack, Math.min(20, getRainyButterflyTime(stack) + 1));
                        }

                        if (worldIn.isRaining()) {
                            if (getRainyButterflyTime(stack) >= 5 && getRainyButterflyCount(stack) < 9 && getRainyButterflyTime(stack) > 0) {
                                setRainyButterflyCount(stack, Math.min(9, getRainyButterflyCount(stack) + 1));
                                setRainyButterflyTime(stack, getRainyButterflyTime(stack) - 5);
                            }
                        } else {
                            if (getRainyButterflyTime(stack) % 20 == 0 && getRainyButterflyCount(stack) < 3 && getRainyButterflyTime(stack) > 0) {
                                setRainyButterflyCount(stack, Math.min(3, getRainyButterflyCount(stack) + 1));
                                setRainyButterflyTime(stack, getRainyButterflyTime(stack) - 20);
                            }
                        }
                    }
                }
            }
        }
        if (worldIn.isRaining()) {
            if (stack.getDamageValue() < stack.getMaxDamage()) {
                Player player = (Player) entityIn;
                if (player.tickCount % 20 == 0) {
                    stack.hurtAndBreak(-1, player, (Player) -> Player.broadcastBreakEvent(player.getUsedItemHand()));
                }
            }
            ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_RAIN, true);
        } else {
            ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_RAIN, false);
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);

        boolean open = ItemNBTTool.getBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
        if (open) {
            if (playerIn.isShiftKeyDown()) {
                ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
                playerIn.getCooldowns().addCooldown(stack.getItem(), 40);
                playerIn.playSound(SoundEvents.ARMOR_EQUIP_LEATHER, 1.0f, 1.0f);
            }
        } else {
            int level = getRainyButterflyCount(stack);
            if (level > 0) {
                if (playerIn.isShiftKeyDown()) {
                    playerIn.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 800, level - 1, false, false));

                    Vec3 look = playerIn.getLookAngle();
                    Vec3 position = playerIn.position().add(0, playerIn.getEyeHeight(), 0);
                    Vec3 endPos = position.add(look.scale(4.0));

                    AABB box = new AABB(position, endPos);
                    List<Entity> entities = worldIn.getEntitiesOfClass(Entity.class, box);

                    for (Entity entity : entities) {
                        if (entity != playerIn && entity.isPushable()) {
                            if (entity instanceof LivingEntity && !(entity instanceof ArmorStand)) {
                                float strength = (float) Math.ceil(getRainyButterflyCount(stack) / 3.0f);
                                ((LivingEntity) entity).knockback(strength * 1.5f, playerIn.getX() - entity.getX(), playerIn.getZ() - entity.getZ());
                            }
                        }
                    }

                    setRainyButterflyCount(stack, 0);
                } else {
                    playerIn.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0, false, false));
                    setRainyButterflyCount(stack, level - 1);
                }
            }

            ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, true);
            playerIn.getCooldowns().addCooldown(stack.getItem(), 10);
            playerIn.playSound(SoundEvents.ARMOR_EQUIP_LEATHER, 1.0f, 1.0f);
        }
        return new InteractionResultHolder<>(InteractionResult.FAIL, stack);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot, stack);
        UUID uuid = new UUID(ItemRegistry.RAINY_BUTTERFLY.hashCode() + equipmentSlot.toString().hashCode(), 0);
        UUID uuid2 = new UUID(ItemRegistry.RAINY_BUTTERFLY.hashCode(), 0);
        if (equipmentSlot == EquipmentSlot.MAINHAND || equipmentSlot == EquipmentSlot.OFFHAND) {
            map = HashMultimap.create(map);
            boolean flag = ItemNBTTool.getBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
            int count = ItemNBTTool.getInt(stack, TAG_RAINY_BUTTERFLY_COUNT, 0);
            boolean rain = ItemNBTTool.getBoolean(stack, TAG_RAINY_BUTTERFLY_RAIN, false);

            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, flag ? 0.0f : 7.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, flag ? count * 0.05f : 0.0f, AttributeModifier.Operation.MULTIPLY_TOTAL));
            map.put(Attributes.ARMOR,
                    new AttributeModifier(uuid2, "rainy butterfly modifier2", rain ? count * 0.03f : 0.0f, AttributeModifier.Operation.MULTIPLY_TOTAL));
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, rain ? count * 0.02f : 0.0f, AttributeModifier.Operation.MULTIPLY_TOTAL));
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, rain ? count * 0.05f : 0.0f, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return map;
    }

    private static int getRainyButterflyCount(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_RAINY_BUTTERFLY_COUNT, 0);
    }

    private static int getRainyButterflyTime(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_RAINY_BUTTERFLY_TIME, 0);
    }

    private static void setRainyButterflyCount(ItemStack stack, int count) {
        ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_COUNT, count);
    }

    private static void setRainyButterflyTime(ItemStack stack, int time) {
        ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_TIME, time);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}
