package top.yora.virtuarealcraft.item.virtuareal5th.hoshimi;

import net.minecraft.ChatFormatting;
import net.minecraft.item.Food;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.init.SoundRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class RedSunflowerSeeds extends Item {
    private static final Food food = new Food.Builder().setAlwaysEdible().hunger(1).saturation(0.2f).fastToEat()
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 60, 0), 1.0f).build();

    public RedSunflowerSeeds() {
        super(new Properties().group(ModGroup.itemgroup).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.red_sunflower_seeds").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.HOSHIMI);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        if (entityLiving instanceof Player) {
            Player player = (Player) entityLiving;

            if (worldIn.isClientSide) {
                worldIn.playSound(player, player.getPosition(), SoundRegistry.HOSHIMI_MUA.get(), SoundCategory.AMBIENT, 2.0f, 1.0f);
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
