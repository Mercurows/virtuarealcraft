package top.yora.virtuarealcraft.group;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import top.yora.virtuarealcraft.init.ItemRegistry;

public class VirtuaRealCraftGroup extends CreativeModeTab {
    public VirtuaRealCraftGroup() {
        super(CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.VirtuaRealCraft Items"))
                .icon(() -> new ItemStack(ItemRegistry.VRC_LOGO.get()))
                .displayItems((param, output) ->
                        ItemRegistry.ITEMS.getEntries().forEach((registryObject) -> {
                            if(registryObject != ItemRegistry.VRC_LOGO) {
                                output.accept(registryObject.get());
                            }
                        }))
        );
    }

}
