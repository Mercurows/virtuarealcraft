package top.yora.virtuarealcraft.item.virtuareal11th.chiyuu;

import net.minecraft.network.chat.Component;
import net.minecraft.util.ActionResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class GhostCloak extends Item {
    public GhostCloak() {
        super(new Properties().durability(21).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.ghost_cloak_1").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.ghost_cloak_2").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.CHIYUU);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);

        if (!worldIn.isClientSide) {
            playerIn.addPotionEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0, false, false));
            playerIn.addPotionEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1, false, false));
            playerIn.addPotionEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1, false, false));

            playerIn.getCooldowns().addCooldown(stack.getItem(), 400);

            stack.damageItem(1, playerIn, player -> player.sendBreakAnimation(handIn));
        }

        return ActionResult.func_233538_a_(stack, worldIn.isClientSide);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.LEATHER;
    }

}
