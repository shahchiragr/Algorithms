package com.example.algorithms.graph;

/**
 * Created by cshah on 5/8/14.
 */
public class GraphNode {
    String label;
    GraphNode[] children;

    public GraphNode(String label) {
        this.label = label;
    }

    public GraphNode(GraphNode orig) {
        label = orig.label;
        children = new GraphNode[orig.children.length];
    }

}
