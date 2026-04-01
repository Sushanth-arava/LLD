package Head_First.Structural_Patterns.Decorator.beverages;

import Head_First.Structural_Patterns.Decorator.base.Beverage;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast";
    }

    public double cost() {
        return 2.99;
    }

}
