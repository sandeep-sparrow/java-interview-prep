package algorithm.graph.weightedGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {

    public ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public WeightedGraph(ArrayList<WeightedNode> nodeList){
        this.nodeList = nodeList;
    }

    public void addWeightedEdge(int a, int b, int distance){
        WeightedNode firstNode = nodeList.get(a);
        WeightedNode secondNode = nodeList.get(b);
        firstNode.neighbours.add(secondNode);
        firstNode.weightMap.put(secondNode, distance);
    }

    public void dijkstrasAlgo(WeightedNode currentLocation){
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        currentLocation.distance = 0;
        queue.addAll(nodeList);
        while(!queue.isEmpty()){
            WeightedNode currentNode = queue.remove();
            for(WeightedNode neighbour : currentNode.neighbours){
                if(queue.contains(neighbour)){
                    if(neighbour.distance > (currentNode.distance + currentNode.weightMap.get(neighbour))){
                        neighbour.distance =  (currentNode.distance + currentNode.weightMap.get(neighbour));
                        neighbour.parent = currentNode;
                        // refresh PQ
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }
        for(WeightedNode locationToCheck :  nodeList){
            System.out.print("Location -> " + locationToCheck + ", shortest distance: " + locationToCheck.distance + ", shortest path: ");
            pathPrint(locationToCheck);
            System.out.println();
        }
    }


    public static void pathPrint(WeightedNode node){
        if(node.parent != null){
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }
    
}
