package top.yora.virtuarealcraft.item.virtuareal11th.imi;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
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
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MagicFeather extends Item {
    public MagicFeather() {
        super(new Properties().group(ModGroup.itemgroup).maxDamage(126));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.magic_feather_1").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.magic_feather_2").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.IMI);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.LAPIS_LAZULI;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        ItemStack offItem = playerIn.getHeldItem(Hand.OFF_HAND);

        if(!worldIn.isRemote && handIn == Hand.MAIN_HAND){
            if(offItem.getItem() == Items.ENCHANTED_BOOK) {
                if (playerIn.isSneaking()) {
                    AtomicInteger sum = new AtomicInteger();

                    Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(offItem);
                    map.forEach(((enchantment, integer) -> {
                        if (enchantment.isCurse()) {
                            sum.addAndGet(0);
                        }else if (enchantment.isTreasureEnchantment()) {
                            sum.addAndGet(enchantment.getMaxEnchantability(integer) + 50);
                        } else {
                            sum.addAndGet(enchantment.getMaxEnchantability(integer));
                        }
                    }));

                    int l = sum.get();
                    while(l > 0) {
                        int i1 = ExperienceOrbEntity.getXPSplit(l);
                        l -= i1;
                        worldIn.addEntity(new ExperienceOrbEntity(worldIn, playerIn.getPosX(), playerIn.getPosY() + 0.5D, playerIn.getPosZ(), i1));
                    }

                    playerIn.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(Items.BOOK));
                    stack.damageItem(1, playerIn, player -> player.sendBreakAnimation(handIn));

                    return new ActionResult<>(ActionResultType.SUCCESS, stack);
                }else {
                    Map<Enchantment, Integer> curseMap = EnchantmentHelper.getEnchantments(offItem).entrySet().stream().filter((enchant) -> enchant.getKey().isCurse()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                    if(curseMap.size() == 0){
                        return new ActionResult<>(ActionResultType.FAIL, stack);
                    }
                    if(playerIn.experienceLevel > curseMap.size()){
                        System.out.println(456);
                        Map<Enchantment, Integer> noCurseMap =  EnchantmentHelper.getEnchantments(offItem).entrySet().stream().filter((enchant) -> !enchant.getKey().isCurse()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                        ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);
                        EnchantmentHelper.setEnchantments(noCurseMap, enchantedBook);

                        playerIn.addExperienceLevel(-1 * curseMap.size());

                        playerIn.setItemStackToSlot(EquipmentSlotType.OFFHAND, enchantedBook);
                        stack.damageItem(1, playerIn, player -> player.sendBreakAnimation(handIn));

                        return new ActionResult<>(ActionResultType.SUCCESS, stack);
                    }
                }
            }
        }

        return new ActionResult<>(ActionResultType.FAIL, stack);
    }
}
