package org.cshah.algorithms.tree;

import java.util.Stack;

/**
 * Created by cshah on 5/5/14.
 */
public class PrintAllPathBinary {

    public static TreeNode getTree() {
        TreeNode leftNode = new TreeNode(50, new TreeNode(25,null,null), new TreeNode(75,null,null));
        TreeNode rightNode = new TreeNode(150, new TreeNode(125,null,null), new TreeNode(175,null,null));
        TreeNode root = new TreeNode(100, leftNode, rightNode);
        return root;
    }

    public static  void printBinaryPath(TreeNode root, Stack<TreeNode> path) {
        if (root == null)
            return;

        for (TreeNode n : path) {
            System.out.print(n.getVal() + "," );
        }
        System.out.println();

        if (root.getLeft() != null) {
            path.push(root.getLeft());
            printBinaryPath(root.getLeft(), path);
            path.pop();
        }

        if (root.getRight() != null) {
            path.push(root.getRight());
            printBinaryPath(root.getRight(), path);
            path.pop();
        }

    }

    public static void main(String args[]) {

        Stack<TreeNode> path = new Stack<TreeNode>();
        TreeNode root = getTree();
        path.push(root);
        printBinaryPath(root,path);

    }
}
