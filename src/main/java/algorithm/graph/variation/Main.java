package algorithm.graph.variation;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(4);

        // Adding edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        int shortestDistance = g.shortestDistance(0, 3);
        System.out.println("Shortest distance from node 0 to node 3 is: " + shortestDistance);
    }
}
