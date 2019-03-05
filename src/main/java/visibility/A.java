package visibility;

/**
 * Created by kraghunathan on 1/21/19.
 */
public class A {

    public void publicMethod(){
        System.out.println("A.publicMethod");

    }

    private void privateMethod(){
        System.out.println("A.privateMethod");

    }

    void packageProtectedMethod(){
        System.out.println("A.packageProtectedMethod");

    }

    protected void protectedMethod(){
        System.out.println("A.protectedMethod");

    }


}
