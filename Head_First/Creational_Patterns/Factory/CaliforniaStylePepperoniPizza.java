package Head_First.Creational_Patterns.Factory;

public class CaliforniaStylePepperoniPizza extends Pizza {

    public CaliforniaStylePepperoniPizza() {
        name = "California Style Pepperoni Pizza";
        dough = "Sourdough Crust";
        sauce = "Sun-Dried Tomato Sauce";
        toppings.add("Goat Cheese");
        toppings.add("Sliced Pepperoni");
        toppings.add("Roasted Red Peppers");
        toppings.add("Fresh Arugula");
    }
}
