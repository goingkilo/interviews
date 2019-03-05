package main;

/**
 * Created by kraghunathan on 9/30/18.
 */
public class Perm {


    /**
     *  successful permutation .for each letter, for all possible combination of next letter from remaining, add until nothing's left
     *
     */
    public static void  main( String[] s) {
        permutationsHelper("|_", "", "abcde");
    }

    public static void permutationsHelper( String offset , String result, String original) {

        //System.out.println( String.format( offset + "[%s][%s]" , result , original));

        if( original == null || original.length() == 0) {
            System.out.println( result);
        }
        for( int i = 0 ; i < original.length() ; i++ ) {

            String s = new String(original);
            s = s.substring( 0, i) + s.substring( i+1, s.length());
            permutationsHelper( offset + ".-", result + original.charAt(i), s);
        }
    }
}
