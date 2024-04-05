package algorithm.graph;

import java.util.Random;

public class Graph {
    @SuppressWarnings("unused")
    private static final String NEWLINE = System.getProperty("line.separator");
    @SuppressWarnings("unused")
    private final int V;
    private int E;

    private LinkedList<Integer>[] adjList;

    // initializes an empty graph with V vertices and 0 edges
    @SuppressWarnings("unchecked")
    public Graph(int V){
        if(V<0) throw new IllegalArgumentException("Number of vertices must be non -ve");
        this.V = V;
        this.E = 0;
        adjList = (LinkedList<Integer>[]) new LinkedList[V];
        for(int u = 0; u < V; u++){
            adjList[u] = new LinkedList<>();
        }
    }

    // random graph with V vertices and E edges
    public Graph(int V, int E){
        this(V);
        if(E > (long) V*(V-1)/2 + V) throw new IllegalArgumentException("To many edges");
        if(E < 0) throw new IllegalArgumentException("To few edges");
        Random random = new Random();

        while(this.E != E){
            int u = random.nextInt(V);
            int v = random.nextInt(V);
            addEdge(u, v);
        }
    }

    private void addEdge(int u, int v2) {
        throw new UnsupportedOperationException("Unimplemented method 'addEdge'");
    }
    
}
