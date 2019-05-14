package geektrust.traffic1;


import geektrust.traffic1.exception.VehicleNotAllowedException;

import java.util.Scanner;

/**
 * Created by kraghunathan on 5/19/18.
 */
public class App {

    Vehicle[] vehicles;
    Orbit[] orbits  ;
    Weather weather;

    public App(){

        Car car = new Car();
        Bike bike = new Bike();
        TukTuk tuktuk = new TukTuk();

        Orbit orbit1  = new Orbit( "Orbit1", 18, 20);
        Orbit orbit2  = new Orbit( "Orbit2", 20, 10);

        vehicles = new Vehicle[] { car, bike, tuktuk};
        orbits   = new Orbit[] { orbit1, orbit2};
    }

    public String solveForX(Weather weather, float trafficSpeed1, float trafficSpeed2) {

        orbits[0].setTrafficSpeed( trafficSpeed1);
        orbits[1].setTrafficSpeed( trafficSpeed2);

        float minTime = Float.MAX_VALUE;

        Orbit minOrbit = null;
        Vehicle minVehicle = null;

        for( Vehicle vehicle: vehicles) {

            if( ! vehicle.allowed(weather))
                continue;

            for( Orbit orbit : orbits) {

                try {
                    float time = orbit.getTimeTaken( vehicle, weather);

                    if (time < minTime) {
                        minTime = time;
                        minOrbit = orbit;
                        minVehicle = vehicle;
                    }
                }
                catch (VehicleNotAllowedException e) {
                    System.out.println( e.getMessage());
                }
            }
        }
        return "Vehicle " + minVehicle.getName() + " on " + minOrbit.getName();
    }

    public static void main(String[] args){
        App app = new App();

        Scanner scanner = new Scanner(System.in);

        String a = loopTillYouGet( scanner,
                "Enter Weather as windy/sunny/rainy" ,
                "\nPlease enter one of windy/sunny/rainy.\n Try again!");

        Weather weather = Weather.valueOf(a);

        String b =  loopTillYouGet( scanner,
                "Enter orbit1 traffic speed ",
                "\nPlease enter a valid number  value for speed");
        float speed1 = Float.valueOf(b);

        String c =  loopTillYouGet( scanner,
                "Enter orbit2 traffic speed ",
                "\nPlease enter a valid number  value for speed.\nIt's not difficult, you know ");
        float speed2 = Float.valueOf(c);


        System.out.println( app.solveForX( weather, speed1, speed2 ));
    }

    private static String loopTillYouGet( Scanner scanner, String prompt, String retryMessage) {
        while( true) {
            System.out.println( prompt);
            try {
                return scanner.next().toUpperCase().trim();
            }
            catch (Exception e) {
                System.out.println(e.getMessage()
                        +  retryMessage);
            }
        }

    }
}
