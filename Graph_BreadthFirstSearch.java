package datastructures;

import java.util.*;

public class Graph_BreadthFirstSearch {
    private Map<Integer, List<Integer>> adjList;

    // Constructor
    public Graph_BreadthFirstSearch() {
        adjList = new HashMap<>();
    }

    // Add edge to the graph
    public void addEdge(int src, int dest) {
        adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(src); // If undirected graph
    }

    // Perform BFS
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // Start with the initial node
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            // Visit all adjacent nodes
            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Main method to test the graph and BFS implementation
    public static void main(String[] args) {
        Graph_BreadthFirstSearch graph = new Graph_BreadthFirstSearch();

        // Add edges to the graph
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);

        System.out.println("BFS Traversal:");
        graph.bfs(1);
    }
}
