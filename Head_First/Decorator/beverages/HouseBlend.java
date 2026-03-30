package Head_First.Decorator.beverages;

import Head_First.Decorator.base.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    public double cost() {
        return .89;
    }

}
