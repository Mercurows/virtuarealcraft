package top.yora.virtuarealcraft.tool;

public enum Livers {
    NANAMI("nanami", "2nd", "#418BDE", true),
    KOUICHI("kouichi", "2nd", "#E6E1D2", true),
    YUKIE("yukie","7th","#FFECC7",true),
    CHIHARU("chiharu", "9th", "#8C6250", true),
    SHAUN("shaun","10th","#DFD6D3",true),
    MARI("mari","11th","#C70039", true),
    CHIYUU("chiyuu","11th","#CC225F",true),
    IMI("imi","11th","#CC777C",true),
    MAYUMI("mayumi","12th","#D6E568",true),
    KOXIA("koxia","14th","#EE548E",false),
    GIRIMI("girimi","16th","#1E377F",true),
    KIYUU("kiyuu","16th","#FF91AE",true),
    SUI("sui","17th","#87EAFF", true),
    AMEKI("ameki","19th","#9EEEFF",true);

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
