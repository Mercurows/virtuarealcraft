package top.yora.virtuarealcraft.item.virtuareal14th.koxia;

import net.minecraft.item.UseAction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.ActionResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.entity.KuyaEntity;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class Kuya extends Item {
    public Kuya(){
        super(new Properties().group(ModGroup.itemgroup).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add((new TranslationTextComponent("des.virtuarealcraft.kuya_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.virtuarealcraft.kuya_2")).mergeStyle(TextFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.KOXIA);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);
        playerIn.setActiveHand(handIn);
        return ActionResult.resultConsume(stack);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
        if (!worldIn.isClientSide) {
            if (entityLiving instanceof Player) {
                Player player = (Player) entityLiving;

                KuyaEntity kuyaEntity = new KuyaEntity(worldIn, player);
                int usingTime = this.getUseDuration(stack) - timeLeft;

                float power = Math.min(usingTime / 30.0f, 3.5f);

                kuyaEntity.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0f, power, 0.0f);
                worldIn.addFreshEntity(kuyaEntity);

                if(!player.isCreative()) {
                    stack.shrink(1);
                }

                player.getCooldowns().addCooldown(stack.getItem(), 100);
            }
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 1000;
    }
}
