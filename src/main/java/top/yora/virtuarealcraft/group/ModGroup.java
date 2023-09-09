package top.yora.virtuarealcraft.group;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;
import top.yora.virtuarealcraft.init.ItemRegistry;

import java.util.ArrayList;
import java.util.List;

public class ModGroup {
    private static final List<RegistryObject<Item>> HIDDEN = new ArrayList<>();

    static {
        HIDDEN.add(ItemRegistry.VRC_LOGO);
        HIDDEN.add(ItemRegistry.GORGEOUS_BLOOM);
    }

    public static CreativeModeTab VRC_TAB = CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.VirtuaRealCraft Items"))
            .icon(() -> new ItemStack(ItemRegistry.VRC_LOGO.get()))
            .displayItems((param, output) -> ItemRegistry.ITEMS.getEntries().forEach((registryObject) -> {
                if (!HIDDEN.contains(registryObject)) {
                    output.accept(registryObject.get());
                }
            }))
            .build();
}
