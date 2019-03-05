package misc;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by kraghunathan on 8/4/18.
 */
public class Tala8 {

    public static void main(String[] args) {

        List<String> l = new ArrayList<String>(){{
            add("101111010110011011100100");
        }};

        List<String> l2 = new Tala8().closestColor(l);
        System.out.println( l2);

        List<Integer> l1 = new ArrayList<Integer>(){{
           add(1);
            add(1);
            add(3);
            add(3);
        }};

//        Double s = Collections.min(l1);
//        int s1 = l.indexOf(s);
//        double d = distance( new Pixel( 0,0,255), new Pixel( 0,255,6) );
//        Pixel p = pixelFromString("111111111111111111111111");
//        System.out.println( fromString("00000110"));
//        System.out.println( fromString("11111111"));

    }

    List<String> closestColor(List<String> sPixels) {

        Pixel red   = new Pixel(255,0,0);
        Pixel green = new Pixel(0,255,0);
        Pixel blue  = new Pixel(0,0,255);
        Pixel black = new Pixel(0,0,0);
        Pixel white = new Pixel(255,255,255);

        List<Pixel> pureColors = Arrays.asList(black, white, red, green, blue);



        return sPixels
                .stream()
                .map(c -> pixelFromString(c))
                .collect(Collectors.toList())   // Pixels : List<Pixel>
                .stream()
                .map(px -> distances(pureColors, px))
                .collect(Collectors.toList())   // Distances of each pixel : List<List<Double>>
                .stream()
                .map(d -> getClosest(d))
                .collect(Collectors.toList());  // String nearest



    }

    String getClosest(List<Double> distances){

        double min = Collections.min(distances);

        if( isAmbiguous(distances, min)) {
            return "Ambiguous";
        }

        switch (distances.indexOf(min)) {
            case 0:
                return "Black";
            case 1:
                return "White";
            case 2:
                return "Red";
            case 3:
                return "Green";
            case 4:
                return "Blue";
            case 5:
                return "Ambiguous";
        }
        return "Ambiguous";
    }

    boolean isAmbiguous(List<Double> distances, double min){

        return distances
                .stream()
                .filter( d -> d == min)
                .collect( Collectors.toList())
                .size() > 1;
    }

    List<Double> distances( List<Pixel> pureColors, Pixel color){

        return pureColors
                .stream()
                .map( pc -> distance( pc, color))
                .collect(Collectors.toList());

    }

    double distance( Pixel pure, Pixel target) {

        return Math.sqrt(
                Math.pow(  pure.getX() -  target.getX(), 2)
                +
                Math.pow(   pure.getY() -  target.getY(), 2)
                +
                Math.pow(pure.getZ() -  target.getZ(), 2));
    }

    Pixel pixelFromString(String s) {
        String xString = s.substring( 0, 8);
        String yString = s.substring( 8, 16);
        String zString = s.substring( 16);

        return new Pixel(
                fromString(xString),
                fromString(yString),
                fromString(zString)
                );
    }

    float fromString(final String b) {
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

    class Pixel {
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
