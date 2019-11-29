package org.cshah.algorithms.tree;


/**
 * Created by chirag on 9/4/16.
 */
public class PrintAllPathForSum {

    void findSum(TreeNode node, int sum, int[] path, int level) {
        if (node == null)
            return;

//        System.out.println("ListNode " + node.getVal() + " Level :" + level );
        path[level] = node.getVal();

        int sumOfNodes = 0;
        for (int i=level; i >=0; i--) {
//            if (path[i] != 0) {
            sumOfNodes += path[i];
//            }
            if (sumOfNodes == sum) {
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

    int depth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
        }
    }

    void findSum(TreeNode node, int sum) {
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

        TreeNode leftNode = new TreeNode(5, new TreeNode(4,new TreeNode(1, null, null),null), new TreeNode(10, new TreeNode(-10, null, null),null));
        TreeNode rightNode = new TreeNode(15, new TreeNode(-5,null,null), new TreeNode(25,null,null));
        TreeNode root = new TreeNode(5, leftNode, rightNode);
        PrintAllPathForSum printAllPathForSum = new PrintAllPathForSum();
        printAllPathForSum.findSum(root, 15);
    }
}
