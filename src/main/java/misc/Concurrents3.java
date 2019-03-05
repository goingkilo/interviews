//package 
//
//import java.lang.*;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorCompletionService;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// * Created by kraghunathan on 6/29/18.
// */
//public class Concurrents3 {
//
//    public static void main(String[] args) {
//
//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executorService);
//        Set<Callable<Locales>> callables = new HashSet<Callable<Locales>>();
//        for (Locales loc : locales) {
//            Sheet sheet = book.createSheet(loc.getName());
//            XlsAsCallable xlsAsCallable = new XlsAsCallable(attrNames, emptyAttrHM, locales, categoriesENUS, sheet, taxonomyGuid, loc, categoriesENUSHM);
//            callables.add(xlsAsCallable);
//        }
//        for (Callable<Locales> callable : callables) {
//            executorCompletionService.submit(callable);
//        }
//        executorService.shutdown();
//        for (int i = 0; i < callables.size(); i++) {
//            Future take = executorCompletionService.take();
//            Locales loc = (Locales) take.get(30, TimeUnit.SECONDS);
//            if (loc != null) {
//                Logger.getLogger(CreateXls.class.getName()).log(Level.INFO, "sheet ready to " + loc.getName());
//            } else {
//                Logger.getLogger(CreateXls.class.getName()).log(Level.INFO, "an error has occurred generating a sheet");
//                executorService.shutdownNow();
//                if (!executorService.awaitTermination(3, TimeUnit.SECONDS)) {
//                    executorService.shutdownNow();
//                    Thread.currentThread().interrupt();
//                }
//                throw new java.lang.Exception("an error has occurred generating the file, please try again");
//            }
//        }
//        executorService.shutdownNow();
//    }
//}
