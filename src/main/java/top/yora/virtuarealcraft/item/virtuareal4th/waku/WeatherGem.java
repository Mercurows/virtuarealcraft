package top.yora.virtuarealcraft.item.virtuareal4th.waku;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class WeatherGem extends Item {
    public WeatherGem() {
        super(new Properties().group(ModGroup.itemgroup).maxDamage(10).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.weather_gem.func").mergeStyle(TextFormatting.AQUA));
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.weather_gem").mergeStyle(TextFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.WAKU);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.HONEYCOMB;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        boolean flag = false;

        ItemStack itemStack = playerIn.getHeldItem(handIn);
        if(handIn == Hand.MAIN_HAND){
            if(!worldIn.isRemote) {
                ItemStack off = playerIn.getHeldItemOffhand();
                if (off.isEmpty()) {
                    return new ActionResult<>(ActionResultType.FAIL, itemStack);
                } else {
                    if (off.getItem() == Items.TORCH) {
                        off.shrink(1);

                        ((ServerWorld) worldIn).func_241113_a_(12000, 0, false, false);
                        itemStack.damageItem(1, playerIn, p -> p.sendBreakAnimation(handIn));
                        playerIn.getCooldownTracker().setCooldown(itemStack.getItem(), 6000);

                        flag = true;
                    } else if (off.getItem() == Items.WHEAT_SEEDS) {
                        off.shrink(1);

                        ((ServerWorld) worldIn).func_241113_a_(0, 12000, true, false);
                        itemStack.damageItem(1, playerIn, p -> p.sendBreakAnimation(handIn));
                        playerIn.getCooldownTracker().setCooldown(itemStack.getItem(), 6000);

                        flag = true;
                    } else if (off.getItem() == Items.GUNPOWDER) {
                        off.shrink(1);

                        ((ServerWorld) worldIn).func_241113_a_(0, 12000, true, true);
                        itemStack.damageItem(1, playerIn, p -> p.sendBreakAnimation(handIn));
                        playerIn.getCooldownTracker().setCooldown(itemStack.getItem(), 6000);

                        flag = true;
                    }

                    if(flag){
                        return new ActionResult<>(ActionResultType.SUCCESS, itemStack);
                    }
                }
            }

            if(worldIn.isRemote) {
                ItemStack off = playerIn.getHeldItemOffhand();
                if (off.getItem() == Items.TORCH || off.getItem() == Items.WHEAT_SEEDS || off.getItem() == Items.GUNPOWDER) {
                    flag = true;
                }

                if(flag) {
                    Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(ItemRegistry.WEATHER_GEM.get()));
                }
            }

        }

        return new ActionResult<>(ActionResultType.FAIL, itemStack);
    }
}
