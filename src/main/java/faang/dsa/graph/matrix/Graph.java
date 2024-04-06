package faang.dsa.graph.matrix;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int[][] adjMatrix;

    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        adjMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j){
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (GraphNode graphNode : nodeList) {
            s.append(graphNode.name).append(" ");
        }
        s.append("\n");
        for(int i = 0; i < nodeList.size(); i++){
            s.append(nodeList.get(i).name).append(": ");
            for(int j : adjMatrix[i]){
                s.append((j)).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    // GET neighbours - HELPER method
    public ArrayList<GraphNode> getNeighours(GraphNode node){
        ArrayList<GraphNode> neighbours = new ArrayList<>();
        int nodeIndex = node.index;

        for(int i = 0; i < adjMatrix.length; i++){
            if(adjMatrix[nodeIndex][i] == 1){
                neighbours.add(nodeList.get(i));
            }
        }
        return neighbours;
    }

    // BSF - Internal - HELPER METHOD
    void bfsVisit(GraphNode node){
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNode> neighbours = getNeighours(currentNode);
            for(GraphNode neighbour : neighbours){
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