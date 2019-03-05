package walmartlabs;

public class ThreadStaticLockingExample implements Runnable {

    public void run(){
        synchronized( A.class) {
            A.a++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread( new ThreadStaticLockingExample());
        Thread t2 = new Thread( new ThreadStaticLockingExample());
        t1.start();
        t2.start();
        Thread.sleep(100);
        System.out.println( A.a);
    }
}
