package walmartlabs;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadInstanceLockingExample implements Runnable {

    private A a;

    public ThreadInstanceLockingExample(A a) {
        this.a = a;
    }

    public void run() {
        synchronized (a) {
            a.setB(a.getB() + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        A a = new A();

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(100);

        executor.submit(new ThreadInstanceLockingExample(a));
    }
}
