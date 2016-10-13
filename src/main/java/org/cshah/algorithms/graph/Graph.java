package org.cshah.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chirag on 9/4/16.
 */
public class Graph {
    private List<GraphNode> nodeList = new ArrayList<GraphNode>();

    public void addNode(GraphNode node) {
        nodeList.add(node);
    }
    public List<GraphNode> getNodeList() {
        return nodeList;
    }


    public static void isRoutedGraph() {
//        a - b -c
//            |
//            - d - e
//            |
//             -f

        Graph graph = new Graph();

        GraphNode dNode = new GraphNode("d").add(graph);
        dNode.addAdjacent(new GraphNode("f").add(graph));

        GraphNode eNode = new GraphNode("e").add(graph);
        dNode.addAdjacent(eNode);

        GraphNode bNode = new GraphNode("b").add(graph);

        GraphNode cNode =  new GraphNode("c").add(graph);
        bNode.addAdjacent(cNode);
        bNode.addAdjacent(dNode);

        GraphNode aNode = new GraphNode("a").add(graph);
        aNode.addAdjacent(bNode);

        GraphNode startNode = bNode;
        GraphNode endNode = eNode;

        boolean isRouted = search(graph, startNode,endNode );

        System.out.println("Route between " + startNode.getLabel() + " and " + endNode.getLabel() + " is  " + isRouted);


        startNode = cNode;

        isRouted = search(graph, startNode,endNode );

        System.out.println("Route between " + startNode.getLabel() + " and " + endNode.getLabel() + " is  " + isRouted);

    }

    public static boolean search(Graph g, GraphNode start, GraphNode end) {
        LinkedList<GraphNode> q = new LinkedList<GraphNode>();

        for (GraphNode u : g.getNodeList()) {
            u.state = Status.UNVISITED;
        }


        start.state = Status.VISITNG;
        q.add(start);

        GraphNode u = null;

        while (!q.isEmpty()) {
            u =  q.removeFirst();
            if (u != null) {
                for (GraphNode v : u.getAdjacentList()) {
                    if (v.state == Status.UNVISITED) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = Status.VISITNG;
                            q.add(v);
                        }
                    }

                }

                u.state = Status.VISITED;
            }
        }


        return false;
    }

    public static void main(String args[]) {
        Graph.isRoutedGraph();
    }

}
