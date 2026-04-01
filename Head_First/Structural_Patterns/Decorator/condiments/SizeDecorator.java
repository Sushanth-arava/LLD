package Head_First.Structural_Patterns.Decorator.condiments;

import Head_First.Structural_Patterns.Decorator.base.Beverage;
import Head_First.Structural_Patterns.Decorator.base.CondimentDecorator;
import Head_First.Structural_Patterns.Decorator.base.Size;

public class SizeDecorator extends CondimentDecorator {
    private final Size size;

    public SizeDecorator(Beverage beverage, Size size) {
        this.beverage = beverage;
        this.size = size;
    }

    @Override
    public String getDescription() {
        return size.getLabel() + " " + beverage.getDescription();
    }

    @Override
    public double cost() {
        return beverage.cost() * size.getMultiplier();
    }
}
