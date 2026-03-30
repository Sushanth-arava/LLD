package Head_First.Decorator;

import Head_First.Decorator.base.Beverage;
import Head_First.Decorator.base.Size;
import Head_First.Decorator.beverages.DarkRoast;
import Head_First.Decorator.beverages.Expresso;
import Head_First.Decorator.beverages.HouseBlend;
import Head_First.Decorator.condiments.Mocha;
import Head_First.Decorator.condiments.Soy;
import Head_First.Decorator.condiments.SizeDecorator;
import Head_First.Decorator.condiments.Whip;

public class Main {

    public static void main(String[] args) {
        Beverage beverage = new Expresso();
        beverage = new SizeDecorator(beverage, Size.TALL);
        System.out.printf("%s $%.2f%n", beverage.getDescription(), beverage.cost());

        Beverage beverage2 = new DarkRoast();

        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        beverage2 = new SizeDecorator(beverage2, Size.GRANDE);
        System.out.printf("%s $%.2f%n", beverage2.getDescription(), beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Mocha(beverage3);
        beverage3 = new Soy(beverage3);
        beverage3 = new Whip(beverage3);
        beverage3 = new SizeDecorator(beverage3, Size.VENTI);
        System.out.printf("%s $%.2f%n", beverage3.getDescription(), beverage3.cost());
    }

}
