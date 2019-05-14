package atlassian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcurrentObjectPool<T> {

    private Map<T,Boolean> pool = new HashMap<>();
    private List<T> items = new ArrayList<>();

    int available;

    public ConcurrentObjectPool(){
        //load pool
    }

    private  void loadPool(T t) {
        items.add(t);
        pool.put( t, true);
        available ++;
    }



    public T nonBlockingGet() {
        if( available == items.size()) {
           return null;
        }
        T t = items.get(available);
        pool.put(t,false);

        return t;
    }

    public void put(T t){
        pool.put(t,true);
        available++;

    }

    private class PoolEmptyException {
    }

    private class PoolObject {
    }
}
