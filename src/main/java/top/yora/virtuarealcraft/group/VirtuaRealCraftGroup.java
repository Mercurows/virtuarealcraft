package top.yora.virtuarealcraft.group;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import top.yora.virtuarealcraft.init.ItemRegistry;

import javax.annotation.Nonnull;

public class VirtuaRealCraftGroup extends ItemGroup {
    public VirtuaRealCraftGroup() {
        super("VirtuaRealCraft Items");
    }

    @Override
    @Nonnull
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.VRC_LOGO.get());
    }
}
