package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kraghunathan on 8/4/18.
 */
public class Tala {

    public static void main(String[] args) {

        List<String> l = new ArrayList<String>(){{
            add("101111010110011011100100");
        }};

        List<String> l2 = closestColor(l);
        System.out.println( l2);

        List<Integer> l1 = new ArrayList<Integer>(){{
           add(1);
            add(1);
            add(3);
            add(3);
        }};

//        Double s = Collections.min(l);
//        int s1 = l.indexOf(s);
//        double d = distance( new Pixel( 0,0,255), new Pixel( 0,255,6) );
//        Pixel p = pixelFromString("111111111111111111111111");
//        System.out.println( fromString("00000110"));
//        System.out.println( fromString("11111111"));

    }

    static List<String> closestColor(List<String> pixels) {

        Pixel red   = new Pixel(255,0,0);
        Pixel green = new Pixel(0,255,0);
        Pixel blue  = new Pixel(0,0,255);
        Pixel black = new Pixel(0,0,0);
        Pixel white = new Pixel(255,255,255);

        Pixel[] pureColors = new Pixel[]{ black, white, red, green, blue};


        List<String> ret =   new ArrayList<>();

        for( String sPixel : pixels) {
            Pixel color = pixelFromString(sPixel);
            List<Double> distances = distances( pureColors, color);
            String s = getClosest(distances);
            ret.add(s);
        }


        return ret;
    }

    static String getClosest(List<Double> distances){
        double min = Collections.min(distances);
        if( containsMoreThanOne( distances, min)) {
            return "Ambigious";
        }

        switch (distances.indexOf(min)) {
            case 0:
                return "BLACK";
            case 1:
                return "WHITE";
            case 2:
                return "RED";
            case 3:
                return "GREEN";
            case 4:
                return "BLUE";
            case 5:
                return "AMBIGIOUS";
        }
        return "AMBIGIOUS";
    }

    static boolean containsMoreThanOne(List<Double> distances, double min){
        int c =0;
        for( int i = 0 ; i < distances.size() ; i++ ) {
            if( distances.get(i) == min) {
                c += 1;
                if( c > 1) {
                    return true;
                }
            }
        }
        return false;
    }


    static List<Double> distances( Pixel[] pureColors, Pixel color){
        List<Double> distances = new ArrayList<Double>();

        for( Pixel pureColor : pureColors ){
            distances.add( distance(pureColor,color));
        }
        return distances;
    }

    static double distance( Pixel pure, Pixel target) {

        return Math.sqrt(
                Math.pow(  pure.getX() -  target.getX(), 2)
                +
                Math.pow(   pure.getY() -  target.getY(), 2)
                +
                Math.pow(pure.getZ() -  target.getZ(), 2));
    }

    static Pixel pixelFromString(String s) {
        String xString = s.substring( 0, 8);
        String yString = s.substring( 8, 16);
        String zString = s.substring( 16);

        return new Pixel(
                fromString(xString),
                fromString(yString),
                fromString(zString)
                );
    }

    static float fromString(final String b) {
        int sum = 0;
        int pow = 7;
        for( int i = 0 ; i < b.length() ; i++) {
            if( b.charAt(i) == '1') {
                sum += Math.pow( 2, pow);
            }
            pow -= 1;
        }
        return (float)sum;
    }

    static class Pixel {
        private float x,y,z;

        public Pixel (float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public float getZ() {
            return z;
        }


    }
}
