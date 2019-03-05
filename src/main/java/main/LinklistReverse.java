package main;

/**
 * Created by kraghunathan on 11/28/18.
 */
public class LinklistReverse {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }


    Node makeTree(){
        Node tree = new Node(0);
        Node tmp = tree;
        for( int i = 1 ; i <= 10 ; i ++) {
            tmp.next = new Node(i);
            tmp = tmp.next;
        }
        return tree;
    }

    static void disp(Node n) {
        while( n != null) {
            System.out.print( " " + n.data);
            n  = n.next;
        }
        System.out.println();
    }

    static Node reverse(Node n) {

        Node tmp = n;
        Node prev = null;
        Node next = null;

        while( tmp != null) {
            next = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = next;

        }
        return prev;
    }


    public static void main(String[] args) {
        LinklistReverse ll = new LinklistReverse();
        Node n = ll.makeTree();
        disp(n);
        Node rev = reverse(n);
        disp(rev);
    }

}
