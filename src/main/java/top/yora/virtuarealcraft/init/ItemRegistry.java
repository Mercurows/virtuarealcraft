package top.yora.virtuarealcraft.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.item.others.VrcLogo;
import top.yora.virtuarealcraft.item.virtuareal19th.ameki.ButterflyStaff;
import top.yora.virtuarealcraft.item.virtuareal2nd.nanami.IceCreamBlackTea;
import top.yora.virtuarealcraft.item.virtuareal3rd.muri.AdventBadge;
import top.yora.virtuarealcraft.item.virtuareal4th.nyatsuki.TorrentGem;
import top.yora.virtuarealcraft.item.virtuareal4th.waku.WeatherGem;
import top.yora.virtuarealcraft.item.virtuareal5th.hoshimi.GreenSunflowerSeeds;
import top.yora.virtuarealcraft.item.virtuareal5th.hoshimi.HamsterWheel;
import top.yora.virtuarealcraft.item.virtuareal5th.hoshimi.RedSunflowerSeeds;
import top.yora.virtuarealcraft.item.virtuareal6th.ReverseCard;
import top.yora.virtuarealcraft.item.virtuareal9th.chiharu.Magnifier;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    public static final RegistryObject<Item> VRC_LOGO = ITEMS.register("vrc_logo", VrcLogo::new);

    /**
     * 2nd
     */
    //nanami
    public static final RegistryObject<Item> ICE_CREAM_BLACK_TEA = ITEMS.register("ice_cream_black_tea", IceCreamBlackTea::new);


    /**
     * 3rd
     */
    //muri
    public static final RegistryObject<Item> ADVENT_BADGE = ITEMS.register("advent_badge", AdventBadge::new);



    /**
     * 4th
     */
    //nyatsuki
    public static final RegistryObject<Item> TORRENT_GEM = ITEMS.register("torrent_gem", TorrentGem::new);


    //waku
    public static final RegistryObject<Item> WEATHER_GEM = ITEMS.register("weather_gem", WeatherGem::new);



    /**
     * 5th
     */
    //miki


    //hoshimi
    public static final RegistryObject<Item> HAMSTER_WHEEL = ITEMS.register("hamster_wheel", HamsterWheel::new);
    public static final RegistryObject<Item> RED_SUNFLOWER_SEEDS = ITEMS.register("red_sunflower_seeds", RedSunflowerSeeds::new);
    public static final RegistryObject<Item> GREEN_SUNFLOWER_SEEDS = ITEMS.register("green_sunflower_seeds", GreenSunflowerSeeds::new);


    /**
     * 6th
     */
    //aza


    //yagi


    //tabibito
    public static final RegistryObject<Item> REVERSE_CARD = ITEMS.register("reverse_card", ReverseCard::new);


    //roi




    /**
     * 9th
     */
    //chiharu
    public static final RegistryObject<Item> MAGNIFIER = ITEMS.register("magnifier", Magnifier::new);


    /**
     * 19th
     */
    //ameki
    public static final RegistryObject<Item> BUTTERFLY_STAFF = ITEMS.register("butterfly_staff", ButterflyStaff::new);





}
