package concurrent;

import java.util.concurrent.Callable;

public class DelayedCallable implements Callable<Void> {

    public DelayedCallable() {
    }

    @Override
    public Void call() throws Exception {
        Thread.currentThread().sleep(100);
        return null;
    }
}
