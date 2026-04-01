package Head_First.Structural_Patterns.Decorator.base;

public abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;

    public abstract String getDescription();

}
