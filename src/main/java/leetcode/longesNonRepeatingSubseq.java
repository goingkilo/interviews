package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class longesNonRepeatingSubseq {

    public static void main(String[] args) {
        String s = "aabaab!bb";//"jbpnbwwd";//

        System.out.println(calc(s));
    }

    private static int calc(String s) {
        Map<Character,List<Integer>> index = new HashMap<>();

        int i = 0;
        int max = 0,curmax = 0;
        while ( i < s.length()) {

            char c = s.charAt(i);
            if( index.containsKey(c)){
                List<Integer> l = index.get(c);
                int ret  = l.get(l.size() - 1);
                l.add(i);
                i =ret ;
                if (curmax > max ) {
                    max = curmax;

                }
                index = new HashMap<>();
                curmax = 0;
            }
            else {
                List<Integer> l = new ArrayList<Integer>();
                l.add(i);
                index.put( c,l);
                curmax ++;
            }
            i++;

        }
        if( curmax > max) max = curmax;
        return max;
    }

    private static int indexPut(Map<Character, List<Integer>> index, char c, int i) {

        return i;

    }
}
