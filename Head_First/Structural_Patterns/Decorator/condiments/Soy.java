package Head_First.Structural_Patterns.Decorator.condiments;

import Head_First.Structural_Patterns.Decorator.base.Beverage;
import Head_First.Structural_Patterns.Decorator.base.CondimentDecorator;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    public double cost() {
        return beverage.cost() + .50;
    }

}
