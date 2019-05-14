package geektrust.traffic2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Vehicle {

    private String name;
    private float speed;
    private float potHoleTime;
    private Set<Weather> allowedWeather;

    public Vehicle(Builder builder) {
        this.name   = builder.name;
        this.speed  = builder.speed;

        this.potHoleTime    = builder.potHoleTime;

        this.allowedWeather = new HashSet<>();
        this.allowedWeather.addAll(Arrays.asList(builder.allowedWeather));
    }

    boolean canTravel(Weather weather){
        return allowedWeather.contains(weather);
    }

    public String getName() {
        return name;
    }

    public float getTimeToTravel(Weather weather, float megamiles, int potholes, float trafficSpeed){

        if( !canTravel(weather)) {
            throw new RuntimeException("Vehicle " + name + " cannot travel in " + weather.getType() + " weather");
        }

        float newSpeed = this.speed > trafficSpeed ? trafficSpeed : this.speed;
        float time = (megamiles/newSpeed) + (potholes * potHoleTime);

        return time;
    }



    public static Builder builder (String name){
        return new Builder(name);
    }

    public static class Builder {

        private String name;
        private float speed;
        private float potHoleTime;
        private Weather[] allowedWeather;

        public Builder(String name){
            this.name = name;
        }
        public Builder speed(float speed){
            this.speed = speed;
            return this;
        }
        public Builder potHoleTime(float potHoleTime){
            this.potHoleTime = potHoleTime;
            return this;
        }
        public Builder allowedWeather(Weather[] weathers){
            this.allowedWeather = weathers;
            return this;
        }
        public Vehicle build(){
            Vehicle v =  new Vehicle(this);
            return v;
        }

    }

    public static void main(String[] args) {
        Vehicle v = Vehicle.builder("Car")
                .speed(10f)
                .potHoleTime(1f)
                .build();

        Orbit o = Orbit.builder("Route1")
                .craters(10)
                .end1("HalliTharam")
                .end2("RKPuram")
                .megaMiles(10f)
                .build();
    }
}
