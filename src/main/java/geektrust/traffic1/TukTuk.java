package geektrust.traffic1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kraghunathan on 5/12/18.
 */
public class TukTuk implements Vehicle {

    private static Set<Weather> allowedWeather = new HashSet<Weather>();

    static
    {
        allowedWeather.add(Weather.RAINY);
        allowedWeather.add(Weather.SUNNY);
    }

    public String getName() {
        return "TukTuk";
    }

    public float getSpeed() {
        return 12;
    }

    public float getCraterTime() {
        return 1;
    }

    public boolean allowed(Weather weather) {
        return allowedWeather.contains(weather);
    }
}
