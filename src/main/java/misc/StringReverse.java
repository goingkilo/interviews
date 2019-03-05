package misc;

/**
 * Created by kraghunathan on 4/1/18.
 */
public class StringReverse {


    public String reverse(String s){
        StringBuilder s1 = new StringBuilder();
        for( int i = s.length() -1 ; i >= 0  ; i--){
            s1.append( s.charAt( i));

        }
        return s1.toString();
    }

    public static void main(String[] args) {
        String[] tests = { "" , "hello world" , "a", " ) (", "i have binary characters @#@#*%"};
        for( String s : tests) {
            System.out.println( "[" +
                    new StringReverse().reverse(s) + "]");
        }
    }
}
