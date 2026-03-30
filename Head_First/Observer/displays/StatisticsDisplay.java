package Head_First.Observer.displays;

import Head_First.Observer.interfaces.DisplayElement;
import Head_First.Observer.interfaces.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = Float.MIN_VALUE;
    private float minTemp = Float.MAX_VALUE;
    private float sumTemp = 0;
    private int count = 0;

    public void update(float temperature, float humidity, float pressure) {
        sumTemp += temperature;
        count++;
        if (temperature > maxTemp) maxTemp = temperature;
        if (temperature < minTemp) minTemp = temperature;
        display();
    }

    public void display() {
        System.out.println("[Statistics] Min: " + minTemp + "°C Max: " + maxTemp + "°C Avg: " + (sumTemp / count) + "°C");
    }
}
