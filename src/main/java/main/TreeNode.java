package main;

/**
 * Created by kraghunathan on 10/9/18.
 */
public class TreeNode<T> {

    private TreeNode<T> left,right;
    private String data;

    public TreeNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }


    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public String getData() {
        return data;
    }
}
