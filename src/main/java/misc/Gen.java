package misc;

/**
 * Created by kraghunathan on 6/15/18.
 */
public class Gen<T> {

    static int a = 0;

    static {
        a += 1;
        System.out.println("static block " + a);
    }

    public Gen(){
        a += 1;
        System.out.println("constructor " + a);
    }

    public String process(T t){
        //
        return null;
    }

    public static void main(String[] args) {
        new Gen<String>();
    }
}
