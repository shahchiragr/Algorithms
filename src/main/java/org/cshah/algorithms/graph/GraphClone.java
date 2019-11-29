package org.cshah.algorithms.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by cshah on 9/18/19.
 */
public class GraphClone {
    private Map<String, GraphNode> newNodeMap = new HashMap<String,GraphNode>();

    public GraphClone() {
    }

    public GraphNode clone(GraphNode root) {
         if (root == null)
             return  null;

         Queue<GraphNode> queue = new LinkedBlockingQueue<GraphNode>();
         queue.offer(root);
         GraphNode newRootNode = createNode(root);

         while (!queue.isEmpty()) {
             GraphNode node = queue.remove();
              if (node.state == Status.UNVISITED) {
                  node.state = Status.VISITING;
                  GraphNode newnode = createNode(node);

                  node.adjacentList.forEach(newGraphNode -> {
                      GraphNode childNode = createNode(newGraphNode);
                      newnode.addAdjacent(childNode);
                      if (childNode.state == Status.UNVISITED) {
                          //childNode.state = Status.VISITNG;
                          queue.offer(newGraphNode);
                      }
                  });
                    node.state = Status.VISITED;
              }
         }

         return newRootNode;
    }

    public GraphNode createNode(GraphNode node) {
        if ( newNodeMap.containsKey(node.label))
                return newNodeMap.get(node.label);

        GraphNode newNode = new GraphNode(node.label);
        newNodeMap.put(node.label, newNode);

        return  newNode;
    }


    public static void main(String arg[]) {
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

        GraphClone graphClone = new GraphClone();
        GraphNode newRoot = graphClone.clone(aNode);
     //   System.out.println();
    }
}

