package top.yora.virtuarealcraft.item.virtuareal9th.chiharu;

import net.minecraft.block.AirBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
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
import java.util.Random;

public class Magnifier extends SwordItem {
    public Magnifier() {
        super(ItemTier.GOLD, 4, -3.0f, new Properties().group(ModGroup.itemgroup).defaultMaxDamage(114));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.magnifier_1").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.magnifier_2").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.CHIHARU);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addPotionEffect(new EffectInstance(Effects.GLOWING, 100, 0));
        target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 4));

        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if(!worldIn.isRemote){
            if(!playerIn.isSneaking()){
                if(playerIn.abilities.isCreativeMode || playerIn.getFoodStats().getFoodLevel() >= 4) {
                    if(!playerIn.abilities.isCreativeMode) {
                        playerIn.getFoodStats().addStats(-4, 0);
                    }

                    playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 1200, 0));

                    playerIn.getCooldownTracker().setCooldown(stack.getItem(), 2400);
                    stack.damageItem(5, playerIn, (player -> player.sendBreakAnimation(handIn)));
                    return new ActionResult<>(ActionResultType.SUCCESS, stack);
                }
            }
        }
        return new ActionResult<>(ActionResultType.FAIL, stack);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        PlayerEntity player = context.getPlayer();
        ItemStack mag = context.getItem();
        Hand hand = context.getHand();

        if(!(world.getBlockState(pos).getBlock() instanceof AirBlock) && player != null){
            if(player.isSneaking()) {
                if(player.abilities.isCreativeMode || player.getFoodStats().getFoodLevel() >= 2) {
                    if(!player.abilities.isCreativeMode) {
                        player.getFoodStats().addStats(-2, 0);
                    }

                    if (!world.isRemote) {
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
                        world.addEntity(entity);


                        player.getCooldownTracker().setCooldown(mag.getItem(), 2400);
                        mag.damageItem(25, player, (player1 -> player1.sendBreakAnimation(hand)));
                    }
                    return ActionResultType.SUCCESS;
                }
            }
        }
        return super.onItemUse(context);
    }
}
