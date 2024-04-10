package faang.dsa.graph.dijkstras;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();

        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        nodeList.add(new WeightedNode("E", 4));
        nodeList.add(new WeightedNode("F", 5));
        nodeList.add(new WeightedNode("G", 6));

        WeightedGraph myWeightedGraph = new WeightedGraph(nodeList);

        myWeightedGraph.addWeightedEdges(0, 1, 2);
        myWeightedGraph.addWeightedEdges(0, 2, 5);
        myWeightedGraph.addWeightedEdges(1, 2, 6);
        myWeightedGraph.addWeightedEdges(1, 3, 1);
        myWeightedGraph.addWeightedEdges(1, 4, 3);
        myWeightedGraph.addWeightedEdges(2, 5, 8);
        myWeightedGraph.addWeightedEdges(3, 4, 4);
        myWeightedGraph.addWeightedEdges(4, 6, 9);
        myWeightedGraph.addWeightedEdges(5, 6, 7);

        System.out.println("Printing Dijkstra from source: A");
        myWeightedGraph.dijkstra(nodeList.get(0));
    }

}
