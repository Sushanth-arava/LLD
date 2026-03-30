package Head_First.Observer.displays;

import Head_First.Observer.interfaces.DisplayElement;
import Head_First.Observer.interfaces.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature, humidity;

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("[Current Conditions] Temp: " + temperature + "°C Humidity: " + humidity + "%");
    }
}
