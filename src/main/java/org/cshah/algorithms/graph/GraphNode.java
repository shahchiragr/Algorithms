package org.cshah.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cshah on 5/8/14.
 */
public class GraphNode {
    String label;
    Status state = Status.UNVISITED;
    List<GraphNode> adjacentList = new ArrayList<GraphNode>();

    public GraphNode(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphNode graphNode = (GraphNode) o;

        return label.equals(graphNode.label);

    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    public void addAdjacent(GraphNode node) {
        adjacentList.add(node);
    }

    public List<GraphNode> getAdjacentList() {
        return adjacentList;
    }

    public GraphNode add(Graph g) {
        g.addNode(this);
        return this;
    }
}
