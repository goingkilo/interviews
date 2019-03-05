package datastructures;

public class LinkedList {

    Node n;

    public LinkedList(){
    }


    void add(int data) {
        Node node = new Node();
        node.data = data;
        if ( n == null ) {
            n = node;
        }
        else {
            Node tmp = n;
            while( tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    void delete( Node node) {

        if( search(node.data) == null)
            return;

        // no list
        if( n == null )
            return;

        // node first element
        if( n.equals(node)) {
            n = node.next;
        }


        Node tmp = n;
        Node prev = null;
        while ( tmp.next != null ){
            prev = tmp;
            tmp = tmp.next;
            if( tmp.equals(node)){
                if( tmp.next != null){
                    prev.next = tmp.next;
                }
                else {
                    prev.next = null;
                }
            }
        }

    }

    Node search(int data){
        if( n == null )
            return null;

        Node tmp = n;
        while( tmp.next != null ) {
            if( tmp.data == data)
                return tmp;

            tmp = tmp.next;
        }
        return null;
    }


    class Node {
        int data;
        Node next;
    }
}
