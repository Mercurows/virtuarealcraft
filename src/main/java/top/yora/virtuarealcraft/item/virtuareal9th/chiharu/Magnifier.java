package top.yora.virtuarealcraft.item.virtuareal9th.chiharu;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class Magnifier extends SwordItem {
    public Magnifier() {
        super(Tiers.GOLD, 4, -3.0f, new Properties().durability(114));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.magnifier_1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("des.virtuarealcraft.magnifier_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.CHIHARU);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0));
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 4));

        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);

        if (!worldIn.isClientSide) {
            if (!playerIn.isShiftKeyDown()) {
                if (playerIn.isCreative() || playerIn.getFoodData().getFoodLevel() >= 4) {
                    if (!playerIn.isCreative()) {
                        playerIn.getFoodData().eat(-4, 0);
                    }

                    playerIn.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0));

                    playerIn.getCooldowns().addCooldown(stack.getItem(), 2400);
                    stack.hurtAndBreak(5, playerIn, (player -> player.broadcastBreakEvent(handIn)));
                    return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
                }
            }
        }

        return new InteractionResultHolder<>(InteractionResult.FAIL, stack);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack mag = context.getItemInHand();
        InteractionHand hand = context.getHand();

        if (!(world.getBlockState(pos).getBlock() instanceof AirBlock) && player != null) {
            if (player.isShiftKeyDown()) {
                if (player.isCreative() || player.getFoodData().getFoodLevel() >= 2) {
                    if (!player.isCreative()) {
                        player.getFoodData().eat(-2, 0);
                    }

                    if (!world.isClientSide) {
                        double rand = new Random().nextDouble();
                        ItemStack stack;
                        if (rand < .15) {
                            stack = new ItemStack(Items.DIAMOND);
                        } else if (rand < .25) {
                            stack = new ItemStack(Items.EMERALD);
                        } else if (rand < .3) {
                            stack = new ItemStack(Items.ANCIENT_DEBRIS);
                        } else {
                            stack = new ItemStack(Items.COAL);
                        }
                        ItemEntity entity = new ItemEntity(world, pos.getX(), pos.getY() + 0.5f, pos.getZ(), stack);
                        world.addFreshEntity(entity);


                        player.getCooldowns().addCooldown(mag.getItem(), 2400);
                        mag.hurtAndBreak(25, player, (player1 -> player1.broadcastBreakEvent(hand)));
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }

        return super.useOn(context);
    }
}
