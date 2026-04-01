package Head_First.Structural_Patterns.Decorator.condiments;

import Head_First.Structural_Patterns.Decorator.base.Beverage;
import Head_First.Structural_Patterns.Decorator.base.CondimentDecorator;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    public double cost() {
        return beverage.cost() + .30;
    }

}
