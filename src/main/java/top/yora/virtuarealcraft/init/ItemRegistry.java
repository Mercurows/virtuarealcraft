package top.yora.virtuarealcraft.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.item.others.VrcLogo;
import top.yora.virtuarealcraft.item.virtuareal10th.shaun.AngelHalo;
import top.yora.virtuarealcraft.item.virtuareal10th.yua.FrozenBoots;
import top.yora.virtuarealcraft.item.virtuareal11th.chiyuu.GhostCloak;
import top.yora.virtuarealcraft.item.virtuareal11th.imi.MagicFeather;
import top.yora.virtuarealcraft.item.virtuareal11th.mari.BloodPearl;
import top.yora.virtuarealcraft.item.virtuareal13th.joi.OrangeGrenade;
import top.yora.virtuarealcraft.item.virtuareal14th.koxia.Kuya;
import top.yora.virtuarealcraft.item.virtuareal16th.girimi.ShadowHood;
import top.yora.virtuarealcraft.item.virtuareal16th.kiyuu.GameConsole;
import top.yora.virtuarealcraft.item.virtuareal17th.sui.SuimashedCookie;
import top.yora.virtuarealcraft.item.virtuareal19th.ameki.ButterflyStaff;
import top.yora.virtuarealcraft.item.virtuareal19th.ameki.RainyButterfly;
import top.yora.virtuarealcraft.item.virtuareal19th.michiya.EternalCandelabra;
import top.yora.virtuarealcraft.item.virtuareal2nd.nanami.IceCreamBlackTea;
import top.yora.virtuarealcraft.item.virtuareal2nd.nanami.SharkTail;
import top.yora.virtuarealcraft.item.virtuareal3rd.muri.AdventBadge;
import top.yora.virtuarealcraft.item.virtuareal3rd.muri.MuriDice;
import top.yora.virtuarealcraft.item.virtuareal4th.nyatsuki.TorrentGem;
import top.yora.virtuarealcraft.item.virtuareal4th.waku.WeatherGem;
import top.yora.virtuarealcraft.item.virtuareal5th.hoshimi.GreenSunflowerSeeds;
import top.yora.virtuarealcraft.item.virtuareal5th.hoshimi.HamsterWheel;
import top.yora.virtuarealcraft.item.virtuareal5th.hoshimi.RedSunflowerSeeds;
import top.yora.virtuarealcraft.item.virtuareal5th.mahiru.MahiruTail;
import top.yora.virtuarealcraft.item.virtuareal5th.miki.Mi;
import top.yora.virtuarealcraft.item.virtuareal5th.miki.MikiTail;
import top.yora.virtuarealcraft.item.virtuareal6th.tabibito.ReverseCard;
import top.yora.virtuarealcraft.item.virtuareal9th.chiharu.LittleSpringRoll;
import top.yora.virtuarealcraft.item.virtuareal9th.chiharu.Magnifier;

@SuppressWarnings("unused")
public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    public static final RegistryObject<Item> VRC_LOGO = ITEMS.register("vrc_logo", VrcLogo::new);

    /**
     * 2nd
     */
    //nanami
    public static final RegistryObject<Item> ICE_CREAM_BLACK_TEA = ITEMS.register("ice_cream_black_tea", IceCreamBlackTea::new);
    public static final RegistryObject<Item> SHARK_TAIL = ITEMS.register("shark_tail", SharkTail::new);


    /**
     * 3rd
     */
    //muri
    public static final RegistryObject<Item> ADVENT_BADGE = ITEMS.register("advent_badge", AdventBadge::new);
    public static final RegistryObject<Item> MURI_DICE = ITEMS.register("muri_dice", MuriDice::new);



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
    public static final RegistryObject<Item> MIKI_TAIL = ITEMS.register("miki_tail", MikiTail::new);
    public static final RegistryObject<Item> MI = ITEMS.register("mi", Mi::new);

    //hoshimi
    public static final RegistryObject<Item> HAMSTER_WHEEL = ITEMS.register("hamster_wheel", HamsterWheel::new);
    public static final RegistryObject<Item> RED_SUNFLOWER_SEEDS = ITEMS.register("red_sunflower_seeds", RedSunflowerSeeds::new);
    public static final RegistryObject<Item> GREEN_SUNFLOWER_SEEDS = ITEMS.register("green_sunflower_seeds", GreenSunflowerSeeds::new);

    //mahiru
    public static final RegistryObject<Item> MAHIRU_TAIL = ITEMS.register("mahiru_tail", MahiruTail::new);

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
    public static final RegistryObject<Item> LITTLE_SPRING_ROLL = ITEMS.register("little_spring_roll", LittleSpringRoll::new);


    /**
     * 10th
     */
    //shaun
    public static final RegistryObject<Item> ANGEL_HALO = ITEMS.register("angel_halo", AngelHalo::new);

    //yua
    public static final RegistryObject<Item> FROZEN_BOOTS = ITEMS.register("frozen_boots", FrozenBoots::new);


    /**
     * 11th
     */
    //imi
    public static final RegistryObject<Item> MAGIC_FEATHER = ITEMS.register("magic_feather", MagicFeather::new);

    //chiyuu
    public static final RegistryObject<Item> GHOST_CLOAK = ITEMS.register("ghost_cloak", GhostCloak::new);

    //mari
    public static final RegistryObject<Item> BLOOD_PEARL = ITEMS.register("blood_pearl", BloodPearl::new);


    /**
     * 13th
     */
    //joi
    public static final RegistryObject<Item> ORANGE_GRENADE = ITEMS.register("orange_grenade", OrangeGrenade::new);


    /**
     * 14th
     */
    //koxia
    public static final RegistryObject<Item> KUYA = ITEMS.register("kuya", Kuya::new);


    /**
     * 16th
     */
    //girimi
    public static final RegistryObject<Item> SHADOW_HOOD = ITEMS.register("shadow_hood", ShadowHood::new);

    //kiyuu
    public static final RegistryObject<Item> GAME_CONSOLE = ITEMS.register("game_console", GameConsole::new);


    /**
     * 17th
     */
    //sui
    public static final RegistryObject<Item> SUIMASHED_COOKIE = ITEMS.register("suimashed_cookie", SuimashedCookie::new);


    /**
     * 19th
     */
    //ameki
    public static final RegistryObject<Item> BUTTERFLY_STAFF = ITEMS.register("butterfly_staff", ButterflyStaff::new);
    public static final RegistryObject<Item> RAINY_BUTTERFLY = ITEMS.register("rainy_butterfly", RainyButterfly::new);

    //michiya
    public static final RegistryObject<Item> ETERNAL_CANDELABRA = ITEMS.register("eternal_candelabra", EternalCandelabra::new);



}
