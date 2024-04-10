package faang.dsa.graph.linkedList;

import java.util.ArrayList;

public class SSSPPMain {

    public static void main(String[] args) {

        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));

        Graph newGraph = new Graph(nodeList);

        newGraph.addUndirectedEdges(0, 1);
        newGraph.addUndirectedEdges(0, 2);
        newGraph.addUndirectedEdges(1, 3);
        newGraph.addUndirectedEdges(1, 6);
        newGraph.addUndirectedEdges(2, 3);
        newGraph.addUndirectedEdges(2, 4);
        newGraph.addUndirectedEdges(3, 5);
        newGraph.addUndirectedEdges(4, 5);
        newGraph.addUndirectedEdges(5, 6);

        newGraph.BFSforSSSPP(nodeList.get(0));
    }
}
