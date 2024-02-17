package interview.companies.here.dsa.generics.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GenericGraph<T> {

    private HashMap<T, ArrayList<T>> adjList = new HashMap<>();

    public boolean addVertex(T vertex){
        if(adjList.get(vertex) == null){
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public void pringGraph(){
       for(Map.Entry<T, ArrayList<T>> entry : adjList.entrySet()){
        System.out.println("Key: " + entry.getKey().toString());
        for(T otherVertex : entry.getValue()){
            System.out.println("Value: " + otherVertex.toString());
        }
        System.out.println();
       }
    }

    public boolean addEdge(T vertex1, T vertex2){
        if(adjList.get(vertex1) != null && adjList.get(vertex2) != null){
            adjList.get(vertex2).add(vertex1);
            adjList.get(vertex1).add(vertex2);
            return true;
        }
        return false;
    }

    public boolean removeEdge(T vertex1, T vertex2){
        if(adjList.get(vertex1) != null && adjList.get(vertex2) != null){
            adjList.get(vertex2).remove(vertex1);
            adjList.get(vertex1).remove(vertex2);
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
