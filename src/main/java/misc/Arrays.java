package  misc;

import java.util.stream.IntStream;

/**
 * Created by kraghunathan on 5/14/18.
 */
public class Arrays {

    public static void main(String[] args) {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9}};
        shift90(a);
        IntStream.range( 0, a.length).forEach( i -> {
                        IntStream.range( 0, a[i].length).forEach(j -> {
                            System.out.print(a[i][j]);
                            System.out.print(" ");
                        });
                    System.out.println();
                }
        );
    }

    private static void shift90(int[][] a) {

    }

    void go(){
        String[] a = { "hello", "world", "foo", "bar", "baz", "quux"};
        String[] b = { "hello", "foo", "baz" };
        int n = a.length - b.length;
        String temp[] = new String[n];
        int i=0,j=0,k=0;
    boolean valueStatus=false;

        for(i=0;i<a.length;++i){
            String item = a[i];
            //System.out.println("item is " + item);
            valueStatus=false;
            for(j=0;j<b.length;++j){
                if(item.equals(b[j])){
                    //System.out.println("Math found " + a[j]);
                    valueStatus=true;
                }
            }
            //System.out.println("A length is " + a.length);
            //System.out.println("J is  " + j);
            if(valueStatus==false){
                //System.out.println("test");
                temp[k++]=item;
            }
        }
        for(String value : temp){
            System.out.println("   " + value);
        }

    }
}
