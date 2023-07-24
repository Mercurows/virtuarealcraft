package top.yora.virtuarealcraft.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.item.others.VrcLogo;
import top.yora.virtuarealcraft.item.virtuareal2nd.nanami.IceCreamBlackTea;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    public static final RegistryObject<Item> VRC_LOGO = ITEMS.register("vrc_logo", VrcLogo::new);

    /**
     * 2nd
     */
    //nanami
    public static final RegistryObject<Item> ICE_CREAM_BLACK_TEA = ITEMS.register("ice_cream_black_tea", IceCreamBlackTea::new);
}
