package com.example.algorithms.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cshah on 5/8/14.
 */
public class GraphClone {
    private Map<String, GraphNode> visited = new HashMap<String,GraphNode>();
    private final GraphNode root;

    public GraphClone(GraphNode root) {
        this.root = root;
    }

    public GraphNode cloneGraph() {
        return cloneGraph(root);
    }


    private GraphNode cloneGraph(GraphNode node) {
        GraphNode clone = visited.get(node.label);
        if(clone != null)
            return clone;

        clone = new GraphNode(node);
        visited.put(node.label, clone);

        for(int i = 0; i < node.children.length; i++) {
            GraphNode child = node.children[i];
            GraphNode childClone = cloneGraph(child);
            clone.children[i] = childClone;
        }

        return clone;
    }

}

