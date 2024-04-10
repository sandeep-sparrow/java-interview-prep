package faang.dsa.graph.linkedList;

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

        g1.addUndirectedEdges(0,1);
        g1.addUndirectedEdges(0,2);
        g1.addUndirectedEdges(0, 3);
        g1.addUndirectedEdges(1, 4);
        g1.addUndirectedEdges(2, 3);
        g1.addUndirectedEdges(3, 4);

        System.out.println(g1.toString());

        System.out.println("Breath First Search");
        g1.BFS();

        ArrayList<GraphNode> nodeList2 = new ArrayList<>();

        nodeList2.add(new GraphNode("A", 0));
        nodeList2.add(new GraphNode("B", 1));
        nodeList2.add(new GraphNode("C", 2));
        nodeList2.add(new GraphNode("D", 3));
        nodeList2.add(new GraphNode("E", 4));

        Graph g2 = new Graph(nodeList2);

        g2.addUndirectedEdges(0,1);
        g2.addUndirectedEdges(0,2);
        g2.addUndirectedEdges(0, 3);
        g2.addUndirectedEdges(1, 4);
        g2.addUndirectedEdges(2, 3);
        g2.addUndirectedEdges(3, 4);
        
        System.out.println("\nDepth First Search");
        g2.DFS();
    }

}
