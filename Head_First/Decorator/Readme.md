# Decorator Pattern

## Open-Closed Principle

> Classes should be open for extension but not modification

**_Decorator pattern follows this open-closed principle_**

**Points to remember:**

1. Decorators have the same supertype as the objects they decorate.
2. You can use one or more decorators to wrap an object. Given that the decorator has the same supertype as the object it decorates, we can pass around a decorated object in place of the original (wrapped) object.
3. _The decorator adds its own behavior before and/or after delegating to the object it decorates to do the rest of the job._
4. Objects can be decorated at any time, so we can decorate objects dynamically at runtime with as many decorators as we like.

## Definition

> **The Decorator Pattern** attaches additional responsibilities to an object dynamically.
> Decorators provide a flexible alternative to subclassing for extending functionality.

---

## Use Case — Starbuzz Coffee

A coffee shop needs to price beverages with optional condiments (Mocha, Soy, Whip, etc.). Instead of creating a subclass for every combination (`DarkRoastWithMochaAndWhip`, etc.), condiments are added as decorators at runtime.

### Class Structure

```
Beverage  (abstract)
│   getDescription()
│   cost()  (abstract)
│
├── Expresso          → $1.99
├── DarkRoast         → $2.99
└── HouseBlend        → $0.89

CondimentDecorator  (abstract, extends Beverage)
│   wraps a Beverage instance
│
├── Mocha             → +$0.20
├── Soy               → +$0.50
└── Whip              → +$0.30
```

- `Beverage` — abstract base class for all drinks. Holds `description` and declares `cost()`.
- `CondimentDecorator` — abstract decorator that extends `Beverage` and holds a reference to a wrapped `Beverage`. Forces subclasses to override `getDescription()`.
- Concrete beverages (`Expresso`, `DarkRoast`, `HouseBlend`) — set their description and base price.
- Concrete decorators (`Mocha`, `Soy`, `Whip`) — delegate `getDescription()` and `cost()` to the wrapped beverage, then append their own name and price.

### How wrapping works

Each decorator holds a reference to the `Beverage` it wraps. When `cost()` or `getDescription()` is called, it chains back through every wrapper:

```java
Beverage b = new HouseBlend();        // "House Blend Coffee"  $0.89
b = new Mocha(b);                     // "House Blend Coffee, Mocha"  $1.09
b = new Soy(b);                       // "House Blend Coffee, Mocha, Soy"  $1.59
b = new Whip(b);                      // "House Blend Coffee, Mocha, Soy, Whip"  $1.89
```

`cost()` call chain for the above:
```
Whip.cost()
  → Soy.cost() + 0.30
      → Mocha.cost() + 0.50
          → HouseBlend.cost() + 0.20
              → 0.89
```

### Sample Output

```
Expresso $1.99
Dark Roast, Mocha, Mocha $3.39
House Blend Coffee, Mocha, Soy, Whip $1.89
```

---

## Why not just use inheritance?

If you subclassed every combination:
- 3 beverages × 4 condiments = potential explosion of classes
- Adding a new condiment requires modifying the base class or every subclass
- Condiment quantities (e.g., double Mocha) are hard to handle

With the Decorator pattern, each condiment is a single class and combinations are composed at runtime.
