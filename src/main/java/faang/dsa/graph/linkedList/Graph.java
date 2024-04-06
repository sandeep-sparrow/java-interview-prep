package faang.dsa.graph.linkedList;

import faang.dsa.graph.linkedList.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    ArrayList<GraphNode> nodeList = new ArrayList<>();

    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j){
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);

        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (GraphNode graphNode : nodeList) {
            s.append(graphNode.name).append(" -> ");
            for (int j = 0; j < graphNode.neighbours.size(); j++) {
                if (j == graphNode.neighbours.size() - 1) {
                    s.append((graphNode.neighbours.get(j).name));
                } else {
                    s.append(graphNode.neighbours.get(j).name).append(" -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    // Internal HELPER Method
    public void bfsVisit(GraphNode node){
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNode neighbour : currentNode.neighbours){
                if(!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    public void BFS(){
        for(GraphNode node : nodeList){
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }
}
