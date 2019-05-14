package circles.life;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertBinaryToZero {

    //1000→1001→1011→1010→1110→1111→1101→1100→0100→0101→0111→0110→0010→0011→0001→0000
    // 1101→1100→0100→0101→0111→0110→0010→0011→0001→0000

    static long globalCount = Long.MAX_VALUE;

    public static void main(String[] args) {
        ConvertBinaryToZero c = new ConvertBinaryToZero();
        c.convertOps(13);
        System.out.println(c.globalCount);
        //System.out.println( c.flippableIndex("1100"));
    }

        private  static void convertOps(long i) {
            iterate( Long.toBinaryString(i), 0, new HashSet<String>());
        }


        static void iterate( String s, long count, Set<String> visited) {
            if( Integer.parseInt(s) == 0 ) {
                if (count < globalCount) {
                    globalCount = count;
                }
            }

            // get flippable list
            List<Integer> candidates = flippableIndex(s);

            for( int i  = 0 ; i < candidates.size() ; i++) {
                String newString = flip(s, candidates.get(i));

                if( visited.contains(newString ))
                    continue;

                Set<String> newVisited = new HashSet<>(visited);
                newVisited.add( newString);
                iterate(newString, count+1, newVisited);
            }
        }


        static List<Integer> flippableIndex(String s){
            List<Integer> flippableIndices = new ArrayList<>();
            for( int i = 0 ; i < s.length() ; i++ ){
                if( canFlip(s,i)){
                    flippableIndices.add(i);
                }
            }
            return flippableIndices;
        }


        static boolean canFlip(String s, int i) {
            if( i >= s.length())
                return false;

            if( i == s.length() -1)
                return true;

            if( s.charAt(i+1) == '1' ){
                // if not 0s all the way to end, return false
                for( int x = i+2 ; x <  s.length() ; x++) {
                    if( s.charAt(x) == '1') {
                        return false;
                    }
                }
                return true;
            }
            return false;

        }

        static String flip(String s, int i) {
            StringBuilder s1 = new StringBuilder(s);
            s1.setCharAt(i,   (s.charAt(i) == '0' ? '1' : '0'));
            return s1.toString();

        }



}
