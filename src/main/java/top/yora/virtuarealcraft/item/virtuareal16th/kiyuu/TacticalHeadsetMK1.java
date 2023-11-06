package top.yora.virtuarealcraft.item.virtuareal16th.kiyuu;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
import top.yora.virtuarealcraft.gui.RectangleHUD;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

// TODO 物品材质贴图+模型
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

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        // TODO 补充物品描述
        TooltipTool.addLiverInfo(tooltip, Livers.KIYUU);
    }

}
