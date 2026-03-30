package Head_First.Decorator.beverages;

import Head_First.Decorator.base.Beverage;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast";
    }

    public double cost() {
        return 2.99;
    }

}
