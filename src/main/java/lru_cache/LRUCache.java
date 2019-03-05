package lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<String,Node> map   ;

    Node list , listEndNode;

    int size                = 0, capacity =5;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public String get(String key) {
        if( map.containsKey(key) ){
            Node n = map.get(key);
            moveExistingNodeToEndOfList( n);
            return n.data;
        }
        return null;
    }

    public void put(String key, String value) {

        if( list == null) {
            Node newNode  = new Node(value);
            list = newNode;
            listEndNode = newNode;
            map.put( key, newNode);
            size ++;
        }
        else {
            Node n = null;
            if( map.containsKey( key)) {
                // overwrite and move to front of list
            }
            else {
                // add elt directly to front of list
                n = new Node(value);
            }
            map.put( key, n);

            n.prev = null;
            n.next = list;
            list = n;   // now list starts at n
        }
    }

    private void moveExistingNodeToEndOfList(Node node) {

        Node currNext = node.next;
        Node currPrev = node.prev;

        if (currNext != null) {
            // short circuit previous and next
            if (currPrev != null)
                currPrev.next = currNext;


            currNext.prev = currPrev;

            // set the new node at the end to be the end node ( next = null), change the current end node
            this.listEndNode.next = node;
            node.prev = this.listEndNode;
            node.next = null;

            this.listEndNode = node;
        }

    }

    void test1(){
        list  = new Node("a");
        Node b  = new Node("b");
        Node c  = new Node("c");

        list.next = b;
        b.next = c;
        b.prev = list;
        c.prev = b;

        disp(list);
        moveExistingNodeToEndOfList(b);
        disp(list);

    }

    void test2(){
        put("a","1");
        put("b","2");
        put("c","3");
        put("d","4");
        put("e","5");

        disp(list);
        get("b");
        disp(list);
        get("b");
        disp(list);

    }

    void disp(Node n) {
        while( n!= null){
            System.out.print( " " + n.data);
            n  = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        new LRUCache(0).test2();

    }
}

class Node {
    String data;
    Node next, prev;

    public Node(String data) {
        this.data = data;
    }

}
