package top.yora.virtuarealcraft.item.virtuareal14th.rhea;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Streams;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WisdomWand extends SwordItem {
    public WisdomWand() {
        super(Tiers.IRON, 7, -3.0f, new Properties().rarity(Rarity.EPIC).durability(1487));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((Component.translatable("des.virtuarealcraft.wisdom_wand")).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.RHEA);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getDefaultAttributeModifiers(pEquipmentSlot);
        UUID uuid = new UUID(ItemRegistry.WISDOM_WAND.hashCode() + pEquipmentSlot.toString().hashCode(), 0);
        if (pEquipmentSlot == EquipmentSlot.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(ForgeMod.ENTITY_REACH.get(),
                    new AttributeModifier(uuid, Utils.ATTRIBUTE_MODIFIER, 3.0f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        int lvl = -1;
        if (pAttacker.hasEffect(MobEffects.DIG_SPEED)) {
            lvl = pAttacker.getEffect(MobEffects.DIG_SPEED).getAmplifier();
        }

        pAttacker.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 120, lvl > 3 ? 4 : lvl + 1));

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 28;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.SPEAR;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player) {
            if (player.isSteppingCarefully()) {
                if (player.getVehicle() != null) {
                    return pStack;
                }

                Vec3 start = player.getEyePosition(1);
                Vec3 end = start.add(player.getLookAngle().scale(50));

                Vec3 res;

                BlockHitResult rayTrace = pLevel.clip(new ClipContext(start, end, ClipContext.Block.COLLIDER,
                        ClipContext.Fluid.NONE, player));

                if (rayTrace.getType() == HitResult.Type.BLOCK) {
                    BlockPos pos = rayTrace.getBlockPos().relative(rayTrace.getDirection());

                    res = getTpPos(player, getFaceCenter(pos));
                } else {
                    res = start.add(player.getLookAngle().scale(30));
                }

                if (res != null) {
                    if (!pLevel.isClientSide) {
                        player.teleportTo(res.x, res.y, res.z);
                    } else {
                        for (int i = 1; i <= 20; i++) {
                            pLevel.addParticle(ParticleTypes.ENCHANT, true,
                                    player.getX(), player.getY(), player.getZ(),
                                    pLevel.random.nextDouble() * 3 - 0.5, pLevel.random.nextDouble() * 3, pLevel.random.nextDouble() * 3 - 0.5);
                        }
                    }
                }

                pLevel.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
                player.fallDistance = 0;
            } else {
                if (!pLevel.isClientSide) {
                    AABB box = new AABB(player.getOnPos().offset(20, 20, 20), player.getOnPos().offset(-20, -20, -20));

                    List<Projectile> projectiles = pLevel.getEntitiesOfClass(Projectile.class, box);
                    projectiles.forEach(p -> {
                        if (!p.getTags().contains("vrc_pause") && !p.onGround()) {
                            if (p instanceof Fireball fireball) {
                                fireball.discard();
                            }

                            Vec3 vec = p.getDeltaMovement();
                            boolean flag = p.isNoGravity();

                            p.addTag("vrc_pause");
                            p.setNoGravity(true);
                            p.setDeltaMovement(0, 0, 0);

                            new Object() {
                                private int ticks = 0;
                                private float waitTicks;

                                public void start(int waitTicks) {
                                    this.waitTicks = waitTicks;
                                    MinecraftForge.EVENT_BUS.register(this);
                                }

                                @SubscribeEvent
                                public void tick(TickEvent.ServerTickEvent event) {
                                    if (event.phase == TickEvent.Phase.END) {
                                        this.ticks++;
                                        if (this.ticks >= this.waitTicks) {
                                            run();
                                        }
                                    }
                                }

                                private void run() {
                                    p.setDeltaMovement(vec);
                                    p.setNoGravity(flag);
                                    p.removeTag("vrc_pause");

                                    MinecraftForge.EVENT_BUS.unregister(this);
                                }
                            }.start(80);
                        }
                    });
                }
            }

            player.getCooldowns().addCooldown(this, 140);
            pStack.hurtAndBreak(1, player, pPlayer -> pPlayer.broadcastBreakEvent(pPlayer.getUsedItemHand()));
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    public static Vec3 getTpPos(Entity entity, Vec3 vec3) {
        Level level = entity.level();
        AABB box = entity.getBoundingBox();

        box = box.move(vec3.subtract(entity.getX(), entity.getY(), entity.getZ()));

        Iterable<BlockPos> cuboid = BlockPos.betweenClosed(Mth.floor(box.minX), Mth.floor(box.minY),
                Mth.floor(box.minZ), Mth.floor(box.maxX), Mth.floor(box.maxY), Mth.floor(box.maxZ));

        if (Streams.stream(cuboid).noneMatch(b -> level.noCollision(new AABB(b)))) {
            return vec3;
        } else {
            double dx = box.maxX - box.minX;
            double dy = box.maxY - box.minY;
            double dz = box.maxZ - box.minZ;

            int nx = Mth.ceil(dx) / 2;
            int px = Mth.ceil(dx) - nx;
            int ny = Mth.ceil(dy) / 2;
            int py = Mth.ceil(dy) - ny;
            int nz = Mth.ceil(dz) / 2;
            int pz = Mth.ceil(dz) - nz;

            List<BlockPos> nearby = Streams.stream(BlockPos.betweenClosed(Mth.floor(box.minX) - 1,
                    Mth.floor(box.minY) - 1, Mth.floor(box.minZ) - 1,
                    Mth.floor(box.maxX) + 1, Mth.floor(box.maxY) + 1,
                    Mth.floor(box.maxZ) + 1)).collect(Collectors.toList());

            List<BlockPos> possiblePositions = Streams.stream(cuboid).collect(Collectors.toList());

            while (!nearby.isEmpty()) {
                BlockPos pos = nearby.remove(0);

                if (level.noCollision(new AABB(pos))) {
                    Predicate<BlockPos> nearSolidBlock = b -> b.getX() >= pos.getX() - nx && b.getX() <= pos.getX() + px
                            && b.getY() >= pos.getY() - ny && b.getY() <= pos.getY() + py
                            && b.getZ() >= pos.getZ() - nz && b.getZ() <= pos.getZ() + pz;
                    nearby.removeIf(nearSolidBlock);
                    possiblePositions.removeIf(nearSolidBlock);
                }
            }

            if (possiblePositions.isEmpty()) {
                return null;
            }

            BlockPos nearest = possiblePositions.stream().min(Comparator.comparingDouble(b -> vec3.distanceToSqr(
                    b.getX() + 0.5, b.getY() + 0.5, b.getZ() + 0.5))).get();

            return getFaceCenter(nearest);
        }
    }

    public static Vec3 getFaceCenter(BlockPos pos) {
        return new Vec3(pos.getX(), pos.getY(), pos.getZ()).add(0.5, 0, 0.5);
    }
}
