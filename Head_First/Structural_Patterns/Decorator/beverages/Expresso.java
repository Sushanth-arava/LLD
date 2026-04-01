package Head_First.Structural_Patterns.Decorator.beverages;

import Head_First.Structural_Patterns.Decorator.base.Beverage;

public class Expresso extends Beverage {
    public Expresso() {
        description = "Expresso";
    }

    public double cost() {
        return 1.99;
    }

}
