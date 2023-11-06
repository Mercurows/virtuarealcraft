package top.yora.virtuarealcraft.item.virtuareal16th.kiyuu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.gui.RectangleHUD;
import top.yora.virtuarealcraft.models.TacticalHeadsetMK1Model;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class TacticalHeadsetMK1 extends ArmorItem {

    public TacticalHeadsetMK1() {
        super(ArmorMaterials.IRON, Type.HELMET, new Properties().durability(166));
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!player.getCooldowns().isOnCooldown(stack.getItem()) && player.isSteppingCarefully()) {
            if (level.isClientSide) {
                RectangleHUD.lastActiveTime = System.currentTimeMillis();
            } else {
                var startPos = player.position().add(-30, -30, -30);
                var endPos = player.position().add(30, 30, 30);
                var box = new AABB(startPos, endPos);

                var entities = level.getEntitiesOfClass(LivingEntity.class, box);
                entities.forEach(e -> {
                    if (e.getStringUUID().equals(player.getStringUUID())) return;
                    e.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 1));
                });

                player.getCooldowns().addCooldown(stack.getItem(), 600);
            }
        }
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
                        "head", new TacticalHeadsetMK1Model<>(Minecraft.getInstance().getEntityModels().bakeLayer(TacticalHeadsetMK1Model.LAYER_LOCATION)).main,
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
        return Utils.MOD_ID + ":textures/models/armor/tactical_headset_mk1.png";
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        // TODO 补充物品描述
        TooltipTool.addLiverInfo(tooltip, Livers.KIYUU);
    }

}
