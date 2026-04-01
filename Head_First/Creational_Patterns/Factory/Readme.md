# Factory Pattern

The Factory Pattern is a creational design pattern that defines an interface or abstract class for creating an object, but lets subclasses (or separate factory classes) decide which concrete class to instantiate. The goal is to decouple the client code from the concrete classes it uses, centralising the instantiation logic so it can vary independently of the code that consumes the created objects.

There are three commonly recognised variants:

- **Simple Factory** - A single non-polymorphic class that encapsulates object creation behind one method. Not a formal GoF pattern, but a common first step.
- **Factory Method** - An abstract creator class declares a factory method; each concrete subclass overrides it to produce the appropriate product.
- **Abstract Factory** - An interface groups a family of related factory methods so that entire product families can be swapped consistently.

---

## Notes

### Variant Implemented

This codebase demonstrates **both the Simple Factory and the Factory Method pattern**, with the Factory Method being the primary and fully wired-up implementation.

- `SimplePizzaFactory` is present as a standalone class and represents the **Simple Factory** variant. It is commented out inside `PizzaStore`, indicating it was an earlier draft that was superseded.
- `PizzaStore` (abstract) with `NYPizzaStore`, `ChicagoPizzaStore`, and `CaliforniaPizzaStore` as concrete subclasses is the **Factory Method** implementation.

---

### Class and Interface Inventory

#### Abstract Product

| Class | Role |
|---|---|
| `Pizza` | Abstract base class for all pizza products. Holds package-private fields `name`, `dough`, `sauce`, and a `toppings` list. Provides concrete lifecycle methods `prepare()`, `bake()`, `cut()`, and `box()`, plus a `getName()` getter. Subclasses may override any lifecycle method. |

#### Concrete Products

| Class | Style | Dough | Sauce | Notable Toppings / Overrides |
|---|---|---|---|---|
| `NYStyleCheesePizza` | NY | Thin Crust | Marinara | Grated Reggiano |
| `NYStylePepperoniPizza` | NY | Thin Crust | Marinara | Reggiano, Pepperoni, Garlic, Onion, Mushrooms, Red Pepper |
| `ChicagoStyleCheesePIzza` | Chicago | Extra Thick Crust | Plum Tomato | Shredded Mozzarella; overrides `cut()` to produce square slices |
| `ChicagoStylePepperoniPizza` | Chicago | Extra Thick Crust | Plum Tomato | Mozzarella, Black Olives, Spinach, Eggplant, Pepperoni; overrides `cut()` for square slices |
| `CaliforniaStyleCheesePizza` | California | Sourdough Crust | Sun-Dried Tomato | Goat Cheese, Artichoke Hearts, Avocado, Fresh Basil |
| `CaliforniaStylePepperoniPizza` | California | Sourdough Crust | Sun-Dried Tomato | Goat Cheese, Pepperoni, Roasted Red Peppers, Fresh Arugula |

Note: `ChicagoStyleCheesePIzza` contains a typo in the class name (`PIzza` instead of `Pizza`). This is present in the source file as-is.

#### Abstract Creator (Factory Method)

| Class | Role |
|---|---|
| `PizzaStore` | Abstract class that defines the ordering workflow in `orderPizza(String type)`. This method calls the abstract factory method `createPizza(String type)`, then invokes `prepare()`, `bake()`, `cut()`, and `box()` on the returned pizza in that fixed sequence. Subclasses must implement `createPizza()` but cannot alter the ordering workflow. |

#### Concrete Creators (Factory Method)

| Class | Products Created |
|---|---|
| `NYPizzaStore` | `NYStyleCheesePizza`, `NYStylePepperoniPizza` |
| `ChicagoPizzaStore` | `ChicagoStyleCheesePIzza`, `ChicagoStylePepperoniPizza` |
| `CaliforniaPizzaStore` | `CaliforniaStyleCheesePizza`, `CaliforniaStylePepperoniPizza` |

Each concrete store returns `null` for any unrecognised type string.

#### Simple Factory (superseded draft)

| Class | Role |
|---|---|
| `SimplePizzaFactory` | Standalone factory class with a single `createPizza(String type)` method. Only handles `"cheese"` and `"pepperoni"` types and hard-codes NY-style products for both. The constructor injection of this class into `PizzaStore` is present in `PizzaStore.java` as commented-out code, showing the evolution from Simple Factory to Factory Method. |

---

### Execution Flow (Main.java)

`Main` creates three stores — `NYPizzaStore`, `ChicagoPizzaStore`, and `CaliforniaPizzaStore` — and places the following six orders:

1. Ethan orders NY cheese pizza
2. Joel orders Chicago cheese pizza
3. Ethan orders NY pepperoni pizza
4. Joel orders Chicago pepperoni pizza
5. Sophia orders California cheese pizza
6. Sophia orders California pepperoni pizza

For each order, `orderPizza()` on the abstract `PizzaStore` drives the full prepare-bake-cut-box pipeline. The concrete store's `createPizza()` supplies the correctly styled product; `PizzaStore` never needs to know which region or concrete type was chosen.

---

### Interesting Behaviours

- **Template Method embedded in Factory Method.** `PizzaStore.orderPizza()` acts as a Template Method: it defines the fixed algorithm (`createPizza` -> `prepare` -> `bake` -> `cut` -> `box`) while delegating the variable step (`createPizza`) to subclasses. The two patterns work together naturally here.
- **Selective method override for regional style.** Only the Chicago-style pizzas override `cut()`, changing the output to square slices. NY and California styles inherit the default round-cut behaviour from `Pizza`. This makes regional differences purely a product-class concern.
- **Simple Factory as a stepping stone.** The commented-out constructor and field in `PizzaStore` preserve the earlier design clearly, making this codebase useful as a before-and-after illustration of why the Factory Method is preferred over the Simple Factory for extensibility.
- **Null return on unknown type.** All three concrete stores return `null` for unrecognised type strings. Calling `orderPizza()` with an unknown type would cause a `NullPointerException` at `pizza.prepare()`. There is no guard clause or custom exception handling in the current code.
