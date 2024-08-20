package datastructures;

import java.util.*;

public class Graph_DepthFirstSearch {
    private Map<Integer, List<Integer>> adjList;

    // Constructor
    public Graph_DepthFirstSearch() {
        adjList = new HashMap<>();
    }

    // Add edge to the graph
    public void addEdge(int src, int dest) {
        adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(src); // If undirected graph
    }

    // Perform DFS using recursion
    public void dfsRecursive(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursiveHelper(start, visited);
    }

    // Helper method for recursive DFS
    private void dfsRecursiveHelper(int node, Set<Integer> visited) {
        // Mark the current node as visited
        visited.add(node);
        System.out.print(node + " ");

        // Visit all adjacent nodes
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursiveHelper(neighbor, visited);
            }
        }
    }

    // Perform DFS using a stack (iterative approach)
    public void dfsIterative(int start) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited.contains(node)) {
                visited.add(node);
                System.out.print(node + " ");

                // Push all adjacent nodes onto the stack
                for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    // Main method to test the graph and DFS implementations
    public static void main(String[] args) {
        Graph_DepthFirstSearch graph = new Graph_DepthFirstSearch();

        // Add edges to the graph
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);

        System.out.println("DFS Recursive:");
        graph.dfsRecursive(1);

        System.out.println("\nDFS Iterative:");
        graph.dfsIterative(1);
    }
}
