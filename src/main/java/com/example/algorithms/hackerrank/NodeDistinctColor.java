package com.example.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chirag on 9/28/16.
 * https://www.hackerrank.com/contests/moodysuniversityhackathon/challenges/distinctly-colored-nodes-in-a-tree
 *
 */
public class NodeDistinctColor {
    List<ColorNode> nodeList = new ArrayList<ColorNode>();

    class ColorNode{
        int nodeID;
        int color;
        List<ColorNode> childrenList = new ArrayList<ColorNode>();
        boolean visited = false;

        public ColorNode(int nodeNumber, int color) {
            this.nodeID = nodeNumber;
            this.color = color;
        }

        public List<ColorNode> getChildrenList() {
            return childrenList;
        }

        public int getColor() {
            return color;
        }

        public void removeNode(ColorNode node) {
            childrenList.remove(node);
        }

    }


    public int findDistinctColor(ColorNode startNode, List<Integer> color) {
        if (startNode.visited == true)
            return 0;

        startNode.visited =true;

        if (!color.contains(startNode.color)) {
                color.add(startNode.color);
        }

        for (ColorNode cNode : startNode.childrenList) {
                findDistinctColor(cNode, color);
        }

        return color.size();

    }


    public void buildList() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            nodeList.add(new ColorNode(i+1, scanner.nextInt()));
        }

        ColorNode[][] array = new ColorNode[count-1][2];

        for (int i=0; i < count-1; i++) {
            int pNode = scanner.nextInt();
            int cNode = scanner.nextInt();

            ColorNode parentNode = findNode(pNode);
            ColorNode childNode = findNode(cNode);

            if (parentNode != null && childNode != null) {
                parentNode.childrenList.add(childNode);
            }

            array[i][0] = parentNode;
            array[i][1] = childNode;
        }

        int sum = breakLink(array, count-1);
    //    printNode();
        System.out.println(sum);
    }

    public int breakLink(ColorNode[][] array, int row) {
        int sum = 0;
        for (int i=0; i < row; i++) {

            for (ColorNode node : nodeList) {
                node.visited = false;
            }

            array[i][0].removeNode(array[i][1]);

            int c1 = findDistinctColor(nodeList.get(0), new ArrayList<Integer>());
            int c2 = findDistinctColor(array[i][1], new ArrayList<Integer>());
            sum += c1 * c2;

            array[i][0].childrenList.add(array[i][1]);
        }

        return sum;
    }
    public void printNode() {
            for (ColorNode node : nodeList) {
                node.visited = false;
            }

            for (ColorNode node : nodeList) {
                 if (node.visited == true)
                     continue;

                node.visited =true;

                Queue<ColorNode> queue = new LinkedBlockingQueue<ColorNode>();
                queue.add(node);

                while (!queue.isEmpty()) {
                    ColorNode n = queue.poll();
                    n.visited = true;
                    System.out.println("Node " + n.nodeID);

                    for (ColorNode childNode : n.childrenList) {
                        if (childNode.visited != true) {
                            queue.add(childNode);
                        }
                    }

                }
             }


        for (ColorNode node : nodeList) {
            node.visited = false;
        }

        ColorNode node1 = nodeList.get(0);
        int colorNo = findDistinctColor(node1, new ArrayList<Integer>());
        System.out.println("TOTAL COLOR" + colorNo);
    }

    public ColorNode findNode(int nodeID) {
        for (ColorNode colorNode : nodeList) {
            if (colorNode.nodeID == nodeID)
                return colorNode;
        }

            return null;
    }


    public static void main(String args[]) {
        NodeDistinctColor nodeDistinctColor = new NodeDistinctColor();
        nodeDistinctColor.buildList();
    }

}
