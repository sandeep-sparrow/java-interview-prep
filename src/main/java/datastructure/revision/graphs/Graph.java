package datastructure.revision.graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<T> {

    public HashMap<T, ArrayList<T>> adjList = new HashMap<>();

    public void printGraph(){
        System.out.println(adjList);
    }

    public boolean addVertex(T vertex){
        if(adjList.get(vertex) == null){
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdges(T vertex1, T vertex2){
        if(adjList.get(vertex1) != null && adjList.get(vertex2) != null){
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdges(T vertex1, T vertex2){
        if(adjList.get(vertex1) != null && adjList.get(vertex2) != null){
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(T vertex){
        if(adjList.get(vertex) == null) return false;
        for(T otherVertex : adjList.get(vertex)){
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }
    
}
