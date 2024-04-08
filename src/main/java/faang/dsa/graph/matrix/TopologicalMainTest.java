package faang.dsa.graph.matrix;

import java.util.ArrayList;

public class TopologicalMainTest {

    public static void main(String[] args) {

        ArrayList<GraphNode> nodeList = new ArrayList<>();

        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));
        nodeList.add(new GraphNode("H", 7));

        Graph g = new Graph(nodeList);

        g.addDirectedEdges(0, 2);
        g.addDirectedEdges(1, 2);
        g.addDirectedEdges(1, 3);
        g.addDirectedEdges(2, 4);
        g.addDirectedEdges(3, 5);
        g.addDirectedEdges(4, 5);
        g.addDirectedEdges(4, 7);
        g.addDirectedEdges(5, 6);

        System.out.println(g.toString());
        g.TopologicalSort();


    }
}
