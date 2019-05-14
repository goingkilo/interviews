package visibility;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATest {

    A a;

    @Before
    public void before() throws Exception {
        a = new A();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testPublicMethod() throws Exception {
    }

    @Test
    public void testPackageProtectedMethod() throws Exception {
    }

    @Test
    public void testProtectedMethod() throws Exception {
    }


    @Test
    public void testPrivateMethod() throws Exception {
    /*
    try {
       Method method = A.getClass().getMethod("privateMethod");
       method.setAccessible(true);
       method.invoke(<Object>, <Parameters>);
    } catch(NoSuchMethodException e) {
    } catch(IllegalAccessException e) {
    } catch(InvocationTargetException e) {
    }
    */
    }

} 
