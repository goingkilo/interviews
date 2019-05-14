import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DDL {

    Map<String,Node> nodes  ;
    class Node {
        String key;
        int inCount;
        List<Node> edgesOut;
        public Node(String key){
            edgesOut = new ArrayList<>();
        }
    }

    void init(){
        nodes = new HashMap<>();
    }

    void load(String start, String end) {
        if( end == null){
            //handle this case
        }
        Node n1,n2;
        if( nodes.containsKey(start)){
            n1 = nodes.get(start);
        }
        else{
            n1 = new Node(start);
        }
        if (nodes.containsKey(end)) {
            n2 = nodes.get(end);
        }
        else {
            n2 = new Node(end);
        }
        n1.edgesOut.add(n2);
        n2.inCount++;
        nodes.put( start,n1);
        nodes.put( end, n2);
    }

    List<Node> getRootNodes(){
        return nodes.values()
                .stream()
                .filter(n -> n.inCount == 0)
                .collect(Collectors.toList());
    }

    void drawPath(Node n, List<String> soFar){
        soFar.add(n.key);
        if( n.edgesOut != null && n.edgesOut.size() > 0){
            for( Node edgeOut : n.edgesOut ){
                drawPath(edgeOut, new ArrayList<String>(soFar));
            }
        }
        else{
            System.out.println( String.join( "->", soFar));
        }
    }

    void drawAllPaths(){
        List<Node> rootNodes = getRootNodes();
        for( Node n : rootNodes){
            drawPath(n, new ArrayList<String>());
        }
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s1 = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
            s1.append(s);
        }
        String[] lines = s1.toString().split("\n");


        DDL solution  = new DDL();
        solution.init();

        for( int i = 1 ; i < lines.length ; i++){
            String[] pair = lines[i].split(",");
            solution.load( pair[0].trim(), pair[1].trim());
        }
        solution.drawAllPaths();


    }
}

