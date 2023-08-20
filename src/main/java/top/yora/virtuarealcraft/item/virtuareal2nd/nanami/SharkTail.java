package top.yora.virtuarealcraft.item.virtuareal2nd.nanami;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.group.ModGroup;
import top.yora.virtuarealcraft.models.SharkTailModel;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class SharkTail extends ArmorItem {
    public SharkTail() {
        super(ArmorMaterials.IRON, EquipmentSlot.LEGS, new Properties().group(ModGroup.itemgroup).rarity(Rarity.UNCOMMON).durability(517));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.shark_tail").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.NANAMI);
    }

    @SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, A _default) {
        return (A) new SharkTailModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/shark_tail.png";
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide) {
            if(player.isInWater()){
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 40, 0, false, false));
            }
        }
    }
}
