package top.yora.virtuarealcraft.item.virtuareal2nd.kouichi;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.init.ItemRegistry;
import top.yora.virtuarealcraft.models.BloodWingsModel;
import top.yora.virtuarealcraft.network.VrcNetwork;
import top.yora.virtuarealcraft.network.packet.BloodWingPacket;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BloodWings extends ArmorItem {
    public BloodWings() {
        super(ArmorMaterials.IRON, Type.CHESTPLATE, new Properties().rarity(Rarity.UNCOMMON).durability(410));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add(Component.translatable("des.virtuarealcraft.blood_wings").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.KOUICHI);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                HumanoidModel<?> armorModel = new HumanoidModel<>(new ModelPart(Collections.emptyList(), Map.of(
                        "body", new BloodWingsModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(BloodWingsModel.LAYER_LOCATION)).main,
                        "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
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
        return Utils.MOD_ID + ":textures/models/armor/blood_wings.png";
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void leftClick(PlayerInteractEvent.LeftClickEmpty event) {
        if (!event.getItemStack().isEmpty()) {
            return;
        }

        Player player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }

        if (!player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(ItemRegistry.BLOOD_WINGS.get()) || player.getCooldowns().isOnCooldown(ItemRegistry.BLOOD_WINGS.get())) {
            return;
        }

        VrcNetwork.CHANNEL.sendToServer(new BloodWingPacket(true));
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void rightClick(PlayerInteractEvent.RightClickEmpty event) {
        if (!event.getItemStack().isEmpty()) {
            return;
        }

        Player player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }

        if (!player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(ItemRegistry.BLOOD_WINGS.get()) || player.getCooldowns().isOnCooldown(ItemRegistry.BLOOD_WINGS.get())) {
            return;
        }

        if (!player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty() || !player.getItemInHand(InteractionHand.OFF_HAND).isEmpty()) {
            return;
        }

        VrcNetwork.CHANNEL.sendToServer(new BloodWingPacket(false));

        Level level = player.level();

        if (level.isClientSide) {
            player.playSound(SoundEvents.SCULK_SHRIEKER_SHRIEK, 0.8f, 1f);
        }
    }
}
