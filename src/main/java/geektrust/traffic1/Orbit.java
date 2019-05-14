package geektrust.traffic1;

import geektrust.traffic1.exception.VehicleNotAllowedException;

/**
 * Created by kraghunathan on 5/9/18.
 */
public class Orbit {

    private String name;
    private float megaMiles;
    private int craters;

    private float trafficSpeed;

    public Orbit(String name, float megaMiles, int numCraters) {
        this.name = name;
        this.megaMiles = megaMiles;
        this.craters = numCraters;
    }

    public String getName(){
        return this.name;
    }

    public float getMegaMiles() {
        return megaMiles;
    }

    public int getCraters() {
        return craters;
    }

    public int getCraters(Weather weather) {
        return (int) (craters * weather.getCraterMultiplier());
    }

    public float getTrafficSpeed() {
        return trafficSpeed;
    }

    public void setTrafficSpeed(float trafficSpeed) {
        this.trafficSpeed = trafficSpeed;
    }

    public float getTimeTaken( Vehicle vehicle, Weather weather) throws VehicleNotAllowedException {
        if( ! vehicle.allowed(weather))
            throw new VehicleNotAllowedException( vehicle.getName()  + " is not allowed in " + weather.toString());

        float roadTime =  getMegaMiles() / Math.min(vehicle.getSpeed(), getTrafficSpeed()) * 60
                +
                vehicle.getCraterTime() * getCraters() * weather.getCraterMultiplier();

        return roadTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orbit orbit = (Orbit) o;

        if (Float.compare(orbit.getMegaMiles(), getMegaMiles()) != 0) return false;
        return getCraters() == orbit.getCraters();

    }

    @Override
    public int hashCode() {
        int result = (getMegaMiles() != +0.0f ? Float.floatToIntBits(getMegaMiles()) : 0);
        result = 31 * result + getCraters();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("v1.Orbit{");
        sb.append("megaMiles=").append(megaMiles);
        sb.append(", craters=").append(craters);
        sb.append('}');
        return sb.toString();
    }
}
