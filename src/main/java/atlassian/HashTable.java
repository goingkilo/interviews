package atlassian;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K,V> {

    class Entry<K,V> {
        K key;
        V value;

    }

    List<Entry> table = new ArrayList<>();

    public void put(K k,V v){

    }

    public boolean contains(K k){
return false;
    }

    public V get(K k){
        return null;
    }
}
