package top.yora.virtuarealcraft.item.virtuareal5th.miki;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.yora.virtuarealcraft.init.ItemRegistry;

public class Mi extends Item {
    public Mi() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mi = pPlayer.getItemInHand(pUsedHand);
        if(!pLevel.isClientSide){
            ItemStack stack = pPlayer.getItemBySlot(EquipmentSlot.LEGS);
            if(stack.getItem() == ItemRegistry.MIKI_TAIL.get()){
                pPlayer.heal(1.0f);
                mi.shrink(1);
            }else {
                pPlayer.addItem(new ItemStack(ItemRegistry.MI.get()));
            }
            pPlayer.getCooldowns().addCooldown(mi.getItem(), 20);
            return InteractionResultHolder.success(mi);
        }
        return InteractionResultHolder.fail(mi);
    }
}
