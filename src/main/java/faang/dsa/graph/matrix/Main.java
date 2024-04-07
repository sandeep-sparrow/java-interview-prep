package faang.dsa.graph.matrix;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList1 = new ArrayList<>();

        nodeList1.add(new GraphNode("A", 0));
        nodeList1.add(new GraphNode("B", 1));
        nodeList1.add(new GraphNode("C", 2));
        nodeList1.add(new GraphNode("D", 3));
        nodeList1.add(new GraphNode("E", 4));

        Graph g1 = new Graph(nodeList1);

        g1.addUndirectedEdge(0,1);
        g1.addUndirectedEdge(0,2);
        g1.addUndirectedEdge(0, 3);
        g1.addUndirectedEdge(1, 4);
        g1.addUndirectedEdge(2, 3);
        g1.addUndirectedEdge(3, 4);

        System.out.println(g1.toString());

        g1.BFS();

        ArrayList<GraphNode> nodeList2 = new ArrayList<>();

        nodeList2.add(new GraphNode("A", 0));
        nodeList2.add(new GraphNode("B", 1));
        nodeList2.add(new GraphNode("C", 2));
        nodeList2.add(new GraphNode("D", 3));
        nodeList2.add(new GraphNode("E", 4));

        Graph g2 = new Graph(nodeList2);

        g2.addUndirectedEdge(0,1);
        g2.addUndirectedEdge(0,2);
        g2.addUndirectedEdge(0, 3);
        g2.addUndirectedEdge(1, 4);
        g2.addUndirectedEdge(2, 3);
        g2.addUndirectedEdge(3, 4);

        System.out.println("\nDepth First Search");
        g2.DFS();
    }

}
