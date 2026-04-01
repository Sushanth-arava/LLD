package Head_First.Creational_Patterns.Factory;

public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new NYStylePepperoniPizza();
        }
        return pizza;
    }
}
