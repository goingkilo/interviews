package lru_cache;

import java.util.UUID;

/**
 * Created by kraghunathan on 12/6/18.
 */
public class DoublyLinkedList {

    Node head, tail;
    int capacity, size;

    public boolean add(int i) {
        if (size == capacity)
            return false;

        Node n = new Node(i);

        if (head == null && tail == null) {
            // list is empty
            head = n;
            tail = n;
        } else {
            // add to tail
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        size++;

        return true;
    }

    public static void display(Node n) {
        while (n != null) {
            System.out.print(" " + n.data);
            n = n.next;
        }
        System.out.println();
    }

    public void remove(Node n) {
        if (size == 0) {
            return;
        } else if (size == 1 && n.equals(head)) {
            head = null;
            tail = null;
            size = 0;
        } else {

        }
    }

    class Node {
        UUID id;
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
            id = UUID.randomUUID();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (data != node.data) return false;
            return id.equals(node.id);

        }

        @Override
        public int hashCode() {
            int result = id.hashCode();
            result = 31 * result + data;
            return result;
        }
    }
}
