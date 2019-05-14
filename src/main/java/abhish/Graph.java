package abhish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    class Vertex {
        String key;

        public Vertex(String key) {
            this.key = key;
        }
    }

    Map<Vertex,List<Vertex>> graph;

    public Graph(){
        graph = new HashMap<>();
    }

    public void addEdge( Vertex v1, Vertex v2){
        List<Vertex> adjacentVertices = graph.get(v1);
        adjacentVertices.add(v2);
    }

    public void addVertex(Vertex v){
        graph.putIfAbsent(v,new ArrayList<>());
    }

    public void remove( String key){
        Vertex v = new Vertex(key);
        graph.remove(v);
        graph.values().stream().forEach( l -> l.remove(v));
    }

    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }
}
