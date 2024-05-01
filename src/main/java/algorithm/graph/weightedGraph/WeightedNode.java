package algorithm.graph.weightedGraph;

import java.util.ArrayList;
import java.util.HashMap;

import org.jetbrains.annotations.NotNull;

public class WeightedNode implements Comparable<WeightedNode> {

    public String name;
    public ArrayList<WeightedNode> neighbours = new ArrayList<>();
    public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
    public boolean isVisited = false;
    public int distance;
    public WeightedNode parent;
    public int index;

    public WeightedNode(String name, int index){
        this.name = name;
        this.distance = Integer.MAX_VALUE;
        this.index = index;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(@NotNull WeightedNode o) {
        return this.distance - o.distance;
    }


    
}
