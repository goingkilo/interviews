//package 
//
//import java.util.Date;
//import java.util.List;
//import java.util.Queue;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.IntStream;
//
///**
// * Created by kraghunathan on 6/28/18.
// */
//public class Concurrents  {
//
//    private Queue  tasks = new java.util.concurrent.ConcurrentLinkedQueue<>();
//
//    public Concurrents(){
//    }
//
//    public void loadQueue( List<T> tasks) {
//        this.tasks.addAll( tasks);
//    }
//
//
//    public static void main(String[] args) throws InterruptedException {
//        Concurrents c = new Concurrents();
//        c.loadQueueAsync();
//        c.startWorkers();
//    }
//
//
//    void loadQueueAsync() throws InterruptedException {
//
//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000000; i++) {
//                    tasks.add( ":->" + System.currentTimeMillis() + "[" + String.valueOf(i) +"]");
//                }
//            }
//        }.start();
//
//        Thread.sleep(1);
//    }
//    void startWorkers() throws InterruptedException {
//
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//
//        class Worker implements Runnable {
//            Queue<String> tasks;
//
//            public Worker(Queue<String> tasks) {
//                this.tasks = tasks;
//            }
//
//            @Override
//            public void run() {
//                while (!tasks.isEmpty()) {
//                    String s = tasks.poll();
//                    System.out.println(new Date() + ":" + s);
//                }
//            }
//        }
//        // create 5 workers to the pool
//        IntStream.range(0, 5).forEach( i -> executor.execute(new Worker(tasks)));
//
//        executor.shutdown();
//        while( executor.isTerminated()){
//            Thread.sleep(1000);
//        }
//    }
//
//    private void _whatISThis_() {
//        ExecutorService threadPoolExecutor =
//                new ThreadPoolExecutor(
//                        10,
//                        20,
//                        2000,
//                        TimeUnit.MILLISECONDS,
//                        new LinkedBlockingQueue<Runnable>()
//                );
//    }
//
//
//}
//
//
