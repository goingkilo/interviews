package walmartlabs;


import datastructures.Node;

public class TreeLRCompare {
    /*
    	  A
      B	          B
   D       E   E     D
F                          F

     */

    boolean compare ( Node n1, Node n2) {

        if( n1 == null && n2 == null ){
            return true;
        }


        if( (n1 == null && n2 != null) || (n1 != null && n2 == null) )
            return false;

        if( !n1.getData().equals(n2.getData())) {
            return false;
        }
        return	compare (n1.getL(), n2.getR()) && compare(n1.getR(), n2.getL());
    }

    boolean compare ( Node n1) {
        return compare( n1.getL(), n1.getR());
    }

    void disp(Node n){
        while( n != null) {
            System.out.println( n.getData());
            disp(n.getL());
            disp(n.getR());
        }
    }

    public static void main(String[] args) {
        Node<String> a = new Node<>("A");

        a.setL( new Node<String>("B"));
        a.setR(new Node<String>("B"));

        a.getL().setL( new Node<String>("D"));
        a.getL().setR(new Node<String>("E"));

        a.getL().getL().setL( new Node<String>("F"));

        a.getR().setR(new Node<String>("D"));
        a.getR().setL(new Node<String>("E"));

        a.getR().getR().setR(new Node<String>("F"));

        System.out.println( new TreeLRCompare().compare(a));

    }

}
