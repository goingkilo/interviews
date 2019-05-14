//package geektrust.traffic1;
//
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//
///**
// * v1.Orbit Tester.
// *
// * @author <Authors name>
// * @version 1.0
// * @since <pre>05/09/2018</pre>
// */
//public class Solution2Test extends TestCase {
//
//    Car car;
//    Bike bike ;
//    TukTuk tuktuk ;
//
//    Orbit orbit1 ;
//    Orbit orbit2 ;
//    Orbit orbit3 ;
//    Orbit orbit4 ;
//
//    Vehicle[] vehicles;
//    Orbit[] orbits  ;
//
//    Weather weather;
//
//    public Solution2Test(String name) {
//        super(name);
//    }
//
//    public void setUp() throws Exception {
//        super.setUp();
//        car     = new Car();
//        bike    = new Bike();
//        tuktuk  = new TukTuk();
//
//        orbit1  = new Orbit( "Orbit1", 18, 20);
//        orbit2  = new Orbit( "Orbit2", 20, 10);
//        orbit3  = new Orbit( "Orbit3", 18, 20);
//        orbit4  = new Orbit( "Orbit4", 20, 10);
//
//        vehicles = new Vehicle[]{ car, bike, tuktuk};
//        orbits   = new Orbit[]{orbit1, orbit2};
//
//        weather = Weather.valueOf("SUNNY");
//
//    }
//
//    public void tearDown() throws Exception {
//        super.tearDown();
//    }
//
//
//    public void testCase1() throws Exception {
//
//
//
//    }
//
//    public void testCase2() throws Exception {
//
//
//
//    }
//
//
//
//    public static Test suite() {
//        return new TestSuite(OrbitTest.class);
//    }
//}
