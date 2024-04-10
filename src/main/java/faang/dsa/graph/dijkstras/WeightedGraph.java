package faang.dsa.graph.dijkstras;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {

    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public WeightedGraph(ArrayList<WeightedNode> nodeList){
        this.nodeList = nodeList;
    }

    public void addWeightedEdges(int i, int j, int d){
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbours.add(second);
        // Directed Edge with Weight
        first.weightMap.put(second, d);
    }

    // Recursive Call - HELPER method
    public static void pathPrint(WeightedNode node){
        if(node.parent != null){
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    public void dijkstra(WeightedNode node){
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        // Set Node Distance to zero
        node.distance = 0;
        queue.addAll(nodeList);
        while(!queue.isEmpty()){
            WeightedNode currentNode = queue.remove();
            for(WeightedNode neighbour : currentNode.neighbours){
                if(queue.contains(neighbour)){
                    if(neighbour.distance > currentNode.distance + currentNode.weightMap.get(neighbour)){
                        neighbour.distance = (currentNode.distance + currentNode.weightMap.get(neighbour));
                        neighbour.parent = currentNode;
                        // Refresh Priority Queue
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }
        for(WeightedNode nodeToCheck : nodeList){
            System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }
}
