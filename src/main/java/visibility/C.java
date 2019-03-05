package visibility;

/**
 * Created by kraghunathan on 1/21/19.
 */
public class C extends B {

    @Override
    public void publicMethod(){
        System.out.println("C.publicMethod");

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

    @Override
    public void protectedMethod(){
        System.out.println("C.protectedMethod");

    }

    public static void main(String[] args) {

        A a = new A();
        a.publicMethod();
        a.protectedMethod();
        a.packageProtectedMethod();

        A b = new B();
        b.publicMethod();
        b.protectedMethod();
        b.packageProtectedMethod();

        A c = new C();
        c.publicMethod();
        c.protectedMethod();
        c.packageProtectedMethod();


    }
}
