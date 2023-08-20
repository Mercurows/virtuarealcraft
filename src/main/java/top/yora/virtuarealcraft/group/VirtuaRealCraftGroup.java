package top.yora.virtuarealcraft.group;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import top.yora.virtuarealcraft.init.ItemRegistry;

import javax.annotation.Nonnull;

public class VirtuaRealCraftGroup extends CreativeModeTab {
    public VirtuaRealCraftGroup() {
        super(CreativeModeTab.builder()
                .title(Component.literal("VirtuaRealCraft Items"))
        );
    }

    @Override
    @Nonnull
    public ItemStack getIconItem() {
        return new ItemStack(ItemRegistry.VRC_LOGO.get());
    }
}
