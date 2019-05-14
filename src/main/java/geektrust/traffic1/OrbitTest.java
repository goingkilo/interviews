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
//public class OrbitTest extends TestCase {
//
//    Orbit orbit ;
//    Vehicle vehicle;
//
//    public OrbitTest(String name) {
//        super(name);
//    }
//
//    public void setUp() throws Exception {
//        super.setUp();
//        orbit = new Orbit( "A", 1,1);
//        vehicle = new Car();
//    }
//
//    public void tearDown() throws Exception {
//        super.tearDown();
//    }
//
//
//    public void testGetMegaMiles() throws Exception {
//        assertEquals( true, orbit.getMegaMiles() >= 0 );
//    }
//
//    public void testGetCraters() throws Exception {
//        assertEquals( true, orbit.getCraters() >= 0 );
//    }
//
//    public static Test suite() {
//        return new TestSuite(OrbitTest.class);
//    }
//}
