package top.yora.virtuarealcraft.tool;

public enum Livers {
    EINE("eine", "1st", "#A00000", true),
    NANAMI("nanami", "2nd", "#418BDE", true),
    KOUICHI("kouichi", "2nd", "#E6E1D2", true),
    MURI("muri", "3rd", "#E9F6FE", false),
    NYATSUKI("nyatsuki", "4th", "#D8FEFE", false),
    WAKU("waku", "4th", "#047799", true),
    MIKI("miki", "5th", "#BF90F0", true),
    HOSHIMI("hoshimi", "5th", "#FCE6EA", false),
    MAHIRU("mahiru", "5th", "#F97169", false),
    AZA("aza","6th","#B8E994",true),
    YAGI("yagi","6th","#875E37",true),
    TABIBITO("tabibito", "6th", "#354B55", true),
    ROI("roi","6th","#FFEC89", false),
    SAYA("saya", "7th", "#764699", true),
    YUKIE("yukie", "7th", "#FFECC7", true),
    CHIHARU("chiharu", "9th", "#8C6250", true),
    REVE("reve","10th","#91BCB5",false),
    YUA("yua", "10th", "#C0E0F0", true),
    SHAUN("shaun", "10th", "#FFFAFA", true),
    TANOSHIBA("tanoshiba","11th","#E7B45B",false),
    MARI("mari", "11th", "#C70039", false),
    CHIYUU("chiyuu", "11th", "#CC225F", true),
    IMI("imi", "11th", "#CC777C", false),
    MAYUMI("mayumi", "12th", "#D6E568", true),
    TSUKUMO("tsukumo", "12th", "#C6B6EC", true),
    REMI("remi", "12th", "#77CFD4", true),
    TOCCI("tocci","13th","#EABAE1",true),
    JOI("joi", "13th", "#FFCE65", true),
    KITI("kiti", "13th", "#FBA33E", true),
    KOXIA("koxia", "14th", "#EE548E", false),
    HAKUJA("hakuja", "14th", "#55A8CB", true),
    YOMIYA("yomiya", "14th", "#FFBBD1", true),
    RHEA("rhea", "14th", "#776EF2", true),
    YOG("yog", "15th", "#6671BC", true),
    KEKE("keke", "15th", "#FF0329", true),
    HUNGER("hunger", "15th", "#6F1313", true),
    UKA("uka", "15th", "#A72424", true),
    SYBIL("sybil", "16th", "#91CAD1", true),
    GIRIMI("girimi", "16th", "#1E377F", true),
    KARISA("karisa", "16th", "#B4BBC4", true),
    KIYUU("kiyuu", "16th", "#FF91AE", true),
    LEO("leo","17th","#FFDB79",true),
    ERA("era","17th","#AE55E6",true),
    SUI("sui", "17th", "#87EAFF", true),
    EVE("eve", "18th", "#F15642", true),
    OPAL("opal", "18th", "#90CC4B", true),
    SHIORI("shiori", "18th", "#93B0F8", true),
    AMEKI("ameki", "19th", "#9EEEFF", true),
    MICHIYA("michiya", "19th", "#EBE4D7", true),
    AWU("awu", "19th", "#F9A699", true),
    HATSUSE("hatsuse", "19th", "#BA66F6", true),
    AYUMI("ayumi","20th-k","#7894D2",true),
    MIZUKI("mizuki","20th-k","#FCC8CB",true),
    RICHI("richi","20th-k","#CD5666",true),
    MIKOTO("mikoto","20th-i","#935059",true),
    URUSHIHA("urushiha","20th-i","#6309EA",true),
    HAJIME("hajime","20th-i","#3B6CF7",true),
    INARI("inari","link","#FFB779",true),
    AZUSA("azusa","link","#B4B8FD",true),
    KERO("kero","link","#C9302A",true),
    RIN("rin","link","#7678A5",true),
    NOX("nox","link","#438E94",true),
    SUSAM("susam","link","#E5B5F9",true),
    NOI("noi","link","#FEBB70",true);

    private final String name;
    private final String gen;
    private final String color;
    private final boolean active;

    Livers(String name, String gen, String color, boolean active) {
        this.name = name;
        this.gen = gen;
        this.color = color;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public String getGen() {
        return gen;
    }

    public String getColor() {
        return color;
    }

    public boolean isActive() {
        return active;
    }
}
