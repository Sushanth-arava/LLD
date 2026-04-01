package Head_First.Structural_Patterns.Decorator.beverages;

import Head_First.Structural_Patterns.Decorator.base.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    public double cost() {
        return .89;
    }

}
