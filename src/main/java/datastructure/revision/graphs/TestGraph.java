package datastructure.revision.graphs;

public class TestGraph {

    public static void main(String[] args) {
        Graph<String> g = new Graph<>();


        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");

        g.addEdges("A", "B");
        g.addEdges("A", "C");
        g.addEdges("A", "D");
        g.addEdges("B", "C");
        g.addEdges("B", "D");
        g.addEdges("D", "C");

        g.printGraph();


    }
    
}
