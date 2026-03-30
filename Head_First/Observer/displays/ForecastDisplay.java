package Head_First.Observer.displays;

import Head_First.Observer.interfaces.DisplayElement;
import Head_First.Observer.interfaces.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
    private float lastPressure = 29.92f;
    private float currentPressure;

    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    public void display() {
        String forecast;
        if (currentPressure > lastPressure) {
            forecast = "Improving weather on the way!";
        } else if (currentPressure == lastPressure) {
            forecast = "More of the same.";
        } else {
            forecast = "Watch out for cooler, rainy weather.";
        }
        System.out.println("[Forecast] " + forecast);
    }
}
