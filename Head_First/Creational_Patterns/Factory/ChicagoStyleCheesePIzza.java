package Head_First.Creational_Patterns.Factory;

public class ChicagoStyleCheesePIzza extends Pizza {

    public ChicagoStyleCheesePIzza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
