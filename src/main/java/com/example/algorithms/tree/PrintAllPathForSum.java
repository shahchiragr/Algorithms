package com.example.algorithms.tree;


/**
 * Created by chirag on 9/4/16.
 */
public class PrintAllPathForSum {

    void findSum(Tree node, int sum, int[] path,int level) {
        if (node == null)
            return;

//        System.out.println("Node " + node.getValue() + " Level :" + level );
        path[level] = node.getValue();

        int t = 0;
        for (int i=level; i >=0; i--) {
//            if (path[i] != 0) {
            t += path[i];
//            }
            if (t == sum) {
                print(path, i, level);
            }

        }
            findSum(node.getLeft(), sum, path, level+1);
            findSum(node.getRight(), sum, path, level+1);

//            path[level] = 0;

        //}
    }

    void print(int[] path, int start, int end) {
        for (int i=start; i <= end; i++) {
            System.out.print(path[i] + " ");
        }

        System.out.println("....");
    }

    int depth(Tree node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
        }
    }

    void findSum(Tree node, int sum) {
        int depth = depth(node);
        System.out.println("Depth " + depth);
        int[] pathArray = new int[depth];
        findSum(node, sum, pathArray, 0);
    }

    public static void main(String args[]) {

//                                5
//                        5               15
//                    4        10     -5      25
//                 1        -10

        Tree leftNode = new Tree(5, new Tree(4,new Tree(1, null, null),null), new Tree(10, new Tree(-10, null, null),null));
        Tree rightNode = new Tree(15, new Tree(-5,null,null), new Tree(25,null,null));
        Tree root = new Tree(5, leftNode, rightNode);
        PrintAllPathForSum printAllPathForSum = new PrintAllPathForSum();
        printAllPathForSum.findSum(root, 15);
    }
}
