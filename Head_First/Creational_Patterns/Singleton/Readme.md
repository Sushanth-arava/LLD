# Singleton Design Pattern

The **Singleton** is a creational design pattern that ensures a class has only one instance throughout the lifetime of an application, and provides a global point of access to that instance.

> "The Singleton Pattern ensures a class has only one instance, and provides a global point of access to it."
> — Head First Design Patterns, Freeman & Robson

## Notes

### Classes

**`Singleton`** (`Singleton.java`)

The core class that enforces the single-instance contract. Key implementation decisions:

- The sole constructor is `private`, preventing any external caller from using `new Singleton()` directly.
- The static field `instance` is marked `volatile`. This prevents the JVM or CPU from reordering the memory writes that happen during object construction, ensuring no thread ever receives a reference to a partially-constructed object.
- `getInstance()` uses the **double-checked locking** idiom. The outer `if (instance == null)` check runs without holding a lock, so threads that arrive after the instance is created pay no synchronization cost. Only the very first race — when `instance` is still `null` — causes threads to enter the `synchronized` block, where a second `if (instance == null)` check guards the actual construction.
- `state` is a mutable `String` field with a getter and setter, included to make shared identity concrete and testable rather than purely abstract.

**`Main`** (`Main.java`)

A minimal driver that demonstrates two behaviors back-to-back:

1. **Identity check.** `getInstance()` is called twice, assigning the result to `s1` and `s2`. The reference comparison `s1 == s2` prints `true`, confirming both variables point at the exact same object in memory, not two equal-but-distinct objects.
2. **Shared state.** `setState` is called on `s1`, and then `getState` is read through `s2`. The printed value reflects the change made via `s1`, proving that mutating the instance through any reference mutates the one shared object — there is no second copy to fall out of sync.

### What the code demonstrates

The implementation shows a production-style thread-safe Singleton rather than the simplest possible version. The combination of `volatile` and double-checked locking addresses two distinct failure modes: the `volatile` keyword fixes the broken-publication problem (a thread seeing a non-null but incompletely initialized object), while the inner `synchronized` block fixes the race condition where two threads could both pass the first null check before either constructs the instance.

The `Main` demo makes the consequence of single-instance identity tangible: because `s1` and `s2` are the same object, a state change through one reference is immediately visible through the other, with no messaging or synchronization required between them.

### Tradeoffs

- The `synchronized` keyword on the `getInstance()` method signature is redundant given the internal `synchronized (Singleton.class)` block; it adds unnecessary lock acquisition on every call. A strict double-checked locking implementation would remove the method-level `synchronized`.
- `volatile` incurs a small read/write barrier cost on every access to `instance`, which is negligible in practice since it is only read once per `getInstance()` call after initialization.
- Mutable shared state (the `setState` / `getState` pair) makes the class non-thread-safe after construction unless callers synchronize externally, which is a common real-world concern when a Singleton carries changing data.
