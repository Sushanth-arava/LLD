# Observer Pattern — Weather Station

## Goal
Implement the **Observer design pattern** using a Weather Station as the real-world example, based on the *Head First Design Patterns* book.

#### Definition:
The Observer Pattern defines a **one-to-many dependency** between objects so that when one object changes state, all of its dependents are notified and updated automatically.
---

## What I Did First (Without the Pattern)

In `WeatherData.java`, the initial approach directly called display methods from inside `measurementsChanged()`:

```java
public void measurementsChanged() {
    float temperate = getTemperature();
    float humidity = getHumidity();
    float pressure = getPressure();
}
CurrentConditionsDisplay.update(temperate, humidity, pressure);
StatisticsDisplay.updaate(temperate, humidity, pressure);   // typo
ForecastDisplay.update(temperate, humidity, pressure);
```

### Problems with this approach

- **Lines 13–15 were outside the class body** — a structural/syntax error
- **Typo** in `StatisticsDisplay.updaate(...)` → should be `update`
- **Variable mismatch** — variable declared as `temperate` but field is `temperature`
- **Missing getters** — `getTemperature()`, `getHumidity()`, `getPressure()` were called but never defined
- **Tight coupling** — `WeatherData` had to know about every display class directly
- **Not scalable** — adding a new display required modifying `WeatherData` itself (violates Open/Closed Principle)

---

## Why Use the Observer Pattern Here?

The Weather Station is a perfect fit for Observer because:

- `WeatherData` (the **Subject**) produces data — temperature, humidity, pressure
- Multiple displays (the **Observers**) want to react whenever that data changes
- The Subject should not care *who* is listening or *how many* listeners there are

### Benefits

| Without Observer | With Observer |
|---|---|
| `WeatherData` calls each display directly | Displays register themselves |
| Adding a display = modifying `WeatherData` | Adding a display = zero changes to `WeatherData` |
| Static/compile-time coupling | Dynamic, runtime registration |
| Violates Open/Closed Principle | Follows Open/Closed Principle |

---

## How It Works

```
Subject (WeatherData)
    └── registerObserver(Observer o)
    └── removeObserver(Observer o)
    └── notifyObservers()          ← called when measurements change
            │
            ▼
    Observer.update(temp, humidity, pressure)
            │
     ┌──────┼──────────────────┐
     ▼      ▼                  ▼
CurrentConditions  Statistics  Forecast
   Display          Display     Display
```

1. `WeatherData` implements `Subject` — holds a list of observers
2. Each display implements `Observer` — defines an `update()` method
3. When `setMeasurements()` is called, `notifyObservers()` loops through all registered displays and calls `update()` on each
4. Each display handles its own rendering logic independently

---

## Interfaces

```java
interface Observer {
    void update(float temperature, float humidity, float pressure);
}

interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
```

---

## Running

```bash
javac Head_First/Observer/Main.java && java Head_First.Observer.Main
```
