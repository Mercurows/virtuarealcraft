package top.yora.virtuarealcraft.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.init.DamageSourceRegistry;
import top.yora.virtuarealcraft.init.EffectRegistry;
import top.yora.virtuarealcraft.network.VrcNetwork;
import top.yora.virtuarealcraft.network.packet.CurseFlamePacket;
import top.yora.virtuarealcraft.tool.Livers;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CurseFlame extends MobEffect {
    public CurseFlame() {
        super(MobEffectCategory.HARMFUL, 0xB1C1F2);
        addAttributeModifier(Attributes.ARMOR, new UUID(Livers.MICHIYA.hashCode(), 0).toString(), -1, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity.isAlive()) {
            int flameTime = pLivingEntity.getPersistentData().getInt("CurseFlame");

            int level = pAmplifier + 1;
            float rate = (10f / (float) level) * 20f;
            float damage = 1.0f + Math.min(5.0f * level, ((float) flameTime / rate));

            pLivingEntity.hurt(DamageSourceRegistry.causeCurseFlameDamage(pLivingEntity.level().registryAccess(), null), damage);
            pLivingEntity.invulnerableTime = 0;
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return pDuration % 15 == 0;
    }

    @SubscribeEvent
    public static void onCurseFlame(TickEvent.LevelTickEvent event) {
        Level level = event.level;

        if (level == null) {
            return;
        }

        if (event.phase == TickEvent.Phase.END && level instanceof ServerLevel serverLevel) {
            serverLevel.getAllEntities().forEach(entity -> {
                if (entity instanceof LivingEntity living) {
                    if (living instanceof Player player && player.isSpectator()) {
                        living.getPersistentData().putInt("CurseFlame", 0);
                    }

                    int flameTime = living.getPersistentData().getInt("CurseFlame");
                    if (!living.hasEffect(EffectRegistry.CURSE_FLAME.get())) {
                        living.getPersistentData().putInt("CurseFlame", 0);
                    } else {
                        living.getPersistentData().putInt("CurseFlame", ++flameTime);
                    }

                    VrcNetwork.CHANNEL.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), new CurseFlamePacket(entity.getId(), flameTime));
                }
            });
        }
    }
}
