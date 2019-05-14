package leetcode;

public class ShiftArray {


    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6};
        shift(a,3);
        for( int i : a){
            System.out.print(i+" ");
        }
        System.out.println();


    }

    static void shift(int[] a,int k){
        int [] b = new int[a.length];
        int popped = 0;
        int new_index = (0+k) % a.length;
        for( int i = 0 ; i < a.length ;i++){

            popped = a[new_index];
            a[new_index] = a[i];

            System.out.println(i +"," + "," + new_index);

        }
        System.out.println(b);
    }
}
