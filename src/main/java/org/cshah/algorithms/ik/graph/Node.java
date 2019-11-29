package org.cshah.algorithms.ik.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class Node {
    int value;
    List<Node> edges;

    /**    DFS   **/
    public void dfs(List<Node> vertexes) {
        Set<Node> set = new HashSet<Node>();

        for (Node n : vertexes) {
            dfsRec(n, set);
        }
    }
    public void dfsRec(Node n, Set<Node> visitedSet) {
        if (visitedSet.contains(n))
            return;

        visitedSet.add(n);
        System.out.println("Visited... " + n.value);
        for (Node child : n.edges) {
            dfsRec(child, visitedSet);
        }
    }

    public void bfs(List<Node> vertexes) {
        Queue<Node> nodeQueue = new ArrayBlockingQueue<Node>(10);
        Set<Node> visitedSet = new HashSet<Node>();
        for (Node n : vertexes) {
            nodeQueue.add(n);
        }

        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            System.out.println("Visited... " + node.value);
            visitedSet.add(node);

            for (Node child : node.edges) {
                if (!visitedSet.contains(child)) {
                    nodeQueue.offer(child);
                }
            }
        }
    }

    public void shortestPath(List<Node> vertexes, Node start, Node end) {
        Queue<Node> queue = new ArrayBlockingQueue<Node>(10);
        Set<Node> visitedSet = new HashSet<Node>();
        visitedSet.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.value == end.value) {
                break;
            }

            for (Node child : node.edges) {
                if (!visitedSet.contains(child)) {
                    queue.offer(child);
                    visitedSet.add(child);
                }
            }
        }
    }

}
