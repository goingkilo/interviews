package misc;

public class Threads1 {

    static int[] arrays = { 1 ,2 ,3 ,4 ,5 ,6 ,7};

    public static void main(String[] args){


        System.out.println("hello fortran programmer **");

        Thread t1 = new Thread(){
            public void run(){
                for( int i = 0 ; i < arrays.length ; i++){
                    if( arrays[i] % 2 != 0 ) {
                        System.out.println( arrays[i]);
                    }
                }
            }

        };
        t1.start();

    }
}
