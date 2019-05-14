package geektrust.traffic1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kraghunathan on 5/12/18.
 */
public class Bike implements Vehicle {

    private static Set<Weather> allowedWeather = new HashSet<Weather>();

    static {
        allowedWeather.add(Weather.WINDY);
        allowedWeather.add(Weather.SUNNY);
    }

    public String getName() {

        return "Bike";
    }

    public float getSpeed() {

        return 10;
    }

    public float getCraterTime() {

        return 2;
    }

    public boolean allowed(Weather weather) {

        return allowedWeather.contains(weather);
    }
}
