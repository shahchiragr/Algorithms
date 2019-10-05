package org.cshah.algorithms.graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    static class Graph {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; // Adjacency List

        //Constructor
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        public void topologicalSort() {
            boolean visited[] = new boolean[V];
            for (int i =0; i < V; i++) {
                visited[i] = false;
            }

            Stack stack = new Stack();

            for (int i=0; i < V;i++) {
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + "  ");
            }

            System.out.println();
        }

        private void topologicalSortUtil(int v, boolean[] visited, Stack stack) {

            visited[v] = true;

            LinkedList<Integer> edges = adj[v];
            for (int edgeInt : edges) {
                if (!visited[edgeInt]) {
                   topologicalSortUtil(edgeInt, visited, stack);
                }
            }

            stack.push(v);
        }

    }

    public static void main(String args[])  {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }
}
