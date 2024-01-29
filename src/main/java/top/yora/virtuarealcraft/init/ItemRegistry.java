package top.yora.virtuarealcraft.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.item.others.NightRainRing;
import top.yora.virtuarealcraft.item.others.TokimoriSeisand;
import top.yora.virtuarealcraft.item.others.VrcLogo;
import top.yora.virtuarealcraft.item.others.WorkaholicFury;
import top.yora.virtuarealcraft.item.virtuareal10th.shaun.AngelHalo;
import top.yora.virtuarealcraft.item.virtuareal10th.shaun.BakedSweetPotato;
import top.yora.virtuarealcraft.item.virtuareal10th.shaun.LittleSweetPotato;
import top.yora.virtuarealcraft.item.virtuareal10th.yua.FrozenBoots;
import top.yora.virtuarealcraft.item.virtuareal11th.chiyuu.GhostCloak;
import top.yora.virtuarealcraft.item.virtuareal11th.imi.MagicFeather;
import top.yora.virtuarealcraft.item.virtuareal11th.mari.BloodPearl;
import top.yora.virtuarealcraft.item.virtuareal12th.mayumi.MayumiLefthand;
import top.yora.virtuarealcraft.item.virtuareal13th.joi.OrangeGrenade;
import top.yora.virtuarealcraft.item.virtuareal13th.kiti.Cornucopia;
import top.yora.virtuarealcraft.item.virtuareal13th.qilou.GorgeousBloom;
import top.yora.virtuarealcraft.item.virtuareal13th.tocci.JokerMask;
import top.yora.virtuarealcraft.item.virtuareal14th.koxia.Kuya;
import top.yora.virtuarealcraft.item.virtuareal14th.rhea.WisdomWand;
import top.yora.virtuarealcraft.item.virtuareal16th.girimi.ShadowHood;
import top.yora.virtuarealcraft.item.virtuareal16th.karisa.TailFeatherSword;
import top.yora.virtuarealcraft.item.virtuareal16th.kiyuu.GameConsole;
import top.yora.virtuarealcraft.item.virtuareal16th.kiyuu.TacticalHeadsetMK1;
import top.yora.virtuarealcraft.item.virtuareal17th.sui.DebtReliefTicket;
import top.yora.virtuarealcraft.item.virtuareal17th.sui.SuiJokes;
import top.yora.virtuarealcraft.item.virtuareal17th.sui.SuimashedCookie;
import top.yora.virtuarealcraft.item.virtuareal19th.ameki.*;
import top.yora.virtuarealcraft.item.virtuareal19th.awu.AncientEssence;
import top.yora.virtuarealcraft.item.virtuareal19th.awu.ChengHuangCrystal;
import top.yora.virtuarealcraft.item.virtuareal19th.hatsuse.Nemumaru;
import top.yora.virtuarealcraft.item.virtuareal19th.hatsuse.PurityShard;
import top.yora.virtuarealcraft.item.virtuareal19th.michiya.CursedArtifact;
import top.yora.virtuarealcraft.item.virtuareal19th.michiya.EternalCandelabra;
import top.yora.virtuarealcraft.item.virtuareal19th.michiya.EternalTouch;
import top.yora.virtuarealcraft.item.virtuareal19th.michiya.MichiyamekiRing;
import top.yora.virtuarealcraft.item.virtuareal1st.eine.BarrierHat;
import top.yora.virtuarealcraft.item.virtuareal20th.kismet.ayumi.BaseballBat;
import top.yora.virtuarealcraft.item.virtuareal20th.kismet.mizuki.FutureBrewingStand;
import top.yora.virtuarealcraft.item.virtuareal20th.kismet.richi.FoxMirror;
import top.yora.virtuarealcraft.item.virtuareal21st.hihi.SunnyDoll;
import top.yora.virtuarealcraft.item.virtuareal21st.nagisa.PocketWatch;
import top.yora.virtuarealcraft.item.virtuareal21st.pako.KindnessBottle;
import top.yora.virtuarealcraft.item.virtuareal21st.yukisyo.BurningMirror;
import top.yora.virtuarealcraft.item.virtuareal2nd.ichigo.OrangeAhoge;
import top.yora.virtuarealcraft.item.virtuareal2nd.kouichi.BloodWings;
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
import top.yora.virtuarealcraft.item.virtuareal6th.aza.CharmingBrooch;
import top.yora.virtuarealcraft.item.virtuareal6th.roi.RoyalHalo;
import top.yora.virtuarealcraft.item.virtuareal6th.tabibito.ReverseCard;
import top.yora.virtuarealcraft.item.virtuareal7th.saya.SugarCaneCake;
import top.yora.virtuarealcraft.item.virtuareal7th.yukie.YukieDumplings;
import top.yora.virtuarealcraft.item.virtuareal9th.chiharu.LittleSpringRoll;
import top.yora.virtuarealcraft.item.virtuareal9th.chiharu.Magnifier;
import top.yora.virtuarealcraft.item.virtuareal9th.kiyora.RebelPeriod;

