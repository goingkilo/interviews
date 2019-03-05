package datastructures;

public class Node<T> {

    T data;
    Node<T> l,r;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getL() {
        return l;
    }

    public void setL(Node<T> l) {
        this.l = l;
    }

    public Node<T> getR() {
        return r;
    }

    public void setR(Node<T> r) {
        this.r = r;
    }
}
