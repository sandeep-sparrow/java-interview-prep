package datastructure.collections.graph;

public class Main {
    public static void main(String[] args) {

        Graph myGraph = new Graph();

        System.out.println(myGraph.addVertex("S"));
        myGraph.printGraph();

        System.out.println(myGraph.addVertex("A"));
        System.out.println(myGraph.addVertex("B"));
        System.out.println(myGraph.addVertex("C"));
        System.out.println(myGraph.addVertex("D"));

        System.out.println(myGraph.addEdge("A", "B"));
        System.out.println(myGraph.addEdge("B", "C"));
        System.out.println(myGraph.addEdge("C", "A"));
        System.out.println(myGraph.addEdge("S", "A"));
        System.out.println(myGraph.addEdge("S", "B"));
        System.out.println(myGraph.addEdge("S", "C"));
        System.out.println(myGraph.addEdge("S", "D"));

        myGraph.printGraph();

        System.out.println(myGraph.removeEdge("A", "C"));
        System.out.println(myGraph.removeVertex("S"));
        myGraph.printGraph();
    }
}
