package top.yora.virtuarealcraft.item.virtuareal11th.chiyuu;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
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

public class GhostCloak extends Item {
    public GhostCloak() {
        super(new Properties().maxDamage(21).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.ghost_cloak_1").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.ghost_cloak_2").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.CHIYUU);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if(!worldIn.isRemote){
            playerIn.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 200, 0, false, false));
            playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, 1, false, false));
            playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 200, 1, false, false));

            playerIn.getCooldownTracker().setCooldown(stack.getItem(), 400);

            stack.damageItem(1, playerIn, player -> player.sendBreakAnimation(handIn));
        }

        return ActionResult.func_233538_a_(stack, worldIn.isRemote);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.LEATHER;
    }

}
