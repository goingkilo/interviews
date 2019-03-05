package lru_cache;

/**
 * Created by kraghunathan on 12/5/18.
 */
public interface Cache<K,V> {

    public V get(K k);
    public boolean put(K k,V v);

}
