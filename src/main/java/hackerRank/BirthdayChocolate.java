package hackerRank;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BirthdayChocolate {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        if( m == 1 && s.size() == 1 && s.get(0) == d)
            return 1;

        int c = 0;
        for( int i = 0 ; i < s.size() - m +1; i++) {
            if( ok( s, i, d, m)){
                System.out.println( s + " _ " +i + " _ " + d + " _ " + m);
                c++;
            }
            else {
            }
        }
        return c;
    }

    static boolean ok(List<Integer> s, int start, int days, int month){

        int sum = 0;

        for(int i = start; i < start+month ; i++){
            sum += s.get(i);
        }
        if( sum == days)
            return true;

        return false;

    }



    public static void main(String[] args) throws IOException {

        List<Integer> s = Stream.of("2 5 1 3 4 4 3 5 1 1 2 1 4 1 3 3 4 2 1".split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = birthday(s, 18, 7);
        System.out.println(result);

    }
}

