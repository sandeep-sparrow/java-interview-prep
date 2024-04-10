package faang.dsa.graph.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int[][] adjMatrix;

    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        adjMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdges(int i, int j){
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

    public void dfsVisit(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNode> neighbours = getNeighours(node);
            for(GraphNode neighbour : neighbours){
                if(!neighbour.isVisited){
                    neighbour.isVisited = true;
                    stack.push(neighbour);
                }
            }
        }
    }

    // Dept First Search
    public void DFS(){
        for(GraphNode node : nodeList){
            if(!node.isVisited){
                dfsVisit(node);
            }
        }
    }

    // Topological Sort
    public void addDirectedEdges(int i, int j){
        adjMatrix[i][j] = 1;
    }

    public void topologicalVisit(GraphNode node, Stack<GraphNode> stack){
        ArrayList<GraphNode> neighbours = getNeighours(node);
        for(GraphNode neighbour : neighbours){
            if(!neighbour.isVisited){
                topologicalVisit(neighbour, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    public void TopologicalSort(){
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node : nodeList){
            if(!node.isVisited){
                topologicalVisit(node, stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().name + " ");
        }
    }
}
