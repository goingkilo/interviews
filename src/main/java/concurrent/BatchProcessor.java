package concurrent;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class BatchProcessor<T> {
    public static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(BatchProcessor.class);

    private int threadPoolBatchSize = 10;
    private ExecutorService executor ;
    private CompletionService<Void> service;

    public BatchProcessor() {
        executor = Executors.newFixedThreadPool(this.threadPoolBatchSize);
        service = new ExecutorCompletionService<>(executor);
        LOGGER.error(String.format("timelog : %s : creating batch processor with %s threads ", new Date(),  threadPoolBatchSize));
    }

    public void process(List<String> icfJsonPlaces) {

        IntStream.range(0, threadPoolBatchSize).forEach( i -> {
            service.submit(new DelayedCallable());
            i++;
        });

        IntStream.range(0, threadPoolBatchSize).forEach( ignoreMe -> {
            try {
                Future<Void> f = service.take() ;
                f.get();
                LOGGER.info(String.format("timelog : %s : processing  completed:", new Date() ));
            }
            catch (InterruptedException e) {
                LOGGER.error(String.format("timelog : %s : processing  interrupted: %s ", new Date(),  e.getMessage()));
            }
            catch (ExecutionException e) {
                LOGGER.error(String.format("timelog : %s : processing  failed : %s ", new Date(),  e.getMessage()));
            }
        });


    }

    public void close() {

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        }
        catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {

    }

}
