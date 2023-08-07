package top.yora.virtuarealcraft.item.virtuareal3rd.muri;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.ItemNBTTool;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class MuriDice extends Item {
    public MuriDice() {
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.muri_dice").mergeStyle(TextFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.MURI);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(entityIn instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityIn;
            ItemNBTTool.setInt(stack, "time", Math.min(60, ItemNBTTool.getInt(stack, "time", 0) + 1));

            if(ItemNBTTool.getInt(stack, "time", 0) >= 60){
                if(!worldIn.isRemote) {
                    int rand = (int)(Math.random() * 100 + 1);

                    player.sendStatusMessage(new StringTextComponent("1D100 = " + rand).mergeStyle(TextFormatting.BOLD), true);

                    if (rand > 50) {
                        player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, 0));
                        player.addPotionEffect(new EffectInstance(Effects.WITHER, 200, 0));
                        player.addPotionEffect(new EffectInstance(Effects.HUNGER, 200, 0));
                        player.addPotionEffect(new EffectInstance(Effects.UNLUCK, 200, 0));
                    }
                }else {
                    Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(ItemRegistry.MURI_DICE.get()));
                }

                stack.shrink(1);
            }
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}
