package visibility;

/**
 * Created by kraghunathan on 1/21/19.
 */
public class B extends A {

    @Override
    public void publicMethod(){
        System.out.println("B.publicMethod");

    }

//    @Override
//    private void privateMethod(){
//        System.out.println("A.privateMethod");
//
//    }

//    @Override
//    void packageProtectedMethod(){
//        System.out.println("B.packageProtectedMethod");
//
//    }

//    @Override
//    protected void protectedMethod(){
//        System.out.println("B.protectedMethod");
//
//    }

    public static void main(String[] args) {

        A a = new A();
        a.publicMethod();
        a.protectedMethod();
        a.packageProtectedMethod();

        A b = new B();
        b.publicMethod();
        b.protectedMethod();
        b.packageProtectedMethod();


    }
}
