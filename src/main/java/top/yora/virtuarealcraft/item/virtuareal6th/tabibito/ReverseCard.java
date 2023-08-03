package top.yora.virtuarealcraft.item.virtuareal6th.tabibito;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
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

public class ReverseCard extends SwordItem {
    public ReverseCard() {
        super(ItemTier.WOOD, 1, -1.0f, new Properties().maxDamage(610).setNoRepair().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.reverse_card.func").mergeStyle(TextFormatting.AQUA));
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.reverse_card").mergeStyle(TextFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.TABIBITO);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote){
            playerIn.setHealth(1.0f);
            playerIn.getCooldownTracker().setCooldown(stack.getItem(), 100);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) attacker;
            if(player.getHealth() <= 1.0f){
                target.attackEntityFrom(DamageSource.causePlayerDamage(player), 100.0f);
            }
        }
        return super.hitEntity(stack, target, attacker);
    }
}
