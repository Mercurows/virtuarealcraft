package top.yora.virtuarealcraft.item.virtuareal12th.mayumi;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.init.SoundRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

// TODO 我模型呢
public class MayumiLefthand extends Item {
    public MayumiLefthand() {
        super(new Properties().durability(816));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add(Component.translatable("des.virtuarealcraft.mayumi_lefthand").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.MAYUMI);
    }

    // TODO 实现勾叫
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        InteractionHand left = pPlayer.getMainArm() == HumanoidArm.RIGHT ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;

        if (pUsedHand == left) {
            if (pLevel.isNight()) {
                Vec3 look = pPlayer.getLookAngle();
                Vec3 start = pPlayer.getEyePosition();
                Vec3 end = pPlayer.getEyePosition().add(look.x * 300, look.y * 300, look.z * 300);

                BlockHitResult result = pLevel.clip(new ClipContext(start, end, ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, pPlayer));
                if (result.getType() == HitResult.Type.BLOCK) {
                    return InteractionResultHolder.fail(stack);
                }

                float yrot = pPlayer.getViewYRot(0) % 360;
                boolean isReversed = yrot < 0;
                boolean isValid = false;
                boolean isEast = false;

                float absYrot = Math.abs(yrot);
                if (absYrot <= 273 && absYrot >= 267) {
                    isEast = true;
                    isValid = true;
                }
                if (absYrot <= 93 && absYrot >= 87) {
                    isValid = true;
                }

                isEast = isReversed != isEast;
                boolean flag = false;

                // yrot correct
                if (isValid) {
                    float time = pLevel.getTimeOfDay(0);

                    if (time < 0.5f) {
                        // moon east
                        float moonPercent = time / 0.5f;
                        float playerPercent = (180 - (pPlayer.getViewXRot(0) + 90)) / 180f;

                        if (Math.abs(moonPercent - playerPercent) < 0.022 && isEast) {
                            flag = true;
                        }
                    } else {
                        // moon west
                        float moonPercent = (time - 0.5f) / 0.5f;
                        float playerPercent = (pPlayer.getViewXRot(0) + 90) / 180f;

                        if (Math.abs(moonPercent - playerPercent) < 0.022 && !isEast) {
                            flag = true;
                        }
                    }

                    if (flag) {
                        pPlayer.startUsingItem(pUsedHand);
                        return InteractionResultHolder.consume(stack);
                    }
                }
            }
        }

        return InteractionResultHolder.fail(stack);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        int time = getUseDuration(pStack) - pRemainingUseDuration;
        if (time == 0) {
            pLevel.playLocalSound(pLivingEntity.getOnPos(), SoundRegistry.MAYUMI_MOON_1.get(), SoundSource.PLAYERS, 1.0f, 1.0f, false);
        }
        if (time == 300) {
            pLevel.playLocalSound(pLivingEntity.getOnPos(), SoundRegistry.MAYUMI_MOON_2.get(), SoundSource.PLAYERS, 1.0f, 1.0f, false);
        }
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 540;
    }

    @Override
    public void onStopUsing(ItemStack stack, LivingEntity entity, int count) {
        if (!entity.level().isClientSide) {
            List<ServerPlayer> players = entity.level().getEntitiesOfClass(ServerPlayer.class, entity.getBoundingBox().inflate(30, 30, 30));
            int time = getUseDuration(stack) - count;
            ClientboundStopSoundPacket clientboundstopsoundpacket;
            if (time < 300) {
                clientboundstopsoundpacket = new ClientboundStopSoundPacket(SoundRegistry.MAYUMI_MOON_1.get().getLocation(), SoundSource.PLAYERS);
            } else {
                clientboundstopsoundpacket = new ClientboundStopSoundPacket(SoundRegistry.MAYUMI_MOON_2.get().getLocation(), SoundSource.PLAYERS);
            }
            players.forEach(player -> player.connection.send(clientboundstopsoundpacket));
        }
    }
}
