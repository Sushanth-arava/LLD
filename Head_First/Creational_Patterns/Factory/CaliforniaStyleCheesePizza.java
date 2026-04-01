package Head_First.Creational_Patterns.Factory;

public class CaliforniaStyleCheesePizza extends Pizza {

    public CaliforniaStyleCheesePizza() {
        name = "California Style Cheese Pizza";
        dough = "Sourdough Crust";
        sauce = "Sun-Dried Tomato Sauce";
        toppings.add("Goat Cheese");
        toppings.add("Artichoke Hearts");
        toppings.add("Avocado");
        toppings.add("Fresh Basil");
    }
}
