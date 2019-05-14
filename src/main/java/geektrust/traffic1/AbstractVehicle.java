package geektrust.traffic1;


import geektrust.traffic1.exception.VehicleNotAllowedException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kraghunathan on 5/12/18.
 */
public abstract class AbstractVehicle {

    private static Set<Weather> allowedWeather = new HashSet<Weather>();

    private VehicleType type;
    private float speed;
    private int craterTime;

    public AbstractVehicle(VehicleType type, float speed, int craterTime ) {
        this.type = type;
        this.speed = speed;
        this.craterTime = craterTime;
    }

    public String getName(){
        return type.toString();
    }

    public float getSpeed(){
        return getSpeed();
    }

    public float getSpeed(float trafficLimit){
        return Math.min( trafficLimit, getSpeed());
    }

    public float getCraterTime(){
        return getCraterTime();
    }

    static void addAllowedWeather( Weather ... weathers) {
        allowedWeather.addAll( Arrays.asList(weathers));
    }
    public boolean allowed(Weather weather){
        return allowedWeather.contains(weather);
    }

    public int timeTaken( Orbit orbit, Weather weather) throws VehicleNotAllowedException {

        if( !allowed(weather)) {
            throw new VehicleNotAllowedException("");
        }
        return (int) (orbit.getMegaMiles() / getSpeed(orbit.getTrafficSpeed())
                        +
                        orbit.getCraters(weather) * getCraterTime());
    }


}
