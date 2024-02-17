package algorithm.graph.variation;


import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer>[] adj;

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // for undirected graph
    }

    // BFS to find the shortest distance
    public int shortestDistance(int start, int end) {
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];

        // Initialize visited array and distance array
        Arrays.fill(visited, false);
        Arrays.fill(distance, -1);

        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        distance[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : adj[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }

        return distance[end];
    }
}
