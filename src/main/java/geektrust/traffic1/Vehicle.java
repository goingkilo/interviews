package geektrust.traffic1;

/**
 * Created by kraghunathan on 5/12/18.
 */
public interface Vehicle {

    public String getName();
    public float getSpeed();
    public float getCraterTime();
    public boolean allowed(Weather weather);

}
