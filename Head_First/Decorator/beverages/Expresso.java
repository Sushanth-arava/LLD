package Head_First.Decorator.beverages;

import Head_First.Decorator.base.Beverage;

public class Expresso extends Beverage {
    public Expresso() {
        description = "Expresso";
    }

    public double cost() {
        return 1.99;
    }

}
