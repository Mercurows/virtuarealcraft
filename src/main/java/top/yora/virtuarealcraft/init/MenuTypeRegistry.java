package top.yora.virtuarealcraft.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.gui.FutureBrewingStandMenu;

public class MenuTypeRegistry {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Utils.MOD_ID);

    public static final RegistryObject<MenuType<FutureBrewingStandMenu>> FUTURE_BREWING_STAND_MENU =
            MENU_TYPES.register("future_brewing_stand_menu",
                    () -> IForgeMenuType.create((windowId, inv, data) -> new FutureBrewingStandMenu(windowId, inv)));
}
