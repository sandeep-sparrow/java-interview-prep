package datastructure.revision.graphs.linkedList;

import java.util.ArrayList;

public class Graph {

    public ArrayList<GraphNode> nodeList;

    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
    }

    public void addUndirectedEdges(int i, int j){
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);

        first.neighbours.add(nodeList.get(j));
        second.neighbours.add(nodeList.get(i));
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
}
