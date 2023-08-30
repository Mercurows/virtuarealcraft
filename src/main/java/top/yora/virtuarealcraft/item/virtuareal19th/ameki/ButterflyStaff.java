package top.yora.virtuarealcraft.item.virtuareal19th.ameki;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.entity.RainCrystalEntity;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class ButterflyStaff extends SwordItem {
    public ButterflyStaff() {
        super(Tiers.IRON, 3, -2.0f, new Properties().durability(261));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add(Component.translatable("des.virtuarealcraft.butterfly_staff").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));

        TooltipTool.addLiverInfo(tooltip, Livers.AMEKI);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        int tick = this.getUseDuration(pStack) - pRemainingUseDuration;
        if(tick % 10 == 0){
            if(pLivingEntity instanceof Player player){
                for(int i=0;i<8;i++){
                    if(!pLevel.isClientSide) {
                        RainCrystalEntity rainCrystal = new RainCrystalEntity(pLevel, player);
                        //TODO 修改为正确的发射方向
                        rainCrystal.shootFromRotation(player, player.getXRot() + i * 45.0f, 90.0f, 0.0f, 3f, 0.0f);
                        pLevel.addFreshEntity(rainCrystal);
                    }
                }
            }

        }
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }
}
