# Creational Design Patterns

Creational patterns focus on **how objects are created**. They decouple the system from the details of instantiation — what gets created, who creates it, and how it's assembled.

## Two Core Themes

1. **Hide the concrete classes** — the system doesn't need to know which specific class is being used.
2. **Hide the instantiation details** — the system doesn't need to know how objects are constructed or assembled.

## Patterns

| Pattern | Intent |
|---------|--------|
| **Singleton** | Ensures only one instance of a class exists and provides a global access point to it |
| **Factory Method** | Defines an interface for creating an object, but lets subclasses decide which class to instantiate |
| **Abstract Factory** | Provides an interface for creating families of related objects without specifying their concrete classes |
| **Builder** | Separates the construction of a complex object from its representation |
| **Prototype** | Creates new objects by copying an existing instance |
