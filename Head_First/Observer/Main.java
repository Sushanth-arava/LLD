package Head_First.Observer;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        weatherData.registerObserver(new CurrentConditionsDisplay());
        weatherData.registerObserver(new StatisticsDisplay());
        weatherData.registerObserver(new ForecastDisplay());
        weatherData.registerObserver(new HeatIndexDisplay());

        System.out.println("--- Measurement 1 ---");
        weatherData.setMeasurements(28.5f, 65f, 30.4f);

        System.out.println("\n--- Measurement 2 ---");
        weatherData.setMeasurements(32.0f, 70f, 29.2f);

        System.out.println("\n--- Measurement 3 ---");
        weatherData.setMeasurements(25.0f, 90f, 29.2f);
    }
}
