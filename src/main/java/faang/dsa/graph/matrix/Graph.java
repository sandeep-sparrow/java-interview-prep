package faang.dsa.graph.matrix;

import java.util.ArrayList;

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




}
