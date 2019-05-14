//package geektrust.traffic1;
//
//import junit.framework.TestCase;
//import org.junit.After;
//import org.junit.Before;
//
///**
// * v1.Vehicle Tester.
// *
// * @author <Authors name>
// * @version 1.0
// * @since <pre>May 10, 2018</pre>
// */
//public class VehicleTest extends TestCase {
//
//    Orbit orbit ;
//    Vehicle vehicle;
//
//
//    public void setUp() throws Exception {
//        super.setUp();
//        orbit = new Orbit( "A",1,1);
//        orbit.setTrafficSpeed(1);
//        vehicle = new Car();
//    }
//
//    @Before
//    public void before() throws Exception {
//    }
//
//    @After
//    public void after() throws Exception {
//    }
//
//    public void testGetSpeed() throws Exception {
//
//        assertEquals( 20f, vehicle.getSpeed() );
//    }
//
//    public void testGetCraterTime() throws Exception {
//
//        assertEquals( 3f, vehicle.getCraterTime() );
//    }
//
//    public void testVehicleNotAllowedWeather() throws Exception {
//
//         try {
//             orbit.getTimeTaken( new Bike(), Weather.RAINY ) ;
//             assert false;
//         }
//         catch(Exception e) {
//             assertEquals( "Bike is not allowed in RAINY", e.getMessage());
//             assert true;
//         }
//    }
//
//    @Test
//    public void testGetTime() throws Exception {
//        assertEquals( true, orbit.getTimeTaken(vehicle, Weather.RAINY) >= 0 );
//        assertEquals( true, orbit.getTimeTaken(vehicle, Weather.RAINY) >= 0 );
//    }
//
//    public void testGetTimeWithTraffic() throws Exception {
//        float time = orbit.getTimeTaken(vehicle, Weather.WINDY);
//        assertEquals( 63.0f, time );
//
//    }
//
//
//
//}
