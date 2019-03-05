package terracotta;

import java.util.stream.IntStream;

public class Threado implements Runnable {

    MyInteger mi;

    public Threado(MyInteger mi) {
        this.mi = mi;
    }

    public void run(){
        mi.i++;
        System.out.println( mi.i);
    }

    public static void main(String[] args) {

        MyInteger mi = new MyInteger();

        // what will the following code print ?
        Thread t1 = new Thread(new Threado(mi));
        Thread t2 = new Thread(new Threado(mi));
        Thread t3 = new Thread(new Threado(mi));

        t1.start();
        t2.start();
        t3.start();
        System.out.println();

        //also

        IntStream.range(0,100).forEach( i -> {
            Thread t4 = new Thread(new Threado(mi));
            t4.start();
        });
        System.out.println();


    }
}
