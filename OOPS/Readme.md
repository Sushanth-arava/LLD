# OOPs in Java

Object-Oriented Programming (OOP) is a programming paradigm that models software around real-world entities using four core pillars: **Encapsulation**, **Inheritance**, **Polymorphism**, and **Abstraction**. Java enforces these through classes, access modifiers, inheritance hierarchies, interfaces, and abstract classes.

This directory contains a game-inventory-themed example that demonstrates multiple OOP concepts in a single cohesive program.

---

## Notes

### Concept: Encapsulation

**Files involved:** `Item.java`, `Weapon.java`, `Fruits.java`, `Inventory.java`

- `Item` declares its fields `name` and `quantity` as `private`, preventing direct external access.
- Public getter methods (`getName()`, `getQuantity()`) form the controlled interface for reading those values.
- Subclasses (`Weapon`, `Fruits`) cannot access `Item`'s private fields directly; they must go through the inherited getters. This is visible in both `Weapon.toString()` and `Fruits.toString()`, which call `getName()` and `getQuantity()` rather than accessing fields directly.
- `Inventory` similarly hides its internal `ArrayList<Item>` behind public methods, so callers never manipulate the list directly.

---

### Concept: Inheritance

**Files involved:** `Item.java` (parent), `Weapon.java` (child), `Fruits.java` (child)

- `Weapon` and `Fruits` both extend `Item` using the `extends` keyword, forming an IS-A relationship: a Weapon is an Item, a Fruit is an Item.
- Both subclasses call `super(name, quantity)` in their constructors to delegate initialization of the shared fields to the parent class.
- Each subclass adds its own specialised fields: `Weapon` adds `damage` (int) and `type` (String); `Fruits` adds only `type` (String).
- Noteworthy: both subclasses have a field named `type`, but their semantic meaning differs (weapon category vs. fruit origin/variety). They are independent fields with no shared parent declaration.

---

### Concept: Polymorphism

**Files involved:** `Item.java`, `Weapon.java`, `Fruits.java`, `Inventory.java`, `Main.java`

**Method Overriding (Runtime Polymorphism)**

- `Item` defines a `toString()` method. Both `Weapon` and `Fruits` override it with `@Override` to produce type-specific output (e.g., `Weapon` appends `Weapon type`, `Fruits` appends `Fruit type`).
- In `Inventory.displayInventory()`, items are iterated as `Item` references and `item.toString()` is called. At runtime, Java dispatches to the actual overridden implementation of the concrete type — this is dynamic dispatch / runtime polymorphism in action.

**Method Overloading (Compile-time Polymorphism)**

- `Inventory` provides three overloaded versions of `addItem()`:
  - `addItem(Item item)` — accepts any pre-constructed `Item`.
  - `addItem(String name, int quantity, String type)` — constructs and adds a `Fruits` internally.
  - `addItem(String name, int quantity, int damage, String type)` — constructs and adds a `Weapon` internally.
- The caller in `Main.java` uses all three variants, with the compiler selecting the correct method based on argument signature at compile time.

---

### Concept: Abstraction (via Superclass as a Type)

**Files involved:** `Inventory.java`, `Main.java`

- `Inventory` stores all items as `ArrayList<Item>`, abstracting away the concrete type. The caller works with the general `Item` abstraction, not with `Weapon` or `Fruits` specifically.
- In `Main.java`, `Weapon` and `Fruits` instances are added to the inventory and later printed through the `Item` interface, hiding the specifics of each subtype from the display loop.
- Note: the codebase does not use `abstract` classes or Java `interface` constructs. Abstraction here is achieved through superclass-as-type design rather than formal abstract/interface mechanisms.

---

### Program Flow (Main.java)

1. An `Inventory` instance is created.
2. Individual `Item`, `Fruits`, and `Weapon` objects are instantiated explicitly and added via `addItem(Item)`.
3. Two more items are added using the overloaded factory-style `addItem()` signatures (one weapon, one fruit), which construct the objects internally.
4. `displayInventory()` iterates the list and prints each item using polymorphic `toString()` dispatch.

Expected console output (in insertion order):
```
Item: table, Quantity: 20
Item: Apples, Quantity: 30, Fruit type: Kashmir
Item: Knife, Quantity: 1, Weapon type: Meele
Item: AK47, Quantity: 10, Weapon type: Automatic Rifle
Item: Apples, Quantity: 60, Fruit type: Shimla
```

---

### Tradeoffs and Observations

- **Tight coupling in overloaded addItem:** The `addItem(String, int, String)` overload is hardcoded to create a `Fruits` and `addItem(String, int, int, String)` is hardcoded to create a `Weapon`. Adding a new subtype would require adding yet another overload, which does not scale well. A factory or builder pattern would be more extensible.
- **No interface or abstract class:** The `Item` base class is a concrete class, not an abstract one. Nothing prevents a caller from instantiating `Item` directly (as `Main.java` does with the "table" item). Marking `Item` abstract would enforce that only meaningful subtypes are instantiated.
- **Duplicate `type` field:** Both `Weapon` and `Fruits` declare a `String type` field independently. If a `getType()` contract were needed at the `Item` level, it would be cleaner to declare it in `Item` (possibly as abstract) rather than duplicating it in each subclass.
- **Package-private Main:** `Main` is declared without an explicit access modifier, making it package-private. This is functional but atypical; `public class Main` is the conventional entry-point declaration.
