import java.util.HashMap;
import java.util.Map;

public class ContiguousSUm {

    int[] twos;
    int[] a;
    Map<String,Integer> memoizer;

    public static void main(String[] args) {
        int[] a  = {-2,1,2,3};//{-2,1,-3,4,-1,2,1,-5,4};

        ContiguousSUm c = new ContiguousSUm();;
        c.go(a);
//        System.out.println(c.sum(4,4));
//        System.out.println(c.sum(1,4));
//        System.out.println(c.sum(3,2));
        System.out.println(c.sum(3,3));

        System.out.println(c.findMaxArray());
    }

    private void go(int[] a) {
        this.a = a;
        int[] twos = new int[a.length-1];
        memoizer = new HashMap<>();

        // laod twos sum array
        for( int i = 0 ; i < a.length -1; i++) {
            twos[i] = a[i] + a[i+1];
        }
        this.twos = twos;
    }

    int sum(int index, int window){
        if( memoizer.containsKey(""+index+":"+window)) {
            return memoizer.get("" + index + ":" + window);
        }

        if( window == 1)
            return a[index];

        if( window == 2)
            return twos[index] ;

        int sum = 0;
        for( int i = index ; i < (window /2) ; i++){
            sum += twos[2 +i];
        }
        if( window %2 == 1) {
            sum += a[index+window-1];
        }
        memoizer.put(""+index+":"+window, sum);
        return sum;
    }

    int findMaxArray(){
        int max = Integer.MIN_VALUE;
        for( int batch_size = 0 ; batch_size < a.length -1 ; batch_size++) {
            for(int j = 0 ; j < a.length - batch_size +1 ; j++){
                int sum = sum(j ,batch_size);
                max  = ( sum > max ) ? sum : max;
            }
        }
        return max;
    }



}
