package Head_First.Decorator.condiments;

import Head_First.Decorator.base.Beverage;
import Head_First.Decorator.base.CondimentDecorator;
import Head_First.Decorator.base.Size;

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
