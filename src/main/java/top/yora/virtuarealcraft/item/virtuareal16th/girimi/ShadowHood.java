package top.yora.virtuarealcraft.item.virtuareal16th.girimi;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.models.ShadowHoodModel;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class ShadowHood extends ArmorItem {
    public ShadowHood() {
        super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Properties().maxDamage(147).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.virtuarealcraft.shadow_hood").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.GIRIMI);
    }

    @SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new ShadowHoodModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/shadow_hood.png";
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(!world.isRemote){
            if(!world.isDaytime() || !world.canSeeSky(player.getPosition())){
                player.addPotionEffect(new EffectInstance(Effects.SPEED, 40, 1, false, false));
                player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 40, 1, false, false));
                player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 40, 0, false, false));
                player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 300, 0, false, false));
                player.addPotionEffect(new EffectInstance(Effects.HASTE, 40, 1, false, false));
            }else {
                player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 40, 1, false, false));
                player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 40, 1, false, false));
                player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 300, 0, false, false));
                player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 40, 1, false, false));
                player.setFire(1);
            }
        }
    }
}
