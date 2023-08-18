package top.yora.virtuarealcraft.item.virtuareal5th.hoshimi;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
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
            .effect(() -> new EffectInstance(Effects.LEVITATION, 60, 0), 1.0f).build();

    public RedSunflowerSeeds() {
        super(new Properties().group(ModGroup.itemgroup).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.red_sunflower_seeds").mergeStyle(TextFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.HOSHIMI);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityLiving;

            if (worldIn.isRemote) {
                worldIn.playSound(player, player.getPosition(), SoundRegistry.HOSHIMI_MUA.get(), SoundCategory.AMBIENT, 2.0f, 1.0f);
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
