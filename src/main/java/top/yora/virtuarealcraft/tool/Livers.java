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
    SIRIUS("sirius","10th","#3755BD",true),
    YUA("yua", "10th", "#8AB0CC", true),
    SHAUN("shaun", "10th", "#DFD6D3", true),
    TANOSHIBA("tanoshiba","11th","#E7B45B",true),
    MARI("mari", "11th", "#C70039", true),
    CHIYUU("chiyuu", "11th", "#CC225F", true),
    IMI("imi", "11th", "#CC777C", true),
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
    GIRIMI("girimi", "16th", "#1E377F", true),
    KIYUU("kiyuu", "16th", "#FF91AE", true),
    SUI("sui", "17th", "#87EAFF", true),
    AMEKI("ameki", "19th", "#9EEEFF", true),
    MICHIYA("michiya", "19th", "#EBE4D7", true),
    AWU("awu", "19th", "#F9A699", true),
    HATSUNE("hatsune", "19th", "#BA66F6", true);

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
