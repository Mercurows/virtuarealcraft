package top.yora.virtuarealcraft.item.virtuareal2nd.nanami;

import net.minecraft.ChatFormatting;
import net.minecraft.item.Food;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import top.yora.virtuarealcraft.init.GroupRegistry;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class IceCreamBlackTea extends Item {
    private static final Food food = new Food.Builder().setAlwaysEdible().hunger(6).saturation(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1000, 0), 1.0f).build();

    public IceCreamBlackTea() {
        super(new Properties().group(GroupRegistry.itemgroup).food(food).maxStackSize(1));
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.ice_cream_black_tea").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.NANAMI);
    }

    @Override
    public @NotNull SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.DRINK;
    }
}
