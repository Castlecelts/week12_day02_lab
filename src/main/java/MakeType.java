public enum MakeType {
    SONY("Sony"),
    BOSE("Bose"),
    ROKIT("Rokit"),
    BRAVA("Brava"),
    JBL("JBL"),
    SENNHEISER("SENNHEISTER");

    private final String name;

    MakeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
