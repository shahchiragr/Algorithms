package org.cshah.algorithms.graph;

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



}

