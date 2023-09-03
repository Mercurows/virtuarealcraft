package top.yora.virtuarealcraft.item.virtuareal1st.eine;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.models.BarrierHatModel;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class BarrierHat extends ArmorItem {
    public BarrierHat() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties().durability(202).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.virtuarealcraft.barrier_hat").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY).withItalic(true)));

        TooltipTool.addLiverInfo(tooltip, Livers.EINE);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                HumanoidModel<?> armorModel = new HumanoidModel<>(new ModelPart(Collections.emptyList(), Map.of(
                        "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "head", new BarrierHatModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(BarrierHatModel.LAYER_LOCATION)).main,
                        "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
                armorModel.crouching = livingEntity.isShiftKeyDown();
                armorModel.riding = original.riding;
                armorModel.young = livingEntity.isBaby();
                return armorModel;
            }
        });
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/barrier_hat.png";
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (player.isSteppingCarefully()) {
            if(!level.isClientSide){
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0));
            }

            AABB box = new AABB(player.getOnPos()).inflate(2);
            for (var entity : level.getEntitiesOfClass(Projectile.class, box)) {
                if (entity.getOwner() != player && !entity.getTags().contains(Utils.MOD_ID + "_bounce") && !entity.onGround()) {
                    entity.setDeltaMovement(entity.getDeltaMovement().multiply(-1, -1, -1));
                    entity.addTag(Utils.MOD_ID + "_bounce");

                    stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(EquipmentSlot.HEAD));
                }
            }
        }
    }
}
