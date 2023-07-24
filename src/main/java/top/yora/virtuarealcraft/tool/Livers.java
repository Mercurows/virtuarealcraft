package top.yora.virtuarealcraft.tool;

public enum Livers {
    NANAMI("nanami", "2nd", "#418BDE", true),
    CHIHARU("chiharu", "9th", "#8C6250", true),
    SUI("sui","17th","#87EAFF", true);

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
