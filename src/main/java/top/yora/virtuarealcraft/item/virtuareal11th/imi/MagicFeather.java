package top.yora.virtuarealcraft.item.virtuareal11th.imi;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import top.yora.virtuarealcraft.init.GroupRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MagicFeather extends Item {
    public MagicFeather() {
        super(new Properties().group(GroupRegistry.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.magic_feather_1").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltip.add(Component.translatable("des.virtuarealcraft.magic_feather_2").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)).setStyle(Style.EMPTY.withColor(ChatFormatting.ITALIC)));

        TooltipTool.addLiverInfo(tooltip, Livers.IMI);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);
        ItemStack offItem = playerIn.getItemInHand(InteractionHand.OFF_HAND);

        if (!worldIn.isClientSide && handIn == InteractionHand.MAIN_HAND) {
            if (offItem.getItem() == Items.ENCHANTED_BOOK) {
                if (playerIn.isShiftKeyDown()) {
                    AtomicInteger sum = new AtomicInteger();

                    Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(offItem);
                    map.forEach(((enchantment, integer) -> {
                        if (enchantment.isCurse()) {
                            sum.addAndGet(0);
                        } else if (enchantment.isTreasureOnly()) {
                            sum.addAndGet(enchantment.getMaxCost(integer) + 50);
                        } else {
                            sum.addAndGet(enchantment.getMaxCost(integer));
                        }
                    }));

                    int l = sum.get();
                    while (l > 0) {
                        int i1 = ExperienceOrb.getExperienceValue(l);
                        l -= i1;
                        worldIn.addFreshEntity(new ExperienceOrb(worldIn, playerIn.getX(), playerIn.getY() + 0.5D, playerIn.getZ(), i1));
                    }

                    playerIn.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.BOOK));
                    stack.shrink(1);

                    return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
                } else {
                    Map<Enchantment, Integer> curseMap = EnchantmentHelper.getEnchantments(offItem).entrySet().stream().filter((enchant) -> enchant.getKey().isCurse()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                    if (curseMap.isEmpty()) {
                        return new InteractionResultHolder<>(InteractionResult.FAIL, stack);
                    }
                    if (playerIn.experienceLevel > curseMap.size()) {
                        System.out.println(456);
                        Map<Enchantment, Integer> noCurseMap = EnchantmentHelper.getEnchantments(offItem).entrySet().stream().filter((enchant) -> !enchant.getKey().isCurse()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                        ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);
                        EnchantmentHelper.setEnchantments(noCurseMap, enchantedBook);

                        playerIn.giveExperienceLevels(-1 * curseMap.size());

                        playerIn.setItemSlot(EquipmentSlot.OFFHAND, enchantedBook);
                        stack.shrink(1);

                        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
                    }
                }
            }
        }

        return new InteractionResultHolder<>(InteractionResult.FAIL, stack);
    }
}