@SuppressWarnings("unused")
public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    public static final RegistryObject<Item> VRC_LOGO = ITEMS.register("vrc_logo", VrcLogo::new);

    /**
     * 1st
     */
    //eine
    public static final RegistryObject<Item> BARRIER_HAT = ITEMS.register("barrier_hat", BarrierHat::new);


    /**
     * 2nd
     */
    //nanami
    public static final RegistryObject<Item> ICE_CREAM_BLACK_TEA = ITEMS.register("ice_cream_black_tea", IceCreamBlackTea::new);
    public static final RegistryObject<Item> SHARK_TAIL = ITEMS.register("shark_tail", SharkTail::new);

    //ichigo
    public static final RegistryObject<Item> ORANGE_AHOGE = ITEMS.register("orange_ahoge", OrangeAhoge::new);

    //kouichi
    public static final RegistryObject<Item> BLOOD_WINGS = ITEMS.register("blood_wings", BloodWings::new);
    public static final RegistryObject<Item> KOUICHI_ZIPPER = ITEMS.register("kouichi_zipper", () -> new BlockItem(BlockRegistry.KOUICHI_ZIPPER.get(), new Item.Properties()));


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
    public static final RegistryObject<Item> CHARMING_BROOCH = ITEMS.register("charming_brooch", CharmingBrooch::new);

    //yagi


    //tabibito
    public static final RegistryObject<Item> REVERSE_CARD = ITEMS.register("reverse_card", ReverseCard::new);

    //roi
    public static final RegistryObject<Item> ROYAL_HALO = ITEMS.register("royal_halo", RoyalHalo::new);

    /**
     * 7th
     */
    //saya
    public static final RegistryObject<Item> SUGAR_CANE_CAKE = ITEMS.register("sugar_cane_cake", SugarCaneCake::new);

    //yukie
    public static final RegistryObject<Item> YUKIE_DUMPLINGS = ITEMS.register("yukie_dumplings", YukieDumplings::new);


    /**
     * 9th
     */
    //chiharu
    public static final RegistryObject<Item> MAGNIFIER = ITEMS.register("magnifier", Magnifier::new);
    public static final RegistryObject<Item> LITTLE_SPRING_ROLL = ITEMS.register("little_spring_roll", LittleSpringRoll::new);

    //kiyora
    public static final RegistryObject<Item> REBEL_PERIOD = ITEMS.register("rebel_period", RebelPeriod::new);


    /**
     * 10th
     */
    //shaun
    public static final RegistryObject<Item> ANGEL_HALO = ITEMS.register("angel_halo", AngelHalo::new);
    public static final RegistryObject<Item> LITTLE_SWEET_POTATO = ITEMS.register("little_sweet_potato", LittleSweetPotato::new);
    public static final RegistryObject<Item> BAKED_SWEET_POTATO = ITEMS.register("baked_sweet_potato", BakedSweetPotato::new);

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
     * 12th
     */
    //mayumi
    public static final RegistryObject<Item> MAYUMI_LEFTHAND = ITEMS.register("mayumi_lefthand", MayumiLefthand::new);


    /**
     * 13th
     */
    //tocci
    public static final RegistryObject<Item> JOKER_MASK = ITEMS.register("joker_mask", JokerMask::new);

    //joi
    public static final RegistryObject<Item> ORANGE_GRENADE = ITEMS.register("orange_grenade", OrangeGrenade::new);

    //kiti
    public static final RegistryObject<Item> CORNUCOPIA = ITEMS.register("cornucopia", Cornucopia::new);

    //qilou
    public static final RegistryObject<Item> GORGEOUS_BLOOM = ITEMS.register("gorgeous_bloom", GorgeousBloom::new);


    /**
     * 14th
     */
    //koxia
    public static final RegistryObject<Item> KUYA = ITEMS.register("kuya", Kuya::new);

    //rhea
    public static final RegistryObject<Item> WISDOM_WAND = ITEMS.register("wisdom_wand", WisdomWand::new);

    /**
     * 16th
     */
    //girimi
    public static final RegistryObject<Item> SHADOW_HOOD = ITEMS.register("shadow_hood", ShadowHood::new);

    //kiyuu
    public static final RegistryObject<Item> GAME_CONSOLE = ITEMS.register("game_console", GameConsole::new);
    public static final RegistryObject<Item> TACTICAL_HEADSET_MK1 = ITEMS.register("tactical_headset_mk1", TacticalHeadsetMK1::new);

    //karisa
    public static final RegistryObject<Item> TAIL_FEATHER_SWORD = ITEMS.register("tail_feather_sword", TailFeatherSword::new);

    /**
     * 17th
     */
    //sui
    public static final RegistryObject<Item> SUIMASHED_COOKIE = ITEMS.register("suimashed_cookie", SuimashedCookie::new);
    public static final RegistryObject<Item> DEBT_RELIEF_TICKET = ITEMS.register("debt_relief_ticket", DebtReliefTicket::new);
    public static final RegistryObject<Item> SUI_JOKES = ITEMS.register("sui_jokes", SuiJokes::new);


    /**
     * 19th
     */
    //ameki
    public static final RegistryObject<Item> RAIN_BUTTERFLY_DUST = ITEMS.register("rain_butterfly_dust", RainButterflyDust::new);
    public static final RegistryObject<Item> BUTTERFLY_STAFF = ITEMS.register("butterfly_staff", ButterflyStaff::new);
    public static final RegistryObject<Item> RAINY_BUTTERFLY = ITEMS.register("rainy_butterfly", RainyButterfly::new);
    public static final RegistryObject<Item> AMEKICHIYA_RING = ITEMS.register("amekichiya_ring", AmekichiyaRing::new);
    public static final RegistryObject<Item> ENDLESS_RAIN_SHOWER = ITEMS.register("endless_rain_shower", EndlessRainShower::new);

    //michiya
    public static final RegistryObject<Item> CURSED_ARTIFACT = ITEMS.register("cursed_artifact", CursedArtifact::new);
    public static final RegistryObject<Item> ETERNAL_CANDELABRA = ITEMS.register("eternal_candelabra", EternalCandelabra::new);
    public static final RegistryObject<Item> MICHIYAMEKI_RING = ITEMS.register("michiyameki_ring", MichiyamekiRing::new);
    public static final RegistryObject<Item> ETERNAL_TOUCH = ITEMS.register("eternal_touch", EternalTouch::new);

    //awu
    public static final RegistryObject<Item> ANCIENT_ESSENCE = ITEMS.register("ancient_essence", AncientEssence::new);
    public static final RegistryObject<Item> CHENG_HUANG_CRYSTAL = ITEMS.register("cheng_huang_crystal", ChengHuangCrystal::new);

    //hatsuse
    public static final RegistryObject<Item> PURITY_SHARD = ITEMS.register("purity_shard", PurityShard::new);
    public static final RegistryObject<Item> NEMUMARU = ITEMS.register("nemumaru", Nemumaru::new);


    /**
     * 20th-kismet
     */
    //ayumi
    public static final RegistryObject<Item> BASEBALL_BAT = ITEMS.register("baseball_bat", BaseballBat::new);

    //mizuki
    public static final RegistryObject<Item> FUTURE_BREWING_STAND = ITEMS.register("future_brewing_stand", FutureBrewingStand::new);

    //richi
    public static final RegistryObject<Item> FOX_MIRROR = ITEMS.register("fox_mirror", FoxMirror::new);


    /**
     * 21st
     */
    //hihi
    public static final RegistryObject<Item> SUNNY_DOLL = ITEMS.register("sunny_doll", SunnyDoll::new);

    //yukisyo
    public static final RegistryObject<Item> BURNING_MIRROR = ITEMS.register("burning_mirror", BurningMirror::new);

    //pako
    public static final RegistryObject<Item> KINDNESS_BOTTLE = ITEMS.register("kindness_bottle", KindnessBottle::new);

    //nagisa
    public static final RegistryObject<Item> POCKET_WATCH = ITEMS.register("pocket_watch", PocketWatch::new);


    /**
     * producer
     */
    //tokimori seisa
    public static final RegistryObject<Item> TOKIMORI_SEISAND = ITEMS.register("tokimori_seisand", TokimoriSeisand::new);
    public static final RegistryObject<Item> WORKAHOLIC_FURY = ITEMS.register("workaholic_fury", WorkaholicFury::new);

    /**
     * combination
     */
    //ameki-michiya
    public static final RegistryObject<Item> NIGHT_RAIN_RING = ITEMS.register("night_rain_ring", NightRainRing::new);
}
