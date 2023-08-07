package top.yora.virtuarealcraft.item.virtuareal4th.nyatsuki;

import net.minecraft.block.*;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraft.block.CauldronBlock.LEVEL;

public class TorrentGem extends Item {
    public TorrentGem() {
        super(new Properties().group(ModGroup.itemgroup).maxDamage(99).rarity(Rarity.RARE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.torrent_gem").mergeStyle(TextFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.NYATSUKI);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.DIAMOND;
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(!worldIn.isRemote && entityIn instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityIn;
            if(isSelected){
                player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 40, 0, false, false));
            }

            if(player.ticksExisted % 20 == 0 && worldIn.isRaining()) {
                stack.damageItem(-1, player, player1 -> player1.sendBreakAnimation(player1.getActiveHand()));
            }
        }

        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) attacker;

            if(target instanceof EndermanEntity || target instanceof BlazeEntity || target instanceof SnowGolemEntity
            || target instanceof StriderEntity) {
                target.attackEntityFrom(DamageSource.causePlayerDamage(player), 100.0f);
            }
        }
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getItem();
        Hand hand = context.getHand();

        if(!world.isRemote && player != null){
            BlockState state = world.getBlockState(pos);
            FluidState fluidState = world.getFluidState(pos.add(0,1,0));

            if(fluidState.getBlockState().getBlock() instanceof FlowingFluidBlock){
                world.setBlockState(pos.add(0,1,0), Blocks.OBSIDIAN.getDefaultState(), 3);
                stack.damageItem(1, player, p -> p.sendBreakAnimation(hand));

                return ActionResultType.SUCCESS;
            }

            //这段没有Codeium我就死了
            if(state.getBlock() instanceof ConcretePowderBlock){
                if(state.getBlock() == Blocks.WHITE_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.WHITE_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.ORANGE_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.ORANGE_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.MAGENTA_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.MAGENTA_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.LIGHT_BLUE_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.LIGHT_BLUE_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.YELLOW_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.YELLOW_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.LIME_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.LIME_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.PINK_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.PINK_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.GRAY_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.GRAY_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.LIGHT_GRAY_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.LIGHT_GRAY_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.CYAN_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.CYAN_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.PURPLE_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.PURPLE_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.BLUE_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.BLUE_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.BROWN_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.BROWN_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.GREEN_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.GREEN_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.RED_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.RED_CONCRETE.getDefaultState());
                }else if(state.getBlock() == Blocks.BLACK_CONCRETE_POWDER){
                    world.setBlockState(pos, Blocks.BLACK_CONCRETE.getDefaultState());
                }

                stack.damageItem(1, player, p -> p.sendBreakAnimation(hand));

                return ActionResultType.SUCCESS;
            }else if(state.getBlock() instanceof CauldronBlock){
                if(world.getBlockState(pos).get(LEVEL) == 3){
                    return ActionResultType.FAIL;
                }

                world.setBlockState(pos, state.with(LEVEL, 3), 2);
                stack.damageItem(1, player, p -> p.sendBreakAnimation(hand));

                return ActionResultType.SUCCESS;
            }
        }
        return super.onItemUse(context);
    }
}
