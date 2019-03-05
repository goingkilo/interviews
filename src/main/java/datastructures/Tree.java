package datastructures;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    public void printSpecial(Node n) {
        List<Node> nodes = new ArrayList<Node>();
        List<Node> children = new ArrayList<Node>();
        nodes.add(n);

        while(true){

            if( nodes == null || nodes.size() == 0)
                break;

            for( int i = 0 ; i < nodes.size() ; i++ ) {
                System.out.print(" " + nodes.get(i).getData());
            }
            System.out.println();


            for( Node node : nodes) {
                if ( node.getL() != null ) {
                    children.add(node.getL());
                }
                if ( node.getR() != null ) {
                    children.add(node.getR());
                }
            }
            nodes = children;
            children = new ArrayList<Node>();
        }
    }

}
