package Head_First.Structural_Patterns.Decorator.base;

public enum Size {
    TALL("Tall", 1),
    GRANDE("Grande", 2),
    VENTI("Venti", 3);

    private final String label;
    private final int multiplier;

    Size(String label, int multiplier) {
        this.label = label;
        this.multiplier = multiplier;
    }

    public String getLabel() {
        return label;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
