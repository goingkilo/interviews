package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Threads2 {

    ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private List<String> l = new ArrayList<String>();

    public String get(int i) {
        rwLock.readLock().lock();
        String s = l.get(i);
        rwLock.readLock().unlock();
        return s;
    }

    public void set( String val) {
        rwLock.writeLock().lock();
        l.add( val);
        rwLock.writeLock().unlock();
    }

    public void go() throws InterruptedException {
        System.out.println("hello fortran programmer **");


        ExecutorService es = Executors.newFixedThreadPool(100);
        es.execute(
                new Runnable() {
                    public void run() {
                        Threads2.this.set("donkey" + System.currentTimeMillis());
                    }
                }
        );

        Thread.sleep(20);
        es.shutdown();;
        l.stream().forEach( System.out::println);

    }

    public static void main(String[] args) throws InterruptedException {
        new Threads2().go();
    }

}
