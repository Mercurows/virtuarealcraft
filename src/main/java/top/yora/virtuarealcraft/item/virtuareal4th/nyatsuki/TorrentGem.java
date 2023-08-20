package top.yora.virtuarealcraft.item.virtuareal4th.nyatsuki;

import net.minecraft.ChatFormatting;
import net.minecraft.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CauldronBlock;
import net.minecraft.world.level.block.ConcretePowderBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import top.yora.virtuarealcraft.init.GroupRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraft.block.CauldronBlock.LEVEL;

public class TorrentGem extends Item {
    public TorrentGem() {
        super(new Properties().group(GroupRegistry.itemgroup).durability(99).rarity(Rarity.RARE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.torrent_gem").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.NYATSUKI);
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.DIAMOND;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isClientSide && entityIn instanceof Player player) {
            if (isSelected) {
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, false, false));
            }

            if (player.tickCount % 20 == 0 && worldIn.isRaining()) {
                stack.damageItem(-1, player, player1 -> player1.sendBreakAnimation(player1.getActiveHand()));
            }
        }

        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player) {
            Player player = (Player) attacker;

            if (target instanceof EnderMan || target instanceof Blaze || target instanceof SnowGolem
                    || target instanceof Strider) {
                target.attackEntityFrom(DamageSource.causePlayerDamage(player), 100.0f);
            }
        }
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        InteractionHand hand = context.getHand();

        if (!world.isClientSide && player != null) {
            BlockState state = world.getBlockState(pos);
            FluidState fluidState = world.getFluidState(pos.offset(0, 1, 0));

            if (fluidState.getBlockState().getBlock() instanceof FlowingFluid) {
                world.setBlockState(pos.add(0, 1, 0), Blocks.OBSIDIAN.defaultBlockState(), 3);
                stack.damageItem(1, player, p -> p.sendBreakAnimation(hand));

                return InteractionResult.SUCCESS;
            }

            //这段没有Codeium我就死了
            if (state.getBlock() instanceof ConcretePowderBlock) {
                if (state.getBlock() == Blocks.WHITE_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.WHITE_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.ORANGE_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.ORANGE_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.MAGENTA_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.MAGENTA_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.LIGHT_BLUE_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.LIGHT_BLUE_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.YELLOW_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.YELLOW_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.LIME_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.LIME_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.PINK_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.PINK_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.GRAY_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.GRAY_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.LIGHT_GRAY_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.LIGHT_GRAY_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.CYAN_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.CYAN_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.PURPLE_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.PURPLE_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.BLUE_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.BLUE_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.BROWN_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.BROWN_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.GREEN_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.GREEN_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.RED_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.RED_CONCRETE.defaultBlockState());
                } else if (state.getBlock() == Blocks.BLACK_CONCRETE_POWDER) {
                    world.setBlockAndUpdate(pos, Blocks.BLACK_CONCRETE.defaultBlockState());
                }

                stack.damageItem(1, player, p -> p.sendBreakAnimation(hand));

                return InteractionResult.SUCCESS;
            } else if (state.getBlock() instanceof CauldronBlock) {
                if (world.getBlockState(pos).get(LEVEL) == 3) {
                    return InteractionResult.FAIL;
                }

                world.setBlockState(pos, state.with(LEVEL, 3), 2);
                stack.damageItem(1, player, p -> p.sendBreakAnimation(hand));

                return InteractionResult.SUCCESS;
            }
        }
        return super.useOn(context);
    }
}
