package top.yora.virtuarealcraft.item.virtuareal12th.mayumi;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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
    // TODO 实现视线方块检测
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        InteractionHand left = pPlayer.getMainArm() == HumanoidArm.RIGHT ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;

        if(pUsedHand == left) {
            if (pLevel.isNight()) {
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

                // yrot correct
                if (isValid) {
                    float time = pLevel.getTimeOfDay(0);

                    if (time < 0.5f) {
                        // moon east
                        float moonPercent = time / 0.5f;
                        float playerPercent = (180 - (pPlayer.getViewXRot(0) + 90)) / 180f;

                        if (Math.abs(moonPercent - playerPercent) < 0.022 && isEast) {
                            pPlayer.sendSystemMessage(Component.literal("moon look east"));
                        }
                    } else {
                        // moon west
                        float moonPercent = (time - 0.5f) / 0.5f;
                        float playerPercent = (pPlayer.getViewXRot(0) + 90) / 180f;

                        if (Math.abs(moonPercent - playerPercent) < 0.022 && !isEast) {
                            pPlayer.sendSystemMessage(Component.literal("moon look west"));
                        }
                    }
                    return InteractionResultHolder.success(stack);
                }
            }
        }
        return InteractionResultHolder.fail(stack);
    }
}
