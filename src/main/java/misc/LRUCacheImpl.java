//package hmm;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class LRUCacheImpl<T> implements LRUCache<T> {
//
//    Map<Integer,T> store = new HashMap<Integer,T>();
//
//    List<Item> index = new ArrayList<Item>();
//
//    @Override
//    public T get(int key) throws NotFoundException {
//        if( store.containsKey( key)){
//            return store.get( key);
//        }
//        throw new NotFoundException();
//    }
//
//    @Override
//    public void set( Integer key, T value){
//        store.put( key, value);
//    }
//
//    public static void main(String[] args) throws NotFoundException {
//
//        LRUCache<String> l = new LRUCacheImpl<String>();
//        l.set(0, ")0");
//        System.out.println(l.get(0).equals(")0"));
//    }
//
//    class Item {
//        int score;
//        int key;
//
//        public Item(int key, int score) {
//            this.key = key;
//            this.score = score;
//        }
//
//        public int getKey() {
//            return key;
//        }
//
//        public void setKey(int key) {
//            this.key = key;
//        }
//
//        public int getScore() {
//            return score;
//        }
//
//        public void setScore(int score) {
//            this.score = score;
//        }
//    }
//}
//
