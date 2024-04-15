package faang.dsa.graph.dijkstras;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode implements Comparable<WeightedNode> {

    public String name;
    public ArrayList<WeightedNode> neighbours = new ArrayList<>();
    public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
    public boolean isVisited = false;
    public WeightedNode parent;
    public int distance;
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
