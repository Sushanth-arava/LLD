package Head_First.Creational_Patterns.Factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<String>();

    void prepare() {
        System.out.println("Prepping ...." + name);
        System.out.println("Tossing dough....");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings...");
        for (String topping : toppings) {
            System.out.println(" " + topping);
        }

    }

    void bake() {
        System.out.println("Bake for 25min at 350deg");
    }

    void cut() {
        System.out.println("Cutting the pizza into shape..");
    }

    void box() {
        System.out.println("Placing in box");
    }

    public String getName() {
        return name;
    }

}
