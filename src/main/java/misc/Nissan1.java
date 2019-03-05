package misc;

import java.util.Arrays;

/**
 * Created by kraghunathan on 8/19/18.
 */
public class Nissan1 {

    static int[] a1 = { 1,2,3,4,5};
    public static void main(String[] args) {

//        Scanner s = new Scanner(System.in);
//        int k = Integer.parseInt( s.nextLine().trim());
//        int[] a = Arrays.asList(s.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
//        int q = Integer.parseInt( s.nextLine().trim());
//        for( int i = 0 ; i < q ; i++){
//            int q_i = Integer.parseInt( s.nextLine().trim());
//            System.out.println( intAveQ(a, q_i));
//        }
        System.out.println( intAveQ( a1,4));
    }


    public static int intAveQ( int[] a, int q){

        Arrays.sort(a);
        int sum = 0 ;
        for( int i = 0 ; i < a.length ; i++ ){
            sum += a[i];
            int ave = sum / (i+1);
            if( ave < q ){
                if( i == a.length - 1) {
                    return a.length;
                }
                else {
                    continue;
                }
            }
            else {
                return i;
            }
        }
        return 0;
    }
}
