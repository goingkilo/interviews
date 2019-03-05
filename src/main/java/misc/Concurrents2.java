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
//public class Concurrents<T,W> {
//
//    private Queue<T> taskQueue;
//    private W worker;
//
//    public Concurrents(){
//        taskQueue = new java.util.concurrent.ConcurrentLinkedQueue<>();
//    }
//
//    public void setWorker(W w){
//        this.worker = w;
//
//    }
//
//    public void loadTasks( List<T> tasks) {
//        this.taskQueue.addAll(tasks);
//    }
//
//    public void loadTasksAsync( List<T> tasks) {
//        new Thread( new Runnable(){
//
//            @Override
//            public void run() {
//                tasks
//                        .stream()
//                        .parallel()
//                        .forEach(t -> taskQueue.add(t));
//            }
//        }).start();
//
//    }
//
//    public void executeTasks(int workerCount) {
//        ExecutorService executor = Executors.newFixedThreadPool( workerCount);
//        IntStream
//                .range(0, workerCount)
//                .forEach(i -> executor.execute( ));
//    }
//
//
//    public static void main(String[] args) throws InterruptedException {
//        Concurrents c = new Concurrents();
//    }
//
//
//
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
//        IntStream.range(0, 5).forEach( i -> executor.execute(new Worker(taskQueue)));
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
