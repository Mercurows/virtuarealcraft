package top.yora.virtuarealcraft.item.virtuareal6th.tabibito;

import net.minecraft.ChatFormatting;
import net.minecraft.item.ItemTier;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class ReverseCard extends SwordItem {
    public ReverseCard() {
        super(ItemTier.WOOD, 1, -1.0f, new Properties().durability(610).setNoRepair().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.reverse_card.func").setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA)));
        tooltip.add(Component.translatable("des.virtuarealcraft.reverse_card").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.TABIBITO);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);
        if (!worldIn.isClientSide) {
            playerIn.setHealth(1.0f);
            playerIn.getCooldowns().addCooldown(stack.getItem(), 100);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player) {
            Player player = (Player) attacker;
            if(player.getHealth() <= 1.0f){
                target.attackEntityFrom(DamageSource.causePlayerDamage(player), 100.0f);
            }
        }
        return super.hitEntity(stack, target, attacker);
    }
}
