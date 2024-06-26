package datastructure.revision.graphs.matrix;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<GraphNode> nodeList = new ArrayList<>();

        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        Graph g = new Graph(nodeList);

        g.addUndirectedEdges(0, 1);
        g.addUndirectedEdges(0, 2);
        g.addUndirectedEdges(0, 3);
        g.addUndirectedEdges(1, 4);
        g.addUndirectedEdges(2, 3);
        g.addUndirectedEdges(3, 4);

        System.out.println("ADJ MATRIX:");
        System.out.println(g.toString());

        g.BFS();
    }
}
