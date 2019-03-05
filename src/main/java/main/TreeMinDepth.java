package main;

public class TreeMinDepth {



    static int minDepth = Integer.MAX_VALUE;
    static int minVal = -1;

    static int minDepth(INode root) {
        minDepthHelper(root, 0);
        System.out.println(minVal);
        return minDepth;

    }

    static  void minDepthHelper(INode root, int depth) {
        if (root == null) {
            if (depth < minDepth) {
                minDepth = depth;
                minDepth --;
            }
            return;
        }
        minVal = root.data;
        minDepthHelper(root.l, depth + 1);
        minDepthHelper(root.r, depth + 1);

    }

    static void display( INode n){
        display(n, "|_");

    }
    static void display( INode n, String offset){
        if( n != null) {
            System.out.println( offset + " " + n.data);
        }
        if( n.l != null) {
            display(n.l, "\t" + offset  );
        }
        if( n.r != null) {
            display(n.r, "\t" + offset  );
        }

    }

    /**
     5
     /\
     3 6
     /\
     1 4
     /\
     6 7

     */

    public static void main(String[] args) {
        INode n = new INode( 5);
        n.l = new INode(3);
        n.l.l = new INode(1);
        n.l.l.l = new INode(6);
        n.l.l.r = new INode(7);
        n.l.r = new INode(4);
        n.r = new INode(6);

        display(n);
        System.out.println( minDepth(n));
    }
}

class INode {
    int data;
    INode l,r;

    public INode(int data) {
        this.data = data;
    }

}
